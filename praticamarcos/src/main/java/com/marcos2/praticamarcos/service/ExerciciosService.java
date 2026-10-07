package com.marcos2.praticamarcos.service;

import com.marcos2.praticamarcos.database.model.AlunosEntity;
import com.marcos2.praticamarcos.database.model.ExerciciosEntity;
import com.marcos2.praticamarcos.database.repository.IExerciciosRepository;
import com.marcos2.praticamarcos.dto.ExerciciosDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciciosService {
    private final IExerciciosRepository exerciciosRepository;


    public List<ExerciciosEntity> findAll(){
        return exerciciosRepository.findAll();
    }

    public void save(ExerciciosDto exerciciosDto) {
        ExerciciosEntity novoExercicio = ExerciciosEntity.builder()
                .nome(exerciciosDto.getNome())
                .grupoMuscular(exerciciosDto.getGrupoMuscular())
                .build();
        exerciciosRepository.save(novoExercicio);
    }

}
