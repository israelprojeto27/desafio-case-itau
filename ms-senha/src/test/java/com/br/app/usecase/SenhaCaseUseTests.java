package com.br.app.usecase;

import com.br.app.application.dto.InputSenhaDTO;
import com.br.app.application.usecase.SenhaUseCase;
import com.br.app.domain.validator.SenhaValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SenhaCaseUseTests {

    @InjectMocks
    SenhaUseCase useCase;

    @InjectMocks
    SenhaValidator validator;


    @BeforeEach
    void setup(){
        useCase.validator = validator;
    }

    @Test
    void shouldReturnTrueWhenInputIsValid(){
        boolean isValid = useCase.checkValidSenha(new InputSenhaDTO("Flamengo01#"));
        Assertions.assertEquals(true, isValid);
    }

    @Test
    void shouldReturnFalseWhenInputIsEmpty(){
        boolean isValid = useCase.checkValidSenha(new InputSenhaDTO(""));
        Assertions.assertEquals(false, isValid);
    }

    @Test
    void shouldReturnFalseWhenInputIsEmptyStrip(){
        boolean isValid = useCase.checkValidSenha(new InputSenhaDTO(" "));
        Assertions.assertEquals(false, isValid);
    }

    @Test
    void shouldReturnFalseWhenInputIsOneCharacter(){
        boolean isValid = useCase.checkValidSenha(new InputSenhaDTO("a"));
        Assertions.assertEquals(false, isValid);
    }

    @Test
    void shouldReturnFalseWhenSizeInputIsLessThanNineCharacters(){
        boolean isValid = useCase.checkValidSenha(new InputSenhaDTO("Ab#c14"));
        Assertions.assertEquals(false, isValid);
    }

    @Test
    void shouldReturnFalseWhenInputWithoutOneCharacterUpperCase(){
        boolean isValid = useCase.checkValidSenha(new InputSenhaDTO("ab#c14dp34"));
        Assertions.assertEquals(false, isValid);
    }

    @Test
    void shouldReturnFalseWhenInputWithoutOneCharacterLowerCase(){
        boolean isValid = useCase.checkValidSenha(new InputSenhaDTO("AB#c14DP34"));
        Assertions.assertEquals(false, isValid);
    }

    @Test
    void shouldReturnFalseWhenInputWithoutOneDigit(){
        boolean isValid = useCase.checkValidSenha(new InputSenhaDTO("Aa#cefdP@p"));
        Assertions.assertEquals(false, isValid);
    }

    @Test
    void shouldReturnFalseWhenInputWithoutOneSpecialCharacter(){
        boolean isValid = useCase.checkValidSenha(new InputSenhaDTO("Aa1cefdP2p"));
        Assertions.assertEquals(false, isValid);
    }


    @Test
    void shouldReturnFalseWhenInputWithSpaceBetween(){
        boolean isValid = useCase.checkValidSenha(new InputSenhaDTO("AbTp9 fok"));
        Assertions.assertEquals(false, isValid);
    }

    @Test
    void shouldReturnFalseWhenInputWithDuplicateCharacters(){
        boolean isValid = useCase.checkValidSenha(new InputSenhaDTO("Aa1#@fdP2pA"));
        Assertions.assertEquals(false, isValid);
    }

    @Test
    void shouldReturnFalseWhenInputWithDuplicateDigits(){
        boolean isValid = useCase.checkValidSenha(new InputSenhaDTO("Aa1#@fdP2p2"));
        Assertions.assertEquals(false, isValid);
    }

    @Test
    void shouldReturnFalseWhenInputWithDuplicateSpecialCharacters(){
        boolean isValid = useCase.checkValidSenha(new InputSenhaDTO("Aa1#@fdP2p@"));
        Assertions.assertEquals(false, isValid);
    }


    @Test
    void shouldReturnFalseWhenInputWithDuplicateCharactersAndDigits(){
        boolean isValid = useCase.checkValidSenha(new InputSenhaDTO("Aa1#@fdP2pA1"));
        Assertions.assertEquals(false, isValid);
    }

    @Test
    void shouldReturnFalseWhenInputWithDuplicateCharactersAndSpecialCharacters(){
        boolean isValid = useCase.checkValidSenha(new InputSenhaDTO("Aa1#@fdP2pA@"));
        Assertions.assertEquals(false, isValid);
    }


    @Test
    void shouldReturnFalseWhenInputWithDuplicateCharactersAndDigitsSpecialCharacters(){
        boolean isValid = useCase.checkValidSenha(new InputSenhaDTO("Aa1#@fdP2pA@1"));
        Assertions.assertEquals(false, isValid);
    }
}
