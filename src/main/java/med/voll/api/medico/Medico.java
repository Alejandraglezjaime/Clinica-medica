package med.voll.api.medico;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direccion.Direccion;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(unique = true)
    @Email
    private String email;
    private String telefono;
    private String cedula;
    Boolean activo;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;

    public Medico(DatosRegistroMedico datosRegistroMedico) {
        this.activo = true;
        this.nombre = datosRegistroMedico.nombre();
        this.email = datosRegistroMedico.email();
        this.telefono = datosRegistroMedico.telefono();
        this.cedula = datosRegistroMedico.cedula();
        this.especialidad = datosRegistroMedico.especialidad();
        this.direccion = new Direccion(datosRegistroMedico.direccion());
    }

    public void actualizarDatos(DatosActualizarMedico datosActualizarMedico) {
        if (datosActualizarMedico.nombre() != null) {
            informacionActualizar(datosActualizarMedico.id(), "nombre", this.nombre, datosActualizarMedico.nombre());
            this.nombre = datosActualizarMedico.nombre();
        }
        if (datosActualizarMedico.telefono() != null) {
            informacionActualizar(datosActualizarMedico.id(), "telefono", this.telefono, datosActualizarMedico.telefono());
            this.telefono = datosActualizarMedico.telefono();
        }
        if (datosActualizarMedico.direccion() != null) {
            informacionActualizar(datosActualizarMedico.id(), "direccion", this.direccion, datosActualizarMedico.direccion());
            this.direccion = direccion.actualizarDatos(datosActualizarMedico.direccion());

        }

        if (datosActualizarMedico.activo() != null) {
            informacionActualizar(datosActualizarMedico.id(), "activo/inactivo", this.activo, datosActualizarMedico.activo());
            this.activo = datosActualizarMedico.activo();
        }

    }

    public void informacionActualizar(Long id, String campo, Object valorAnterior, Object valorNuevo) {
        System.out.println("""
        ****************************************************************************
        Dato del médico a actualizar:
        id: """ + id + ", " + campo + " anterior: " + valorAnterior + ", Nuevo " + campo + ": " + valorNuevo);
    }


    public void desactivarMedico() {
        this.activo = false;
    }

    public Boolean getActivo() {
        return activo;
    }


}
