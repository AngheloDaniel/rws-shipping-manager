package restfulwebservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restfulwebservice.model.Client;
import restfulwebservice.services.ClientService;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @RequestMapping("/clients")
    public void getClients() {
        List<Client> clients = clientService.list();

        for (Client client: clients) {
            System.out.println(client.getName());
        }
    }

    @RequestMapping("getClient")
    public String getClient() {
        return "This is the super client 3";
    }

    @GetMapping("/v0.1/clients/insert")
    public String insertClient() {
        Client client = new Client();
        client.setName("Daniel Pérez");
        clientService.insert(client);
        return "Cliente creado";
    }
}
