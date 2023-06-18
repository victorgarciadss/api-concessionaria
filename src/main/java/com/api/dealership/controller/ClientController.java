package com.api.dealership.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dealership.dto.ClientDto;
import com.api.dealership.entity.Client;
import com.api.dealership.service.impl.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClientController {
    
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClients(){
        return clientService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Client getClientById(@PathVariable("id") Long id){
        return clientService.getClientById(id);
    }

    @PostMapping
    public Client insertClient(@Valid @RequestBody ClientDto clientDto){
        return clientService.insertClient(clientDto);
    }

    @PutMapping(value = "/{id}")
    public Client updateClient(@PathVariable("id") Long id, @Valid @RequestBody ClientDto clientDto){
        return clientService.updateClient(id, clientDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteClient(@PathVariable("id") Long id){
        clientService.deleteClient(id);
    }
}
