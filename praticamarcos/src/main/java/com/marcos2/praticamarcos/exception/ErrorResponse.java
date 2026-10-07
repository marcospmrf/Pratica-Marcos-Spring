package com.marcos2.praticamarcos.exception;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {

    private String message;
    private Integer status;
}
