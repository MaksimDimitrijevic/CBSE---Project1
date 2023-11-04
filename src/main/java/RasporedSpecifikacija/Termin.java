package RasporedSpecifikacija;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

@Getter
@Setter
public class Termin {

    private LocalDateTime pocetak_termina;
    private LocalDateTime kraj_termina;
    private String dan;
    private Prostorija prostorija;

    public Termin(LocalDateTime pocetak_termina, LocalDateTime kraj_termina, String dan, Prostorija prostorija) {
        this.pocetak_termina = pocetak_termina;
        this.kraj_termina = kraj_termina;
        this.dan = dan;
        this.prostorija = prostorija;
    }
    public Termin(LocalDateTime pocetak_termina, LocalDateTime kraj_termina, String dan) {
        this.pocetak_termina = pocetak_termina;
        this.kraj_termina = kraj_termina;
        this.dan = dan;
        this.prostorija = prostorija;
    }

    public Termin(LocalDateTime pocetak_termina, LocalDateTime kraj_termina, Prostorija prostorija) {
        this.pocetak_termina = pocetak_termina;
        this.kraj_termina = kraj_termina;
        this.dan = dan;
        this.prostorija = prostorija;
    }

    public Termin(LocalDateTime pocetak_termina, LocalDateTime kraj_termina) {
        this.pocetak_termina = pocetak_termina;
        this.kraj_termina = kraj_termina;
        this.dan = dan;
        this.prostorija = prostorija;
    }
}
