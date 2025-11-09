import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BukuService {
    private Connection conn;

    public BukuService() throws SQLException {
        conn = DatabaseConnection.getConnection();
    }

    // Tambah buku (dengan thread)
    public void tambahBuku(Buku buku) {
        new Thread(() -> {
            String sql = "INSERT INTO tbl_buku (judul, genre, harga, stok) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, buku.getJudul());
                stmt.setString(2, buku.getGenre());
                stmt.setInt(3, buku.getHarga());
                stmt.setInt(4, buku.getStok());
                stmt.executeUpdate();
                System.out.println("✅ Buku berhasil ditambahkan: " + buku.getJudul());
            } catch (SQLException e) {
                System.out.println("❌ Gagal menambah buku: " + e.getMessage());
            }
        }).start();
    }

    // Ambil semua data buku
    public List<Buku> getAllBuku() {
        List<Buku> list = new ArrayList<>();
        String sql = "SELECT * FROM tbl_buku";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Buku(
                        rs.getInt("id_buku"),
                        rs.getString("judul"),
                        rs.getString("genre"),
                        rs.getInt("harga"),
                        rs.getInt("stok")
                ));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error ambil data: " + e.getMessage());
        }
        return list;
    }

    // Backup otomatis ke tabel tbl_backup
    public void backupBuku() {
    new Thread(() -> {
        try (Statement stmt = conn.createStatement()) {
            // Hapus data lama di tabel backup
            stmt.executeUpdate("DELETE FROM tbl_backup");

            // Salin data terbaru dari tbl_buku
            String sql = "INSERT INTO tbl_backup (id_buku, judul, genre, harga, stok) " +
                         "SELECT id_buku, judul, genre, harga, stok FROM tbl_buku";
            int rows = stmt.executeUpdate(sql);

            System.out.println("✅ Backup berhasil! Total data tersalin: " + rows);
        } catch (SQLException e) {
            System.out.println("❌ Gagal melakukan backup: " + e.getMessage());
        }
    }).start();
}


    
}
