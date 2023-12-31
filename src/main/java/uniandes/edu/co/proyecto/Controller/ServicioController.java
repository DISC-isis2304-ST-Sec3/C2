package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Servicio;
import uniandes.edu.co.proyecto.Repositorios.ServicioRepository;

@Controller
public class ServicioController {
    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/servicios/new")
    public String servicioForm(Model model) {
        model.addAttribute("servicio", new Servicio());
        return "servicioNuevo";
    }

    @PostMapping("/servicios/new/save")
    public String servicioGuardar(@ModelAttribute Servicio servicio) {
        servicioRepository.insertarServicio(servicio.getId(), servicio.getTipo(), servicio.getNumprendas(), servicio.getCostos(), servicio.getNombre_hotel().getNombre());
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/{id}/edit")
    public String servicioEditarForm(@PathVariable("id") Integer id, Model model) {
        Servicio servicio = servicioRepository.darServicio(id);
        if (servicio != null) {
            model.addAttribute("servicio", servicio);
            return "servicioEditar";
        } else {
            return "redirect:/servicios";
        }
    }

    @PostMapping("/servicios/{id}/edit/save")
    public String servicioEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Servicio servicio) {
        servicioRepository.actualizarServicio(servicio.getTipo(), servicio.getNumprendas(), servicio.getCostos(),
            servicio.getNombre_hotel().getNombre());
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/{id}/delete")
    public String servicioEliminar(@PathVariable("id") Integer id) {
        servicioRepository.eliminarServicio(id);
        return "redirect:/servicios";
    }
}
