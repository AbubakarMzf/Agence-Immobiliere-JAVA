package vue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import controlleur.InterfaceAgenceControlleur;
import modele.InterfaceModeleAgence;
import observateur.Observateur;

public class VueGraphique extends JFrame implements InterfaceVueGraphique, Observateur{
	private InterfaceModeleAgence modele ;
	private InterfaceAgenceControlleur controlleur ;
	
	public VueGraphique(InterfaceModeleAgence unModeleAgence, InterfaceAgenceControlleur unControlleur){
		super("Abubakar Mzf"); 
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.centrer(0.4);
		this.add(afficherMenuPrincipal()); 
		this.controlleur = unControlleur ;
		this.modele = unModeleAgence ;
		this.modele.enregistrerObservateur(this) ;
		this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                String[] options = {"Oui", "Non"};
                int confirmed = JOptionPane.showOptionDialog(null, "Vous êtes sur le point de quitter l'application. \n Voulez vous continuer ?", "Fermer l'application ?",0, JOptionPane.YES_NO_OPTION, null, options, null);
                if (confirmed == JOptionPane.YES_OPTION) {
                    System.out.println("Fermeture du programme.");
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
		
	}
	
	
	
	
	public void actualiser() {	
	}
	
	public JPanel afficherMenuPrincipal() {
		JPanel pan = new JPanel();
		JButton buttonClient = new JButton("Menu Client"); 
		JButton buttonBien = new JButton("Menu Bien"); 
		pan.add(buttonClient); 
		pan.add(buttonBien); 
		return pan ; 
		
		
	}
	
	
	public void centrer(double d) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int largeur = (int) (d * dim.width);
        int longueur = (int) (d * dim.height);
        this.setBounds((dim.width - largeur) / 2, (dim.height - longueur) / 2, largeur, longueur);
    }

	
	
	
	
	
	
	
	
	public void activerVue() {
	
	}

	
	
}
