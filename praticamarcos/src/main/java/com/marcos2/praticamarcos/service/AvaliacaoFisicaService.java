package com.marcos2.praticamarcos.service;

import com.marcos2.praticamarcos.database.model.AlunosEntity;
import com.marcos2.praticamarcos.database.model.AvaliacaoFisicaEntity;
import com.marcos2.praticamarcos.database.repository.IAlunosRepository;
import com.marcos2.praticamarcos.database.repository.IAvaliacaoFisicaRepository;
import com.marcos2.praticamarcos.dto.AvaliacaoFisicaDto;
import com.marcos2.praticamarcos.exception.BadRequestException;
import com.marcos2.praticamarcos.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliacaoFisicaService {

    private final IAlunosRepository alunosRepository;
    private final IAvaliacaoFisicaRepository avaliacaoFisicaRepository;

    public void criarAvaliacao(AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException, BadRequestException {
       AlunosEntity aluno = alunosRepository.findById(avaliacaoFisicaDto.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Aluno não Encontrado"));

        AvaliacaoFisicaEntity avaliacaoFisica = aluno.getAvaliacaoFisica();

        if (avaliacaoFisica != null) {
            throw new BadRequestException("Avaliação fisica ja cadastrada para este aluno");
        }
        avaliacaoFisica = AvaliacaoFisicaEntity.builder()
                .peso(avaliacaoFisicaDto.getPeso())
                .altura(avaliacaoFisicaDto.getAltura())
                .percentualGorduraCorporal(avaliacaoFisicaDto.getPercentualGorduraCorporal())
                .build();

        aluno.setAvaliacaoFisica(avaliacaoFisica);
        alunosRepository.save(aluno);
    }


}
