package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Cliente;
import uniandes.edu.co.proyecto.Repositorios.ClienteRepository;

@Controller
public class ClientesController {
    @Autowired
    private ClienteRepository ClienteRepository;

    @GetMapping("/clientes")
    public String clientes(Model model) {
        model.addAttribute("clientesBuenos", ClienteRepository.darBuenosClientes());
        return "bebidasBuenos";
    }

    @GetMapping("/clientes/new")
    public String ClienteForm(Model model) {
        model.addAttribute("Cliente", new Cliente());
        return "ClienteNuevo";
    }

    @PostMapping("/clientes/new/save")
    public String ClienteGuardar(@ModelAttribute Cliente Cliente) {
        ClienteRepository.insertarCliente(Cliente.getNombre(), Cliente.getApellido(), Cliente.getDocumento(), Cliente.getEdad(), Cliente.getHabitacion(), Cliente.getConsumo(), Cliente.getHotel_nombre().getNombre(), Cliente.getChecksins_id().getId(), Cliente.getChecksouts_id().getId(), Cliente.getReservas_id().getId());
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{id}/edit")
    public String ClienteEditarForm(@PathVariable("documento") Integer documento, Model model) {
        Cliente Cliente = ClienteRepository.darCliente(documento);
        if (Cliente != null) {
            model.addAttribute("Cliente", Cliente);
            return "ClienteEditar";
        } else {
            return "redirect:/clientes";
        }
    }

    @PostMapping("/clientes/{id}/edit/save")
    public String ClienteEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute Cliente Cliente) {
        ClienteRepository.actualizarCliente(Cliente.getNombre(), Cliente.getApellido(), Cliente.getEdad(), Cliente.getHabitacion(), Cliente.getConsumo(), Cliente.getHotel_nombre().getNombre(), Cliente.getChecksins_id().getId(), Cliente.getChecksouts_id().getId(), Cliente.getReservas_id().getId());
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{id}/delete")
    public String ClienteEliminar(@PathVariable("documento") Integer documento) {
        ClienteRepository.eliminarCliente(documento);
        return "redirect:/clientes";
    }
    
}
