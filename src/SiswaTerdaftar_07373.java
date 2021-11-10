public class SiswaTerdaftar_07373 {
    private SiswaKursus_07373 siswa;
    private int indexKursus;
    private String kodeSiswa;

    public SiswaTerdaftar_07373(SiswaKursus_07373 siswa, int indexKursus, String kodeSiswa) {
        this.siswa = siswa;
        this.indexKursus = indexKursus;
        this.kodeSiswa = kodeSiswa;
    }
    public SiswaKursus_07373 getSiswaKursus() {
        return siswa;
    }
    public void setSiswa(SiswaKursus_07373 siswa) {
        this.siswa = siswa;
    }
    public int getIndexKursus() {
        return indexKursus;
    }
    public void setIndexKursus(int indexKursus) {
        this.indexKursus = indexKursus;
    }
    public String getKodeSiswa() {
        return kodeSiswa;
    }
    public void setKodeSiswa(String kodeSiswa) {
        this.kodeSiswa = kodeSiswa;
    }
}
