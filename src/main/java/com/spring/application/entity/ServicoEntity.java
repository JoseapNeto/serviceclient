package com.spring.application.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class ServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;

    @JsonIgnore
    @ManyToOne
    //@JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;



    }

