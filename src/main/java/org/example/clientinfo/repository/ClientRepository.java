package org.example.clientinfo.repository;

import org.example.clientinfo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {

    Boolean existsByMobileNumber(Long mobileNumber);

}
