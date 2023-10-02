package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.ui.Model;
import uniandes.edu.co.proyecto.Modelo.Reservaservicio;
import uniandes.edu.co.proyecto.Repositorios.ReservaservicioRepository;

@Controller
public class ReservasServicioController {
     @Autowired
    private ReservaservicioRepository ReservaservicioRepository;

    @GetMapping("/reservasservicio/new")
    public String ReservaservicioForm(Model model) {
        model.addAttribute("Reservaservicio", new Reservaservicio());
        return "ReservaservicioNuevo";
    }

    @PostMapping("/reservasservicio/new/save")
    public String ReservaservicioGuardar(@ModelAttribute Reservaservicio Reservaservicio) {
        ReservaservicioRepository.insertarReservaservicio(Reservaservicio.getId(), Reservaservicio.getHabitacion(), Reservaservicio.getServicio(), Reservaservicio.getHorainicio(), Reservaservicio.getHorafin(), Reservaservicio.getDocumento_cliente().getDocumento());
        return "redirect:/reservasservicio";
    }

    @GetMapping("/reservasservicio/{id}/edit")
    public String ReservaservicioEditarForm(@PathVariable("id") Integer id, Model model) {
        Reservaservicio Reservaservicio = ReservaservicioRepository.darReservaservicio(id);
        if (Reservaservicio != null) {
            model.addAttribute("Reservaservicio", Reservaservicio);
            return "ReservaservicioEditar";
        } else {
            return "redirect:/reservasservicio";
        }
    }

    @PostMapping("/reservasservicio/{id}/edit/save")
    public String ReservaservicioEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute Reservaservicio Reservaservicio) {
        ReservaservicioRepository.actualizarReservaservicio(Reservaservicio.getHabitacion(), Reservaservicio.getServicio(), Reservaservicio.getHorainicio(), Reservaservicio.getHorafin(), Reservaservicio.getDocumento_cliente().getDocumento());
        return "redirect:/reservasservicio";
    }

    @GetMapping("/reservasservicio/{id}/delete")
    public String ReservaservicioEliminar(@PathVariable("id") Integer id) {
        ReservaservicioRepository.eliminarReservaservicio(id);
        return "redirect:/reservasservicio";
    }
    
}
