package com.br.app.domain.validator;

// Valida se a senha contém ao menos uma letra maiúscula
class LetraMaiusculaRegra implements RegraValidacao {
    @Override
    public boolean validar(String senha) {
        return senha.chars().anyMatch(Character::isUpperCase);
    }
}
