package com.api.dealership.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.dealership.dto.ClientDto;
import com.api.dealership.dto.SaleDto;
import com.api.dealership.entity.Client;
import com.api.dealership.repository.ClientRepository;
import com.api.dealership.service.IClientService;


@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private SaleService saleService;

    @Autowired
    private CarService carService;

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> getClients(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Client> clients = clientRepository.findAll(pageRequest);
        return clients.getContent();
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public Client insertClient(ClientDto clientDto) {
        Client client = new Client();
        BeanUtils.copyProperties(clientDto, client);
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Long id, ClientDto clientDto) {
        Client client = getClientById(id);
        BeanUtils.copyProperties(clientDto, client);
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public void buyCar(SaleDto saleDto){
        carService.incrementSoldAmount(saleDto.getCarId());
        saleService.makesSale(saleDto);
    }
    
}
