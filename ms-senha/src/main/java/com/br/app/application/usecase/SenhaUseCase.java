package com.br.app.application.usecase;

import com.br.app.application.dto.InputSenhaDTO;
import com.br.app.domain.validator.SenhaValidator;
import com.br.app.domain.exception.SenhaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenhaUseCase {


    @Autowired
    public SenhaValidator validator;

    public boolean checkValidSenha(InputSenhaDTO dto) throws SenhaException {
        if (dto != null && dto.getInput() != null){
            return validator.validar(dto.getInput());
        }
        throw new SenhaException("Senha informada nao pode ser nula");
    }
}
