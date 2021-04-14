package vue;

import java.util.Comparator;
import java.util.Scanner;

import fonctionnel.Client;

public interface InterfaceVueTextuel {
	
	public void afficherMenuPrincipal(); 
	public void afficherMenuClient(); 
	public void afficherMenuBien(); 
	public int saisirChoixMenu(); 
	public String saisirNomClient() ;
	public String saisirPrenomClient(); 
	public int saisirIdentifiantClient(); 
	public int saisirReferenceBien(); 
	public void afficherClients(); 
	public void afficherBiens(); 
	public void actualiser(); 
	public String saisirAdresse();
	public float saisirTarifMensuel();
	public float saisirSurface();
	public boolean saisirIsMeublee();
	public int saisirNbChambre();
	public int saisirNumEtage();
	public boolean saisirHasBalcon(); 
	public int saisirNumEmplacement(); 
	public int saisirChoixTypeBien(); 
	public int afficherSuppressionClient(String nom, String prenom); 
	public void afficherClient(String nom, String prenom); 
	public int afficherModifClient(String nom, String prenom) ; 
	public void afficherTypeModifClient() ; 
	public int afficherSaisirRefBien(); 
	public float afficherModifBien(); 
	public void afficherBiensLouee(); 
	public void afficherBiensNonLouee(); 
	
}
