package com.marcos2.praticamarcos.database.repository;

import com.marcos2.praticamarcos.database.model.TreinosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITreinoRepository extends JpaRepository<TreinosEntity, Integer> {

    Optional<TreinosEntity> findByNomeAndAlunoId(String nome, Integer id);
}
