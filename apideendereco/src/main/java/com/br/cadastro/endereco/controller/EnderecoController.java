package com.br.cadastro.endereco.controller;

import com.br.cadastro.endereco.model.dto.EnderecoDto;
import com.br.cadastro.endereco.model.dto.EnderecoRequest;
import com.br.cadastro.endereco.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class EnderecoController {
    private final EnderecoService enderecoService;

    @PostMapping("/consulta")
    public ResponseEntity consultaCep(@RequestBody EnderecoRequest enderecoRequest) {
        ResponseEntity response = ResponseEntity.ok(enderecoService.executa(enderecoRequest));
        return response;
    }
    @GetMapping("/{cep}")
    public EnderecoDto consultaCepGet(@PathVariable("cep") String cep) {
        return enderecoService.getCep(cep);
    }
}