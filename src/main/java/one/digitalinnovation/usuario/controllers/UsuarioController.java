package one.digitalinnovation.usuario.controllers;

import lombok.AllArgsConstructor;
import one.digitalinnovation.usuario.dto.request.UsuarioDTO;
import one.digitalinnovation.usuario.exception.UsuarioNaoEncontradoExcecao;
import one.digitalinnovation.usuario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/usuario")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity criarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        ResponseEntity usuarioCriado = usuarioService.criarUsuario(usuarioDTO);
        return usuarioCriado;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> pesquisarPorId(@PathVariable Long id) throws UsuarioNaoEncontradoExcecao {
        return usuarioService.pesquisarPorId(id);
    }



}
