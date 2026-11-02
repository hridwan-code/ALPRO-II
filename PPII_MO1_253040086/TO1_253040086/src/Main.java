package PPII_MO1_253040086.TO1_253040086.src;

public class Main {

    public static void main(String[] args) {
        testChainedHashMap();
        testProbeHashMap();
        testTicketIntegration();
    }
    public static void testChainedHashMap() {
        System.out.println("   PENGUJIAN CHAINED HASH MAP");
        MiniMap<Integer, String> map =
            new ChainedHashMap<>();
        System.out.println("\n1. Pengujian Put");
        System.out.println("Put 2: " + map.put(2, "Andi"));
        System.out.println("Put 7: " + map.put(7, "Budi"));
        System.out.println("Put 12: " + map.put(12, "Citra"));
        System.out.println("Size: " + map.size());
        System.out.println("\n2. Pengujian Get");
        System.out.println("Get 2: " + map.get(2));
        System.out.println("Get 7: " + map.get(7));
        System.out.println("Get 12: " + map.get(12));
        System.out.println("\n3. Pengujian Update");
        System.out.println(
            "Old Value: " + map.put(7, "Budi Revisi")
        );
        System.out.println("New Value: " + map.get(7));
        System.out.println("Size: " + map.size());
        System.out.println("\n4. Pengujian ContainsKey");
        System.out.println("Key 7: " + map.containsKey(7));
        System.out.println("Key 99: " + map.containsKey(99));
        System.out.println("\n5. Pengujian Remove");
        System.out.println("Remove 2: " + map.remove(2));
        System.out.println("Contains 2: " + map.containsKey(2));
        System.out.println("Final Size: " + map.size());
        System.out.println("\n6. Pengujian Resize");
        map.put(17, "Dina");
        map.put(22, "Eko");
        System.out.println("Size setelah penambahan: " + map.size());
        System.out.println("Get 12: " + map.get(12));
        System.out.println("Get 17: " + map.get(17));
        System.out.println("Get 22: " + map.get(22));
        System.out.println("\n=== PENGUJIAN CHAINED SELESAI ===");
    }


    public static void testProbeHashMap() {
        System.out.println("    PENGUJIAN PROBE HASH MAP");
        ProbeHashMap<Integer, Integer> map =
            new ProbeHashMap<>(5, false);
        System.out.println("\n1. Memasukkan Data");
        System.out.println("Put 2: " + map.put(2, 2));
        System.out.println("Put 7: " + map.put(7, 7));
        System.out.println("Put 12: " + map.put(12, 12));
        System.out.println("Size: " + map.size());
        System.out.println("\n2. Menghapus Key 7");
        System.out.println("Remove 7: " + map.remove(7));
        System.out.println("Contains 7: " + map.containsKey(7));
        System.out.println("\n3. Mengakses Key 12");
        System.out.println("Get 12: " + map.get(12));
        System.out.println("\n4. Memperbarui Key 12");
        System.out.println("Old Value: " + map.put(12, 99));
        System.out.println("New Value: " + map.get(12));
        System.out.println("\n5. Memasukkan Key 17");
        System.out.println("Put 17: " + map.put(17, 17));
        System.out.println("\n6. Hasil Akhir");
        System.out.println("Size: " + map.size());
        System.out.println("Key 2: " + map.get(2));
        System.out.println("Key 12: " + map.get(12));
        System.out.println("Key 17: " + map.get(17));
        System.out.println("Contains 7: " + map.containsKey(7));
        System.out.println("\n=== PENGUJIAN PROBE SELESAI ===");
    }

    
    public static void testTicketIntegration() {

    System.out.println("\n==================================");
    System.out.println("       INTEGRASI DATA TIKET");
    System.out.println("==================================");

    // Menguji kedua implementasi map
    runTicketScenario(
        new ChainedHashMap<Integer, Tiket>(),
        "CHAINED HASH MAP"
    );

    runTicketScenario(
        new ProbeHashMap<Integer, Tiket>(),
        "PROBE HASH MAP"
    );
}

    public static void runTicketScenario(
        MiniMap<Integer, Tiket> map,
        String namaMap) {
    SimpleBag<Tiket> riwayat = new ArrayBag<>();
    System.out.println("\n--- " + namaMap + " ---");
    System.out.println("\n1. Menambahkan Tiket");
    Tiket tiket2 = new Tiket(2, "Andi", "BARU");
    Tiket tiket7 = new Tiket(7, "Budi", "BARU");
    Tiket tiket12 = new Tiket(12, "Citra", "BARU");
    map.put(tiket2.getId(), tiket2);
    riwayat.add(tiket2);
    map.put(tiket7.getId(), tiket7);
    riwayat.add(tiket7);
    map.put(tiket12.getId(), tiket12);
    riwayat.add(tiket12);
    System.out.println("Tiket berhasil ditambahkan.");
    System.out.println("\n2. Menghapus Tiket ID 7");
    System.out.println("Hasil remove: " +
        map.remove(7));
    System.out.println("Tiket ID 7 masih di map: " +
        map.containsKey(7));
    System.out.println("\n3. Mengambil Tiket ID 12");
    Tiket tiketLama = map.get(12);
    System.out.println("Tiket ditemukan: " + tiketLama);
    System.out.println("\n4. Memperbarui Tiket ID 12");
    Tiket tiketBaru = tiketLama.versiBaru(
        "Citra revisi",
        "DIPROSES"
    );
    map.put(12, tiketBaru);
    riwayat.add(tiketBaru);
    System.out.println("Versi lama: " + tiketLama);
    System.out.println("Versi baru: " + map.get(12));
    System.out.println("\n5. Menambahkan Tiket ID 17");
    Tiket tiket17 = new Tiket(17, "Dina", "BARU");
    map.put(tiket17.getId(), tiket17);
    riwayat.add(tiket17);
    System.out.println("Tiket berhasil ditambahkan.");
    System.out.println("\n6. Isi Map Saat Ini");
    int[] daftarId = {2, 7, 12, 17};
    for (int id : daftarId) {
        Tiket tiket = map.get(id);
        if (tiket != null) {
            System.out.println(tiket);
        } else {
            System.out.println("ID " + id + " tidak ditemukan.");
        }
    }
    System.out.println("\n7. Riwayat Seluruh Tiket");
    java.util.Iterator<Tiket> iterator =
        riwayat.iterator();
    while (iterator.hasNext()) {
        System.out.println(iterator.next());
    }
    System.out.println("\nJumlah tiket dalam map: " +
        map.size());
    System.out.println("Jumlah riwayat tiket: " +
        riwayat.size());
    System.out.println("==================================");
}
}
