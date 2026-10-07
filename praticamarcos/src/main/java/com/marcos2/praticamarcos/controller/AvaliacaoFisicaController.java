package com.marcos2.praticamarcos.controller;

import com.marcos2.praticamarcos.dto.AvaliacaoFisicaDto;
import com.marcos2.praticamarcos.exception.BadRequestException;
import com.marcos2.praticamarcos.exception.NotFoundException;
import com.marcos2.praticamarcos.service.AvaliacaoFisicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/avaliacoes")
@RequiredArgsConstructor
public class AvaliacaoFisicaController {

    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAvaliacao(@RequestBody AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException, BadRequestException {
        avaliacaoFisicaService.criarAvaliacao(avaliacaoFisicaDto);
    }
}
