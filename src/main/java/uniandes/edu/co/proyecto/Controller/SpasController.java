package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import uniandes.edu.co.proyecto.Modelo.Spa;
import uniandes.edu.co.proyecto.Repositorios.SpaRepository;

@Controller
public class SpasController {
  @Autowired
    private SpaRepository SpaRepository;

    @GetMapping("/spas/new")
    public String SpaForm(Model model) {
        model.addAttribute("Spa", new Spa());
        return "SpaNuevo";
    }

    @PostMapping("/spas/new/save")
    public String SpaGuardar(@ModelAttribute Spa Spa) {
        SpaRepository.insertarSpa(Spa.getId(), Spa.getDuracion(), Spa.getCosto(), Spa.getConsumo(), Spa.getHorario(), Spa.getNombre_hotel().getNombre());
        return "redirect:/spas";
    }

    @GetMapping("/spas/{id}/edit")
    public String SpaEditarForm(@PathVariable("id") Integer id, Model model) {
        Spa Spa = SpaRepository.darSpa(id);
        if (Spa != null) {
            model.addAttribute("Spa", Spa);
            return "SpaEditar";
        } else {
            return "redirect:/spas";
        }
    }

    @PostMapping("/spas/{id}/edit/save")
    public String SpaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Spa Spa) {
        SpaRepository.actualizarSpa(Spa.getDuracion(), Spa.getCosto(), Spa.getConsumo(), Spa.getHorario(), Spa.getNombre_hotel().getNombre());
        return "redirect:/spas";
    }

    @GetMapping("/spas/{id}/delete")
    public String SpaEliminar(@PathVariable("id") Integer id) {
        SpaRepository.eliminarSpa(id);
        return "redirect:/spas";
    }   
}
