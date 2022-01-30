package one.digitalinnovation.usuario.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.usuario.enums.TipoTelefone;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TelefoneDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoTelefone tipoTelefone;

    @NotEmpty
    @Size(min = 9, max = 14)
    private String numero;

    @Override
    public String toString() {
        return "TelefoneDTO{" +
                "tipoTelefone=" + tipoTelefone +
                ", numero='" + numero + '\'' +
                '}';
    }
}
