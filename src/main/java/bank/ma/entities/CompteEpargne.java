package bank.ma.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@DiscriminatorValue("CE")
@Data @NoArgsConstructor @ToString
public class CompteEpargne extends Compte {
	public CompteEpargne(String numCompte, double solde, Date dateCreation, String typeCompte, Client client,
			double decouverAutorise) {
		super(numCompte, solde, dateCreation, typeCompte, client);
		this.decouverAutorise = decouverAutorise;
	}

	private double decouverAutorise;
	

}
