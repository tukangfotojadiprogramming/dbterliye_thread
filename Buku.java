public class Buku {
    private int id_buku;
    private String judul;
    private String genre;
    private int harga;
    private int stok;

    public Buku(int id_buku, String judul, String genre, int harga, int stok) {
        this.id_buku = id_buku;
        this.judul = judul;
        this.genre = genre;
        this.harga = harga;
        this.stok = stok;
    }

    // Constructor tanpa ID (untuk tambah data baru)
    public Buku(String judul, String genre, int harga, int stok) {
        this.judul = judul;
        this.genre = genre;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter
    public int getId_buku() { return id_buku; }
    public String getJudul() { return judul; }
    public String getGenre() { return genre; }
    public int getHarga() { return harga; }
    public int getStok() { return stok; }

    // Setter
    public void setJudul(String judul) { this.judul = judul; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setHarga(int harga) { this.harga = harga; }
    public void setStok(int stok) { this.stok = stok; }
}
