package com.br.app.domain.validator;

// Valida se a senha contém ao menos um caractere especial
class CaractereEspecialRegra implements RegraValidacao {
    private final String especiais = "!@#$%^&*()-+";

    @Override
    public boolean validar(String senha) {
        return senha.chars().anyMatch(c -> especiais.indexOf(c) != -1);
    }
}
