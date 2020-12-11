/**
 * @author Kaja Mikoszewska
 * @version 1.00 05/10/30
 */
 import java.util.*;
 import java.io.*;
public class TranspozycjaMacierzy {

static int podajLiczbe(String tekst, int min, int max) throws IOException {
        BufferedReader wejscie = new BufferedReader(
    new InputStreamReader(System.in));
    int liczba;
        do {
                System.out.print(tekst);
                // kradniemy z Oazy
        liczba = min - 1;
        try {
            String element = wejscie.readLine();
                        liczba = Integer.parseInt(element);
                if ((liczba < min) || (liczba > max))
                liczba = min - 1;
            }
        catch (NumberFormatException ex) {
            liczba = min - 1;
        }
    } while (liczba == min - 1);
    return liczba;
}
static void pokazTablice(int[][] tab) {
        for (int w = 0; w < tab.length; w++) {
                for (int k = 0; k < tab[w].length; k++) {
                        System.out.print(tab[w][k] + "\t");
                }
                System.out.print("\n");
    }
}

    public static void main(String[] args) throws IOException {
                BufferedReader wejscie = new BufferedReader(
                new InputStreamReader(System.in));
        int wiersze = podajLiczbe("Podaj liczbe wierszy (max 9): ",1,9);
                int kolumny = podajLiczbe("Podaj liczbe kolumn (max 9): ", 1,9);

                // kradniemy z MacierzTemperatur
                Random los = new Random();
                int[][] tab = new int[wiersze][kolumny];
                // wypelnianie losowo
                for (int w = 0; w < tab.length; w++) {
                        for (int k = 0; k < tab[w].length; k++) {
                                tab[w][k] = los.nextInt(100) + (w+1) * 100;
                        }
            }
            pokazTablice(tab);
                System.out.print("\nTransponowana:\n");
            // tablica transponowana
            int[][] transtab = new int[kolumny][wiersze];
                for (int w = 0; w < transtab.length; w++) {
                        for (int k = 0; k < transtab[w].length; k++) {
                                transtab[w][k] = tab[k][w];
                        }
            }
            pokazTablice(transtab);
        }
}
