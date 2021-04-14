package fonctionnel;
import java.util.Date ;



public class Bien {
    public int reference;
    public String adresse;
    public float tarifMensuel;
    public float surfaceTotal;
    public boolean enLocation;
    public Date dateDebut;


    public Bien(int reference, String adresse, float tarifMensuel, float surfaceTotal, boolean enLocation) {
        this.reference = reference;
        this.adresse = adresse;
        this.tarifMensuel = tarifMensuel;
        this.surfaceTotal = surfaceTotal;
        this.enLocation = enLocation;

    }


    public String getAdresse() {
        return adresse;
    }


    @Override
	public String toString() {
		return " reference=" + reference + ", adresse=" + adresse + ", tarifMensuel=" + tarifMensuel
				+ ", surfaceTotal=" + surfaceTotal + ", enLocation=" + enLocation + ", dateDebut=" + dateDebut ;
	}


	public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public float getTarifMensuel() {
        return tarifMensuel;
    }


    public void setTarifMensuel(float tarifMensuel) {
        this.tarifMensuel = tarifMensuel;
    }


    public float getSurfaceTotal() {
        return surfaceTotal;
    }


    public void setSurfaceTotal(float surfaceTotal) {
        this.surfaceTotal = surfaceTotal;
    }


    public boolean isEnLocation() {
        return enLocation;
    }


    public void setEnLocation(boolean enLocation) {
        this.enLocation = enLocation;
    }


    public String getDateDebutStr() {
        return dateDebut.toString();
    }

    public Date getDateDebut() {
        return dateDebut;
    }


    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getReference() {
        return this.reference ;
    }


    public void setReference(int reference) {
        this.reference = reference;
    }


}

