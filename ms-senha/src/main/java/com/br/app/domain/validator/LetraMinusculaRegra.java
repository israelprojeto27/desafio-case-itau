package com.br.app.domain.validator;

// Valida se a senha contém ao menos uma letra minúscula
class LetraMinusculaRegra implements RegraValidacao {
    @Override
    public boolean validar(String senha) {
        return senha.chars().anyMatch(Character::isLowerCase);
    }
}
