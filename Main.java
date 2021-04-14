import fonctionnel.* ; 
import modele.* ; 
import observateur.*;
import vue.*;


import controlleur.*;
public class Main {
	
	public static void main(String[] args) {
		
		Agence agence = new Agence(); 
		AgenceControlleur controlleur = new AgenceControlleur(agence); 
		VueTextuel vueTxt = new VueTextuel(agence, controlleur);
		controlleur.setVue(vueTxt);
		vueTxt.activerVue();

	

	}
}