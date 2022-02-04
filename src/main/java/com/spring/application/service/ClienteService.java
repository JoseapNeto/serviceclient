package com.spring.application.service;

import com.spring.application.entity.ClienteEntity;
import com.spring.application.repository.ServicoRepository;
import com.spring.application.repository.ClienteRepository;
import com.sun.deploy.security.ValidationState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ServicoRepository servicoRepository;


    public ClienteEntity insert(ClienteEntity cliente){
        cliente = clienteRepository.save(cliente);
    return cliente;
    }

    public List<ClienteEntity> findAll(){
    return clienteRepository.findAll();
    }

    public ClienteEntity getClienteById(Integer id){
       return clienteRepository.findById(id).orElseThrow(() ->
    new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado") {
        });
    }

    //DeleteById
    public void deleteClienteById(Integer id){
         clienteRepository.findById(id).map(ClienteEntity -> {clienteRepository.delete(ClienteEntity);
             return Void.TYPE;}).orElseThrow(() ->
                 new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
     }

    public void updateClienteById(Integer id, ClienteEntity cliente){
        clienteRepository.findById(id).map(ClienteEntity -> {
            ClienteEntity.setNome(cliente.getNome());
            ClienteEntity.setCpf(cliente.getCpf());
            clienteRepository.save(ClienteEntity);
         return Void.TYPE;}).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
    }













/*
    for(AddressEntity a: cliente.getAddressEntity()){
        a.setCliente(cliente);
        addressRepository.save(a);
    }
*/
}
