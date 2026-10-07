package com.marcos2.praticamarcos.database.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "avalicoes_fisicas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class AvaliacaoFisicaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private BigDecimal peso;
    @Column(nullable = false)
    private BigDecimal altura;
    @Column(name = "percentual_gordura_corporal")
    private BigDecimal percentualGorduraCorporal;

}
