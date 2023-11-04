package RasporedSpecifikacija;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Termin termin = (Termin) o;
        return Objects.equals(pocetak_termina, termin.pocetak_termina) && Objects.equals(kraj_termina, termin.kraj_termina) && Objects.equals(dan, termin.dan) && Objects.equals(prostorija, termin.prostorija);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pocetak_termina, kraj_termina, dan, prostorija);
    }

    public String toString() {
        return "Appointment{" +
                "start=" + pocetak_termina +
                ", end=" + kraj_termina +
                ", place='" + prostorija + '\'' +
                ", day=" +  dan+
                '}';
    }

}
