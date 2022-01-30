package one.digitalinnovation.usuario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNaoEncontradoExcecao extends Exception {

    public UsuarioNaoEncontradoExcecao(Long id) {
        super(String.format("Usuario com o ID %s não foi encontrado no nosso banco de dados!", id));
    }
}
