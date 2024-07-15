package br.com.gabrielpaulillo.forumhub_challenge.domain.topico;

import br.com.gabrielpaulillo.forumhub_challenge.domain.curso.Curso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosTopico(
        @NotNull(message = "Título é obrigatório")
        String titulo,
        @NotNull(message = "Mensagem é obrigatória")
        String mensagem,
        @NotNull(message = "Data é obrigatória")
        LocalDateTime data,
        @NotNull(message = "Curso é obrigatório")
        @Valid
        Curso curso) {
}
