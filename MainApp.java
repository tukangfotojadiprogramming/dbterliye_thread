import java.sql.SQLException;
import java.util.List;

public class MainApp {
    // ANSI warna
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String BOLD = "\u001B[1m";

    public static void garis() {
        System.out.println(CYAN + "============================================================================" + RESET);
    }

    public static void main(String[] args) {
        try {
            BukuService service = new BukuService();

            garis();
            System.out.println(BOLD + BLUE + "📘 SISTEM DATA BUKU TERE LIYE" + RESET);
            garis();


            // === AMBIL SEMUA DATA BUKU ===
            List<Buku> semuaBuku = service.getAllBuku();

            System.out.println(YELLOW + "\n📚 DAFTAR BUKU:" + RESET);
            garis();
            System.out.printf(BOLD + "%-5s %-25s %-15s %-10s %-5s" + RESET + "\n",
                    "ID", "Judul", "Genre", "Harga", "Stok");
            garis();

            if (semuaBuku.isEmpty()) {
                System.out.println(RED + "⚠️ Tidak ada data buku di database." + RESET);
            } else {
                for (Buku b : semuaBuku) {
                    System.out.printf("%-5d %-25s %-15s Rp%-9d %-5d\n",
                            b.getId_buku(),
                            b.getJudul(),
                            b.getGenre(),
                            b.getHarga(),
                            b.getStok());
                }
            }

            garis();
            System.out.println(GREEN + "⏳ Backup sedang diproses..." + RESET);
            service.backupBuku();

        } catch (SQLException e) {
            System.out.println(RED + "❌ Koneksi database gagal: " + e.getMessage() + RESET);
        }
    }
}
