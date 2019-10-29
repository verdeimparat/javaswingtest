public class Istorie extends Carte {

    private String tagIstorie;

    public Istorie( String titlu, String autor, String pret, String ISBN, String tagIstorie) {
        super(titlu,autor,pret,ISBN);
        this.tagIstorie = tagIstorie;
    }

    public String toString() {
        return "| Titlu:" + getTitlu() + " " + "| Autor:" + getAutor() + " " + "| Pret:" + getPret() + " " +
                "| ISBN:" + getISBN() + " " + "| Tag:" + getTagIstorie();
    }

    public String getTagIstorie() {
        return tagIstorie;
    }

    public void setTagIstorie(String newTagIstorie) {
        this.tagIstorie = newTagIstorie;
    }

}
