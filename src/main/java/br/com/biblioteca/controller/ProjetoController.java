package br.com.biblioteca.controller;

import br.com.biblioteca.entity.Projeto;
import br.com.biblioteca.enums.Classificacao;
import br.com.biblioteca.enums.Status;
import br.com.biblioteca.exception.ApplicationException;
import br.com.biblioteca.service.PessoaService;
import br.com.biblioteca.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/projetos")
public class ProjetoController {

	@Autowired
	private ProjetoService service;

	@Autowired
	private PessoaService pessoaService;

	public ProjetoController(ProjetoService service) {
		this.service = service;
	}

	@GetMapping("/")
	public String carregaPaginaInicial(ModelAndView model) {
		List<Projeto> projetos = service.findAll().stream().map( projeto -> {
			if(!service.validaSeProjetoPodeSerExcluido(projeto)){
				projeto.setPermiteExclusao(false);
			}
			return projeto;
		}).collect(Collectors.toList());
		model.addObject("projetosList", projetos );
		return "list-projetos";
	}

	@GetMapping("/novo")
	public String adicionaNovoProjeto(ModelAndView model) {
		model.addObject("projeto", new Projeto() );
		carregaDadosDoFormulario(model);
		return "form-projetos";
	}

	@PostMapping("/novo")
	public String adicionaNovoProjeto(ModelAndView model, @ModelAttribute  Projeto projeto, BindingResult result) {
		service.save( projeto );
		model.addObject("message", "Salvo com sucesso. " );
		return "redirect:/projetos/";
	}

	@GetMapping("/{id}/atualiza")
	public String carregaProjetoPorId(ModelAndView model, @PathVariable Long id) {
		model.addObject("projeto", service.findById(id)  );
		carregaDadosDoFormulario(model);
		return "form-projetos";
	}

	@PostMapping("/{id}/atualiza")
	public String atualizaProjetoPorId(ModelAndView model , @ModelAttribute  Projeto projeto) {
		service.save(projeto);
		model.addObject("message", "Atualizado com sucesso. " );
		return "redirect:/projetos/";
	}

	@GetMapping("/{id}/delete")
	public String deletaProjetoPorId(@PathVariable Long id) throws ApplicationException {
		Optional<Projeto> projeto = service.findById(id);
		if(!projeto.isPresent() || service.validaSeProjetoPodeSerExcluido(projeto.get())){
			throw new ApplicationException("Projeto nao pode ser excluido");
		}
		return "redirect:/projetos/";
	}

	private void carregaDadosDoFormulario(ModelAndView model) {
		model.addObject("gerentesList", pessoaService.findGerentes() );
		model.addObject("statusList", Arrays.stream(Status.values()).collect(Collectors.toList()) );
		model.addObject("classificacaoList", Arrays.stream(Classificacao.values()).collect(Collectors.toList()) );
	}


}
