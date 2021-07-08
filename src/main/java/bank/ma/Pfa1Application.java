package bank.ma;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import bank.ma.entities.Client;
import bank.ma.entities.Compte;
import bank.ma.entities.CompteEpargne;
import bank.ma.entities.Versement;

import bank.ma.repositories.ClientRepository;
import bank.ma.repositories.CompteRepository;
import bank.ma.repositories.OperationRepository;


@SpringBootApplication
public class Pfa1Application implements CommandLineRunner {
	 @Autowired
	 private CompteRepository compteRepository;
	 @Autowired
	 private ClientRepository clientRepository;
	 @Autowired
	 private OperationRepository operationRepository;
	 
	public static void main(String[] args) {
		SpringApplication.run(Pfa1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		 Client c1 =clientRepository.save(new Client(null,"BOUTA","ASMAA","0611223344","asmaabouta99@gmail.com"));
		 
		 Compte cp1= compteRepository.save(new CompteEpargne("cpte1",100000,new Date(),"individual",c1,100.0));
		 
		 operationRepository.save(new Versement(new Date(), 500, cp1));
		 
		
		
	}
	
	
	
	

}
