package uniandes.edu.co.proyecto.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Checkin;
import uniandes.edu.co.proyecto.Repositorios.CheckinRepository;

@Controller
public class CheckinsController {
    @Autowired
    private CheckinRepository checkinRepository;

    @GetMapping("/checkins")
    public String checkins(Model model, Integer consumo) {
        Date FechaMayorOcupacion = checkinRepository
                .darFechaMayorOcupacion();

        Date FechaMenorOcupacion = checkinRepository
                .darFechaMenorOcupacion();

        Date FechaMayoresIngresos = checkinRepository
                .darFechaMayoresIngresos();

        return "checkins";
    }


    @GetMapping("/checkins/new")
    public String checkinForm(Model model) {
        model.addAttribute("checkin", new Checkin());
        return "checkinNuevo";
    }

    @PostMapping("/checkins/new/save")
    public String checkinGuardar(@ModelAttribute Checkin checkin) {
        checkinRepository.insertarCheckin(checkin.getId(), checkin.getDocumentoCliente().getDocumento(), checkin.getDia(), checkin.getRealizadopor(), checkin.getCuentaabierta(), checkin.getDocumentocliente(), checkin.getDocumentoEmpleado().getDocumento());
        return "redirect:/bares";
    }

    @GetMapping("/checkins/{id}/edit")
    public String checkinEditarForm(@PathVariable("id") Integer id, Model model) {
        Checkin checkin = checkinRepository.darCheckin(id);
        if (checkin != null) {
            model.addAttribute("checkin", checkin);
            return "checkinEditar";
        } else {
            return "redirect:/checkins";
        }
    }

    @PostMapping("/checkins/{id}/edit/save")
    public String checkinEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Checkin checkin) {
        checkinRepository.actualizarCheckin(checkin.getDocumentoCliente().getDocumento(), checkin.getDia(), checkin.getRealizadopor(), checkin.getCuentaabierta(),
                checkin.getDocumentoCliente().getDocumento(), checkin.getDocumentoEmpleado().getDocumento());
        return "redirect:/bares";
    }

    @GetMapping("/checkins/{id}/delete")
    public String checkinsEliminar(@PathVariable("id") Integer id) {
        checkinRepository.eliminarCheckin(id);
        return "redirect:/checkins";
    }

}
