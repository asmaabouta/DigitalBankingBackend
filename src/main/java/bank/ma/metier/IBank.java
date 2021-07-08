package bank.ma.metier;



import java.util.List;

import org.springframework.data.domain.Page;

import bank.ma.entities.Client;
import bank.ma.entities.Compte;
import bank.ma.entities.Operation;
import bank.ma.entities.PageOperation;


public interface IBank {

	
	    public Client saveClient(Client c);
	    
	    public Client getClient(Long cin);
	    
	    public List<Client> listeClient();
	    
	    public Compte saveCompte(Compte c);
	    
	    public Compte getCompte(String code );
	    
	    public void verser(String code, double montant);
	    
	    public void retirer(String code , double montant);
	    
        public boolean virement( String codeCompte1, String codeCompte2, double montant );
        
        public boolean payement(String code ,double montant ) ;

	    public PageOperation getOperations( String codeCompte, int page, int size );
	
}
 
