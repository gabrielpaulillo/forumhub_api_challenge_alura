package br.com.gabrielpaulillo.forumhub_challenge.domain.curso;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    private String nomeCurso;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
}
