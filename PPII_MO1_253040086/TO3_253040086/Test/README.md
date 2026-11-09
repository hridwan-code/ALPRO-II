# Tugas 2 - Array, Matriks, String dan Linear Search

Praktikum Pemrograman II
Nama : Hanura Nur Ridwan
NRP  : 253040086

## Isi pengumpulan
- src/ArrayUtil.java   : method linear dan semuaIndeks
- src/MatriksUtil.java : method jumlahBaris dan transpose
- src/TeksUtil.java    : method ukurTeks
- src/Main.java        : program untuk menjalankan semua uji (Tabel A, B, C)
- README.md
- laporan.pdf
- log_pengujian.txt    : hasil menjalankan Main

## Cara menjalankan
mkdir out
javac -d out src/*.java
java -cp out Main

Untuk menyimpan log:
java -cp out Main > log_pengujian.txt

## Catatan
- Semua method public static dengan nama dan tipe sesuai soal.
- Logika ada di ArrayUtil, MatriksUtil, TeksUtil. Pencetakan hanya di Main.
- semuaIndeks memakai dua lintasan (hitung dulu, baru isi array).
- Tidak pakai ArrayList, Stream, sort, atau fungsi pencarian bawaan.
- jumlahBaris pakai variabel long dari awal supaya tidak overflow.
- transpose mengecek semua baris dulu sebelum menyalin, jadi kalau masukan
  tidak sah tidak ada data yang berubah.
- Masukan tidak diubah, hasil selalu array baru.
- Semua uji di Main lulus (29 uji). 