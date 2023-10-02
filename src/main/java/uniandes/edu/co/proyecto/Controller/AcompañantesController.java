package uniandes.edu.co.proyecto.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Acompañante;
import uniandes.edu.co.proyecto.Repositorios.AcompañanteRepository;


@Controller
public class AcompañantesController {
     @Autowired
    private AcompañanteRepository AcompañanteRepository;

    @GetMapping("/acompañantes/new")
    public String AcompañanteForm(Model model) {
        model.addAttribute("Acompañante", new Acompañante());
        return "AcompañanteNuevo";
    }

    @PostMapping("/acompañantes/new/save")
    public String AcompañanteGuardar(@ModelAttribute Acompañante Acompañante) {
        AcompañanteRepository.insertarAcompañante(Acompañante.getIdacompañante(), Acompañante.getCliente().getDocumento());
        return "redirect:/acompañantes";
    }

    @GetMapping("/acompañantes/{id}/edit")
    public String AcompañanteEditarForm(@PathVariable("idacompañante") Integer idacompañante, Model model) {
        Acompañante Acompañante = AcompañanteRepository.darAcompañante(idacompañante);
        if (Acompañante != null) {
            model.addAttribute("Acompañante", Acompañante);
            return "AcompañanteEditar";
        } else {
            return "redirect:/acompañantes";
        }
    }

    @PostMapping("/acompañantes/{id}/edit/save")
    public String AcompañanteEditarGuardar(@PathVariable("idacompañante") Integer idacompañante, @ModelAttribute Acompañante Acompañante) {
        AcompañanteRepository.actualizarAcompañante(idacompañante);
        return "redirect:/acompañantes";
    }

    @GetMapping("/acompañantes/{id}/delete")
    public String AcompañanteEliminar(@PathVariable("idacompañante") String idacompañante) {
        AcompañanteRepository.eliminarAcompañante(idacompañante);
        return "redirect:/acompañantes";
    }
}
