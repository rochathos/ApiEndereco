package com.br.cadastro.endereco.controller;

import com.br.cadastro.endereco.model.dto.EnderecoResponse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoControllerTest {
    private static final String cep = " 01001000";
    private static final String rua = "praça da Sé";
    private static final String complemento = "lado impar";
    private static final String bairro = " Se";
    private static final String cidade = " São paulo";
    private static final String estado = " SP";
    private static final String frete = "15,00";

    private EnderecoResponse enderecoResponse;


    @Test
    void naoContemCep() {
        
    }

    @BeforeEach
    void setUp() {

    }

    @AfterAll
    static void afterAll() {

    }
    private void startaEndereco(){
        enderecoResponse = new EnderecoResponse(cep,rua, complemento,bairro,cidade,estado, frete);
    }

}