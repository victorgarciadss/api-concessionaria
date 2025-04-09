package com.api.dealership.controller;

import java.util.List;

import com.api.dealership.controller.docsInterfaces.ClientControllerDoc;
import com.api.dealership.pages.PaginationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.api.dealership.dto.ClientDto;
import com.api.dealership.dto.SaleDto;
import com.api.dealership.entity.Client;
import com.api.dealership.service.impl.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClientController implements ClientControllerDoc {
    
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClients(){
        return clientService.getAll();
    }

    @Override
    @GetMapping(value = "/paginado")
    public PaginationData<Client> getClients(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return clientService.getClients(page, size);
    }

    @Override
    @GetMapping(value = "/{id}")
    public Client getClientById(@PathVariable("id") Long id){
        return clientService.getClientById(id);
    }

    @Override
    @PostMapping
    public Client insertClient(@Valid @RequestBody ClientDto clientDto){
        return clientService.insertClient(clientDto);
    }

    @Override
    @PutMapping(value = "/{id}")
    public Client updateClient(@PathVariable("id") Long id, @Valid @RequestBody ClientDto clientDto){
        return clientService.updateClient(id, clientDto);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void deleteClient(@PathVariable("id") Long id){
        clientService.deleteClient(id);
    }

    @Override
    @PostMapping(value = "/compra")
    public void makesPurchase(@Valid @RequestBody SaleDto saleDto){
        clientService.buyCar(saleDto);
    }
}
