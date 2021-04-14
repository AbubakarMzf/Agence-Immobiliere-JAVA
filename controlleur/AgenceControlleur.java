package controlleur;
import fonctionnel.* ; 
import modele.* ; 
import observateur.*;
import vue.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import controlleur.*;

public class AgenceControlleur implements InterfaceAgenceControlleur, Observateur {
	
	private InterfaceVueTextuel uneVue ; 
	private InterfaceVueGraphique uneVueGraph ; 
	private InterfaceModeleAgence unModele ; 


	
	public AgenceControlleur(InterfaceModeleAgence modele) {
		this.unModele = modele ; 
	}
	
	
	public void gererSaisirChoixMenuPrincipal() {
		int choix = 0 ; 
		do {
			
			try {
				choix = this.uneVue.saisirChoixMenu();
				if (choix == 1) {
					this.uneVue.afficherMenuClient();
					this.gererSaisirChoixMenuClient();
				}
				
				else if  (choix == 2){
					this.uneVue.afficherMenuBien();	
					this.gererSaisirChoixMenuBien();
				}
				
			} 
			catch (Exception e) {
				System.out.println("mauvais choix") ; 
			}	
		} while(choix !=3) ; 
		
	}
	
	public void gererSaisirChoixMenuClient() {
		try {
			int choix = this.uneVue.saisirChoixMenu();
			if (choix == 1) {
				this.gererSaisirInfoClient();
				System.out.println("crée ! ");
			}
			
			else if (choix==2) {
				this.gererModifierClient(); 
				
			}

			else if (choix == 3) {
				this.gererSupprimerClient();
			}
			
			else if  (choix == 4){
				this.uneVue.afficherClients();
			}
			
			else if (choix==5) {
				System.out.println("pas encore disponible"); 
			}
			this.uneVue.afficherMenuPrincipal();
		} 
		catch (Exception e) {
			System.out.println("mauvais choix") ; 
		}		
	}
	
	public void gererModifierClient() {
		try {
			String nom = this.uneVue.saisirNomClient(); 
			String prenom = this.uneVue.saisirPrenomClient();
			int compte = this.unModele.sameClient(nom, prenom); 
			if (compte > 1) {
				int identifiant = this.uneVue.afficherModifClient(nom, prenom) ;
				int position = this.unModele.recherchePosClient(identifiant); 
				this.uneVue.afficherTypeModifClient();
				int choix = this.uneVue.saisirChoixMenu();
				if(choix == 1) {
					this.gererAfficherSaisirRefBien(position,"ajout");	
				}
				
				else if (choix ==2) {
					this.gererAfficherSaisirRefBien(position,"supp");
				}
				
			}
			
			
			else if(compte == 1) {
				int position = this.unModele.recherchePosClient(nom, prenom) ; 
				this.uneVue.afficherTypeModifClient();
				int choix = this.uneVue.saisirChoixMenu();
				if(choix == 1) {
					this.gererAfficherSaisirRefBien(position,"ajout");	
				}
				
				else if (choix ==2) {
					this.gererAfficherSaisirRefBien(position,"supp");
				}
				
			}
			
			else {
				System.out.println("Client inexistant");
			}
		}
	catch (Exception e) {
		System.out.println("mauvais choix") ; 
	}	
		
	} 


	public void gererAfficherSaisirRefBien (int position, String action) {
		try {
			int ref = this.uneVue.afficherSaisirRefBien();
			boolean existeBien = this.unModele.existeBien(ref);
		
			if (action.equals("ajout")) {
			if (existeBien && this.unModele.disponibleBien(ref)) {
				this.unModele.ajoutBienClient(position, ref);
				this.unModele.changeEtatBien(ref,true);
				System.out.println("Bien ajouté au client ! ");
			}		
		
			else if (!existeBien) {
				System.out.println("Le bien n'existe pas. ");
			}
		
			else {
				System.out.println("Bien déjà loué. ");
			}
		}
		
		
		if (action.equals("supp")) {
			if (existeBien && this.unModele.clientPossedeBien(ref, position)) {
				this.unModele.suppBienClient(position, ref);
				this.unModele.changeEtatBien(ref,false);
				
				System.out.println("Bien retirer au client ! ");
			}		
		
			else if (!existeBien) {
				System.out.println("Le bien n'existe pas. ");
			}
			else {
				System.out.println("Bien non loué par le client. ");
			}
			
		}
		
		}
		catch (Exception e) {
			System.out.println("Référence incorrect. " + e) ; 
		}	
	}
	
	
	
	public void gererSupprimerClient() {
		try {
				String nom = this.uneVue.saisirNomClient(); 
				String prenom = this.uneVue.saisirPrenomClient();
				int compte = this.unModele.sameClient(nom, prenom); 
				if (compte > 1) {
					int identifiant = this.uneVue.afficherSuppressionClient(nom, prenom) ; 
					this.unModele.changeEtatBiens(identifiant); 
					this.unModele.supprimerClient(identifiant);
					System.out.println("client supprimé ! ");
					
				}
				else if(compte == 1) {
					this.unModele.changeEtatBiens(this.unModele.recherchePosClient(nom, prenom));
					this.unModele.supprimerClient(this.unModele.recherchePosClient(nom, prenom));
					System.out.println("client supprimé ! ");
				}
				
				else {
					System.out.println("Client inexistant");
				}
			}
		catch (Exception e) {
			System.out.println("mauvais choix") ; 
		}	
		
	}
	/*
	ResultSet rs = stmt.executeQuery("SELECT * FROM client"); 
	while (rs.next()) {
		  int i = rs.getInt("id_client");
		  String str = rs.getString("l_name"); 
		  String str2 = rs.getString("f_name");
		  System.out.println(i + " " + str + " " + " " + str2 + "\n");
	} */
	
	public void InsertIntoClient(String nom, String prenom) {
		String url = "jdbc:postgresql://localhost/postgres"; 
		String user = "postgres"; 
		String pass = "azerty"; 
		try (Connection connection = DriverManager.getConnection(url, user, pass);){
			if(connection !=null) {
				System.out.println("Connection java psql réussis ! \n");
				Statement stmt = connection.createStatement();
				int update = stmt.executeUpdate("INSERT INTO client VALUES (default, '" + nom + "', '"+ prenom + "')");
				connection.close();
			}
			
		else {
			System.out.println("connexion raté");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	
	}
	
	public void InsertIntoAppartement(boolean isMeublee, int nbChambre, int numEtage, boolean hasBalcon, String adresse, float tarifMensuel, float surfaceTotal, boolean enLocation) {
		String url = "jdbc:postgresql://localhost/postgres"; 
		String user = "postgres"; 
		String pass = "azerty"; 
		try (Connection connection = DriverManager.getConnection(url, user, pass);){
			if(connection !=null) {
				System.out.println("Connection java psql réussis ! \n");
				Statement stmt = connection.createStatement();
				int update = stmt.executeUpdate("INSERT INTO apt VALUES (default, " + isMeublee + "," + nbChambre + "," + numEtage + "," +  hasBalcon + ",'" + adresse + "',  " + tarifMensuel + "," + surfaceTotal + "," + enLocation + "  )");
				connection.close();
			}
			
		else {
			System.out.println("connexion raté");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	

	

	public void gererSaisirInfoClient() {
		try {
			String nom = this.uneVue.saisirNomClient(); 
			String prenom = this.uneVue.saisirPrenomClient(); 
			this.unModele.creeClient(nom, prenom);
			this.InsertIntoClient(nom, prenom);
			
			}
		catch (Exception e) {
			System.out.println("mauvais choix") ; 
		}		
	}
	
	public void gererSaisirChoixMenuBien() {
		try {
			int choix = this.uneVue.saisirChoixMenu();
			if (choix == 1) {
				this.gererSaisirInfoBien();
			}
			
			else if (choix==2) {
				this.gererModifBien();
			}
			else if (choix==3) {
				this.gererSupprimerBien();
			}
			
			else if (choix == 4) {
				this.uneVue.afficherBiens(); 
			}
			else if (choix == 5) {
				this.uneVue.afficherBiensLouee(); 
			}
			else if (choix == 6) {
				this.uneVue.afficherBiensNonLouee(); 
			}
			
			this.uneVue.afficherMenuPrincipal();
		} 
		catch (Exception e) {
			System.out.println("mauvais choix") ; 
		}		
	}
		
	public void gererSaisirInfoBien() {
		try {
			int choix = this.uneVue.saisirChoixTypeBien();
			if (choix == 1) {
				try {
					int reference = this.uneVue.saisirReferenceBien() ; 
					if (this.unModele.existeBien(reference)) {
						System.out.println("Erreur la référence entrer existe déjà");
					}
					else {
					String adresse = this.uneVue.saisirAdresse() ; 
					float tarifMensuel = this.uneVue.saisirTarifMensuel(); 
					float surfaceTotal = this.uneVue.saisirSurface(); 
					boolean enLocation = false ; 
					boolean isMeublee = this.uneVue.saisirIsMeublee(); 
					int nbChambre = this.uneVue.saisirNbChambre() ; 
					int numEtage = this.uneVue.saisirNumEtage(); 
					boolean hasBalcon = this.uneVue.saisirHasBalcon();
					this.unModele.creerAppartement(isMeublee,  nbChambre,  numEtage,  hasBalcon,  reference,  adresse,  tarifMensuel,  surfaceTotal,  enLocation);
					System.out.println("Appartement crée avec succès ! ");
					this.InsertIntoAppartement(isMeublee, nbChambre, numEtage, hasBalcon, adresse, tarifMensuel, surfaceTotal, enLocation);
					}
				}
				catch (Exception e) {
					System.out.println("Problème dans la saisie, recommencez");
				}		
			}
			
			else if(choix ==2){
				System.out.println("pas encore dispo");
			}
			
			else if(choix==3) {
				try {
					int reference = this.uneVue.saisirReferenceBien() ; 
					if (this.unModele.existeBien(reference)) {
						System.out.println("Erreur la référence entrer existe déjà");
					}
					else {
					String adresse = this.uneVue.saisirAdresse() ; 
					float tarifMensuel = this.uneVue.saisirTarifMensuel(); 
					float surfaceTotal = this.uneVue.saisirSurface(); 
					boolean enLocation = false ; 
					int numEmplacement = this.uneVue.saisirNumEmplacement();
					this.unModele.creerGarage(numEmplacement,  reference,  adresse,  tarifMensuel,  surfaceTotal,  enLocation) ; 
					System.out.println("Garage crée avec succès ! ");
					}
				}
				catch (Exception e) {
					System.out.println("Problème dans la saisie, recommencez");
				}
			}
			
		}
		catch (Exception e) {
			System.out.println("mauvais choix");
		}
		
	}
	
	
	
	public void gererSupprimerBien() {
		int reference = this.uneVue.afficherSaisirRefBien();
		boolean existe = this.unModele.existeBien(reference) ; 
		if (existe && this.unModele.disponibleBien(reference)) {
			this.unModele.suppBien(reference);
		}
		
		else if (!existe) {
			System.out.println("La référence entrée n'existe pas");
		}
		
		else {
			System.out.println("Le bien est alloué à une personne, veuillez lui retirer ce bien avant la suppression.");
		}
		
	}
	
	public void gererModifBien() {
		int reference = this.uneVue.afficherSaisirRefBien(); 
		float tarif = this.uneVue.afficherModifBien(); 
		boolean existe = this.unModele.existeBien(reference) ; 
		if (existe) {
			this.unModele.modifTarifBien(tarif, reference);;
		}
		else if (!existe) {
			System.out.println("La référence entrée n'existe pas");
		}
		
	}
	
	
	

	
	public void setVue(InterfaceVueTextuel uneVue) {
		this.uneVue = uneVue ; 
	}
	
	public void setVue(InterfaceVueGraphique uneVue) {
		this.uneVueGraph = uneVue ; 
	}
	
	public void actualiser() {
		// TODO Auto-generated method stub
		
	}

}
