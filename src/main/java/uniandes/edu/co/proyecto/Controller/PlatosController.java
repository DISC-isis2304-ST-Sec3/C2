package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.ui.Model;
import uniandes.edu.co.proyecto.Modelo.Plato;
import uniandes.edu.co.proyecto.Repositorios.PlatoRepository;

@Controller
public class PlatosController {
     @Autowired
    private PlatoRepository PlatoRepository;

    @GetMapping("/platos/new")
    public String PlatoForm(Model model) {
        model.addAttribute("Plato", new Plato());
        return "PlatoNuevo";
    }

    @PostMapping("/platos/new/save")
    public String PlatoGuardar(@ModelAttribute Plato Plato) {
        PlatoRepository.insertarPlato(Plato.getId(), Plato.getNombre(), Plato.getCosto(), Plato.getRestaurante().getNombre());
        return "redirect:/platos";
    }

    @GetMapping("/platos/{id}/edit")
    public String PlatoEditarForm(@PathVariable("id") Integer id, Model model) {
        Plato Plato = PlatoRepository.darPlato(id);
        if (Plato != null) {
            model.addAttribute("Plato", Plato);
            return "PlatoEditar";
        } else {
            return "redirect:/platos";
        }
    }

    @PostMapping("/platos/{id}/edit/save")
    public String PlatoEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Plato Plato) {
        PlatoRepository.actualizarPlato(Plato.getNombre(), Plato.getCosto(), Plato.getRestaurante().getNombre());
        return "redirect:/platos";
    }

    @GetMapping("/platos/{id}/delete")
    public String PlatoEliminar(@PathVariable("id") Integer id) {
        PlatoRepository.eliminarPlato(id);
        return "redirect:/platos";
    }
}
