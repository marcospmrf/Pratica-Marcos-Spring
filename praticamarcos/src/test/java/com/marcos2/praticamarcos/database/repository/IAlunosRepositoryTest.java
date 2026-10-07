package com.marcos2.praticamarcos.database.repository;

import com.marcos2.praticamarcos.database.model.AlunosEntity;
import com.marcos2.praticamarcos.dto.AlunosDto;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class IAlunosRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    IAlunosRepository alunosRepository;

    @Test
    @DisplayName("Should get User successfyly from DB")
    void findByEmailCase1() {
        String email = "Teste@gmail.com";
        AlunosDto alunosDto = AlunosDto.builder()
                .nome("teste")
                .email(email)
                .build();
        crateUser(alunosDto);
       Optional<AlunosEntity> foundAluno = alunosRepository.findByEmail(email);

       assertThat(foundAluno.isPresent()).isTrue();


    }

    @Test
    @DisplayName("Should not get aluno successfyly from DB")
    void findByEmailCase2() {
        String email = "Teste@gmail.com";
        Optional<AlunosEntity> foundAluno = alunosRepository.findByEmail(email);

        assertThat(foundAluno.isEmpty()).isTrue();


    }

    private AlunosEntity crateUser(AlunosDto alunosDto) {
        AlunosEntity novoAluno = AlunosEntity.builder()
                .nome(alunosDto.getNome())
                .email(alunosDto.getEmail())
                .build();
        entityManager.persist(novoAluno);
        return novoAluno;
    }
}