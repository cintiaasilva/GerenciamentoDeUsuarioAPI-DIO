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

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;

    public ResponseEntity criarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toModel(usuarioDTO);
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity<UsuarioDTO> pesquisarPorId(Long id) throws UsuarioNaoEncontradoExcecao {
        verificaSeExisteUsuario(id);
        UsuarioDTO usuarioDTO = usuarioMapper.toDTO(verificaSeExisteUsuario(id));

        return ResponseEntity.ok(usuarioDTO);
    }

    public ResponseEntity<List<UsuarioDTO>> listarTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        List<UsuarioDTO> usuariosDto = usuarios.stream()
                .map(usuarioMapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(usuariosDto);
    }

    public void atualizarUsuario(Long id, UsuarioDTO usuarioDTO) throws UsuarioNaoEncontradoExcecao {
        verificaSeExisteUsuario(id);
        Usuario atualizarUsuario = usuarioMapper.toModel(usuarioDTO);
        atualizarUsuario.setId(id);
        usuarioRepository.save(atualizarUsuario);
    }

    public ResponseEntity excluirUsuario(Long id) throws UsuarioNaoEncontradoExcecao {
        verificaSeExisteUsuario(id);
        usuarioRepository.deleteById(id);

        return ResponseEntity.ok("Usuario excluido com sucesso!!");
    }

    
    private Usuario verificaSeExisteUsuario(Long id) throws UsuarioNaoEncontradoExcecao {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoExcecao(id));
    }
}

