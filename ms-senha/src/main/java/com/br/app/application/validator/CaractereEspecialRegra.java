package com.br.app.application.validator;

import com.br.app.application.validator.RegraValidacao;

// Valida se a senha contém ao menos um caractere especial
class CaractereEspecialRegra implements RegraValidacao {
    private final String especiais = "!@#$%^&*()-+";

    @Override
    public boolean validar(String senha) {
        return senha.chars().anyMatch(c -> especiais.indexOf(c) != -1);
    }
}
