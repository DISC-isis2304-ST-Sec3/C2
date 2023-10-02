package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Modelo.Checkout;
import uniandes.edu.co.proyecto.Repositorios.CheckOutRepository;

@Controller
public class CheckoutsController {
    @Autowired
    private CheckOutRepository checkoutRepository;

    @GetMapping("/checkouts/new")
    public String checkoutForm(Model model) {
        model.addAttribute("checkout", new Checkout());
        return "checkoutNuevo";
    }

    @PostMapping("/checkouts/new/save")
    public String checkoutGuardar(@ModelAttribute Checkout checkout) {
        checkoutRepository.insertarCheckout(checkout.getId(), checkout.getDia(), checkout.getCuentaabierta(), checkout.getCuentatotal(), checkout.getPagocuenta(), checkout.getCliente().getDocumento());
        return "redirect:/checkouts";
    }

    @GetMapping("/checkouts/{id}/edit")
    public String checkoutEditarForm(@PathVariable("id") Integer id, Model model) {
        Checkout checkout = checkoutRepository.darCheckout(id);
        if (checkout != null) {
            model.addAttribute("checkout", checkout);
            return "checkoutEditar";
        } else {
            return "redirect:/checkouts";
        }
    }

    @PostMapping("/checkouts/{id}/edit/save")
    public String checkoutEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Checkout checkout) {
        checkoutRepository.actualizarCheckout(checkout.getDia(), checkout.getCuentaabierta(), checkout.getCuentatotal(),
            checkout.getPagocuenta(), checkout.getCliente().getDocumento());
        return "redirect:/checkouts";
    }

    @GetMapping("/checkouts/{id}/delete")
    public String checkoutEliminar(@PathVariable("id") Integer id) {
        checkoutRepository.eliminarCheckout(id);
        return "redirect:/checkouts";
    }
    
}
