public class Admin_07373 extends Biodata_07373{
    private String password;

    public Admin_07373(String password, String nama, String noTelp, String alamat) {
        super(nama, noTelp, alamat);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
