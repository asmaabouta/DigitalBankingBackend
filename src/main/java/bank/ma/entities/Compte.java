package bank.ma.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data @NoArgsConstructor @ToString
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn( name="TYPE_CPT", discriminatorType=DiscriminatorType.STRING,length = 2)

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type")
@JsonSubTypes({
	@Type(name="CC",value=CompteCourant.class),
	@Type(name="CE",value=CompteEpargne.class)
})
public abstract class Compte {
	
		@Id
		private String numCompte;
		private double solde;
		private Date dateCreation;
		private String typeCompte;
		
		@ManyToOne
		@JoinColumn(name="CODE_CLIENT")
		private Client client;
		
		@OneToMany(mappedBy="compte")
		@JsonProperty(access=Access.WRITE_ONLY)
		private Collection<Operation> operations;
		
		public Compte(String numCompte, double solde, Date dateCreation, String typeCompte, Client client) {
			super();
			this.numCompte = numCompte;
			this.solde = solde;
			this.dateCreation = dateCreation;
			this.typeCompte = typeCompte;
			this.client = client;
		}

}
