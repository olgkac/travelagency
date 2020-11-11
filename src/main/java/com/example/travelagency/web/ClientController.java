package com.example.travelagency.web;

import com.example.travelagency.persistance.Client;
import com.example.travelagency.persistance.ClientDao;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
//@Slf4j
public class ClientController {

    private final ClientDao clientDao;

    @GetMapping("")
    Collection<Client> findAll() {
        return clientDao.findAll();
    }

    @GetMapping("/{id}")
    Client findById(@PathVariable Integer id) {
        return clientDao.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Integer id) {
        clientDao.deleteById(id);
    }

    @PostMapping("")
    Client addClient(@RequestBody Client client) {
        if (client.getId() != null) {
            throw new IllegalArgumentException("Cannot add a new client, id should be null");
        }
        return clientDao.save(client);
    }

    @PutMapping("/{id}")
    Client editClient(@PathVariable Integer id, @RequestBody Client client) {
        // https://stackoverflow.com/questions/27900041/rest-put-ids-in-body-or-not
        // generalnie to jest zawsze jakaś rozkmina i nie ma jednego dobrego rozwiązania co zrobić z id.
        // można iść w "duplikację" czyli i w urlu ma być id i w ciele requestu ale wtedy za każdym razem trzeba to weryfikować.
        // tak jak ja zrobiłem jest na pewno prościej, czyli niezależnie od tego czy w ciele jest to pole czy nie (i jaką ma wartość)
        // to i tak je olewamy, bierzmy z urla. Kwestia konwencji jakie są stosowane w projekcie.
        client.setId(id);
        return clientDao.save(client);
    }




}
