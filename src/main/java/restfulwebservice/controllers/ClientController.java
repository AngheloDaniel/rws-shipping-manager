package restfulwebservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import restfulwebservice.model.Client;
import restfulwebservice.services.ClientService;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getClients() {
        return clientService.list();
    }

    @RequestMapping("getClient")
    public String getClient() {
        return "This is the super client 3";
    }

    /**
     * Create client
     */
    @PostMapping("/1.0/clients")
    @ResponseStatus(HttpStatus.OK)
    public Client insertClient(
            @RequestParam(value = "name") String name) {
        Client client = new Client();
        client.setName(name);
        clientService.insert(client);
        return client;
    }
}
