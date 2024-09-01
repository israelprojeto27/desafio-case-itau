package com.br.app.controllers;

import com.br.app.builders.InputSenhaBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.NestedServletException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
public class SenhaControllerTests {

    @Autowired
    WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private Gson gson = new GsonBuilder().create();

    private static final String BASE_URL = "/senha/valida-senha";

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    void shouldReturnTrueWhenInputValid() throws Exception {
        var dto = InputSenhaBuilder.buildInputValid();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(true, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputIsEmpty() throws Exception {
        var dto = InputSenhaBuilder.buildInputEmpty();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputIsNull() throws Exception {
        var dto = InputSenhaBuilder.buildInputNull();
        Throwable throwable =  Assertions.assertThrows(Throwable.class, () -> {
            final MvcResult mvcResult =
                    mockMvc.perform(post(BASE_URL)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(gson.toJson(dto)))
                            .andReturn();
        });
        Assertions.assertEquals("Senha informada nao pode ser nula", ((NestedServletException) throwable).getRootCause().getMessage());
    }

    @Test
    void shouldReturnFalseWhenInputWithOneCharacter() throws Exception {
        var dto = InputSenhaBuilder.buildInputOneCharacter();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithOneDigit() throws Exception {
        var dto = InputSenhaBuilder.buildInputOneDigit();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithOneSpecialCharacter() throws Exception {
        var dto = InputSenhaBuilder.buildInputOneSpecialCharacter();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenSizeInputIsLessThanNineCharacters() throws Exception {
        var dto = InputSenhaBuilder.buildInputSizeNineCharacters();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithoutOneCharacterUpperCase() throws Exception {
        var dto = InputSenhaBuilder.buildInputWithoutOneCharacterUpperCase();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithoutOneCharacterLowerCase() throws Exception {
        var dto = InputSenhaBuilder.buildInputWithoutOneCharacterLowerCase();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithoutOneDigit() throws Exception {
        var dto = InputSenhaBuilder.buildInputWithoutOneDigit();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }


    @Test
    void shouldReturnFalseWhenInputWithoutOneSpecialCharacter() throws Exception {
        var dto = InputSenhaBuilder.buildInputWithoutOneSpecialCharacter();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }


    @Test
    void shouldReturnFalseWhenInputWithSpaceBetween() throws Exception {
        var dto = InputSenhaBuilder.buildInputWithSpaceBetween();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithDuplicateCharacters() throws Exception {
        var dto = InputSenhaBuilder.buildInputWithDuplicateCharacters();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithDuplicateDigits() throws Exception {
        var dto = InputSenhaBuilder.buildInputWithDuplicateDigits();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithDuplicateSpecialCharacters() throws Exception {
        var dto = InputSenhaBuilder.buildInputWithDuplicateSpecialCharacters();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }


    @Test
    void shouldReturnFalseWhenInputWithDuplicateCharactersAndDigits() throws Exception {
        var dto = InputSenhaBuilder.buildInputWithDuplicateCharactersAndDigits();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    void shouldReturnFalseWhenInputWithDuplicateCharactersAndSpecialCharacters() throws Exception {
        var dto = InputSenhaBuilder.buildInputWithDuplicateCharactersAndSpecialCharacters();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }


    @Test
    void shouldReturnFalseWhenInputWithDuplicateCharactersAndDigitsSpecialCharacters() throws Exception {
        var dto = InputSenhaBuilder.buildInputWithDuplicateCharactersAndDigitsAndSpecialCharacters();
        final MvcResult mvcResult =
                mockMvc.perform(post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(dto)))
                        .andReturn();

        boolean response = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        Assertions.assertEquals(false, response);
        Assertions.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }




}
