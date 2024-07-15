package br.com.gabrielpaulillo.forumhub_challenge.infra.errors;

public class TokenException extends RuntimeException {
    public TokenException(String mensagem) {
        super(mensagem);
    }
}
