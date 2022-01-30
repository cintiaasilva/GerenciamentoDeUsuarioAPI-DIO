package one.digitalinnovation.usuario.dto.mapper;

import one.digitalinnovation.usuario.dto.request.UsuarioDTO;
import one.digitalinnovation.usuario.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "dataAniversario", source = "dataAniversario", dateFormat = "dd-MM-yyyy")
    Usuario toModel(UsuarioDTO dto);

    UsuarioDTO toDTO(Usuario dto);
}
