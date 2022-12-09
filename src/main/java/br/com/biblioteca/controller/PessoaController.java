package br.com.biblioteca.controller;

import br.com.biblioteca.entity.Projeto;
import br.com.biblioteca.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService service;

	public PessoaController(PessoaService service) {
		this.service = service;
	}

	@GetMapping("/")
	public String carregaPaginaInicial(Model model) {
		model.addAttribute("pessoasList", Arrays.asList( ) );
		return "list-pessoas";
	}

	@GetMapping("/novo")
	public String adicionaNovoProjeto(Model model) {
		model.addAttribute("projeto", new Projeto() );
		// carregaDadosDoFormulario(model);
		return "form-pessoas";
	}

	@PostMapping("/novo")
	public String adicionaNovoProjeto(Model model, @ModelAttribute Projeto projeto, BindingResult result) {
		// service.save( projeto );
		return "redirect:/pessoas/";
	}

	@GetMapping("/atualiza/{id}")
	public String carregaProjetoPorId(Model model, @PathVariable Long id) {
		// model.addAttribute("projeto", service.findById(id)  );
		// carregaDadosDoFormulario(model);
		return "form-pessoas";
	}

	@PostMapping("/atualiza/{id}")
	public String atualizaProjetoPorId(@ModelAttribute  Projeto projeto) {
		// service.save(projeto);
		return "redirect:/pessoas/";
	}

	@GetMapping("/delete/{id}")
	public String deletaProjetoPorId(@PathVariable Long id) {
		// service.delete(id);
		return "redirect:/pessoas/";
	}

}
