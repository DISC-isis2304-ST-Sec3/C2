package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import uniandes.edu.co.proyecto.Modelo.Salon;
import uniandes.edu.co.proyecto.Repositorios.SalonRepository;

@Controller
public class SalonController {
     @Autowired
    private SalonRepository SalonRepository;

    @GetMapping("/salones/new")
    public String SalonForm(Model model) {
        model.addAttribute("Salon", new Salon());
        return "SalonNuevo";
    }

    @PostMapping("/salones/new/save")
    public String SalonGuardar(@ModelAttribute Salon Salon) {
        SalonRepository.insertarSalon(Salon.getId(), Salon.getCosto(), Salon.getCapacidad(), Salon.getTienecostoad(), Salon.getCostoad(), Salon.getHotel_nombre().getNombre());
        return "redirect:/salones";
    }

    @GetMapping("/salones/{id}/edit")
    public String SalonEditarForm(@PathVariable("id") Integer id, Model model) {
        Salon Salon = SalonRepository.darSalon(id);
        if (Salon != null) {
            model.addAttribute("Salon", Salon);
            return "SalonEditar";
        } else {
            return "redirect:/salones";
        }
    }

    @PostMapping("/salones/{id}/edit/save")
    public String SalonEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Salon Salon) {
        SalonRepository.actualizarSalon(Salon.getCosto(), Salon.getCapacidad(), Salon.getTienecostoad(), Salon.getCostoad(), Salon.getHotel_nombre().getNombre());
        return "redirect:/salones";
    }

    @GetMapping("/salones/{id}/delete")
    public String SalonEliminar(@PathVariable("id") Integer id) {
        SalonRepository.eliminarSalon(id);
        return "redirect:/salones";
    }
}
