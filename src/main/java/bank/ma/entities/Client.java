package bank.ma.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @ToString
public  class Client {
    public Client(Long cin, String nom, String prenom, String telephone, @Email String gmail) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.gmail = gmail;
	}
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cin;
	private String nom;
	private String prenom;
	private String telephone;
	@Email
	private String gmail;
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	@JsonProperty(access=Access.WRITE_ONLY)
    private Collection<Compte> comptes;

	
}
