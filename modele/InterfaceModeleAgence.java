package modele;

import java.util.Scanner;

import fonctionnel.Appartement;
import fonctionnel.Bien;
import fonctionnel.Client;
import fonctionnel.Garage;
import observateur.Observateur;

public interface InterfaceModeleAgence {
    public void changementTarif(float tarif, int reference);
    public void enregistrerObservateur(Observateur o) ; 
    public void supprimerObservateur(Observateur o); 
    public void notifierObservateur(); 
    public void creeClient(String nom, String prenom); 
    public void toStringClients();
    public void toStringClient(String nom, String prenom);
    public void toStringBien(); 
    public void creerBien(int reference, String adresse, float tarifMensuel, float surfaceTotal, boolean enLocation);
    public void creerAppartement(boolean isMeublee, int nbChambre, int numEtage, boolean hasBalcon, int reference, String adresse, float tarifMensuel, float surfaceTotal, boolean enLocation); 
    public void creerGarage(int numEmplacement, int reference, String adresse, float tarifMensuel, float surfaceTotal, boolean enLocation); 
    public void supprimerClient(int reference); 
    public int sameClient(String nom, String prenom) ; 
    public int recherchePosClient(String nom, String prenom); 
    public void changeEtatBiens(int identifiant) ; 
	public boolean existeBien(int reference);
	public boolean disponibleBien(int reference);
    public int recherchePosBien(int reference); 
    public void ajoutBienClient(int position, int reference) ; 
	public boolean clientPossedeBien(int reference, int identifiant); 
	public void suppBienClient(int position, int reference); 
	public void changeEtatBien(int reference, boolean etat); 
	public int rechercheIdClient(String nom, String prenom); 
	public int recherchePosClient(int identifiant); 
	public void suppBien(int position); 
	public void modifTarifBien(float tarif, int reference); 
	public void toStringBienLouee() ; 
	public void toStringBienNonLouee(); 
}
