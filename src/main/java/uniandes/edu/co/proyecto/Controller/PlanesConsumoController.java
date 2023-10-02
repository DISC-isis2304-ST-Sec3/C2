package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.ui.Model;
import uniandes.edu.co.proyecto.Modelo.Planconsumo;
import uniandes.edu.co.proyecto.Repositorios.PlanconsumoRepositry;

@Controller
public class PlanesConsumoController {
     @Autowired
    private PlanconsumoRepositry PlanconsumoRepository;

    @GetMapping("/planesconsumo/new")
    public String PlanconsumoForm(Model model) {
        model.addAttribute("Planconsumo", new Planconsumo());
        return "PlanconsumoNuevo";
    }

    @PostMapping("/planesconsumo/new/save")
    public String PlanconsumoGuardar(@ModelAttribute Planconsumo Planconsumo) {
        PlanconsumoRepository.insertarPlanconsumo(Planconsumo.getId(), Planconsumo.getTiempo(), Planconsumo.getTipo(), Planconsumo.getPrecio(), Planconsumo.getPromocion(), Planconsumo.getBeneficio(), Planconsumo.getNombreHotel().getNombre());
        return "redirect:/planesconsumo";
    }

    @GetMapping("/planesconsumo/{id}/edit")
    public String PlanconsumoEditarForm(@PathVariable("id") Integer id, Model model) {
        Planconsumo Planconsumo = PlanconsumoRepository.darPlanconsumo(id);
        if (Planconsumo != null) {
            model.addAttribute("Planconsumo", Planconsumo);
            return "PlanconsumoEditar";
        } else {
            return "redirect:/planesconsumo";
        }
    }

    @PostMapping("/planesconsumo/{id}/edit/save")
    public String PlanconsumoEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Planconsumo Planconsumo) {
        PlanconsumoRepository.actualizarPlanconsumo(Planconsumo.getTiempo(), Planconsumo.getTipo(), Planconsumo.getPrecio(), Planconsumo.getPromocion(), Planconsumo.getBeneficio(), Planconsumo.getNombreHotel().getNombre());
        return "redirect:/planesconsumo";
    }

    @GetMapping("/planesconsumo/{id}/delete")
    public String PlanconsumoEliminar(@PathVariable("id") Integer id) {
        PlanconsumoRepository.eliminarPlanconsumo(id);
        return "redirect:/planesconsumo";
    }
}
