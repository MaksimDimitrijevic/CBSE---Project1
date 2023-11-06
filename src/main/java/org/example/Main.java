package org.example;

import KolekcijaTerminaImpl1.KolekcijaTermina;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        KolekcijaTermina kolekcijaTermina = new KolekcijaTermina();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite putanju do fajla i konfiguracionog fajla u obliku: putanjaDoFajla,putanjaDoKonfiguracije");
        String line = scanner.nextLine();
        try {
            kolekcijaTermina.loadData(line.split(",")[0], line.split(",")[1]);

            System.out.println(kolekcijaTermina.getTermini());
        } catch (IOException e) {
            System.out.println("Greska pri citanju fajlova");
            return;
        }
        System.out.println("Unesite naziv izlaznog fajla");
        line = scanner.nextLine();
        try {
            kolekcijaTermina.exportData(line);
            /// studentImportExportOpenCSV.exportData(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}