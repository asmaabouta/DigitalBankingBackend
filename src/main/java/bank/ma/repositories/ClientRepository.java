package bank.ma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bank.ma.entities.Client;

public interface ClientRepository  extends JpaRepository<Client, Long>{

}
