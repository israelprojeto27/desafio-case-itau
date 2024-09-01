package com.br.app.application.validator;

import com.br.app.application.validator.RegraValidacao;

// Valida se a senha contém ao menos uma letra minúscula
class LetraMinusculaRegra implements RegraValidacao {
    @Override
    public boolean validar(String senha) {
        return senha.chars().anyMatch(Character::isLowerCase);
    }
}
