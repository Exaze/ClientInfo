package org.example.clientinfo.serviceImpl;

import org.example.clientinfo.entity.Client;
import org.example.clientinfo.exception.ApiException;
import org.example.clientinfo.repository.ClientRepository;
import org.example.clientinfo.service.ClientService;
import org.example.clientinfo.service.IDValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private IDValidationService idValidationService;

    @Override
    public Client saveClient(Client client) {
        if(clientRepository.existsByMobileNumber(client.getMobileNumber()))
            throw new ApiException("MobileNumber Already Exist");

        if(!idValidationService.isIDNumberValid(client.getIdNumber()))
            throw new ApiException("Not A Valid Id Number");

        return clientRepository.save(client);

    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }
}
