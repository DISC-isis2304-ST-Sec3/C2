package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import uniandes.edu.co.proyecto.Modelo.Tienda;
import uniandes.edu.co.proyecto.Repositorios.TiendaRepository;

@Controller
public class TiendasController {
     @Autowired
    private TiendaRepository TiendaRepository;

    @GetMapping("/tiendas/new")
    public String TiendaForm(Model model) {
        model.addAttribute("Tienda", new Tienda());
        return "TiendaNuevo";
    }

    @PostMapping("/tiendas/new/save")
    public String TiendaGuardar(@ModelAttribute Tienda Tienda) {
        TiendaRepository.insertarTienda(Tienda.getNombre(), Tienda.getTipo(), Tienda.getNombre_hotel().getNombre());
        return "redirect:/tiendas";
    }

    @GetMapping("/tiendas/{id}/edit")
    public String TiendaEditarForm(@PathVariable("nombre") String nombre, Model model) {
        Tienda Tienda = TiendaRepository.darTienda(nombre);
        if (Tienda != null) {
            model.addAttribute("Tienda", Tienda);
            return "TiendaEditar";
        } else {
            return "redirect:/tiendas";
        }
    }

    @PostMapping("/tiendas/{id}/edit/save")
    public String TiendaEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute Tienda Tienda) {
        TiendaRepository.actualizarTienda(Tienda.getTipo(), Tienda.getNombre_hotel().getNombre());
        return "redirect:/tiendas";
    }

    @GetMapping("/tiendas/{id}/delete")
    public String TiendaEliminar(@PathVariable("nombre") String nombre) {
        TiendaRepository.eliminarTienda(nombre);
        return "redirect:/tiendas";
    }
}
