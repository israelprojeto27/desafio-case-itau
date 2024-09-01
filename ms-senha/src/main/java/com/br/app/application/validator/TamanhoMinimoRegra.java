package com.br.app.application.validator;

import com.br.app.application.validator.RegraValidacao;

// Valida se a senha possui no mínimo 9 caracteres
public class TamanhoMinimoRegra implements RegraValidacao {
    @Override
    public boolean validar(String senha) {
        return senha.length() >= 9;
    }
}
