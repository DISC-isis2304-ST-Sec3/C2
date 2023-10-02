package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Super;
import uniandes.edu.co.proyecto.Repositorios.SuperRepository;

@Controller
public class SuperController {
    @Autowired
    private SuperRepository superRepository;

    @GetMapping("/supers/new")
    public String superForm(Model model) {
        model.addAttribute("super", new Super());
        return "superNuevo";
    }

    @PostMapping("/supers/new/save")
    public String superGuardar(@ModelAttribute Super superM) {
        superRepository.insertarSuper(superM.getNombre(), superM.getConsumo(), superM.getHotel_nombre().getNombre());
        return "redirect:/supers";
    }

    @GetMapping("/supers/{id}/edit")
    public String superEditarForm(@PathVariable("nombre") Integer id, Model model) {
        Super superM = superRepository.darSuper("nombre");
        if (superM != null) {
            model.addAttribute("super", superM);
            return "superEditar";
        } else {
            return "redirect:/supers";
        }
    }

    @PostMapping("/supers/{id}/edit/save")
    public String superEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute Super superM) {
        superRepository.actualizarSuper(superM.getConsumo(), superM.getHotel_nombre().getNombre());
        return "redirect:/supers";
    }

    @GetMapping("/supers/{id}/delete")
    public String superEliminar(@PathVariable("nombre") String nombre) {
        superRepository.eliminarSuper("nombre");
        return "redirect:/supers";
    }
}
