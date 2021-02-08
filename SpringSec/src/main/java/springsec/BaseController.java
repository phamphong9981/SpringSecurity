package springsec;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class BaseController {
    @RequestMapping(value = { "/", "/index" })
    public String index() {
        return "index";
    }
    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }
    @RequestMapping("/user")
    public String user() {
        return "user";
    }
    @RequestMapping("/logout")
    public String logout(Model model) {
        model.addAttribute("message", "Logout success!");
        return "index";
    }
}
