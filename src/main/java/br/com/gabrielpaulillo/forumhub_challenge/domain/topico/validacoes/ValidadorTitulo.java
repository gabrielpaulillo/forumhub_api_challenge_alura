package br.com.gabrielpaulillo.forumhub_challenge.domain.topico.validacoes;

import br.com.gabrielpaulillo.forumhub_challenge.domain.ValidacaoException;
import br.com.gabrielpaulillo.forumhub_challenge.domain.topico.DadosTopico;
import br.com.gabrielpaulillo.forumhub_challenge.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTitulo implements IValidadoresTopico{

    @Autowired
    private TopicoRepository repository;



    public void validar(DadosTopico dadosTopico) {
        var titulo = dadosTopico.titulo();

        if(titulo.isEmpty()){
            throw new ValidacaoException("Título não pode estar vazio");
        }

        var tituloExiste = repository.acheTitulo(titulo);
        if(tituloExiste){
            throw new ValidacaoException("Título já existe");
        }

    }
}
