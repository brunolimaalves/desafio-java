package br.com.biblioteca.service.impl;

import br.com.biblioteca.entity.Projeto;
import br.com.biblioteca.enums.Status;
import br.com.biblioteca.exception.ApplicationException;
import br.com.biblioteca.repository.ProjetoRepository;
import br.com.biblioteca.service.PessoaService;
import br.com.biblioteca.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    @Autowired
    private ProjetoRepository repository;

    @Override
    public void save(Projeto projeto) {
        repository.save(projeto);
    }

    @Override
    public void update(Projeto projeto) {
        repository.save(projeto);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Projeto> findAll() {
        return repository.findAll() ;
    }

    @Override
    public Optional<Projeto> findById(Long id) {
        return repository.findById(id);
    }

    public boolean validaSeProjetoPodeSerExcluido(Projeto projeto) {
        return !(Status.INICIADO.equals(projeto.getStatus())
                || Status.EM_ANDAMENTO.equals(projeto.getStatus())
                || Status.ENCERRADO.equals(projeto.getStatus()));
    }

}
