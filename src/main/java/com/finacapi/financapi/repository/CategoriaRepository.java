package com.finacapi.financapi.repository;

import com.finacapi.financapi.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
