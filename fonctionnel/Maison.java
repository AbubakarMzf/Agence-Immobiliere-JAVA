package fonctionnel;

public class Maison extends Bien {
    private boolean isMeublee ;
    private int nbChambre ;
    private int numEtage ;
    private boolean hasBalcon ;

    public Maison(boolean isMeublee, int nbChambre, int numEtage, boolean hasBalcon, int reference, String adresse, float tarifMensuel, float surfaceTotal, boolean enLocation) {

        super(reference, adresse, tarifMensuel, surfaceTotal, enLocation) ;
        this.isMeublee = isMeublee ;
        this.nbChambre = nbChambre ;
        this.numEtage = numEtage ;
        this.hasBalcon = hasBalcon ;
    }


    public boolean getIsMeublee() {
        return this.isMeublee ;
    }

    public int getNbChambre() {
        return this.nbChambre ;
    }

    public int getNumEtage() {
        return this.numEtage ;
    }

    public float getSurface() {
        return this.surfaceTotal ;
    }

    public boolean hasBalcon() {
        return this.hasBalcon ;
    }

}
