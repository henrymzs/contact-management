package models;

public class ProfessionalContact extends Contact{
    private String enterprise;
    private String jobPosition;

    public ProfessionalContact(String name, String telephone, String email, String enterprise, String jobPosition) {
        super(name, telephone, email);
        this.enterprise = enterprise;
        this.jobPosition = jobPosition;
    }

    public void showDetails() {
        super.showDetails();
        System.out.println("Empresa: " + enterprise);
        System.out.println("Cargo de Trabalho: " + jobPosition);
    }
}
