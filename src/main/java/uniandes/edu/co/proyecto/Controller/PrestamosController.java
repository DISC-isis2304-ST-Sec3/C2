package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Prestamo;
import uniandes.edu.co.proyecto.Repositorios.PrestamoRepository;

@Controller
public class PrestamosController {
    @Autowired
    private PrestamoRepository prestamoRepository;

    @GetMapping("/prestamos/new")
    public String prestamoForm(Model model) {
        model.addAttribute("prestamo", new Prestamo());
        return "prestamoNuevo";
    }

    @PostMapping("/prestamos/new/save")
    public String prestamoGuardar(@ModelAttribute Prestamo prestamo) {
        prestamoRepository.insertarPrestamo(prestamo.getId(), prestamo.getDevuelto(), prestamo.getMalestado(), prestamo.getNombreHotel().getNombre(), prestamo.getIdCuenta().getId());
        return "redirect:/prestamos";
    }

    @GetMapping("/prestamos/{id}/edit")
    public String prestamoEditarForm(@PathVariable("id") Integer id, Model model) {
        Prestamo prestamo = prestamoRepository.darPrestamo(id);
        if (prestamo != null) {
            model.addAttribute("prestamo", prestamo);
            return "prestamoEditar";
        } else {
            return "redirect:/prestamo";
        }
    }

    @PostMapping("/prestamos/{id}/edit/save")
    public String prestamoEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Prestamo prestamo) {
        prestamoRepository.actualizarPrestamo(prestamo.getDevuelto(),prestamo.getMalestado(), prestamo.getNombreHotel().getNombre(),
        prestamo.getIdCuenta().getId());
        return "redirect:/prestamos";
    }

    @GetMapping("/prestamos/{id}/delete")
    public String prestamoEliminar(@PathVariable("id") Integer id) {
        prestamoRepository.eliminarPrestamo(id);
        return "redirect:/pretamos";
    }
}
