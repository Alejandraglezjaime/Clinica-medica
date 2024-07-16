package med.voll.api.medico;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Especialidad {
    ORTOPEDIA("ortopedia", "Ortopedia"),
    CARDIOLOGIA("cardiologia", "Cardiologia"),
    GINECOLOGIA("ginecologia", "Ginecologia"),
    PEDIATRIA("pediatria", "Pediatria");

    private String especialidadMinusculas;
    private String especialidadNormal;

    Especialidad(String especialidadMinusculas, String especialidadNormal) {
        this.especialidadMinusculas = especialidadMinusculas;
        this.especialidadNormal = especialidadNormal;
    }

    @JsonCreator
    public static Especialidad fromString(String text) {
        for (Especialidad especialidad : Especialidad.values()) {
            if (especialidad.especialidadMinusculas.equalsIgnoreCase(text)) {
                return especialidad;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }

    @JsonValue
    public String getEspecialidadMinusculas() {
        return especialidadMinusculas;
    }

    public static Especialidad fromNormal(String text) {
        for (Especialidad especialidad : Especialidad.values()) {
            if (especialidad.especialidadNormal.equalsIgnoreCase(text)) {
                return especialidad;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }
}