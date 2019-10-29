public class Beletristica extends Carte {

    private String nrPersonaje;


    public Beletristica(String titlu, String autor, String pret, String ISBN, String nrPersonaje) {
        super(titlu,autor,pret,ISBN);
        this.nrPersonaje = nrPersonaje;
    }

    public String toString() {
        return "| Titlu:" + getTitlu() + " " + "| Autor:" + getAutor() + " " + "| Pret:" + getPret() + " " +
                "| ISBN:" + getISBN() + " " + "| NrPers:" + getNrPersonaje();
    }

    public String getNrPersonaje() {
        return nrPersonaje; }

    public void setNrPersonaje(String nrPersonaje) {
        this.nrPersonaje = nrPersonaje;
    }

}
