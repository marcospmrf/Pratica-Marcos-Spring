package com.marcos2.praticamarcos.controller;

import com.marcos2.praticamarcos.database.model.ExerciciosEntity;
import com.marcos2.praticamarcos.dto.ExerciciosDto;
import com.marcos2.praticamarcos.service.ExerciciosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/exercicios")
@RequiredArgsConstructor
public class ExerciciosController {

    private final ExerciciosService exerciciosService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ExerciciosEntity> findAll(){
        return exerciciosService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save( @RequestBody  ExerciciosDto exerciciosDto){
        exerciciosService.save(exerciciosDto);
    }
}
