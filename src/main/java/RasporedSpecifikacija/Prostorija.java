package RasporedSpecifikacija;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter

public class Prostorija {

    private int kapacitet;
    private String oznaka_prostorije;

    private Map<String, String> dodatne_informacije = new HashMap<>();

    public Prostorija() {
    }

    public Prostorija(int kapacitet, String oznaka_prostorije) {
        this.kapacitet = kapacitet;
        this.oznaka_prostorije = oznaka_prostorije;
    }

    @Override
    public String toString() {
        return oznaka_prostorije;
    }
}
