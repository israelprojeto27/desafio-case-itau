package com.br.app.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ResponseInputSenhaDTO {

    private String message;
    private HttpStatus httpStatus;

    public static ResponseInputSenhaDTO from(String message, HttpStatus httpStatus){
        return ResponseInputSenhaDTO.builder()
                .message(message)
                .httpStatus(httpStatus)
                .build();
    }

}
