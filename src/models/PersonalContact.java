package models;

public class PersonalContact extends Contact{
    private String birthday;
    private String address;


    public PersonalContact(String name, String telephone, String email, String birthday, String address) {
        super(name, telephone, email);
        this.birthday = birthday;
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public void showDetails() {
        super.showDetails();
        System.out.println("Data de Aniversário: " + birthday);
        System.out.println("Endereço: " + address);
    }
}
