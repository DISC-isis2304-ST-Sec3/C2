package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Bar;
import uniandes.edu.co.proyecto.Repositorios.BarRepository;

@Controller
public class BaresController {
    @Autowired
    private BarRepository barRepository;

    @GetMapping("/bares/new")
    public String barForm(Model model) {
        model.addAttribute("bar", new Bar());
        return "barNuevo";
    }

    @PostMapping("/bares/new/save")
    public String barGuardar(@ModelAttribute Bar bar) {
        barRepository.insertarBar(bar.getNombre(), bar.getEstilo(), bar.getCosto(), bar.getCapacidad(), bar.getCostocargado(), bar.getHotel_nombre().getNombre());
        return "redirect:/bares";
    }

    @GetMapping("/bares/{id}/edit")
    public String barEditarForm(@PathVariable("nombre") String nombre, Model model) {
        Bar bar = barRepository.darBar(nombre);
        if (bar != null) {
            model.addAttribute("bar", bar);
            return "barEditar";
        } else {
            return "redirect:/bares";
        }
    }

    @PostMapping("/bares/{id}/edit/save")
    public String barEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute Bar bar) {
        barRepository.actualizarBar(bar.getEstilo(), bar.getCosto(), bar.getCapacidad(), bar.getCostocargado(),
                bar.getHotel_nombre().getNombre());
        return "redirect:/bares";
    }

    @GetMapping("/bares/{id}/delete")
    public String barEliminar(@PathVariable("nombre") String nombre) {
        barRepository.eliminarBar(nombre);
        return "redirect:/bares";
    }
}
