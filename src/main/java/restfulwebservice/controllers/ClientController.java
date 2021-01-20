package restfulwebservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restfulwebservice.model.Client;
import restfulwebservice.services.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    /**
     * Get a list of all the clients
     * @return List<Client>
     */
    @GetMapping("/1.0/clients/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getClients() {
        return clientService.list();
    }

    /**
     *
     * @param id
     * @return Client
     */
    @GetMapping("/1.0/clients")
    public Optional<Client> getClientById(@RequestParam(value = "id") Long id){
        return clientService.findClientById(id);
    }

    /**
     * Create client
     * @return ResponseEntity
     */
    @PostMapping("/1.0/clients/create")
    public ResponseEntity<Client> insertClient(
            @RequestParam(value = "name") String name) {
        Client client = new Client();
        client.setName(name);
        clientService.insert(client);
        return ResponseEntity.ok(client);
    }
}
