package com.br.app.application.validator;

import com.br.app.application.validator.RegraValidacao;

import java.util.HashSet;
import java.util.Set;

// Valida se a senha não contém caracteres repetidos
class CaractereUnicoRegra implements RegraValidacao {
    @Override
    public boolean validar(String senha) {
        Set<Character> caracteres = new HashSet<>();
        for (char c : senha.toCharArray()) {
            if (!caracteres.add(c)) {
                return false;
            }
        }
        return true;
    }
}
