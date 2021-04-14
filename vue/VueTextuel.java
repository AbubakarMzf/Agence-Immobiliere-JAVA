package vue;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;


import java.util.Date;  
import controlleur.InterfaceAgenceControlleur;
import observateur.Observateur;
import fonctionnel.Client;
import modele.InterfaceModeleAgence;
import vue.InterfaceVueTextuel;

public class VueTextuel implements InterfaceVueTextuel, Observateur{
	private InterfaceModeleAgence modele ;
	private InterfaceAgenceControlleur controlleur ;
	
	public VueTextuel(InterfaceModeleAgence unModeleAgence, InterfaceAgenceControlleur unControlleur){
		this.controlleur = unControlleur ;
		this.modele = unModeleAgence ;
		this.modele.enregistrerObservateur(this) ;
	}
	
	
	
	
	public void actualiser() {	
	}
	
	
	
	public void activerVue() {
		this.afficherMenuPrincipal();
		this.controlleur.gererSaisirChoixMenuPrincipal();
	}
	
	
	
	public void afficherMenuPrincipal() {
		System.out.println("***********Bienvenue***********");
		System.out.println("Menu Client entrez :  1 ");
		System.out.println("Menu Bien entrez : 2 ");
		System.out.println("Quittez entrez : 3 ");
		System.out.println("******************************");		
	}
	
	public void afficherMenuClient() {
		System.out.println("***********Bienvenue***********");
		System.out.println("Creer un Client entrez : 1 ");
		System.out.println("Modifier un Client entrez : 2 ");
		System.out.println("Supprimer un Client entrez : 3 ");
		System.out.println("Afficher les Clients entrez : 4 ");
		System.out.println("Afficher les Clients par ordre alph : 5");
		System.out.println("Retour menu principal entrez : 6 ");
		System.out.println("******************************");
	}
	
	public void afficherMenuBien() {
		System.out.println("***********Bienvenue***********");
		System.out.println("Creer un Bien entrez :  1 ");
		System.out.println("Modifier un Bien entrez : 2 ");
		System.out.println("Supprimer un Bien entrez : 3 ");
		System.out.println("Afficher tous les Biens entrez : 4 ");
		System.out.println("Afficher les Biens loués entrez : 5 ");
		System.out.println("Afficher les Biens non loués entrez : 6 ");
		System.out.println("Retour menu principal entrez : 7 ");
		System.out.println("******************************");
	}
		
	public int saisirChoixMenu() {
		Scanner myObj = new Scanner(System.in);
	    System.out.println("Entrez votre choix : ");
	    int choix = myObj.nextInt(); 
	    return choix ; 
	}
	
	
	
	
	public void afficherClients() {
		this.modele.toStringClients();
		
	}
	
	public void afficherBiens() {
		this.modele.toStringBien();
	}
	
	
	public void afficherClient(String nom, String prenom) {
		this.modele.toStringClient(nom, prenom);
	}
	
	
	
	public int afficherSuppressionClient(String nom, String prenom) {
		System.out.println("Il existe plusieurs client du même nom et prénom");
		System.out.println("Les voici : ");
		this.afficherClient(nom, prenom);
		System.out.println("Entrez l'identifiant du client que vous voulez supprimer : ");
		return saisirIdentifiantClient(); 
	}
	
	
	

	public String saisirNomClient() {
		Scanner myObj = new Scanner(System.in);
	    System.out.println("Entrez le nom  : ");
	    String nom = myObj.nextLine(); 
	    return nom ; 
	}
	
	public String saisirPrenomClient() {
		Scanner myObj = new Scanner(System.in);
	    System.out.println("Entrez le prenom  : ");
	    String prenom = myObj.nextLine() ; 
	    return prenom ;  						
	}
	
	public int saisirIdentifiantClient() {
		Scanner myObj = new Scanner(System.in);
	    System.out.println("Entrez l'identifiant du client  : ");
	    int ref = myObj.nextInt() ; 
	    return ref ;  
		
	}
	

	public int saisirChoixTypeBien() {
		Scanner myObj = new Scanner(System.in);
	    System.out.println("Appartement  : 1 ");
	    System.out.println("Maison  : 2 ");
	    System.out.println("Garage  : 3 ");
	    int choix = myObj.nextInt() ; 
	    return choix ;  				
		
	}
	
		public int saisirReferenceBien() {
		Scanner myObj = new Scanner(System.in);
	    System.out.println("Entrez la référence du bien  : ");
	    int ref = myObj.nextInt() ; 
	    return ref ;  
	}
	

	public String saisirAdresse() {
	    Scanner myObj = new Scanner(System.in);
		System.out.println("adresse : ");
		String adresse = myObj.nextLine() ;
	    return adresse ; 
	}

	public float saisirTarifMensuel() {
		Scanner myObj = new Scanner(System.in);
	 	System.out.println("Tarif Mensuel : ");
		float tarif = myObj.nextInt() ;
		return tarif ; 
	}
	    
	   
	public float saisirSurface() {
		Scanner myObj = new Scanner(System.in);
	    System.out.println("surfaceTotal : ");
	    float surface = myObj.nextInt() ; 	
	    return surface ; 
	}

	public boolean saisirIsMeublee() {
		Scanner myObj = new Scanner(System.in);
	    System.out.println("Est-il meublé ? :");
	    boolean isMeublee = myObj.nextBoolean() ;
	    return isMeublee ; 
	}
	
	public int saisirNbChambre() {
	    Scanner myObj = new Scanner(System.in);
	    System.out.println("nombre de Chambre : ");
	    int nbChambre = myObj.nextInt() ;
	    return nbChambre ; 
	}
	
	
	public int saisirNumEtage() {
	    Scanner myObj = new Scanner(System.in);
	    System.out.println("Etage : ");
	    int numEtage = myObj.nextInt() ;
	    return numEtage ; 
	}    
	
	public boolean saisirHasBalcon() {
	    Scanner myObj = new Scanner(System.in);
	    System.out.println("Y a-t-il un Balcon ? : ");
	    boolean hasBalcon = myObj.nextBoolean() ; 	
	    return hasBalcon ; 
	}

	
	public int saisirNumEmplacement() {
		Scanner myObj = new Scanner(System.in);
	    System.out.println("Quel est le numéro d'emplacement ? : ");
	    int numEmplacement = myObj.nextInt() ;
	    return numEmplacement ; 
	}

	

	
	
	public int afficherModifClient(String nom, String prenom) {
		System.out.println("Il existe plusieurs client du même nom et prénom");
		System.out.println("Les voici : ");
		this.afficherClient(nom, prenom);
		System.out.println("Entrez l'identifiant du client que vous voulez modifier : ");
		Scanner myObj = new Scanner(System.in);
	    int ref = myObj.nextInt() ; 
	    return ref ; 
	}
	
	
	public void afficherTypeModifClient() {
	    System.out.println("Ajouter un bien : 1 ");
	    System.out.println("retirer un bien à un client : 2 ");
	}
	
	
	public int afficherSaisirRefBien() {
		System.out.println("Entrez la référence du bien dont-il est question : ");
		Scanner myObj = new Scanner(System.in);
	    int ref = myObj.nextInt() ; 
	    return ref ; 
	}
	
	public float afficherModifBien() {
		System.out.println("Entrez le nouveau tarif de location : ");
		Scanner myObj = new Scanner(System.in);
	    float tarif = myObj.nextFloat() ; 
	    return tarif ; 
	}




	@Override
	public void afficherBiensLouee() {
		this.modele.toStringBienLouee();
		
	}




	@Override
	public void afficherBiensNonLouee() {
		this.modele.toStringBienNonLouee();
		
	}


	
}