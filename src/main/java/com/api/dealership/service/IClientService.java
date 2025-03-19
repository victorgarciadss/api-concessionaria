package com.api.dealership.service;

import java.util.List;

import com.api.dealership.dto.ClientDto;
import com.api.dealership.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IClientService {
    
    /**
     * Esse método retorna todos os clientes cadastrados no sistema
     * @return lista de clientes cadastrados
     */
    public List<Client> getAll();

    /**
     * Esse método retorna parte dos clientes cadastrados por uma página
     * @param page número da página desejada
     * @param size tamanho da página desejada
     * @return uma página de clientes com tamanho determinado
     */
    public List<Client> getClients(Integer page, Integer size);

    /**
     * Esse método obtém um cliente do banco de dados através do ID passado
     * e retorna se ele estiver cadastrado
     * @param id id do cliente no sistema
     * @return retorna o cliente através do id
     */
    public Client getClientById(Long id);

    /**
     * Esse método insere um cliente cadastrado no banco de dados
     * @param clientDto os dados informados pelo cliente para cadastro
     * @return retorna o cliente cadastrado
     */
    public Client insertClient(ClientDto clientDto);

    /**
     * Esse método atualiza um cliente no banco de dados
     * @param id id do usário que deve ser atualizado
     * @param clientDto os dados informados pelo cliente para atualização
     * @return retorna o cliente atualizado
     */
    public Client updateClient(Long id, ClientDto clientDto);

    /**
     * Esse método exclui um usuário do sistema
     * @param id do usuário a ser excluido
     */
    public void deleteClient(Long id);
}
