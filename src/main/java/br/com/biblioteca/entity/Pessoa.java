package br.com.biblioteca.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity(name = "pessoa")
public class Pessoa {

    @Id
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "datanascimento")
    private LocalDate nascimento;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "funcionario")
    private Boolean funcionario;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Membros",
            joinColumns = { @JoinColumn(name = "idpessoa") },
            inverseJoinColumns = { @JoinColumn(name = "idprojeto") }
    )
    Set<Projeto> projetos = new HashSet<>();


}
