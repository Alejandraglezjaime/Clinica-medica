    package med.voll.api.medico;

    public record DatosListadoMedico(Long id, String nombre, String especialidad, String cedula, String email) {

        public DatosListadoMedico(Medico medico) {
            this(medico.getId(), medico.getNombre(), medico.getEspecialidad().toString(), medico.getCedula(), medico.getEmail());
        }
    }


