package RasporedSpecifikacija;

import java.util.ArrayList;
import java.util.List;

public abstract class Raspored {

    public List<Termin> termini;
    public List<Prostorija> prostorije;

    public Raspored() {
        this.termini = new ArrayList<>();
        this.prostorije = new ArrayList<>();
    }

    public abstract void dodaj_Termin(Termin t);
    public abstract void dodaj_Prostoriju(Prostorija p);
    public abstract void obrisi_Termin(Termin t);
    public abstract Termin premesti_Termin(Termin t);
    public abstract boolean zauzet_Termin(Termin t);
    public abstract boolean zauzeta_Prostorija(Prostorija p);
    public abstract List<Termin> filtriraj_termin(Object o,boolean slobodni);

    public List<Termin> getTermini() {
        if(termini == null)
            termini = new ArrayList<>();
        return termini;
    }

    public List<Prostorija> getProstorije() {
        if(prostorije == null)
            prostorije = new ArrayList<>();
        return prostorije;
    }

    public void setTermini(List<Termin> termini) {
        this.termini = termini;
    }

    public void setProstorije(List<Prostorija> prostorije) {
        this.prostorije = prostorije;
    }
}
