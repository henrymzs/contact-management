package models;

public class Contact {
    private String name;
    private String telephone;
    private String email;

    public Contact(String name, String telephone, String email) {
        this.name = name;
        this.telephone = telephone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }


    public void showDetails() {
        System.out.println("Nome: " + name);
        System.out.println("Telefone: " + telephone);
        System.out.println("E-mail: " + email);
    }

}
