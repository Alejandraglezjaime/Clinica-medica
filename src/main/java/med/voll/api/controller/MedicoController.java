package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico) {
        System.out.println("LLegan los datos a la base de datos");
        medicoRepository.save(new Medico(datosRegistroMedico));

    }

    @GetMapping
    public Page<DatosListadoMedico> listadoMedicos(@PageableDefault(size = 10) Pageable paginacion) {
        System.out.println("Actualización de la lista de médicos activos");
        Page<DatosListadoMedico> medicos = medicoRepository.findByActivoTrue(paginacion).map(DatosListadoMedico::new);

        // Imprimir los datos en la consola
        medicos.forEach(medico -> System.out.println("Datos del médico: " + medico));

        return medicos;
    }

    @PutMapping
    @Transactional
    public void actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico) {
        Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
        System.out.println("""
                \n****************************************************************************
                ***************************** Medico actualizado ***************************
                ****************************************************************************\n""");
    }

    // DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> eliminarMedico(@PathVariable Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        if (medico.getActivo()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se puede eliminar un médico activo");
        }
        medico.desactivarMedico();
        return ResponseEntity.ok("Médico desactivado");
    }


//    DELETE EN BASE DE DATOD
//    public void eliminarMedico(@PathVariable Long id) {
//        Medico medico = medicoRepository.getReferenceById(id);
//        medicoRepository.delete(medico);
//    }

}

