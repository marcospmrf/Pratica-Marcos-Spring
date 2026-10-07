package com.marcos2.praticamarcos.service;


import com.marcos2.praticamarcos.database.model.AlunosEntity;
import com.marcos2.praticamarcos.database.model.AvaliacaoFisicaEntity;
import com.marcos2.praticamarcos.database.repository.IAlunosRepository;
import com.marcos2.praticamarcos.dto.AlunosDto;
import com.marcos2.praticamarcos.dto.AvaliacaoFisicaDto;
import com.marcos2.praticamarcos.exception.BadRequestException;
import com.marcos2.praticamarcos.exception.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.math.BigDecimal;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AlunosServiceTest {

    @Mock
    private IAlunosRepository iAlunosRepository;

    @InjectMocks
    private AlunosService alunosService;


    @Test
    @DisplayName("You must register a student when the email is not registered.")
    void save() throws BadRequestException {
        AlunosDto alunos = AlunosDto.builder()
                .nome("keth")
                .email("keth@gmail.com")
                .build();

        when(iAlunosRepository.findByEmail(alunos.getEmail()))
                .thenReturn(Optional.empty());

        alunosService.save(alunos);

        verify(iAlunosRepository).save(any(AlunosEntity.class));
    }

    @Test
    @DisplayName("Do not register the student, as the email is already registered.")
    void save2() throws BadRequestException {
        AlunosDto alunos = AlunosDto.builder()
                .nome("keth")
                .email("keth@gmail.com")
                .build();

        when(iAlunosRepository.findByEmail(alunos.getEmail()))
                .thenReturn(Optional.of(new AlunosEntity()));

        assertThrows(
                BadRequestException.class,
                () -> alunosService.save(alunos)
        );

        verify(iAlunosRepository, never()).save(any(AlunosEntity.class));
    }


    @Test
    @DisplayName("The student's physical assessment must be returned.")
    void getAlunosAavaliacao() throws NotFoundException {

        AvaliacaoFisicaEntity avaliacao = new AvaliacaoFisicaEntity();

        AlunosEntity aluno = AlunosEntity.builder()
                .nome("Lucas")
                .email("lucas@gmail.com")
                .avaliacaoFisica(avaliacao)
                .build();

        when(iAlunosRepository.findById(1))
                .thenReturn(Optional.of(aluno));

        AvaliacaoFisicaEntity resultado =
                alunosService.getAlunosAavaliacao(1);

        assertEquals(avaliacao, resultado);
    }

    @Test
    @DisplayName("It should not return the student's physical assessment.")
    void getAlunosAavaliacao2() throws NotFoundException {

        AvaliacaoFisicaEntity avaliacao = new AvaliacaoFisicaEntity();

        AlunosEntity aluno = AlunosEntity.builder()
                .nome("Lucas")
                .email("lucas@gmail.com")
                .avaliacaoFisica(avaliacao)
                .build();

        when(iAlunosRepository.findById(1))
                .thenReturn(Optional.empty());

        assertThrows(
                NotFoundException.class,
                () -> alunosService.getAlunosAavaliacao(1)
        );
    }

    @Test
    @DisplayName("The student does not have a physical assessment on record.")
    void getAlunosAavaliacao3() throws NotFoundException {

        AvaliacaoFisicaEntity avaliacao = new AvaliacaoFisicaEntity();

        AlunosEntity aluno = AlunosEntity.builder()
                .nome("Lucas")
                .email("lucas@gmail.com")
                .avaliacaoFisica(null)
                .build();

        when(iAlunosRepository.findById(1))
                .thenReturn(Optional.of(aluno));

        assertThrows(
                NotFoundException.class,
                () -> alunosService.getAlunosAavaliacao(1)
        );
    }


}
