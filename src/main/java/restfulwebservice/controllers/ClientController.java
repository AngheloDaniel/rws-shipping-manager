package restfulwebservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @RequestMapping("/clients")
    public String getClients() {
        return "Clients";
    }

    @RequestMapping("getClient")
    public String getClient() {
        return "This is the super client 3";
    }
}
