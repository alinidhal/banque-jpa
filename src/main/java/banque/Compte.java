package banque;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COMPTE")
public class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NUMERO")
	private int numero;
	
	@ManyToMany(mappedBy = "comptes")
	private List<Client> clients = new ArrayList<Client>();
	
	@OneToMany(mappedBy = "compte")
	private List<Operation> operation = new ArrayList<Operation>();
	
	@Override
	public String toString() {
		return "Compte [id=" + id + ", numero=" + numero + ", operation=" + operation + ", solde=" + solde + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	@Column(name="SOLDE")
	private double solde;
	
	public Compte() {
		
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Operation> getOperation() {
		return operation;
	}

	public void setOperation(List<Operation> operation) {
		this.operation = operation;
	}
	
	
}
