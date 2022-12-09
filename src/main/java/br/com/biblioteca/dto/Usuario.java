package br.com.biblioteca.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Usuario implements Serializable {

    private String nome;
    private String cargo;

}
