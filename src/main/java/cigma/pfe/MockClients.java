package cigma.pfe;

import cigma.pfe.models.Client;
import cigma.pfe.repositories.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MockClients implements CommandLineRunner {
    private static final Logger logger =
            LoggerFactory.getLogger(MockClients.class);
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public void run(String... args) throws Exception { Client c1 = new Client("ismail");
        Client c2 = new Client("ibtihal");
        Client c3 = new Client("pablo");
        Client c4 = new Client("CRUD");
        clientRepository.save(c1);
        clientRepository.save(c2);
        clientRepository.save(c3);
        clientRepository.save(c4);
        clientRepository.deleteById(Long.valueOf(4));
        clientRepository.findAll().forEach(System.out::println);
    }
}
