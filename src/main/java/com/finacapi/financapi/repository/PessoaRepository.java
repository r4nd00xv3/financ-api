package com.finacapi.financapi.repository;

import com.finacapi.financapi.model.Categoria;
import com.finacapi.financapi.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
