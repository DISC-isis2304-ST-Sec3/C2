package uniandes.edu.co.proyecto.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Hotel;
import uniandes.edu.co.proyecto.Repositorios.HotelRepository;

@Controller
public class HotelesController {
    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/hoteles/new")
    public String hotelForm(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "hotelNuevo";
    }

    @PostMapping("/hoteles/new/save")
    public String hotelGuardar(@ModelAttribute Hotel hotel) {
        hotelRepository.insertarHotel(hotel.getNombre(), hotel.getTipo(), hotel.getCiudad(), hotel.getPais(), hotel.getInternets_id().getId());
        return "redirect:/hoteles";
    }

    @GetMapping("/hoteles/{id}/edit")
    public String hotelEditarForm(@PathVariable("nombre") String nombre, Model model) {
        Hotel hotel = hotelRepository.darHotel(nombre);
        if (hotel != null) {
            model.addAttribute("hotel", hotel);
            return "hotelEditar";
        } else {
            return "redirect:/hoteles";
        }
    }

    @PostMapping("/hoteles/{id}/edit/save")
    public String hotelEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute Hotel hotel) {
        hotelRepository.actualizarHotel(hotel.getTipo(), hotel.getCiudad(), hotel.getPais(), hotel.getInternets_id().getId());
        return "redirect:/hoteles";
    }

    @GetMapping("/hoteles/{id}/delete")
    public String hotelEliminar(@PathVariable("nombre") String nombre) {
        hotelRepository.eliminarHotel(nombre);
        return "redirect:/hoteles";
    }
}
