package RasporedSpecifikacija;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Prostorija {

    private int kapacitet;
    private String oznaka_prostorije;
    private DodatneInformacije dodatneInformacije;

    public Prostorija(int kapacitet, String oznaka_prostorije) {
        this.kapacitet = kapacitet;
        this.oznaka_prostorije = oznaka_prostorije;
    }

    public Prostorija(int kapacitet, String oznaka_prostorije, DodatneInformacije dodatneInformacije) {
        this.kapacitet = kapacitet;
        this.oznaka_prostorije = oznaka_prostorije;
        this.dodatneInformacije = dodatneInformacije;
    }


}
