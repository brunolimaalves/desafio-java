package br.com.biblioteca.controller;

import br.com.biblioteca.entity.Projeto;
import br.com.biblioteca.service.ProjetoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ProjetoControllerTest {

    private Long ID_PROJETO = 20L;
    private ProjetoController controller;

     @Mock
     private ProjetoService service;

    @Before
    public void before() {
        controller = new ProjetoController(service);
    }

    @Test
    public void deveriaCarregarTodosOsProjetosCadastrados() {
        controller.carregaPaginaInicial(new ModelAndView());
        List<Projeto> projetos = mock(ArrayList.class);
        when(service.findAll()).thenReturn(projetos);
        verify(service).findAll();
    }

    @Test
    public void cadastrarProjeto() {
        controller.adicionaNovoProjeto();
    }
    @Test

    public void salvar() {
        Projeto projeto = mock(Projeto.class);
        BindingResult result = mock(BindingResult.class);

        controller.adicionaNovoProjeto( new ModelAndView() , projeto, result);

        when(result.hasErrors()).thenReturn(true);
        when(result.hasErrors()).thenReturn(false);

        verify(service).save(projeto);
    }


}
