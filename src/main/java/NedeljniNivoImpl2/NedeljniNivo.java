package NedeljniNivoImpl2;

import RasporedSpecifikacija.Prostorija;
import RasporedSpecifikacija.Raspored;
import RasporedSpecifikacija.Termin;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class NedeljniNivo extends Raspored {

    @Override
    public boolean loadData(String filePath, String configPath) throws IOException {
        List<ConfigMapping> columnMappings = readConfig(configPath);
        Map<Integer, String> mappings = new HashMap<>();
        for(ConfigMapping configMapping : columnMappings) {
            mappings.put(configMapping.getIndex(), configMapping.getOriginal());
        }

        FileReader fileReader = new FileReader(filePath);
        CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fileReader);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(mappings.get(-1));

        for (CSVRecord record : parser) {
            Termin termin = new Termin();

            for (ConfigMapping entry : columnMappings) {
                int columnIndex = entry.getIndex();

                if(columnIndex == -1) continue;

                String columnName = entry.getCustom();

                switch (mappings.get(columnIndex)) {
                    case "prostorija":
                        termin.setProstorija(new Prostorija());
                        termin.getProstorija().setOznaka_prostorije(record.get(columnIndex));
                        break;
                    case "pocetak_termina":
                        LocalDateTime startDateTime = LocalDateTime.parse(record.get(columnIndex), formatter);
                        termin.setPocetak_termina(startDateTime);
                        break;
                    case "kraj_termina":
                        LocalDateTime endDateTime = LocalDateTime.parse(record.get(columnIndex), formatter);
                        termin.setKraj_termina(endDateTime);
                        break;
                    case "dodatne_informacije":
                        termin.getProstorija().getDodatne_informacije().put(columnName, record.get(columnIndex));
                        break;
                }
            }

            getTermini().add(termin);
        }
        return true;
    }

    private static List<ConfigMapping>  readConfig(String filePath) throws FileNotFoundException {
        List<ConfigMapping> mappings = new ArrayList<>();

        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] splitLine = line.split(" ", 3);

            mappings.add(new ConfigMapping(Integer.valueOf(splitLine[0]), splitLine[1], splitLine[2]));
        }

        scanner.close();


        return mappings;
    }

    @Override
    public boolean exportData(String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT);

        for (Termin appointment : super.getTermini()) {
            csvPrinter.printRecord(
                    appointment.getPocetak_termina(),
                    appointment.getKraj_termina(),
                    appointment.getProstorija()
            );
        }

        csvPrinter.close();
        fileWriter.close();


        return true;
    }

    @Override
    public void dodaj_Termin(Termin termin) {

    }

    @Override
    public void dodaj_Prostoriju(Prostorija prostorija) {

    }

    @Override
    public void obrisi_Termin(Termin termin) {

    }

    @Override
    public Termin premesti_Termin(Termin termin) {
        return null;
    }

    @Override
    public boolean zauzet_Termin(Termin termin) {
        return false;
    }

    @Override
    public boolean zauzeta_Prostorija(Prostorija prostorija) {
        return false;
    }

    @Override
    public List<Termin> filtriraj_termin(String s) {
        return null;
    }

    @Override
    public List<Termin> filtriraj_prostorija(String s) {
        return null;
    }
}
