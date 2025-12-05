package ManajemenDataMahasiswa;
import java.util.Scanner;
public class ManajemenDataMahasiswa1 {
  static int[] nilaiMahasiswa;
  static int jumlahData = 0;
  static final int MAX_DATA = 100;

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // inisialisasi array
    nilaiMahasiswa = new int[MAX_DATA];

    int pilihan;

    do {
      tampilkanMenu();
      System.out.println("Masukkan pilih (1-4): ");
      pilihan = input.nextInt();

      switch (pilihan) {
        case 1:
          inputNilaiMahasiswa(input);
          break;
        case 2:
          tampilkanNilaiMahasiswa();
          break;
        case 3: 
          urutanNilaiMahasiswa();
          break;
        case 4:
          System.out.println("Terimakasih program selesai!");
          break;
        default:
          System.out.println("Pilihan tidak valid! pilihan dari no 1 - 4");
          break;
      }
      System.out.println();
    } while (pilihan != 4);
    input.close();
  }

  // function menampilkan menu
  static void tampilkanMenu() {
    System.out.println("===============MENU=============");
    System.out.println("1. MASUKKAN NILAI MAHASISWA");
    System.out.println("2. TAMPILKAN NILAI MAHASISWA");
    System.out.println("3. URUTAN NILAI MAHASISWA");
    System.out.println("4. EXIT");
    System.out.println("=================================");
  }

  // function input nilai mahasiswa
  static void inputNilaiMahasiswa(Scanner input) {
    if (jumlahData >= MAX_DATA){
      System.out.println("DATA SUDAH PENUH ! TIDAK DAPAT MENGINPUT");
      return;
    }

    System.out.println("\n--- INPUT NILA MAHASISWA ---");
    System.out.print("MASUKKAN NILAI MAHASISWA");
    int nilai = input.nextInt();

    // validasi nilai 0 - 100
    if (nilai < 0 || nilai > 100) {
      System.out.println("NILAI TIDAK VALID! NILAI HARUS 0 - 100");
      return;
    }

    // nilai disimpan ke data array
    nilaiMahasiswa[jumlahData] = nilai;
    jumlahData++;

    System.out.println("NILAI BERHASIL FITAMBAH");
  }

  // function menammpilkan data nilai mahasiswa
  static void tampilkanNilaiMahasiswa () {
    if (jumlahData == 0) {
      System.out.println("\n BELUM ADA DATA YANG DITAMBAH");
      return;
    }

    System.out.println("\n DATA MAHASISWA");
    System.out.println("NO \tNILAI");
    System.out.println("-----------------");

    for (int i = 0; i <jumlahData; i++ ) {
      System.out.println((i + 1) + "\t" + nilaiMahasiswa[i]);
    }

    // menampilkan statistika
    System.out.println("---------------");
    System.out.println("JUMLAH DATA " + jumlahData);
  }

  // Function untuk mengurutkan nilai mahasiswa menggunakan bubble short
  static void urutanNilaiMahasiswa() {
    if (jumlahData == 0) {
      System.out.println("BELUM ADA DATA NILAI MAHASISWA");
      return;
    }

    if (jumlahData == 1 ){
      System.out.println("HANYA ADA SATU DATA MAHASISWA");
      return;
    }

    // MENGURUTKAN NILAI DATA MAHASISWA
    System.out.println("MENGURUTKAN NILAI MAHASISWA");
    System.out.println("DATA SEBELUM DI URUTKAN");
    tampilkanNilaiMahasiswa();

    // implementasi bubble short Ascending
    for (int i = 0; i < jumlahData -1 ; i++) {
      for (int j = 0; j < jumlahData - i -1; j++) {
        // jika nilai pada index j lebih besar dari pada index j+1, tukar
        if (nilaiMahasiswa[j] > nilaiMahasiswa[j + 1]) {
          // tukar nilai
          int temp =nilaiMahasiswa[j];
          nilaiMahasiswa[j] = nilaiMahasiswa[j+1];
          nilaiMahasiswa[j + 1] = temp;
        }
      }

      // menampilkan proses pegurutan
      System.out.println("LANGKAH" + (i + 1)+ ":");
      for (int k = 0; k < jumlahData; k++) {
        System.out.println(nilaiMahasiswa[k] + " ");
      }
      System.out.println();
    }
    System.out.println("\nDATA SETELAH DIURUTKAN (ASCENDING)");
    tampilkanNilaiMahasiswa();
  }
}
