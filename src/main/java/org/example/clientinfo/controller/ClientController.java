package org.example.clientinfo.controller;

import org.example.clientinfo.entity.Client;
import org.example.clientinfo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(path = "/save")
    public Client saveEmployee(@Valid @RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @GetMapping(path = "/getAll")
    public List<Client> getAll() {
        return clientService.getAll();
    }
}
