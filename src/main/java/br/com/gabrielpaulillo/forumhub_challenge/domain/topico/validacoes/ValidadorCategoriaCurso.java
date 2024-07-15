package br.com.gabrielpaulillo.forumhub_challenge.domain.topico.validacoes;

import br.com.gabrielpaulillo.forumhub_challenge.domain.ValidacaoException;
import br.com.gabrielpaulillo.forumhub_challenge.domain.topico.DadosTopico;
import org.springframework.stereotype.Component;

@Component
public class ValidadorCategoriaCurso implements IValidadoresTopico{

    @Override
    public void validar(DadosTopico dadosTopico) {
        var categoriaCurso = dadosTopico.curso().getCategoria();

        if (categoriaCurso == null) {
            throw new ValidacaoException("Categoria não pode estar vazia");
        }

    }
}
