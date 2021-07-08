package bank.ma.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@DiscriminatorValue("CC")
@Data @NoArgsConstructor @ToString
public class CompteCourant  extends Compte{
private double tauxInteret;

public CompteCourant(String numCompte, double solde, Date dateCreation, String typeCompte, Client client,
		double tauxInteret) {
	super(numCompte, solde, dateCreation, typeCompte, client);
	this.tauxInteret = tauxInteret;
}

}
