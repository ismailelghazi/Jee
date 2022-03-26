package ma.cigma.controllers;
import ma.cigma.models.Client;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;
@Controller
public class ClientController {
    @Value("${api.url}")
    private String apiUrl;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping(value = {"/", "/client"})
    public String home(Model model) {
        List<Client> client = restTemplate.getForObject(apiUrl+"/client/all", List.class);
        model.addAttribute("clients",client);
        model.addAttribute("client",new Client());
        System.out.println(client);
        return "index-client";

    }
    @GetMapping(value = {"/delete-client/{id}"})
    public String deleteClientById(
            Model model, @PathVariable long id) {
        restTemplate.delete(apiUrl+"/client/remove/"+id);
        return "redirect:/client";
    }
    @PostMapping(value = "/add-client")
        public String addClient(Model model, @ModelAttribute("client") Client client,RedirectAttributes redirAttrs) {
        if(client.getName()=="" ) {
            redirAttrs.addFlashAttribute("error", "noo");
        }else {
            restTemplate.postForObject(apiUrl + "/client/create", client, Client.class);
            redirAttrs.addFlashAttribute("success", "good job <3");
        }
        return "redirect:/client";
    }
    @GetMapping("/show-client/{id}")
    public String show( Model model, @PathVariable long id) {
        Client client = restTemplate.getForObject(apiUrl+"/client/show-client/"+id, Client.class);
       model.addAttribute("client",client);
        System.out.println(client);
        return "edit";
    }

    @PostMapping(value = {"/save-client"})
    public String save(Model model, @ModelAttribute("client") Client client) {
        restTemplate.put(apiUrl+"/client/"+client.getId(), client, Client.class);
        return "redirect:/client";
    }
    @RequestMapping("/accessdenied")
    public String accessdenied(RedirectAttributes redirAttrs) {
        redirAttrs.addFlashAttribute("msgDenied", "chkon nta !!!!!");
        return "redirect:/client";
    }

}
