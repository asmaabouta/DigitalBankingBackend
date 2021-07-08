package bank.ma.metier;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import bank.ma.entities.Client;
import bank.ma.entities.Compte;
import bank.ma.entities.Operation;
import bank.ma.entities.PageOperation;
import bank.ma.entities.Retrait;
import bank.ma.entities.Versement;
import bank.ma.repositories.ClientRepository;
import bank.ma.repositories.CompteRepository;
import bank.ma.repositories.OperationRepository;

@Service
@Transactional
public class IBankImpl  implements IBank{

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Override
	public Client saveClient(Client c) {
		// TODO Auto-generated method stub
		return clientRepository.save(c);
	}

	@Override
	public List<Client> listeClient() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public Compte saveCompte(Compte c) {
		// TODO Auto-generated method stub
		return compteRepository.save(c);
	}

	@Override
	public Compte getCompte(String code) {
		// TODO Auto-generated method stub
		return compteRepository.findById(code).get();
	}

	@Override
	public void verser(String code, double montant) {
		// TODO Auto-generated method stub
		Compte cp = compteRepository.findById(code).get();
		Operation o = new Versement();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		operationRepository.save(o);
		cp.setSolde(cp.getSolde()+montant);
		
	}

	@Override
	public void retirer(String code, double montant) {
		// TODO Auto-generated method stub
		
		Compte cp = compteRepository.findById(code).get();
		if(cp.getSolde()<montant) throw new RuntimeException("Solde Insuffisant");
		Operation o = new Retrait();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		operationRepository.save(o);
		cp.setSolde(cp.getSolde()-montant);
	}

	@Override
	public boolean virement(String codeCompte1, String codeCompte2, double montant) {
		// TODO Auto-generated method stub
		if ( codeCompte1.equals( codeCompte2 ) )
         throw new RuntimeException( "Impossible de faire un virement sur le meme compte" );
		retirer(codeCompte1,montant);
		verser(codeCompte2,montant);
			return true;
	}

	@Override
	public boolean payement(String code, double montant) {
		// TODO Auto-generated method stub
	
		return false;
	}

	@Override
	public PageOperation getOperations(String codeCompte, int page, int size) {
		// TODO Auto-generated method stub
		Page<Operation> ops = operationRepository.getOperations(codeCompte, new QPageRequest(page, size));
		PageOperation pop =new PageOperation();
		pop.setOperations(ops.getContent());
		pop.setNombreOperations(ops.getNumberOfElements());
		pop.setPage(ops.getNumber());
		pop.setTotalPages(ops.getTotalPages());
		return pop;
	}

	@Override
	public Client getClient(Long cin) {
		// TODO Auto-generated method stub
		return clientRepository.findById(cin).get();
	}


	
	
	
	

	

	
	

}
