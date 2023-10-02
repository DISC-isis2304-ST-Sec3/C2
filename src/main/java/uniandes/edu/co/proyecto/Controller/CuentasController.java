package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Cuenta;
import uniandes.edu.co.proyecto.Repositorios.CuentaRepository;

@Controller
public class CuentasController {
    @Autowired
    private CuentaRepository cuentaRepository;

    @GetMapping("/cuentas/new")
    public String cuentaForm(Model model) {
        model.addAttribute("cuenta", new Cuenta());
        return "cuentaNuevo";
    }

    @PostMapping("/cuentas/new/save")
    public String cuentaGuardar(@ModelAttribute Cuenta cuenta) {
        cuentaRepository.insertarCuenta(cuenta.getId(), cuenta.getConsumo(), cuenta.getValor(), cuenta.getCliente().getDocumento());
        return "redirect:/cuentas";
    }

    @GetMapping("/cuentas/{id}/edit")
    public String cuentaEditarForm(@PathVariable("id") Integer id, Model model) {
        Cuenta cuenta = cuentaRepository.darCuenta(id);
        if (cuenta != null) {
            model.addAttribute("cuenta", cuenta);
            return "cuentaEditar";
        } else {
            return "redirect:/cuentas";
        }
    }

    @PostMapping("/cuentas/{id}/edit/save")
    public String cuentaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Cuenta cuenta) {
        cuentaRepository.actualizarCuenta(cuenta.getConsumo(), cuenta.getValor(), cuenta.getCliente().getDocumento());
        return "redirect:/cuentas";
    }

    @GetMapping("/cuentas/{id}/delete")
    public String cuentaEliminar(@PathVariable("id") Integer id) {
        cuentaRepository.eliminarCuenta(id);
        return "redirect:/cuentas";
    }
}
