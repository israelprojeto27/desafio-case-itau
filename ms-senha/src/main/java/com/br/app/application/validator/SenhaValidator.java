package com.br.app.application.validator;



import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

// Classe principal que valida a senha usando todas as regras
@Component
public class SenhaValidator {
    private final Set<RegraValidacao> regras = new HashSet<>();

    public SenhaValidator() {
        regras.add(new TamanhoMinimoRegra());
        regras.add(new DigitoRegra());
        regras.add(new LetraMinusculaRegra());
        regras.add(new LetraMaiusculaRegra());
        regras.add(new CaractereEspecialRegra());
        regras.add(new CaractereUnicoRegra());
    }

    public boolean validar(String senha) {
        return regras.stream().allMatch(regra -> regra.validar(senha));
    }
}
