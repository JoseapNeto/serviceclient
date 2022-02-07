package com.spring.application.resource;


import com.spring.application.entity.ServicoEntity;
import com.spring.application.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/address")
//@CrossOrigin("http://localhost:4200")
public class ServicoResource {

    @Autowired
    ServicoService servicoService;

    @PostMapping
    public ResponseEntity<ServicoEntity> insert(@RequestBody ServicoEntity address){
        address = servicoService.insert(address);
        return ResponseEntity.ok().body(address);

    }


}
