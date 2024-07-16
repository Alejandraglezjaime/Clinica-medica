package med.voll.api.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {

    private String calle;
    private String colonia;
    private String estado;
    private String codigo;
    private String interior;
    private String exterior;

    public Direccion(DatosDireccion direccion) {
        this.calle = direccion.calle();
        this.colonia = direccion.colonia();
        this.estado = direccion.estado();
        this.codigo = direccion.codigo();
        this.interior = direccion.interior();
        this.exterior=direccion.exterior();

    }

    public Direccion actualizarDatos(DatosDireccion direccion) {
        this.calle = direccion.calle();
        this.colonia = direccion.colonia();
        this.estado = direccion.estado();
        this.codigo = direccion.codigo();
        this.interior = direccion.interior();
        this.exterior=direccion.exterior();
        return this;
    }
}
