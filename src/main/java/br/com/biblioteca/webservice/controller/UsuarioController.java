package br.com.biblioteca.webservice.controller;

import br.com.biblioteca.dto.Usuario;
import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private static Faker faker = new Faker();

    @GetMapping
    public Usuario carregaUsuario(){
        return Usuario.builder()
                .nome(faker.name().fullName())
                .cargo(faker.commerce().department()).build();

    }

}
