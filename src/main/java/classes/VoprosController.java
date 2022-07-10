package classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/voprosy")
public class VoprosController {
    private final VoprosRealisation voprosRealisation;
    @Autowired
    public VoprosController(VoprosRealisation voprosRealisation) { this.voprosRealisation = voprosRealisation; }

    @GetMapping("/hello")
    public String hello(){
        System.out.println("hello");
        return "hello";
    }
    @GetMapping
    public String vseVoprosy(Model model){
        model.addAttribute("voprosy", voprosRealisation.outputAll());
        return "vsevoprosy";
    }
    @GetMapping("/{id}")
    public String outputById(@PathVariable("id") int id, Model model){
        model.addAttribute("vopros", voprosRealisation.outputById(id));
        return "outputbyid";
    }

    @GetMapping("/new")
    public String newVopros(@ModelAttribute("vopros") Vopros vopros){
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("vopros") Vopros vopros){
        voprosRealisation.save(vopros);
        return "redirect:/voprosy";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("vopros", voprosRealisation.outputById(id));
        return "edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("vopros") Vopros vopros, @PathVariable("id") int id){
        voprosRealisation.update(id, vopros);
        return "redirect:/voprosy";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        voprosRealisation.delete(id);
        return "redirect:/voprosy";
    }
}
