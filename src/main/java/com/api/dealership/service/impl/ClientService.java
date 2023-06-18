package com.api.dealership.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dealership.dto.ClientDto;
import com.api.dealership.entity.Client;
import com.api.dealership.repository.ClientRepository;
import com.api.dealership.service.IClientService;


@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
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
    public Client updateClient(ClientDto clientDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateClient'");
    }

    @Override
    public void deleteClient(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteClient'");
    }
    
}
