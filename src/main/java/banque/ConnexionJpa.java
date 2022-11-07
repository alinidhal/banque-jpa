package banque;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ConnexionJpa {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = factory.createEntityManager();

		EntityTransaction trans = em.getTransaction();

		trans.begin();
		// Création de son adresse
		Adresse adresse = new Adresse();
		adresse.setNumero(8);
		adresse.setRue("Rue de la Roseraie");
		adresse.setCodePostal(13001);
		adresse.setVille("Marseille");
		
		// Creation du nom de la banque 
		Banque banque = new Banque();
		banque.setNom("La Banque Postal");
		em.persist(banque);

		// Creation d'un client
		Client client = new Client();
		client.setNom("Martin");
		client.setPrenom("Raissa");
		client.setDateDeNaissance(LocalDate.now());
		client.setAdresse(adresse);
		client.setBanque(banque);
		em.persist(client);
		
		// Creation d'un compte LivretA
		LivretA livretA = new LivretA();
		livretA.setNumero(1245903750);
		livretA.setSolde(1290);
		livretA.setTaux(100);
		em.persist(livretA);
	
		// Ajout LivretA dans le compte
		client.getComptes().add(livretA);
		
		// Creation d'une assurance de vie 
		AssuranceVie assuranceVie = new AssuranceVie();
		assuranceVie.setNumero(1245903750);
		assuranceVie.setSolde(1290);
		assuranceVie.setTaux(2);
		assuranceVie.setDateFin(LocalDate.now());
		em.persist(assuranceVie);
		
		// Ajout de l'assurance dans le compte
		client.getComptes().add(assuranceVie);
		
		// Creation d'un virement
		Virement virement = new Virement();
		virement.setBeneficiaire("Kassime Nidhal");
		virement.setDate(LocalDateTime.now());
		virement.setMontant(200);
		virement.setMotif("Remboursement");
		virement.setCompte(assuranceVie);
		
		em.persist(virement);
		
		// Ajout Virement dans l'operation
		livretA.getOperation().add(virement);

		trans.commit();
	}

}
