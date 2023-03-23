package com.br.cadastro.endereco.controller;

import com.br.cadastro.endereco.model.dto.EnderecoRequest;
import com.br.cadastro.endereco.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class EnderecoController {
    private final EnderecoService enderecoService;

    @PostMapping("/consulta")
    public ResponseEntity consultaCep(@RequestBody EnderecoRequest enderecoRequest) {
        return ResponseEntity.ok(enderecoService.executa(enderecoRequest));
    }
}