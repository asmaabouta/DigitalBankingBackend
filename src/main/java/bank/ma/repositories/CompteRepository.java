package bank.ma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bank.ma.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {

	
}
