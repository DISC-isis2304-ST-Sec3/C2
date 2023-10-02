package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Piscina;
import uniandes.edu.co.proyecto.Repositorios.PiscinaRepository;

@Controller
public class PiscinaController {
    @Autowired
    private PiscinaRepository piscinaRepository;

    @GetMapping("/piscinas/new")
    public String piscinaForm(Model model) {
        model.addAttribute("piscina", new Piscina());
        return "piscinaNuevo";
    }

    @PostMapping("/piscinas/new/save")
    public String piscinaGuardar(@ModelAttribute Piscina piscina) {
        piscinaRepository.insertarPiscina(piscina.getId(), piscina.getCapacidad(), piscina.getProfundidad(), piscina.getHorario(), piscina.getNombre_hotel().getNombre());
        return "redirect:/piscinas";
    }

    @GetMapping("/piscinas/{id}/edit")
    public String piscinaEditarForm(@PathVariable("id") Integer id, Model model) {
        Piscina piscina = piscinaRepository.darPiscina(id);
        if (piscina != null) {
            model.addAttribute("piscina", piscina);
            return "piscinaEditar";
        } else {
            return "redirect:/piscinas";
        }
    }

    @PostMapping("/piscinas/{id}/edit/save")
    public String piscinaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Piscina piscina) {
        piscinaRepository.actualizarPiscina(piscina.getCapacidad(), piscina.getProfundidad(), piscina.getHorario(),
            piscina.getNombre_hotel().getNombre());
        return "redirect:/piscinas";
    }

    @GetMapping("/piscinas/{id}/delete")
    public String piscinaEliminar(@PathVariable("id") Integer id) {
        piscinaRepository.eliminarPiscina(id);
        return "redirect:/piscinas";
    }
}
