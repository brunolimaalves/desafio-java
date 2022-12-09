package br.com.biblioteca.repository;

import br.com.biblioteca.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findByFuncionario(Boolean isFuncionario);
}
