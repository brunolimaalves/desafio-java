package br.com.biblioteca.service;

import br.com.biblioteca.entity.Projeto;
import br.com.biblioteca.exception.ApplicationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProjetoService {

    void save(Projeto projeto);

    void update(Projeto projeto);

    void delete(Long id);

    List<Projeto> findAll();

    Optional<Projeto> findById(Long id);

    boolean validaSeProjetoPodeSerExcluido(Projeto projeto);
}
