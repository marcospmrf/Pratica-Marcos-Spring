package com.marcos2.praticamarcos.controller;

import com.marcos2.praticamarcos.dto.TreinoDto;
import com.marcos2.praticamarcos.exception.BadRequestException;
import com.marcos2.praticamarcos.exception.NotFoundException;
import com.marcos2.praticamarcos.service.TreinoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/treino")
@RequiredArgsConstructor
public class TreinoController {

    private final TreinoService treinoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarTreino(@RequestBody TreinoDto treinoDto) throws NotFoundException, BadRequestException {
        treinoService.criarTreino(treinoDto);
    }
}
