package one.digitalinnovation.usuario.services;

import lombok.AllArgsConstructor;
import one.digitalinnovation.usuario.dto.mapper.UsuarioMapper;
import one.digitalinnovation.usuario.dto.request.UsuarioDTO;
import one.digitalinnovation.usuario.entities.Usuario;
import one.digitalinnovation.usuario.exception.UsuarioNaoEncontradoExcecao;
import one.digitalinnovation.usuario.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;

    public ResponseEntity criarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toModel(usuarioDTO);
        Usuario salvarUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity<UsuarioDTO> pesquisarPorId(Long id) throws UsuarioNaoEncontradoExcecao {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoExcecao(id));
        UsuarioDTO usuarioDTO = usuarioMapper.toDTO(usuario);

        return ResponseEntity.ok(usuarioDTO);
    }
}
