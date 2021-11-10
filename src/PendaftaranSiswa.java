import java.util.Scanner;

public class PendaftaranSiswa {
    private static Scanner input = new Scanner(System.in);
    private static SiswaKursus_07373[] siswa = new SiswaKursus_07373[100];
    private static Admin_07373[] admin = new Admin_07373[100];
    private static SiswaTerdaftar_07373[] terdaftar = new SiswaTerdaftar_07373[100];

    private static int pilKursus;
    private static int jumSiswa = 0;
    private static int cekAdmin;

    public static void main(String[] args) {
        dataAdmin();

        int menu;

        do {
            System.out.println("Jumlah Siswa: " + jumSiswa);
            System.out.println("1. Login admin");
            System.out.println("2. Lihat Siswa yg terdaftar");
            System.out.println("3. biodata adminnya disini");
            System.out.println("0. Exit Program");

            menu = input.nextInt();
            input.nextLine();
            switch (menu) {
                case 1 -> loginAdmin();
                case 2 -> viewSiswa();
                case 3 -> lihatAdmin();
            }
        } while (menu != 0);
    }

    static void lihatAdmin() {
        for(int i = 0;i<dataAdmin();i++) {
            System.out.println("===============");
            System.out.println("nama: " + admin[i].getNama()
            + "\n no telp: " + admin[i].getNoTelp()
            + "\n alamat: " + admin[i].getAlamat());
        }
    }


    static void loginAdmin() {
        System.out.println("Nama : ");
        String nama = input.next();
        System.out.println("Password : ");
        String password = input.next();

        cekAdmin = login(nama, password);
        System.out.println("Selamat Datang " + admin[cekAdmin].getNama());
        int menu;
        do {
            System.out.println("Jumlah Siswa : " + jumSiswa);
            System.out.println("1. Daftarkan Siswa Kursus ");
            System.out.println("2. Ubah data Siswa kursus ");
            System.out.println("3. Lihat Siswa kursus yg terdaftar ");
            System.out.println("4. hapus siswa kursus ");
            System.out.println("0. Keluar");
            menu = input.nextInt();
            input.nextLine();
            switch (menu) {
                case 1 -> createSiswa();
                case 2 -> updateSiswa();
                case 3 -> viewSiswa();
                case 4 -> deleteSiswa();

            }
        }while (menu != 0);
    }



    static void insertKursus() {
        System.out.println("Jenis Kursus: ");
        for (int i = 0; i<Kursus_07373.kursus.length; i++) {
            System.out.println(i + ". " + Kursus_07373.kursus[i]);
        }
        System.out.println("Pilih Kursus: ");
        pilKursus = input.nextInt();
        System.out.println("Input kode siswa: ");
        String kodeSiswa = input.next();
        terdaftar[jumSiswa] = new SiswaTerdaftar_07373(siswa[jumSiswa], pilKursus, kodeSiswa);
        jumSiswa = jumSiswa + 1;
    }


    static int login(String nama, String password) {
        int loop = 0;
        for (int i = 0; i <= dataAdmin(); i++) {
            if (admin[i].getNama().equals(nama) && admin[i].getPassword().equals(password)) {
                break;
            } else {
                loop++;
            }
        }
        return loop;
    }

    static int dataAdmin() {
        String namaAdmin[] = {"Yusuf", "Maruf"};
        String passwordAdmin[] = {"01", "02"};
        String noTelpAdmin[] = {"088", "099"};
        String alamatAdmin[] = {"jl.abc", "jl.bca"};

        for (int i = 0; i < namaAdmin.length; i++) {
            admin[i] = new Admin_07373(passwordAdmin[i], namaAdmin[i], noTelpAdmin[i], alamatAdmin[i]);
        }
        return namaAdmin.length;
    }

    static void createSiswa() {
        System.out.println("input nama: ");
        String nama = input.nextLine();
        System.out.println("input umur: ");
        String umur = input.nextLine();
        System.out.println("input alamat: ");
        String alamat = input.nextLine();
        System.out.println("input no. telp: ");
        String noTelp = input.nextLine();

        siswa[jumSiswa] = new SiswaKursus_07373(umur, nama, noTelp, alamat);
        insertKursus();
    }

    static void updateSiswa() {
        System.out.print("Masukkan kode siswa yg mau di edit: ");
        String search = input.next();
        int cari = 0;
        do {
            if (cari == jumSiswa) {
                System.err.println("Tidak ada data");
                break;
            }else if (terdaftar[cari].getKodeSiswa().equals(search)) {
                int pilEdit;
                do {
                    System.out.println("Pilih data yg ingin diubah: ");
                    System.out.println("1. lihat biodata");
                    System.out.println("2. nama");
                    System.out.println("3. alamat");
                    System.out.println("4. no telp");
                    System.out.println("5. umur");
                    System.out.println("6. kursus");
                    System.out.println("0. keluar");
                    pilEdit = input.nextInt();
                    input.nextLine();
                    if (pilEdit == 1) {
                        System.out.println("Kode siswa: " + terdaftar[cari].getKodeSiswa());
                        System.out.println("=========================================");
                        System.out.println("Nama: " + siswa[cari].getNama()
                                + "\n Umur: " + siswa[cari].getUmur()
                                + "\n Alamat: " + siswa[cari].getAlamat()
                                + "\n no. telp: " + siswa[cari].getNoTelp()
                                + "\n kursus: " + Kursus_07373.kursus[terdaftar[cari].getIndexKursus()]);
                        System.out.println("=========================================");
                    } else if (pilEdit == 2) {
                        System.out.println("Ubah nama: ");
                        String editNama = input.nextLine();
                        siswa[cari].setNama(editNama);
                    } else if (pilEdit == 3) {
                        System.out.println("ubah alamat: ");
                        String editAlamat = input.nextLine();
                        siswa[cari].setAlamat(editAlamat);
                    } else if (pilEdit == 4) {
                        System.out.println("ubah no. telp: ");
                        String editNotelp = input.nextLine();
                        siswa[cari].setNoTelp(editNotelp);
                    } else if (pilEdit == 5) {
                        System.out.println("ubah umur: ");
                        String editUmur = input.nextLine();
                        siswa[cari].setUmur(editUmur);
                    } else if (pilEdit == 6) {
                        System.out.println("pilih kursus: ");
                        for (int i = 0; i < Kursus_07373.kursus.length; i++) ;
                        int editKursus = input.nextInt();
                        terdaftar[cari].setIndexKursus(editKursus);
                    }
                }while (pilEdit != 0) ;
                break;
            } else {
                cari = cari +1 ;
            }
        } while (true);
    }

    static void viewSiswa() {
        if (jumSiswa == 0) {
            System.out.println("belum ada siswa yang didaftarkan");
        } else {
            for (int i = 0; i< jumSiswa; i++) {
                System.out.println("==================");
                System.out.println(" Nama: " + siswa[i].getNama()
                        + "\n Umur: " + siswa[i].getUmur()
                        + "\n Alamat: " + siswa[i].getAlamat()
                        + "\n No telp: " + siswa[i].getNoTelp()
                        + "\n Jenis Kursus: " + Kursus_07373.kursus[terdaftar[i].getIndexKursus()]);
                System.out.println("==================");
            }
        }
    }

    static void deleteSiswa() {
        System.out.println("Masukkan kode siswa yg akan dihapus: ");
        String search = input.next();
        input.nextLine();
        int cari = 0;
        do {
            if (cari == jumSiswa) {
                System.err.println("tidak ada data");
                break;
            }else if (terdaftar[cari].getKodeSiswa().equals(search)) {
                if (cari == jumSiswa - 1) {
                    jumSiswa = jumSiswa - 1;
                }else {
                    for (int i = cari; i<jumSiswa;i++) {
                        terdaftar[i] = terdaftar[i+1];
                        siswa[i] = siswa[i+1];
                    }
                    jumSiswa = jumSiswa - 1;
                } break;
            } else {
                cari = cari + 1;
            }
        } while (true);
    }
}
