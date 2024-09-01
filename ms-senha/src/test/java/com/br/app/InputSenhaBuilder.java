package com.br.app;

import com.br.app.application.dto.InputSenhaDTO;

public class InputSenhaBuilder {

    private static InputSenhaDTO dto = new InputSenhaDTO();

    public static InputSenhaDTO buildInputValid() {
        dto.setInput("Aa12@78b3E");
        return dto;
    }

    public static InputSenhaDTO buildInputEmpty() {
        dto.setInput("");
        return dto;
    }

    public static InputSenhaDTO buildInputNull() {
        dto.setInput(null);
        return dto;
    }

    public static InputSenhaDTO buildInputOneCharacter() {
        dto.setInput("a");
        return dto;
    }

    public static InputSenhaDTO buildInputOneDigit() {
        dto.setInput("1");
        return dto;
    }

    public static InputSenhaDTO buildInputOneSpecialCharacter() {
        dto.setInput("#");
        return dto;
    }



    public static InputSenhaDTO buildInputSizeNineCharacters() {
        dto.setInput("Ab12#3oP");
        return dto;
    }

    public static InputSenhaDTO buildInputWithoutOneCharacterUpperCase() {
        dto.setInput("ab#c14dp34");
        return dto;
    }

    public static InputSenhaDTO buildInputWithoutOneCharacterLowerCase() {
        dto.setInput("AB#C14DP34");
        return dto;
    }

    public static InputSenhaDTO buildInputWithoutOneDigit() {
        dto.setInput("Ab#cdPeFhQ@");
        return dto;
    }

    public static InputSenhaDTO buildInputWithoutOneSpecialCharacter() {
        dto.setInput("Ab1cdPeFhQ2");
        return dto;
    }

    public static InputSenhaDTO buildInputWithSpaceBetween() {
        dto.setInput("AbTp9 fok");
        return dto;
    }

    public static InputSenhaDTO buildInputWithDuplicateCharacters() {
        dto.setInput("Ab1#cdPeFhQ2A");
        return dto;
    }

    public static InputSenhaDTO buildInputWithDuplicateDigits() {
        dto.setInput("Ab1#cdPeFhQ21");
        return dto;
    }

    public static InputSenhaDTO buildInputWithDuplicateSpecialCharacters() {
        dto.setInput("Ab1#cdPeFhQ2#");
        return dto;
    }

    public static InputSenhaDTO buildInputWithDuplicateCharactersAndDigits() {
        dto.setInput("Ab1#cdPeFhQ2A1");
        return dto;
    }

    public static InputSenhaDTO buildInputWithDuplicateCharactersAndSpecialCharacters() {
        dto.setInput("Ab1#cdPeFhQ2A#");
        return dto;
    }

    public static InputSenhaDTO buildInputWithDuplicateCharactersAndDigitsAndSpecialCharacters() {
        dto.setInput("Ab1#cdPeFhQ2A1#");
        return dto;
    }
}
