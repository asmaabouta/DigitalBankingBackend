package bank.ma.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import bank.ma.entities.Client;
import bank.ma.entities.Compte;
import bank.ma.entities.PageOperation;
import bank.ma.metier.IBank;

@RestController
@CrossOrigin("*")
public class BankController {
	@Autowired
	private IBank ibank;

	@RequestMapping(value="/operations",method=RequestMethod.GET)
	public PageOperation getOperations(
			@RequestParam String codeCompte, 
			@RequestParam int page, 
			@RequestParam int size) {
		return ibank.getOperations(codeCompte, page, size);
	}

	@RequestMapping(value="/versement",method=RequestMethod.PUT)
	public void verser(
			           @RequestParam String code,
			           @RequestParam double montant) {
		ibank.verser(code, montant);
	}

	@RequestMapping(value="/retrait",method=RequestMethod.PUT)
	public void retirer(
			 @RequestParam String code,
			 @RequestParam double montant) {
		ibank.retirer(code, montant);
	}

	@RequestMapping(value="/virement",method=RequestMethod.PUT)
	public boolean virement(@RequestParam String codeCompte1, @RequestParam String codeCompte2, @RequestParam double montant) {
		return ibank.virement(codeCompte1, codeCompte2, montant);
	}

	public boolean payement(String code, double montant) {
		return ibank.payement(code, montant);
	}


	@RequestMapping(value="/comptes",method=RequestMethod.POST)
	public Compte saveCompte(@RequestBody Compte c) {
		return ibank.saveCompte(c);
	}

	@RequestMapping(value="/comptes/{code}",method=RequestMethod.GET)
	public Compte getCompte(@PathVariable String code) {
		return ibank.getCompte(code);
	}

	@RequestMapping(value="/clients" ,method=RequestMethod.POST)
	public Client saveClient(@RequestBody Client c) {
		return ibank.saveClient(c);
	}

	@RequestMapping(value="/clients",method=RequestMethod.GET)
	public List<Client> listeClient() {
		return ibank.listeClient();
	}

	@RequestMapping(value="/clients/{cin}",method=RequestMethod.GET)
	public Client getClient(@PathVariable Long cin) {
		return ibank.getClient(cin);
	}
	
	
   
	
	
	
	
}
