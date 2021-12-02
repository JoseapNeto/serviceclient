package com.spring.application.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.time.LocalDate;


@Entity
@Data
public class ClienteEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotBlank(message = "O campo nome é obrigatorio")
    private String nome;

    @Column(nullable = false, length = 11)
    @NotBlank(message = "O campo campo cpf obrigatorio")
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;



    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }






}
