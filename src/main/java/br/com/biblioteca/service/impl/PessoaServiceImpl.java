package br.com.biblioteca.service.impl;

import br.com.biblioteca.entity.Pessoa;
import br.com.biblioteca.repository.PessoaRepository;
import br.com.biblioteca.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Override
    public List<Pessoa> findGerentes() {
        return repository.findByFuncionario(true);
    }
}
