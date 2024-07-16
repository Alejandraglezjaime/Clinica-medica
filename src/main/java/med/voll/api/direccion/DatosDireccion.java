package med.voll.api.direccion;

import jakarta.validation.constraints.NotBlank;

public record DatosDireccion(
        @NotBlank
        String calle,
        @NotBlank
        String colonia,
        @NotBlank
        String estado,
        @NotBlank
        String codigo,
        @NotBlank
        String interior,
        @NotBlank
        String exterior ) {


}
