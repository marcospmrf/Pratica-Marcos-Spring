package com.marcos2.praticamarcos.controller;

import com.marcos2.praticamarcos.database.model.AlunosEntity;
import com.marcos2.praticamarcos.database.model.AvaliacaoFisicaEntity;
import com.marcos2.praticamarcos.dto.AlunosDto;
import com.marcos2.praticamarcos.exception.BadRequestException;
import com.marcos2.praticamarcos.exception.NotFoundException;
import com.marcos2.praticamarcos.service.AlunosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/alunos")
@RequiredArgsConstructor
public class AlunosController {

    private final AlunosService alunosService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AlunosEntity> findAll(){
        return alunosService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody AlunosDto alunosDto) throws BadRequestException {
        alunosService.save(alunosDto);
    }

    @GetMapping("/{alunoId}/avaliacao")
    public AvaliacaoFisicaEntity getAvaliacaoFisica(@PathVariable Integer alunoId) throws NotFoundException {
        return alunosService.getAlunosAavaliacao(alunoId);
    }
}
