package com.marcos2.praticamarcos.service;


import com.marcos2.praticamarcos.database.model.AlunosEntity;
import com.marcos2.praticamarcos.database.model.AvaliacaoFisicaEntity;
import com.marcos2.praticamarcos.database.repository.IAlunosRepository;
import com.marcos2.praticamarcos.dto.AlunosDto;
import com.marcos2.praticamarcos.exception.BadRequestException;
import com.marcos2.praticamarcos.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunosService {

    private final IAlunosRepository alunosRepository;

    public List<AlunosEntity> findAll(){
        return alunosRepository.findAll();
    }

    public void save(AlunosDto alunosDto) throws BadRequestException {

      AlunosEntity aluno = alunosRepository.findByEmail(alunosDto.getEmail())
               .orElse(null);

       if (aluno != null) {
           throw new BadRequestException("Aluno Já Cadastrado com esse email");
       }

        AlunosEntity  novoAluno = AlunosEntity.builder()
                .nome(alunosDto.getNome())
                .email(alunosDto.getEmail())
                .build();

        alunosRepository.save(novoAluno);
    }

    public AvaliacaoFisicaEntity getAlunosAavaliacao(Integer alunoId) throws NotFoundException {
        AlunosEntity aluno = alunosRepository.findById(alunoId)
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        AvaliacaoFisicaEntity avaliacao = aluno.getAvaliacaoFisica();
        if (avaliacao == null){
            throw new NotFoundException("Avalição fisica não encontrada para este aluno");
        }

        return avaliacao;

    }
}
