package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Comodidad;
import uniandes.edu.co.proyecto.Modelo.ComodidadPK;
import uniandes.edu.co.proyecto.Repositorios.ComodidadRepository;

@Controller
public class ComodidadesController {
    
    @Autowired
    private ComodidadRepository ComodidadRepository;

    @GetMapping("/comodidades/new")
    public String ComodidadForm(Model model) {
        model.addAttribute("Comodidad", new Comodidad());
        return "ComodidadNuevo";
    }

    @PostMapping("/comodidades/new/save")
    public String ComodidadGuardar(@ModelAttribute Comodidad Comodidad) {
        ComodidadRepository.insertarComodidad(Comodidad.getPk(), Comodidad.getComodidad());
        return "redirect:/comodidades";
    }

    @GetMapping("/comodidades/{id}/edit")
    public String ComodidadEditarForm(@PathVariable("pk") ComodidadPK pk, Model model) {
        Comodidad Comodidad = ComodidadRepository.darComodidad(pk);
        if (Comodidad != null) {
            model.addAttribute("Comodidad", Comodidad);
            return "ComodidadEditar";
        } else {
            return "redirect:/comodidades";
        }
    }

    @PostMapping("/comodidades/{id}/edit/save")
    public String ComodidadEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute Comodidad Comodidad) {
        ComodidadRepository.actualizarComodidad(Comodidad.getComodidad());
        return "redirect:/comodidades";
    }

    @GetMapping("/comodidades/{id}/delete")
    public String ComodidadEliminar(@PathVariable("pk") ComodidadPK pk) {
        ComodidadRepository.eliminarComodidad(pk);
        return "redirect:/comodidades";
    }
}
