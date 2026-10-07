package com.marcos2.praticamarcos.database.repository;

import com.marcos2.praticamarcos.database.model.ExerciciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExerciciosRepository extends JpaRepository<ExerciciosEntity, Integer> {
}
