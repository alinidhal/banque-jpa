package banque;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="COMPTE")
public class Compte {
	
	@Column(name="NOM")
	private String nom;
	
	@Column(name="SOLDE")
	private double solde;
}
