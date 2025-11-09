public class ThreadUpdateStok extends Thread {
    private BukuService service;
    private String judul;
    private int jumlah;

    public ThreadUpdateStok(BukuService service, String judul, int jumlah) {
        this.service = service;
        this.judul = judul;
        this.jumlah = jumlah;
    }

    @Override
    public synchronized void run() {
        try {
            service.updateStok(judul, jumlah);
            System.out.println("Stok buku '" + judul + "' berkurang " + jumlah);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
