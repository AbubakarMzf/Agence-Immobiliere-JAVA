package fonctionnel;
import java.util.ArrayList;

public class Client {
    private String nom ;
    private String prenom ;
    private int identifiant ; 
    private ArrayList <Bien> bien ;

    public Client(String nom, String prenom) {
        this.nom = nom ;
        this.prenom = prenom ;
        this.bien = new ArrayList<Bien>() ; 
    }

    public String getPrenom() {
        return this.prenom ;
    }

    public String getNom() {
        return this.nom ;
    }
    
    public int getIdentifiant() {
    	return this.identifiant ; 
    }
    
    
    
    public void setNom(String nom) {
        this.nom = nom ;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom ;
    }
    
    public void setIdentifiant(int identifiant) {
    	this.identifiant = identifiant ; 
    }
    
    public void ajoutBien(Bien bien) {
        this.bien.add(bien) ;
    }

    public void suppBien(Bien bien) {
        this.bien.remove(bien) ;
    }

    public String toString() {
    	return ("id : " + this.identifiant + " | nom : " + this.nom + " | prenom : " + this.prenom + " | Bien loué : " + this.bien) ; 
    }
    
    public ArrayList <Bien> getBiens(){
    	return this.bien; 
    }
    public boolean possedeBien(int ref) {
    	for (int i=0; i<this.bien.size(); i++) {
    		if (this.bien.get(i).reference == ref) {
    			return true ; 
    		}
    	}
    	return false ; 
    }

    
    
}
