package fonctionnel;
public class Garage extends Bien {
    private int numEmplacement ;

    public Garage(int numEmplacement, int reference, String adresse, float tarifMensuel, float surfaceTotal, boolean enLocation) {
        super(reference, adresse, tarifMensuel, surfaceTotal, enLocation) ;
        this.numEmplacement = numEmplacement ;
    }

    public float getSurface() {
        return this.surfaceTotal ;
    }

    @Override
	public String toString() {
		return  "Garage [numEmplacement=" + numEmplacement  + super.toString() + "]" ;
	}

	public void setSurface(float surface) {
        this.surfaceTotal = surface;
    }

    public void setNumEmplacement(int numEmplacement) {
        this.numEmplacement = numEmplacement;
    }

    public int getNumEmplacement() {
        return this.numEmplacement ;
    }



}




