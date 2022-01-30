package one.digitalinnovation.usuario.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    @NotEmpty
    @Size(min = 2, max = 100)
    private String primeiroNome;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String segundoNome;

    @NotEmpty
    @CPF
    private String cpf;

    @NotNull
    private String dataAniversario;

    @Valid
    @NotEmpty
    private List<TelefoneDTO> telefones;

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                ", primeiroNome='" + primeiroNome + '\'' +
                ", segundoNome='" + segundoNome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataAniversario='" + dataAniversario + '\'' +
                ", telefones=" + telefones +
                '}';
    }
}
