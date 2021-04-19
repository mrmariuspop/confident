package utcn.ds.carshop.dto;

public class UpdateUserDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String password;
    private long walletAmmount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getWalletAmmount() {
        return walletAmmount;
    }

    public void setWalletAmmount(long walletAmmount) {
        this.walletAmmount = walletAmmount;
    }
}
