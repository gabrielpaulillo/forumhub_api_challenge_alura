package br.com.gabrielpaulillo.forumhub_challenge.domain.curso;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = CategoriaDeserializer.class)
public enum Categoria {
    BACKEND,
    FRONTEND,
    FULLSTACK,
    CYBERSECURITY;

}
