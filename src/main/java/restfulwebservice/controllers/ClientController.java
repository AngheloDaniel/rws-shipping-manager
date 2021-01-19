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

    @GetMapping("/clients")
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getClients() {
        return clientService.list();
    }

    @GetMapping("/v1.0/clients")
    public Optional<Client> getClientById(@RequestParam(value = "id") Long id){
        return clientService.findClientById(id);
    }

    /**
     * Create client
     */
    @PostMapping("/v1.0/clients")
    public ResponseEntity<Client> insertClient(
            @RequestBody Client client) {
        clientService.insert(client);
        return ResponseEntity.ok(client);
    }
}
