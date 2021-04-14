package fonctionnel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import modele.InterfaceModeleAgence;
import observateur.Observateur;
import observateur.Sujet;


public class Agence implements InterfaceModeleAgence, Sujet{
    private ArrayList <Bien> bien ;
    private ArrayList <Client> client ;
    public ArrayList <Observateur> observateur ;
    
    
    public Agence() {
    	this.observateur = new ArrayList<Observateur>() ;
    	this.bien = new ArrayList<Bien>(); 
    	this.client = new ArrayList<Client>(); 
    }
    

    
    /* ***************************************************METHODE************************************************************************* */
    /* ***************************************************BIEN**************************************************************************** */
    
    
    //prend la reference d'un bien en param et retourne la position du bien dans l'arrayList Bien
    
    public int recherchePosBien(int reference){
        for (int i=0; i<bien.size(); i++){
            if (bien.get(i).getReference() == reference) {
                return i ;
            }
        }
        return -1 ;
    }
    

    //affiche le contenu de l'arrayList bien 
    public void toStringBien() {
    	for (int i=0; i < this.bien.size(); i++) {
    		System.out.println(this.bien.get(i) + "\n");
    	}
    }
    
    
    public void changementTarif(float tarif, int reference) {
        int i = recherchePosBien(reference);
        if (i !=-1) {
            this.bien.get(i).setTarifMensuel(tarif);
        }
    } 
    
    
    public void creerBien(int reference, String adresse, float tarifMensuel, float surfaceTotal, boolean enLocation){
    	Bien b = new Bien( reference,  adresse,  tarifMensuel,  surfaceTotal,  enLocation) ; 
    	this.bien.add(b); 
    }
    
    
    
    public void supprimerBien(int reference){
        int i = recherchePosBien(reference);
        if (i !=-1) {
            this.bien.remove(i);
        }
    }
    
    
    //relatif au client
    
    public int recherchePosClient(int identifiant){
        for (int i=0; i<client.size(); i++){
            if (client.get(i).getIdentifiant() == identifiant) {
                return i ;
            }
        }
        return -1 ;
    }
    
    public int recherchePosClient(String nom, String prenom){
        for (int i=0; i<client.size(); i++){
            if (client.get(i).getPrenom().equals(prenom) && client.get(i).getNom().equals(nom)) {
                return i ;
            }
        }
        return -1 ;
    }
    
    public int rechercheIdClient(String nom, String prenom) {
    	for (int i=0; i<client.size(); i++){
            if (client.get(i).getPrenom().equals(prenom) && client.get(i).getNom().equals(nom)) {
                return client.get(i).getIdentifiant() ;
            }
        }
        return -1 ;
    }

    
    public void creeClient(String nom, String prenom){
        Client c = new Client(nom, prenom) ;
        if (this.client.size() == 0) {
        	c.setIdentifiant(this.client.size());
        }     
        else if (this.client.get(this.client.size() -1 ).getIdentifiant() == this.client.size()) {
        	c.setIdentifiant(this.client.size() + 1); 	
        }  
        else {
        c.setIdentifiant(this.client.size());
        }
        this.client.add(c) ; 
    }


    public void supprimerClient(int identifiant){
    	this.client.remove(identifiant);
    	System.out.println("client supprimé ! ");
    }
    
    public void toStringClients() {
    	for (Client c : this.client) {
    		System.out.println(c);
    	}
    }
    
    public void toStringClient(String nom, String prenom) {
    	for (Client c : this.client) {
    		if (c.getNom().equals(nom) && c.getPrenom().equals(prenom)) {
    			System.out.println(c);			
    		}		
    	}
    }
    
    //Observateur 
    
    
    public void enregistrerObservateur(Observateur o) {
        this.observateur.add(o) ;

    }


    public void supprimerObservateur(Observateur o) {
        this.observateur.remove(o) ;
    }

    public void notifierObservateur() {
        for (int i = 0 ; i < this.observateur.size() ; i++){
            this.observateur.get(i).actualiser() ;
        }
    }


    // to String 
    @Override
	public String toString() {
		return "Agence [bien=" + bien + ", client=" + client + "]";
	}
    
    

    public void creerAppartement(boolean isMeublee, int nbChambre, int numEtage, boolean hasBalcon, int reference, String adresse, float tarifMensuel, float surfaceTotal, boolean enLocation) {
    	Appartement a = new Appartement( isMeublee,  nbChambre,  numEtage,  hasBalcon,  reference,  adresse,  tarifMensuel,  surfaceTotal,  enLocation) ; 
    	this.bien.add(a); 
    }
    
    public void creerGarage(int numEmplacement, int reference, String adresse, float tarifMensuel, float surfaceTotal, boolean enLocation) {
    	Garage g = new Garage( numEmplacement,  reference,  adresse,  tarifMensuel,  surfaceTotal,  enLocation); 
    	this.bien.add(g); 
    }



	
	public int sameClient(String nom, String prenom) {
		int compte = 0 ; 
		System.out.println(this.client.size());
		for (int i = 0 ; i<this.client.size(); i++) {
    		if (this.client.get(i).getNom().equals(nom) && this.client.get(i).getPrenom().equals(prenom)) {
    			compte+=1 ; 
    		}		
		}
		return compte;
	}

	
	//quand tu supp un client, ça mets l'état de tout les biens qu'il louait en false
	public void changeEtatBiens(int identifiant) {
		for (Bien b : this.client.get(this.recherchePosClient(identifiant)).getBiens()) {
			b.setEnLocation(false);
			b.setDateDebut(null);
		}
		
	}
	
	
	//quand tu retire ou Ajoute un bien Particulier un client ça change l'état du bien
	public void changeEtatBien(int reference, boolean etat) {
		this.bien.get(this.recherchePosBien(reference)).setEnLocation(etat);
		if (etat) {
			this.bien.get(this.recherchePosBien(reference)).setDateDebut(new Date());
		}
		
		else {
			this.bien.get(this.recherchePosBien(reference)).setDateDebut(null);
		}
	}
	
	
	
	public void ajoutBienClient(int position, int reference) {
		this.client.get(position).ajoutBien(this.bien.get(this.recherchePosBien(reference))); 
	}
	
	public boolean existeBien(int reference) {
		for (Bien b : this.bien) {
			if (b.getReference() == reference) {
				return true ; 
			}
		}
		return false ; 
	}
	
	public boolean disponibleBien(int reference) {
		return !this.bien.get(recherchePosBien(reference)).isEnLocation() ; 
	
	}
	
	
	
	
	
	public boolean clientPossedeBien(int reference, int identifiant) {
		if (this.client.get(this.recherchePosClient(identifiant)).possedeBien(reference)){

			return true ; 
		}
		return false ; 
	}
	
	public void suppBienClient(int position, int reference) {
		this.client.get(position).suppBien(this.bien.get(this.recherchePosBien(reference))); 
	}

	public void suppClient(int identifiant) {
		this.changeEtatBiens(identifiant);
		this.client.remove(this.client.get(this.recherchePosClient(identifiant))); 
		
	}


	public void suppBien(int reference) {
		this.bien.remove(this.recherchePosBien(reference)); 
	}
	
	public void modifTarifBien(float tarif, int reference) {
		this.bien.get(this.recherchePosBien(reference)).setTarifMensuel(tarif);
	}



	@Override
	public void toStringBienLouee() {
		for (int i=0; i < this.bien.size(); i++) {
			if (this.bien.get(i).isEnLocation()) {
    		System.out.println(this.bien.get(i) + "\n");
			}
    	}
		
		
	}



	@Override
	public void toStringBienNonLouee() {
		for (int i=0; i < this.bien.size(); i++) {
			if (!this.bien.get(i).isEnLocation()) {
    		System.out.println(this.bien.get(i) + "\n");
			}
    	}	
		
	}
	
	

			
}
