package com.br.app.application.validator;

import com.br.app.application.validator.RegraValidacao;

// Valida se a senha contém ao menos um dígito
class DigitoRegra implements RegraValidacao {
    @Override
    public boolean validar(String senha) {
        return senha.chars().anyMatch(Character::isDigit);
    }
}
