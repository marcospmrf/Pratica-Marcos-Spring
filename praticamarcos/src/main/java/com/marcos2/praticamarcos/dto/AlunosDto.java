package com.marcos2.praticamarcos.dto;

import com.marcos2.praticamarcos.database.model.AvaliacaoFisicaEntity;
import com.marcos2.praticamarcos.database.model.TreinosEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AlunosDto {

    private String nome;
    private String email;
    private AvaliacaoFisicaEntity avaliacaoFisica;
    private Set<TreinosEntity> treinos;

}