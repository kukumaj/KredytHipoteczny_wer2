package com.testy2;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MIES_W_ROKU = 12;
        final byte PROCENT = 100;

        int kw_kredytu = 0;
        float opr_mies = 0;
        int ilosc_splat = 0;

        Scanner wczyt_dane = new Scanner(System.in);

        while (true) {
            System.out.print("Kwota_Kredytu: ");
            kw_kredytu = wczyt_dane.nextInt();
            if (kw_kredytu >= 1000 && kw_kredytu <= 1_000_000)
                break;
            System.out.println("Wprowadz wartosc od 1000 do 1000000");
        }

        while (true) {
            System.out.print("Oprocentowanie_Roczne: ");
            float opr_rocz = wczyt_dane.nextFloat();
            if (opr_rocz >= 1 && opr_rocz <= 30) {
                opr_mies = opr_rocz / PROCENT / MIES_W_ROKU;
                break;
            }
            System.out.println("Wprowadz wartosc od 1 do 30");
        }

        while (true) {
            System.out.print("Okres(w latach): ");
            byte lata = wczyt_dane.nextByte();
            if (lata >= 1 && lata <= 30) {
                ilosc_splat = lata * MIES_W_ROKU;
                break;
            }
            System.out.println("Wprowadz wartosc od 1 do 30.");
        }

        double hipoteka = kw_kredytu
                * (opr_mies * Math.pow(1 + opr_mies, ilosc_splat))
                / (Math.pow(1 + opr_mies, ilosc_splat) - 1);

        String hipotekaformatowanie = NumberFormat.getCurrencyInstance().format(hipoteka);
        System.out.println("Kredyt jeszcze do splacenia: " + hipotekaformatowanie);
    }
}
