public class ThreadTampil extends Thread {
    private BukuService service;

    public ThreadTampil(BukuService service) {
        this.service = service;
    }

    @Override
    public void run() {
        try {
            System.out.println("=== Daftar Buku Tere Liye ===");
            for (Buku b : service.getAllBuku()) {
                System.out.println(b);
            }
            System.out.println("==============================\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
