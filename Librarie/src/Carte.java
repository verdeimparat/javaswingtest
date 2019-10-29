import java.util.*;

public class Carte {

    public ArrayList<Carte> listaCarti = new ArrayList<Carte>();
    //Stabilim atributele comune
    private String titlu;
    private String autor;
    private String pret;
    private String ISBN;

//    public Carte() {
//
//    }

    public Carte() {

    }

    //Definim constructorul ce va instantia fiecare instanta
    public Carte(String newTitlu, String newAutor, String newPret, String newISBN) {

        setTitlu(newTitlu);
        setAutor(newAutor);
        setPret(newPret);
        setISBN(newISBN);
    }

    public static void main(String[] args) {

//        Beletristica Bele00 = new Beletristica("Mara", "Ioan Slavici",   "2.5", "10000000", "5");
//        Beletristica Bele01 = new Beletristica("Ion",  "Marin Preda",    "2.97","10000001", "15");
//        Beletristica Bele02 = new Beletristica("Moara cu noroc",  "Marin Preda",    "1.97","10000002", "10");
//
//        Istorie Ist00 = new Istorie("Stefan cel Mare", "Nicolae Iorga",  "5.05","20000000", "Moldova");
//        Istorie Ist01 = new Istorie("Mihai Viteazul",  "Domnul Istorie", "5.97","20000001", "Batalia de la Cucu");
//        Istorie Ist02 = new Istorie("Despre Bucuresti",  "Maria Palarie",    "2.1","20000002", "De prin blocuri");
//
//        Carte Item = new Carte(null,null,null,null);

        new AppLib();

//        Item.adaugaCarte(Bele00);
//        Item.adaugaCarte(Bele01);
//        Item.adaugaCarte(Bele02);
//
//        Item.adaugaCarte(Ist00);
//        Item.adaugaCarte(Ist01);
//        Item.adaugaCarte(Ist02);

//        Item.afisareCarti();
//
//        Item.cumparaCarte(Ist01.getISBN());
//        Item.stergeCarteDupaAutor("Marin Preda");
//
//        Item.afisareCartiIstorie();
//        Item.afisareCartiBeletristica();
//
//        Item.afisareCarti();
    }

    String getTitlu() {
        return titlu;
    }

    private void setTitlu(String newTitlu) {
        this.titlu = newTitlu;
    }

    String getAutor() {
        return autor;
    }

    private void setAutor(String newAutor) {
        this.autor = newAutor;
    }

    String getPret() {
        return String.valueOf(pret);
    }

    private void setPret(String newPret) {
        this.pret = newPret;
    }

    String getISBN() {
        return ISBN;
    }

    private void setISBN(String newISBN) {
        this.ISBN = newISBN;
    }

    public String toString() {
        return "| Titlu:" + getTitlu() + " " + "| Autor:" + getAutor() + " " +
                "| Pret:" + getPret() + " " + "| ISBN:" + getISBN();
    }

    private void adaugaCarte(Carte obj) throws DuplicateIsbmException, NotEnoughSpaceException {
        /* adaugare unei carti. daca exista deja o carte cu isbn-ul dat, atunci se va arunca o exceptie DuplicateIsbmException.
        Totodata, daca se depaseste numarul de 100 de carti in librarie, se va arunca NotEnoughSpaceException. */

        setTitlu(obj.getTitlu());
        setAutor(obj.getAutor());
        setPret(obj.getPret());
        setISBN(obj.getISBN());

        if (listaCarti.size() > 100) {
            throw new NotEnoughSpaceException("Pragul maxim de o 100 de carti a fost atins!");
        } else if (listaCarti.contains(obj)) {
            throw new DuplicateIsbmException("Cartea exista deja in Librarie!");
        } else {
            listaCarti.add(obj);
        }
    }

    private void cumparaCarte(String newISBN) {
        /* cumpararea (deci stergerea) unei carti dupa isbn */

        System.out.println("Vinde cartea cu ISBN-ul: " + newISBN);
        ListIterator local = listaCarti.listIterator();

        while (local.hasNext()) {

            Carte i = (Carte) local.next();

            if (i.getISBN().equals(newISBN)) {
                System.out.println("ISBN:" + newISBN + " " + i.getTitlu() + " de " + i.getAutor() + "a fost vanduta!");
                local.remove();
            }
        }
    }

    private void afisareCarti() {
        /* afisarea tuturor cartilor */

        ArrayList<String> localCarti = new ArrayList<>();

        for (Carte i : listaCarti) {
            localCarti.add(i.getISBN());
        }
        System.out.println("Cartile disponibile in Librarie: " + localCarti);
        //System.out.println("Cartile disponibile in Librarie: " + listaCarti);
    }

    private void afisareCartiIstorie() {
        /* afisarea doar a cartilor istorice. */
        ArrayList<String> localCarti = new ArrayList<String>();
        for (Carte i : listaCarti) {
            if (i instanceof Istorie) {
                localCarti.add(i.getISBN());
            }
        }
        System.out.println("Cartile de Istorie disponibile in Librarie: " + localCarti);
    }

    private void afisareCartiBeletristica() {
        /* afisarea doar a cartilor beletristica. */
        ArrayList<String> localCarti = new ArrayList<String>();
        for (Carte i : listaCarti) {
            if (i instanceof Beletristica) {
                localCarti.add(i.getISBN());
            }
        }
        System.out.println("Cartile de Beletristica disponibile in Librarie: " + localCarti);
    }

    private void stergeCarteDupaAutor(String newAutor) {
        /* stergerea tuturor cartilor de la un anumit autor */

        System.out.println("Stergere carti dupa : " + newAutor);
        ListIterator local = listaCarti.listIterator();

        while (local.hasNext()) {

            Carte i = (Carte) local.next();

            if (i.getAutor().equals(newAutor)) {
                System.out.println("Cartea: " + i.getTitlu() + "a fost stearsa!");
                local.remove();
            }
        }
    }
}
