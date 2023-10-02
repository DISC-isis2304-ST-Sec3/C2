package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Reserva;
import uniandes.edu.co.proyecto.Repositorios.ReservaRepository;

@Controller
public class ReservaController {
    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping("/reservas/new")
    public String reservaForm(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "reservaNuevo";
    }

    @PostMapping("/reservas/new/save")
    public String reservaGuardar(@ModelAttribute Reserva reserva) {
        reservaRepository.insertarReserva(reserva.getId(), reserva.getNumpersonas(), reserva.getFechaentrada(), reserva.getFechasalida(), reserva.getCliente_documento().getDocumento());
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/{id}/edit")
    public String reservaEditarForm(@PathVariable("id") Integer id, Model model) {
        Reserva reserva = reservaRepository.darReserva(id);
        if (reserva != null) {
            model.addAttribute("reserva", reserva);
            return "reservaEditar";
        } else {
            return "redirect:/reservas";
        }
    }

    @PostMapping("/reservas/{id}/edit/save")
    public String reservaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Reserva reserva) {
        reservaRepository.actualizarReserva(reserva.getNumpersonas(), reserva.getFechaentrada(), reserva.getFechasalida(),
            reserva.getCliente_documento().getDocumento());
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/{id}/delete")
    public String reservaEliminar(@PathVariable("id") Integer id) {
        reservaRepository.eliminarReserva(id);
        return "redirect:/reservas";
    }
}
