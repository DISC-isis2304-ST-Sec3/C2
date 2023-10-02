package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.ui.Model;
import uniandes.edu.co.proyecto.Modelo.Habitacion;
import uniandes.edu.co.proyecto.Repositorios.HabitacionRepository;

public class HabitacionesController {
     @Autowired
    private HabitacionRepository HabitacionRepository;

    @GetMapping("/habitaciones/new")
    public String HabitacionForm(Model model) {
        model.addAttribute("Habitacion", new Habitacion());
        return "HabitacionNuevo";
    }

    @PostMapping("/habitaciones/new/save")
    public String HabitacionGuardar(@ModelAttribute Habitacion Habitacion) {
        HabitacionRepository.insertarHabitacion(Habitacion.getId(), Habitacion.getTipo(), Habitacion.getCapacidad(), Habitacion.getPrecio(), Habitacion.getConsumo(), Habitacion.getNombreHotel().getNombre());
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{id}/edit")
    public String HabitacionEditarForm(@PathVariable("id") Integer id, Model model) {
        Habitacion Habitacion = HabitacionRepository.darHabitacion(id);
        if (Habitacion != null) {
            model.addAttribute("Habitacion", Habitacion);
            return "HabitacionEditar";
        } else {
            return "redirect:/habitaciones";
        }
    }

    @PostMapping("/habitaciones/{id}/edit/save")
    public String HabitacionEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute Habitacion Habitacion) {
        HabitacionRepository.actualizarHabitacion(Habitacion.getTipo(), Habitacion.getCapacidad(), Habitacion.getPrecio(), Habitacion.getConsumo(), Habitacion.getNombreHotel().getNombre());
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{id}/delete")
    public String HabitacionEliminar(@PathVariable("id") Integer id) {
        HabitacionRepository.eliminarHabitacion(id);
        return "redirect:/habitaciones";
    }
}
