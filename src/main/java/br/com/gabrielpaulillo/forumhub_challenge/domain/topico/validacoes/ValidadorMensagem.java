package br.com.gabrielpaulillo.forumhub_challenge.domain.topico.validacoes;

import br.com.gabrielpaulillo.forumhub_challenge.domain.ValidacaoException;
import br.com.gabrielpaulillo.forumhub_challenge.domain.topico.DadosTopico;
import br.com.gabrielpaulillo.forumhub_challenge.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMensagem implements IValidadoresTopico {

    @Autowired
    private TopicoRepository repository;

    @Override
    public void validar(DadosTopico dadosTopico) {
        var mensagem = dadosTopico.mensagem();

        if(mensagem.isEmpty()){
            throw new ValidacaoException("Mensagem não pode estar vazia");
        }

        var mensagemExiste = repository.acheMensagem(mensagem);
        if(mensagemExiste){
            throw new ValidacaoException("Mensagem já existe");
        }


    }
}
