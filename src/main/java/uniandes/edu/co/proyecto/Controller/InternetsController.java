package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.Modelo.Internet;
import uniandes.edu.co.proyecto.Repositorios.InternetRepository;

@Controller
public class InternetsController {
     @Autowired
    private InternetRepository InternetRepository;

    @GetMapping("/internets/new")
    public String InternetForm(Model model) {
        model.addAttribute("Internet", new Internet());
        return "InternetNuevo";
    }

    @PostMapping("/internets/new/save")
    public String InternetGuardar(@ModelAttribute Internet Internet) {
        InternetRepository.insertarInternet(Internet.getId(), Internet.getCosto(), Internet.getCapacidad(), Internet.getHotel().getNombre());
        return "redirect:/internets";
    }

    @GetMapping("/internets/{id}/edit")
    public String InternetEditarForm(@PathVariable("id") Integer id, Model model) {
        Internet Internet = InternetRepository.darInternet(id);
        if (Internet != null) {
            model.addAttribute("Internet", Internet);
            return "InternetEditar";
        } else {
            return "redirect:/internets";
        }
    }

    @PostMapping("/internets/{id}/edit/save")
    public String InternetEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Internet Internet) {
        InternetRepository.actualizarInternet(Internet.getCosto(), Internet.getCapacidad(), Internet.getHotel().getNombre());
        return "redirect:/internets";
    }

    @GetMapping("/internets/{id}/delete")
    public String InternetEliminar(@PathVariable("id") Integer id) {
        InternetRepository.eliminarInternet(id);
        return "redirect:/internets";
    }
}
