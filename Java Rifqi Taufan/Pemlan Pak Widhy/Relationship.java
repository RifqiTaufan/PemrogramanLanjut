// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.Queue;

class Mobil {
    protected String nomorPolisi;
    protected String tipe;
    protected int jumlahPenumpang;

    public Mobil(String nomorPolisi, String tipe, int jumlahPenumpang) {
        this.nomorPolisi = nomorPolisi;
        this.tipe = tipe;
        this.jumlahPenumpang = jumlahPenumpang;
    }

    public String getNomorPolisi() {
        return nomorPolisi;
    }

    public String getTipe() {
        return tipe;
    }

    public int getJumlahPenumpang() {
        return jumlahPenumpang;
    }

    public String toString() {
        return String.format("%-17s: %s\n%-17s: %s\n%-17s: %d", "Nomor Polisi", nomorPolisi, "Tipe", tipe, "Jumlah Penumpang", jumlahPenumpang);
    }
}

class Angkot extends Mobil {
    private DriverAngkot driverAngkot;
    private Penumpang[] daftarPenumpang;

    public Angkot(String nomorPolisi, String tipe, int jumlahPenumpang) {
        super(nomorPolisi, tipe, jumlahPenumpang);
        this.daftarPenumpang = new Penumpang[jumlahPenumpang];
    }

    public DriverAngkot getDriverAngkot() {
        return driverAngkot;
    }

    public void setDriverAngkot(DriverAngkot driverAngkot) {
        this.driverAngkot = driverAngkot;
    }

    public void naikPenumpang(Penumpang penumpang) {
        for (int i = 0; i < this.daftarPenumpang.length; i++) {
            if (this.daftarPenumpang[i] == null) {
                this.daftarPenumpang[i] = penumpang;
                break;
            }
        }
    }

    public void turunPenumpang(Penumpang penumpang) {
        for (int i = 0; i < daftarPenumpang.length; i++) {
            if (daftarPenumpang[i] != null && daftarPenumpang[i].getNama().equals(penumpang.getNama())) {
                daftarPenumpang[i] = null;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    // public void displayAngkot() {
    //     System.out.println("Nomor Polisi        : " + this.nomorPolisi);
    //     System.out.println("Tipe                : " + this.tipe);
    //     System.out.println("Jumlah penumpang    : " + this.jumlahPenumpang);
    //     System.out.println("Daftar penumpang  : ");
    //     for (int i = 0; i < jumlahPenumpang; i++) {
    //          if (daftarPenumpang[i] != null) {
    //          System.out.println((i + 1) + ". " + daftarPenumpang[i].getNama());
    //          }
    //      }
    // }
}

class Bus extends Mobil {
    private DriverBus driverBus;
    private Penumpang[] daftarPassenger;

    public Bus(String nomorPolisi, String tipe, int jumlahPenumpang) {
        super(nomorPolisi, tipe, jumlahPenumpang);
        this.daftarPassenger = new Penumpang[jumlahPenumpang];
    }

    public DriverBus getDriverBus() {
        return driverBus;
    }

    public void setDriverBus(DriverBus driverBus) {
        this.driverBus = driverBus;
    }

    public void naikPenumpang(Penumpang penumpang) {
        for (int i = 0; i < daftarPassenger.length; i++) {
            if (daftarPassenger[i] == null) {
                daftarPassenger[i] = penumpang;
                break;
            }
        }
    }

    public void turunPenumpang(Penumpang penumpang) {
        for (int i = 0; i < daftarPassenger.length; i++) {
            if (daftarPassenger[i] != null && daftarPassenger[i].getNama().equals(penumpang.getNama())) {
                daftarPassenger[i] = null;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
    // public void displayBus() {
    //     System.out.println("Nomor Polisi       : " + this.nomorPolisi);
    //     System.out.println("Tipe               : " + this.tipe);
    //     System.out.println("Jumlah penumpang   : " + this.jumlahPenumpang);
    //     System.out.println("Daftar penumpang : ");
    //     for (int i = 0; i < jumlahPenumpang; i++) {
    //         if (daftarPassenger[i] != null) {
    //         System.out.println((i + 1) + ". " + daftarPassenger[i].getNama());
    //         }
    //     }
    // }
}

class Orang {
    protected String nama;

    public Orang() {

    }

    public Orang(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

}

class DriverBus extends Orang {
    private boolean SIM_B;

    public DriverBus() {

    }

    public DriverBus(String nama, boolean SIM_B) {
        super(nama);
        this.SIM_B = SIM_B;
    }

    public boolean isSIM_B() {
        return SIM_B;
    }

    public void nyetirBus(Bus bus) {
        if (SIM_B == true) {
            System.out.println("Pengemudi bernama " + getNama() + " mengendarai bus " + bus.tipe + ".");
        } else {
            System.out.println("Pengemudi bernama " + getNama() + " tidak memiliki SIM B untuk menarik bus " + bus.tipe + ".");
        }
    }
}

class DriverAngkot extends Orang {
    private boolean SIM_A;

    public DriverAngkot() {

    }

    public DriverAngkot(String nama, boolean SIM_A) {
        super(nama);
        this.SIM_A = SIM_A;
    }

    public boolean isSIM_A() {
        return SIM_A;
    }

    public void nyetirAngkot(Angkot angkot) {
        if (SIM_A == true) {
            System.out.println("Pengemudi bernama " + getNama() + " mengendarai angkot " + angkot.tipe + ".");
        } else {
            System.out.println("Pengemudi bernama " + getNama() + " tidak memiliki SIM A untuk menarik angkot " + angkot.tipe + ".");
        }
    }

}

class Penumpang extends Orang {

    public Penumpang(String nama) {
        super(nama);
    }
}


public class Relationship {
    public static void main(String[] args) {
        // ARRAY INDEX OUT OF BOUNDS EXCEPTION
        try {
            Mobil[] listKendaraan = new Mobil[5];

            listKendaraan[0] = new Angkot("N 1234 AB", "Suzuki", 20);
            listKendaraan[1] = new Angkot("B 121 FQI", "Toyota", 20);
            listKendaraan[2] = new Angkot("N 1733 DEK", "Isuzu", 15);
            listKendaraan[3] = new Bus("N 9845 BJC", "Juragan 99", 40);
            listKendaraan[4] = new Bus("B 9123 JKL", "27 Trans", 45);
            listKendaraan[5] = new Bus("N 4820 WER", "Handoyo", 30);

            for (Mobil kendaraan : listKendaraan) {
                System.out.println(kendaraan.toString());
                System.out.println();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        // ARITHMETIC EXCEPTION
        try {
            Mobil[] listKendaraan = new Mobil[2];

            listKendaraan[0] = new Angkot("N 1234 AB", "Suzuki", 0);
            listKendaraan[1] = new Angkot("B 121 FQI", "Toyota", 0);
            
            int totalJumlahPenumpang = 0;
            int jumlahKendaraan = 0;

            for (Mobil kendaraan : listKendaraan) {
                totalJumlahPenumpang += kendaraan.getJumlahPenumpang();
            }

            if (jumlahKendaraan == 0) {
                throw new ArithmeticException("Tidak ada kendaraan.");
            }

            int rataRataJumlahPenumpang = totalJumlahPenumpang / jumlahKendaraan;
            System.out.printf("%-27s: %d","Rata-rata Jumlah Penumpang", rataRataJumlahPenumpang);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println();
            Angkot angkot = new Angkot("N 1234 AB", "Suzuki", 20);
            Angkot angkot1 = new Angkot("B 121 FQI", "Toyota", 20);

            System.out.println(angkot.toString());
            System.out.println();
            System.out.println(angkot1.toString());
        }
        System.out.println();

        // GENERAL EXCEPTION (NULL POINTER EXCEPTION)
        try {
            Bus bus = new Bus("N 9845 BJC", "Juragan 99", 40);
            DriverBus driver = null;

            driver.nyetirBus(bus);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        
        // ArrayList<Angkot> daftarAngkot = new ArrayList<Angkot>();
        // daftarAngkot.add(new Angkot("N 1234 AB", "Suzuki", 20));
        // daftarAngkot.add(new Angkot("B 121 FQI", "Toyota", 20));
        // daftarAngkot.add(new Angkot("N 1733 DEK", "Isuzu", 15)); 

        // ArrayList<DriverAngkot> driver1 = new ArrayList<DriverAngkot>();
        // driver1.add(new DriverAngkot("Pak Supri", true));
        // driver1.add(new DriverAngkot("Pak Gonsu", false));
        // driver1.add(new DriverAngkot("Pak Jarwo", true));

        // daftarAngkot.get(0).setDriverAngkot(driver1.get(0));
        // daftarAngkot.get(1).setDriverAngkot(driver1.get(1));
        // daftarAngkot.get(2).setDriverAngkot(driver1.get(2));

        // System.out.println("=======DAFTAR ANGKOT=======");
        // for (Angkot angkot : daftarAngkot) {
        //     angkot.displayAngkot();
        //     System.out.println();
        // }

        // ArrayList<Bus> daftarBus = new ArrayList<Bus>();
        // daftarBus.add(new Bus("N 9845 BJC", "Juragan 99", 40));
        // daftarBus.add(new Bus("B 9123 JKL", "27 Trans", 45));
        // daftarBus.add(new Bus("N 4820 WER", "Handoyo", 30)); 

        // ArrayList<DriverBus> driver2 = new ArrayList<DriverBus>();
        // driver2.add(new DriverBus("Pak Grijo", true));
        // driver2.add(new DriverBus("Pak Seruni", false));
        // driver2.add(new DriverBus("Pak Bediku", true));

        // daftarBus.get(0).setDriverBus(driver2.get(0));
        // daftarBus.get(1).setDriverBus(driver2.get(1));
        // daftarBus.get(2).setDriverBus(driver2.get(2));

        // System.out.println("=======DAFTAR BUS=======");
        // for (Bus bus : daftarBus) {
        //     bus.displayBus();
        //     System.out.println();
        // }

        // Queue<Angkot> antrianAngkot = new LinkedList<>();
        // antrianAngkot.add(daftarAngkot.get(0));
        // antrianAngkot.add(daftarAngkot.get(1));
        // antrianAngkot.add(daftarAngkot.get(2));

        // int nomorantrian = 0;
        // System.out.println("Antrian Angkot di Terminal: ");
        // for (Angkot angkot : antrianAngkot) {
        //     System.out.println(++nomorantrian + ". " + "Pengemudi bernama " + angkot.getDriverAngkot().getNama() + " dengan angkot " + angkot.getTipe() + " masuk terminal.");
        // }

        // Queue<Bus> antrianBus = new LinkedList<>();
        // antrianBus.add(daftarBus.get(0));
        // antrianBus.add(daftarBus.get(1));
        // antrianBus.add(daftarBus.get(2));

        // int antrian = 0;
        // System.out.println("Antrian Bus di Terminal: ");
        // for (Bus bus : antrianBus) {
        //     System.out.println(++antrian + ". " + "Pengemudi bernama " + bus.getDriverBus().getNama() + " dengan bus " + bus.getTipe() + " masuk terminal. ");
        // }

        // Angkot angkot1 = new Angkot("N 1234 AB", "Suzuki", 10);
        // Angkot angkot2 = new Angkot("B 121 FQI", "Toyota", 10);
        // Bus bus1 = new Bus("N 4567 BG", "Mercedes Benz", 20);
        // Bus bus2 = new Bus("AE 1 MS", "Hino", 20);

        // DriverAngkot driverAngkot1 = new DriverAngkot("Pak Bagong", true);
        // DriverAngkot driverAngkot2 = new DriverAngkot("Pak Sutarno", false);
        // DriverBus driverBus1 = new DriverBus("Pak Rudi", true);
        // DriverBus driverBus2 = new DriverBus("Pak Batir", false);
        // System.out.println();

        // Penumpang penumpang1 = new Penumpang("Lebron");
        // Penumpang penumpang2 = new Penumpang("James");
        // Penumpang penumpang3 = new Penumpang("Peter");
        // Penumpang penumpang4 = new Penumpang("Tony");
        // Penumpang penumpang5 = new Penumpang("Caitlin");
        // Penumpang penumpang6 = new Penumpang("Stephen");
        // Penumpang penumpang7 = new Penumpang("Klay");
        // Penumpang penumpang8 = new Penumpang("Albert");
        // Penumpang penumpang9 = new Penumpang("Skylar");
        // Penumpang penumpang10 = new Penumpang("Celi");
        // Penumpang penumpang11 = new Penumpang("Pai");
        // Penumpang penumpang12 = new Penumpang("Kayes");
        // Penumpang penumpang13 = new Penumpang("Vior");
        // Penumpang penumpang14 = new Penumpang("Gaby");
        // Penumpang penumpang15 = new Penumpang("Aisyah");
        // Penumpang penumpang16 = new Penumpang("Citra");
        // Penumpang penumpang17 = new Penumpang("Edith");
        // Penumpang penumpang18 = new Penumpang("Fanny");
        // Penumpang penumpang19 = new Penumpang("Angie");
        // Penumpang penumpang20 = new Penumpang("Vania");
        // System.out.println();

        // driverAngkot1.nyetirAngkot(angkot1);
        // driverAngkot1.nyetirAngkot(angkot2);
        // driverAngkot2.nyetirAngkot(angkot1);
        // driverAngkot2.nyetirAngkot(angkot2);
        // driverBus1.nyetirBus(bus1);
        // driverBus1.nyetirBus(bus2);
        // driverBus2.nyetirBus(bus1);
        // driverBus2.nyetirBus(bus2);
        // System.out.println();

        // angkot1.turunPenumpang(penumpang15);
        // angkot1.naikPenumpang(penumpang10);
        // angkot1.naikPenumpang(penumpang20);
        // angkot1.naikPenumpang(penumpang7);
        // angkot1.naikPenumpang(penumpang11);
        // System.out.println();

        // angkot2.naikPenumpang(penumpang2);
        // angkot2.naikPenumpang(penumpang13);
        // angkot2.naikPenumpang(penumpang12);
        // angkot2.naikPenumpang(penumpang1);
        // angkot2.naikPenumpang(penumpang17);
        // System.out.println();

        // bus1.naikPenumpang(penumpang3);
        // bus1.naikPenumpang(penumpang6);
        // bus1.naikPenumpang(penumpang9);
        // bus1.naikPenumpang(penumpang14);
        // bus1.naikPenumpang(penumpang18);
        // bus1.naikPenumpang(penumpang15);
        // System.out.println();

        // bus2.naikPenumpang(penumpang4);
        // bus2.naikPenumpang(penumpang5);
        // bus2.naikPenumpang(penumpang8);
        // bus2.naikPenumpang(penumpang16);
        // bus2.naikPenumpang(penumpang19);
        // System.out.println();
    }
}
