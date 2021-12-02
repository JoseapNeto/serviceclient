package com.spring.application.resource;


import com.spring.application.entity.ClienteEntity;
import com.spring.application.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/clientes")
@CrossOrigin("http://localhost:4200")
public class ClienteResource {


    @Autowired
    ClienteService clienteService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ClienteEntity> insert(@RequestBody @Validated ClienteEntity cliente){
        cliente = clienteService.insert(cliente);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteEntity> getClienteById(@PathVariable Integer id){
      ClienteEntity cliente = clienteService.getClienteById(id);
      return ResponseEntity.ok().body(cliente);
    }

    @GetMapping()
    public  ResponseEntity<List<ClienteEntity>> findAll(){
    List<ClienteEntity> listCliente = new ArrayList<ClienteEntity>();
    listCliente = clienteService.findAll();
        return ResponseEntity.ok().body(listCliente);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteClienteById(@PathVariable Integer id){
        clienteService.deleteClienteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public ResponseEntity<Void> updateCliente(@PathVariable Integer id,
                                              @RequestBody ClienteEntity cliente){
        clienteService.updateClienteById(id, cliente);
        return ResponseEntity.noContent().build();
    }


}
