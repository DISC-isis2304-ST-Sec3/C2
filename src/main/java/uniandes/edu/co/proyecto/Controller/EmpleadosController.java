package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Empleado;
import uniandes.edu.co.proyecto.Repositorios.EmpleadoRepository;

@Controller
public class EmpleadosController {
     @Autowired
    private EmpleadoRepository EmpleadoRepository;

    @GetMapping("/empleados/new")
    public String EmpleadoForm(Model model) {
        model.addAttribute("Empleado", new Empleado());
        return "EmpleadoNuevo";
    }

    @PostMapping("/empleados/new/save")
    public String EmpleadoGuardar(@ModelAttribute Empleado Empleado) {
        EmpleadoRepository.insertarEmpleado(Empleado.getDocumento(), Empleado.getNombre(), Empleado.getApellido(), Empleado.getEdad(), Empleado.getCargo(), Empleado.getSalario(), Empleado.getNombreHotel().getNombre());
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/{id}/edit")
    public String EmpleadoEditarForm(@PathVariable("documento") String documento, Model model) {
        Empleado Empleado = EmpleadoRepository.darEmpleado(documento);
        if (Empleado != null) {
            model.addAttribute("Empleado", Empleado);
            return "EmpleadoEditar";
        } else {
            return "redirect:/empleados";
        }
    }

    @PostMapping("/empleados/{id}/edit/save")
    public String EmpleadoEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute Empleado Empleado) {
        EmpleadoRepository.actualizarEmpleado(Empleado.getNombre(), Empleado.getApellido(), Empleado.getEdad(), Empleado.getCargo(), Empleado.getSalario(), Empleado.getNombreHotel().getNombre());
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/{id}/delete")
    public String EmpleadoEliminar(@PathVariable("documento") String documento) {
        EmpleadoRepository.eliminarEmpleado(documento);
        return "redirect:/empleados";
    }
}
