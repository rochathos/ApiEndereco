package com.br.cadastro.endereco.service;

import com.br.cadastro.endereco.feign.EnderecoFeign;
import com.br.cadastro.endereco.model.dto.EnderecoDto;
import com.br.cadastro.endereco.model.dto.EnderecoRequest;
import com.br.cadastro.endereco.model.dto.EnderecoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

@RequiredArgsConstructor
@Service
public class EnderecoService {

    private final EnderecoFeign enderecoFeign;
    ArrayList<String> norte = new ArrayList<String>(Arrays.asList("RR", "AP", "AM", "PA", "AC", "RO", "TO"));
    ArrayList<String> nordeste = new ArrayList<String>(Arrays.asList("MA", "PI", "CE", "RN", "PB", "PE", "AL", "SE", "BA"));
    ArrayList<String> centroOeste = new ArrayList<String>(Arrays.asList("MT", "GO", "MS", "DF"));
    ArrayList<String> suldeste = new ArrayList<String>(Arrays.asList("MG", "ES", "RJ", "SP"));

    public EnderecoResponse executa(EnderecoRequest request) {
        EnderecoResponse enderecoResponse = enderecoFeign.buscaEnderecoCep(request.getCep());
        if (norte.contains(enderecoResponse.getUf())) {
            enderecoResponse.setFrete("20,83");
        } else if (nordeste.contains(enderecoResponse.getUf())) {
            enderecoResponse.setFrete("15,98");
        } else if (suldeste.contains(enderecoResponse.getUf())) {
            enderecoResponse.setFrete("7,85");
        } else if (centroOeste.contains(enderecoResponse.getUf())) {
            enderecoResponse.setFrete("12,50");
        } else {
            enderecoResponse.setFrete("17,30");
        }
        return enderecoResponse;
    }

    public EnderecoDto getCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<EnderecoDto> resp = restTemplate.getForEntity(String.format("https://viacep.com.br/ws/%s/json/", cep), EnderecoDto.class);
        if (norte.contains(resp.getBody().getUf())) {
            resp.getBody().setFrete("20,83");
        } else if (nordeste.contains(resp.getBody().getUf())) {
            resp.getBody().setFrete("15,98");
        } else if (suldeste.contains(resp.getBody().getUf())) {
            resp.getBody().setFrete("7,85");
        } else if (centroOeste.contains(resp.getBody().getUf())) {
            resp.getBody().setFrete("12,50");
        } else {
            resp.getBody().setFrete("17,30");
        }
        return resp.getBody();
    }
}
