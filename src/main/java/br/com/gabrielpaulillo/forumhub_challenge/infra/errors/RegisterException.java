package br.com.gabrielpaulillo.forumhub_challenge.infra.errors;

public class RegisterException extends RuntimeException {
    public RegisterException(String message) {
        super(message);
    }
}
