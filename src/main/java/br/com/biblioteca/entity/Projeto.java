package br.com.biblioteca.entity;

import br.com.biblioteca.enums.Classificacao;
import br.com.biblioteca.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_inicio", columnDefinition="DATE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    private LocalDate inicio;

    @Column(name = "data_previsao_fim", columnDefinition="DATE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    private LocalDate previsaoTermino;

    @Column(name = "data_fim", columnDefinition="DATE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    private LocalDate termino;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "status")
    private Status status;

    @Column(name = "orcamento")
    private BigDecimal orcamento;

    @Column(name = "risco")
    private Classificacao classificacao;

    @OneToOne
    @JoinColumn(name = "idgerente")
    private Pessoa idGerente;

    @ManyToMany(mappedBy = "projetos")
    private Set<Pessoa> membros = new HashSet<>();

    @Transient
    private boolean permiteExclusao= true;

}
