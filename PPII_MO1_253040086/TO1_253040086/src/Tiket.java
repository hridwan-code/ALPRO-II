package PPII_MO1_253040086.TO1_253040086.src;

public class Tiket {

    private final int id;
    private final String nama;
    private final String status;
    public Tiket(int id, String nama, String status) {
        this.id = id;
        this.nama = nama;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getStatus() {
        return status;
    }

    public Tiket versiBaru(String namaBaru, String statusBaru) {
        return new Tiket(this.id, namaBaru, statusBaru);
    }

    @Override
    public String toString() {
        return "Tiket{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

