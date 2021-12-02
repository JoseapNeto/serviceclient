package com.spring.application.service;

import com.spring.application.entity.ServicoEntity;
import com.spring.application.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServicoService {

    @Autowired
    ServicoRepository servicoRepository;


    public ServicoEntity insert(ServicoEntity address){
        address = servicoRepository.save(address);
         return address;
    }



}
