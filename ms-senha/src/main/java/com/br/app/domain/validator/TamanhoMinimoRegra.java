package com.br.app.domain.validator;

// Valida se a senha possui no mínimo 9 caracteres
public class TamanhoMinimoRegra implements RegraValidacao {
    @Override
    public boolean validar(String senha) {
        return senha.length() >= 9;
    }
}
