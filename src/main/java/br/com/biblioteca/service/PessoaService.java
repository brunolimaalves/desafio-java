package br.com.biblioteca.service;

import br.com.biblioteca.entity.Pessoa;

import java.util.List;

public interface PessoaService {

    List<Pessoa> findGerentes();
}
