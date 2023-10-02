package uniandes.edu.co.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.ui.Model;
import uniandes.edu.co.proyecto.Modelo.Producto;
import uniandes.edu.co.proyecto.Repositorios.ProductoRepository;

@Controller
public class ProductosController {
     @Autowired
    private ProductoRepository ProductoRepository;

    @GetMapping("/productos/new")
    public String ProductoForm(Model model) {
        model.addAttribute("Producto", new Producto());
        return "ProductoNuevo";
    }

    @PostMapping("/productos/new/save")
    public String ProductoGuardar(@ModelAttribute Producto Producto) {
        ProductoRepository.insertarProducto(Producto.getId(), Producto.getNombre(), Producto.getPrecio(), Producto.getSupermercado().getNombre());
        return "redirect:/productos";
    }

    @GetMapping("/productos/{id}/edit")
    public String ProductoEditarForm(@PathVariable("id") Integer id, Model model) {
        Producto Producto = ProductoRepository.darProducto(id);
        if (Producto != null) {
            model.addAttribute("Producto", Producto);
            return "ProductoEditar";
        } else {
            return "redirect:/productos";
        }
    }

    @PostMapping("/productos/{id}/edit/save")
    public String ProductoEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute Producto Producto) {
        ProductoRepository.actualizarProducto(Producto.getNombre(), Producto.getPrecio(), Producto.getSupermercado().getNombre());
        return "redirect:/productos";
    }

    @GetMapping("/productos/{id}/delete")
    public String ProductoEliminar(@PathVariable("id") Integer id) {
        ProductoRepository.eliminarProducto(id);
        return "redirect:/productos";
    }
}
