package bank.ma.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @ToString
@DiscriminatorValue("P")
public class Payement extends Operation {
	
	public Payement(Date dateOperation, double montant, Compte compte, Long numFacture) {
		super(dateOperation, montant, compte);
		this.numFacture = numFacture;
	}

	private Long numFacture;
	 
	

}
