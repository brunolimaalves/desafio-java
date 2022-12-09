package br.com.biblioteca.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
@Entity(name = "membros")
public class Membro {

    @Id
    private Long id;
    @Column
    private String nome;
    @Column(name = "datanascimento")
    private LocalDate nascimento;
    @Column
    private String cpf;
    private Boolean funcionario;

}
