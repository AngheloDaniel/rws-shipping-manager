package restfulwebservice.services;

import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restfulwebservice.model.Client;
import restfulwebservice.repositories.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> list() {
        return clientRepository.findAll();
    }

    public void insert(Client client) {
        try {
            clientRepository.save(client);
        } catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

    }
}
