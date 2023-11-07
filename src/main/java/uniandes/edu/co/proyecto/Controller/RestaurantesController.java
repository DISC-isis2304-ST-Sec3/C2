package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Restaurante;
import uniandes.edu.co.proyecto.Repositorios.RestauranteRepository;

@Controller
public class RestaurantesController {
    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping("/restaurante/new")
    public String restauranteForm(Model model) {
        model.addAttribute("restaurante", new Restaurante());
        return "restauranteNuevo";
    }

    @PostMapping("/restaurantes/new/save")
    public String restauranteGuardar(@ModelAttribute Restaurante restaurante) {
        restauranteRepository.insertarRestaurante(restaurante.getNombre(), restaurante.getEstilo(), restaurante.getCapacidad(), restaurante.getCosto(), restaurante.getCostocargado(), restaurante.getNombre_hotel().getNombre());
        return "redirect:/restaurantes";
    }

    @GetMapping("/restaurantes/{id}/edit")
    public String restauranteEditarForm(@PathVariable("nombre") String nombre, Model model) {
        Restaurante restaurante = restauranteRepository.darRestaurante(nombre);
        if (restaurante != null) {
            model.addAttribute("restaurante", restaurante);
            return "restauranteEditar";
        } else {
            return "redirect:/restaurantes";
        }
    }

    @PostMapping("/restaurantes/{id}/edit/save")
    public String restauranteEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute Restaurante restaurante) {
        restauranteRepository.actualizarRestaurante(restaurante.getEstilo(),restaurante.getCosto(), restaurante.getCapacidad(),
        restaurante.getCostocargado(), restaurante.getNombre_hotel().getNombre());
        return "redirect:/restaurantes";
    }

    @GetMapping("/restaurantes/{id}/delete")
    public String restauranteEliminar(@PathVariable("nombre") String nombre) {
        restauranteRepository.eliminarRestaurante(nombre);
        return "redirect:/restaurantes";
    }
}
