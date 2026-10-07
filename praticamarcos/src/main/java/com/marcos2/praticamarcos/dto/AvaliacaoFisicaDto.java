package com.marcos2.praticamarcos.dto;

import jakarta.annotation.Nonnull;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AvaliacaoFisicaDto {
    @Nonnull
    private Integer alunoId;
    @Nonnull
    private BigDecimal peso;
    @Nonnull
    private BigDecimal altura;
    @Nonnull
    private BigDecimal percentualGorduraCorporal;
}
