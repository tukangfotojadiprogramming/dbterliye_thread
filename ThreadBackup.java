public class ThreadBackup extends Thread {
    private BukuService service;

    public ThreadBackup(BukuService service) {
        this.service = service;
    }

    @Override
    public void run() {
        while (true) {
            try {
                service.backupData();
                System.out.println("[Backup] Data buku berhasil disalin ke tbl_backup");
                Thread.sleep(30000); // backup tiap 30 detik
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
