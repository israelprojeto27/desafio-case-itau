package com.br.app.infrastructure.controllers;

import com.br.app.application.dto.InputSenhaDTO;
import com.br.app.application.usecase.SenhaUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/senha")
@Tag(name = "Senha Controller")
public class SenhaController {

    @Autowired
    SenhaUseCase useCase;

    @PostMapping(path = "/valida-senha")
    @Operation(summary = "Endpoint valida senha a partir de input informado")
    public boolean validaSenha( @RequestBody InputSenhaDTO dto)  {
        return useCase.checkValidSenha(dto);
    }
}
