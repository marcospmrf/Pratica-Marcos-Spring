package com.marcos2.praticamarcos.dto;


import lombok.*;


import java.util.List;
;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TreinoDto {

    private Integer alunoId;
    private String nome;
    private List<Integer> exerciciosIds;



}