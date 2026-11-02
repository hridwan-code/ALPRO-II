# Tugas 1 – Generic ADT dan Hash Table

## Identitas
- Nama: Hanura Nur Ridwan
- NIM: 253040086
- Kelas: B
- Mata Kuliah: Praktikum Pemrograman II

## Deskripsi
Program ini dibuat untuk memenuhi Tugas 1 Generic ADT dan Hash Table. Program menggunakan Generic ADT berupa `SimpleBag<E>` dan `ArrayBag<E>` untuk menyimpan riwayat tiket, serta dua implementasi hash table, yaitu Separate Chaining dan Linear Probing, untuk menyimpan indeks tiket.

Setiap tiket memiliki ID, nama, dan status. Riwayat menyimpan setiap versi tiket yang dimasukkan, sedangkan hash table menyimpan versi terbaru berdasarkan ID tiket.

## Struktur Proyek
- `src/` : Berisi seluruh kode sumber Java.
- `test/` : Berisi informasi pengujian program.
- `docs/` : Berisi laporan dan bukti pengujian.
- `README.md` : Petunjuk penggunaan proyek.

## Kebutuhan Sistem
- Java Development Kit (JDK): [Isi sesuai hasil `java -version`]
- Editor: Visual Studio Code
- Sistem operasi: Windows

## Cara Memeriksa Versi Java
Jalankan perintah berikut pada terminal:

```bash
java -version
javac -version
```

## Cara Build
Buka terminal pada folder utama proyek, kemudian jalankan perintah berikut di PowerShell:

```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java src | ForEach-Object FullName)
```

## Cara Menjalankan
Setelah proses build berhasil, jalankan:

```bash
java -cp out PPII_MO1_253040086.Main
```

## Fitur Program
1. Menyimpan riwayat tiket menggunakan Generic ADT.
2. Mengimplementasikan ArrayBag dengan iterator.
3. Mengimplementasikan hash table menggunakan Separate Chaining.
4. Mengimplementasikan hash table menggunakan Linear Probing.
5. Menambahkan, mencari, memperbarui, dan menghapus data tiket.
6. Menampilkan riwayat perubahan tiket dan isi indeks.

## Dokumentasi
Laporan dan bukti pengujian dapat ditemukan pada folder `docs/`.