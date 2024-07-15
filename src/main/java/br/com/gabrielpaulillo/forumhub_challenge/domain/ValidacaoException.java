package br.com.gabrielpaulillo.forumhub_challenge.domain;

public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
}
