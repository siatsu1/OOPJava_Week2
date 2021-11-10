public class SiswaKursus_07373 extends Biodata_07373 {
    private String umur;

    public SiswaKursus_07373(String umur, String nama, String noTelp, String alamat) {
        super(nama, noTelp, alamat);
        this.umur = umur;
    }
    public String getUmur() {
        return umur;
    }
    public void setUmur(String umur) {
        this.umur = umur;
    }
}
