package com.marcos2.praticamarcos.service;

import com.marcos2.praticamarcos.database.model.AlunosEntity;
import com.marcos2.praticamarcos.database.model.ExerciciosEntity;
import com.marcos2.praticamarcos.database.model.TreinosEntity;
import com.marcos2.praticamarcos.database.repository.IAlunosRepository;
import com.marcos2.praticamarcos.database.repository.IExerciciosRepository;
import com.marcos2.praticamarcos.database.repository.ITreinoRepository;
import com.marcos2.praticamarcos.dto.TreinoDto;
import com.marcos2.praticamarcos.exception.BadRequestException;
import com.marcos2.praticamarcos.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TreinoService {

    private final ITreinoRepository treinoRepository;
    private final IAlunosRepository alunosRepository;
    private final IExerciciosRepository exerciciosRepository;

    public void criarTreino(TreinoDto treinoDto) throws NotFoundException, BadRequestException {
        Set<ExerciciosEntity> exercicios = new HashSet<>();
        AlunosEntity aluno = alunosRepository.findById(treinoDto.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Aluno nao encontrado"));

       TreinosEntity treino = treinoRepository.findByNomeAndAlunoId(treinoDto.getNome(), treinoDto.getAlunoId())
                .orElse(null);

       if ( treino != null) {
           throw new BadRequestException(("Aluno ja possui este treino"));
       }

       for (Integer exerciciosId : treinoDto.getExerciciosIds()) {
           ExerciciosEntity exercicio = exerciciosRepository.findById(exerciciosId)
                   .orElseThrow(() -> new NotFoundException("Exercicio nao encontrado"));

           exercicios.add(exercicio);
       }

       treino = TreinosEntity.builder()
               .nome(treinoDto.getNome())
               .aluno(aluno)
               .exercicios(exercicios)
               .build();

       treinoRepository.save(treino);
    }
}
