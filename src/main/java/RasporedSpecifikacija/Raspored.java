package RasporedSpecifikacija;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Raspored {

    public List<Termin> termini;
    public List<Prostorija> prostorije;

    public Raspored() {
        this.termini = new ArrayList<>();
        this.prostorije = new ArrayList<>();
    }

    public abstract  boolean loadData(String path, String configPath) throws IOException;

    public abstract  boolean exportData(String path) throws IOException;

    public abstract void dodaj_Termin(Termin t);
    public abstract void dodaj_Prostoriju(Prostorija p);
    public abstract void obrisi_Termin(Termin t);
    public abstract Termin premesti_Termin(Termin t);
    public abstract boolean zauzet_Termin(Termin t);
    public abstract boolean zauzeta_Prostorija(Prostorija p);
    public abstract List<Termin> filtriraj_termin(String vrednost);

    public abstract List<Termin> filtriraj_prostorija(String vrednost);
}
