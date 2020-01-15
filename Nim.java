package com.gameofnim;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Nim {

    String player;

    public void mulai() {
        Scanner in = new Scanner(System.in);

        System.out.println("\n -- Game Of NIM --");
        System.out.println("\nInstruksi sebelum bermain:");
        System.out.println("1. Pemain mengambil minimal satu atau maksimal setengah dari sisa kelereng");
        System.out.println("2. Pemain yang mengambil kelereng terakhir akan menjadi pemenang");

        System.out.print("\nPlayer Name: ");
        player = in.nextLine();
        System.out.println("\na.) Computer Stupid");
        System.out.println("b.) Computer Smart");
        System.out.print("Pilih lawan terlebih dahulu [a/b]: ");
        String lawan = in.nextLine();

        if (lawan.toLowerCase().equals("a")) {
            System.out.println("\nSip, " + player + " akan bermain dengan Computer Stupid");
            stupid();
        } else if (lawan.toLowerCase().equals("b")) {
            System.out.println("\nWow, " + player + " akan bermain dengan Computer Smart");
            smart();
        } else {
            System.err.println("\nLawan tidak ditemukan");
            coba();
        }
    }

    public void stupid(){
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("\nJumlah kelereng yang akan digunakan [10 - 100]: ");
        try {
            int kelereng = in.nextInt();
            if(kelereng < 10) {
                System.err.println("Jumlah kelereng terlalu sedikit");
                stupid();
            }
            else if(kelereng > 100) {
                System.err.println("Jumlah kelereng terlalu banyak");
                stupid();
            }
            else {
                int pertama = random.nextInt(2);

                // Cek siapa yg lebih dahulu
                if(pertama == 0) {
                    System.out.println("\nComputer stupid lebih dahulu");

                    // looping inputan jumlah kelereng
                    while (kelereng > 0) {

                        // Computer
                        int minKelereng = 1;
                        int maxKelereng = kelereng / 2;

                        // Random dari angka minKelereng - maxKelereng
                        int kelComputer = random.nextInt(maxKelereng) + minKelereng;
                        System.out.println("\n-- Computer Stupid mengambil " + kelComputer + " kelereng");

                        kelereng -= kelComputer;
                        System.out.println("Sisa kelereng saat ini: " + kelereng + " kelereng");

                        // Cek sisa kelereng dari computer
                        if(kelereng == 1) {
                            System.out.println("\nMantap, " + player + " menang.");
                            coba();
                            return;
                        }

                        // Player
                        maxKelereng = kelereng / 2;
                        System.out.print("\n" + player + " ambil kelereng: ");
                        int kelPlayer = in.nextInt();

                        // Cek inputan player
                        while (kelPlayer == 0 || kelPlayer == -1 || kelPlayer > maxKelereng){
                            System.err.println("Hey, minimal mengambil satu atau maksimal setengah dari sisa kelereng");
                            System.out.print("\n" + player + " ambil kelereng: ");
                            kelPlayer = in.nextInt();
                        }
                        System.out.println("\n-- " + player + " mengambil " + kelPlayer + " kelereng");

                        kelereng -= kelPlayer;
                        System.out.println("Sisa kelereng saat ini: " + kelereng + " kelereng");

                        // Cek sisa kelereng dari player
                        if(kelereng == 1) {
                            System.out.println("\nWadidaww, Computer Stupid menang.");
                            coba();
                            return;
                        }
                    }
                }
                else {
                    System.out.println("\n" + player + " terlebih dahulu");

                    // looping inputan jumlah kelereng
                    while (kelereng > 0) {

                        // Player
                        int maxKelereng = kelereng / 2;
                        System.out.print("\n" + player + " ambil kelereng: ");
                        int kelPlayer = in.nextInt();

                        // Cek jika inputan player lebih dari sisa kelereng
                        while (kelPlayer == 0 || kelPlayer == -1 || kelPlayer > maxKelereng) {
                            System.err.println("Hey, minimal mengambil satu atau maksimal setengah dari sisa kelereng");
                            System.out.print("\n" + player + " ambil kelereng: ");
                            kelPlayer = in.nextInt();
                        }
                        System.out.println("\n-- " + player + " mengambil " + kelPlayer + " kelereng");

                        kelereng -= kelPlayer;
                        System.out.println("Sisa kelereng saat ini: " + kelereng + " kelereng");

                        // Cek sisa kelereng dari player
                        if (kelereng == 1) {
                            System.out.println("\nWadidaww, Computer Stupid menang.");
                            coba();
                            return;
                        }

                        // Computer
                        int minKelereng = 1;
                        maxKelereng = kelereng / 2;

                        // Random dari angka minKelereng - maxKelereng
                        int kelComputer = random.nextInt(maxKelereng) + minKelereng;
                        System.out.println("\n-- Computer Stupid mengambil " + kelComputer + " kelereng");

                        kelereng -= kelComputer;
                        System.out.println("Sisa kelereng saat ini: " + kelereng + " kelereng");

                        // Cek sisa kelereng dari computer
                        if (kelereng == 1) {
                            System.out.println("\nMantap, " + player + " menang.");
                            coba();
                            return;
                        }
                    }
                }
            }
        }

        // Cek ketika inputan tidak sesuai
        catch (InputMismatchException e) {
            System.err.println("Inputan harus berupa angka bulat");
            stupid();
        }
    }

    public void smart() {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("\nJumlah kelereng yang akan digunakan [10 - 100]: ");
        try {
            int kelereng = in.nextInt();
            if (kelereng < 10) {
                System.err.println("Jumlah kelereng terlalu sedikit");
                smart();
            } else if (kelereng > 100) {
                System.err.println("Jumlah kelereng terlalu banyak");
                smart();
            }
            else {
                int pertama = random.nextInt(2);

                // Cek siapa yg lebih dahulu
                if (pertama == 0) {
                    System.out.println("\nComputer Smart terlebih dahulu");

                    // looping inputan jumlah kelereng
                    while (kelereng > 0) {

                        // Computer
                        int maxKelereng = kelereng / 2;

                        System.out.println("\n-- Computer Smart mengambil " + maxKelereng + " kelereng");

                        kelereng -= maxKelereng;
                        System.out.println("Sisa kelereng saat ini: " + kelereng + " kelereng");

                        // Cek sisa kelereng dari computer
                        if( kelereng == 1) {
                            System.out.println("\nMantap, " + player + " menang.");
                            coba();
                            return;
                        }

                        // Player
                        maxKelereng = kelereng / 2;
                        System.out.print("\n" + player + " ambil kelereng: ");
                        int kelPlayer = in.nextInt();

                        // Cek inputan player
                        while (kelPlayer == 0 || kelPlayer == -1 || kelPlayer > maxKelereng){
                            System.err.println("Hey, minimal mengambil satu atau maksimal setengah dari sisa kelereng");
                            System.out.print("\n" + player + " ambil kelereng: ");
                            kelPlayer = in.nextInt();
                        }
                        System.out.println("\n-- " + player + " mengambil " + kelPlayer + " kelereng");

                        kelereng -= kelPlayer;
                        System.out.println("Sisa kelereng saat ini: " + kelereng + " kelereng");

                        // Cek sisa kelereng dari player
                        if(kelereng == 1) {
                            System.out.println("\nWadidaww, Computer Smart menang.");
                            coba();
                            return;
                        }
                    }
                }
                else {
                    System.out.println("\n" + player + " terlebih dahulu");

                    // looping inputan jumlah kelereng
                    while (kelereng > 0) {

                       // player
                       int maxKelereng = kelereng / 2;
                       System.out.print("\n" + player + " ambil kelereng: ");
                       int kelPlayer = in.nextInt();

                       // Cek inputan player
                       while (kelPlayer == 0 || kelPlayer == -1 || kelPlayer > maxKelereng){
                           System.err.println("Hey, minimal mengambil satu atau maksimal setengah dari sisa kelereng");
                           System.out.print("\n" + player + " ambil kelereng: ");
                           kelPlayer = in.nextInt();
                       }
                       System.out.println("\n-- " + player + " mengambil " + kelPlayer + " kelereng");

                       kelereng -= kelPlayer;
                       System.out.println("Sisa kelereng saat ini: " + kelereng + " kelereng");

                       // Cek sisa kelereng dari player
                       if(kelereng == 1) {
                           System.out.println("\nWadidaww, Computer Smart menang.");
                           coba();
                           return;
                       }

                       // Computer
                       maxKelereng = kelereng / 2;

                       System.out.println("\n-- Computer Smart mengambil " + maxKelereng + " kelereng");

                       kelereng -= maxKelereng;
                       System.out.println("Sisa kelereng saat ini: " + kelereng + " kelereng");

                       // Cek sisa kelereng dari computer
                       if( kelereng == 1) {
                           System.out.println("\nMantap, " + player + " menang.");
                           coba();
                           return;
                       }
                   }
                }
            }
        }
        catch (InputMismatchException e) {
            System.err.println("Inputan harus berupa angka bulat");
            smart();
        }
    }

    public void coba(){
        Scanner in = new Scanner(System.in);
        System.out.print("\nCoba lagi [y/n] ? ");
        String input = in.nextLine();

        if (input.toLowerCase().equals("y")){
            mulai();
        }
        else if(input.toLowerCase().equals("n")){
            System.out.print("\nTerima kasih " + player + " sudah mau bermain :)");
        }
        else {
            System.err.println("\nJawaban kurang tepat");
            coba();
        }
    }
}
