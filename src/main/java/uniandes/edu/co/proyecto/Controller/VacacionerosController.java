package uniandes.edu.co.proyecto.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VacacionerosController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}