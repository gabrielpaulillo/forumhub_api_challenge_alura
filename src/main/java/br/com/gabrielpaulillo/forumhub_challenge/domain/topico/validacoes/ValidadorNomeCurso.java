package br.com.gabrielpaulillo.forumhub_challenge.domain.topico.validacoes;

import br.com.gabrielpaulillo.forumhub_challenge.domain.ValidacaoException;
import br.com.gabrielpaulillo.forumhub_challenge.domain.topico.DadosTopico;
import org.springframework.stereotype.Component;

@Component
public class ValidadorNomeCurso implements IValidadoresTopico {

    @Override
    public void validar(DadosTopico dadosTopico) {
        var nomeCurso = dadosTopico.curso().getNomeCurso();
        if(nomeCurso.isEmpty()){
            throw new ValidacaoException("Nome do curso não pode estar vazio");
        }

    }
}
