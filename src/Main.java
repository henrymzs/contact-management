import models.Contact;
import models.PersonalContact;
import models.ProfessionalContact;
import services.Agenda;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner read = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Adicionar contato pessoal: ");
            System.out.println("2 - Adicionar contato profissional: ");
            System.out.println("3 - Remover contato: ");
            System.out.println("4 - Buscar contato: ");
            System.out.println("5 - Listar contatos: ");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int option = read.nextInt();
            read.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Nome: ");
                    String namePersonal = read.nextLine();

                    System.out.print("Telefone: ");
                    String telephonePersonal = read.nextLine();


                    System.out.print("Email: ");
                    String emailPersonal = read.nextLine();

                    System.out.print("Data de Aniversário: ");
                    String birthday = read.nextLine();

                    System.out.print("Endereço: ");
                    String address = read.nextLine();

                    PersonalContact personalContact = new PersonalContact(namePersonal, telephonePersonal, emailPersonal, birthday, address);
                    agenda.addContacts(personalContact);
                    break;

                case 2:
                    System.out.print("Nome: ");
                    String nameProfessional = read.nextLine();

                    System.out.print("Telefone: ");
                    String telephoneProfessional = read.nextLine();

                    System.out.print("Email: ");
                    String emailProfessional = read.nextLine();


                    System.out.print("Empresa: ");
                    String enterprise = read.nextLine();

                    System.out.print("Cargo: ");
                    String jobPosition = read.nextLine();

                    ProfessionalContact professionalContact = new ProfessionalContact(nameProfessional, telephoneProfessional, emailProfessional, enterprise, jobPosition);
                    agenda.addContacts(professionalContact);
                    break;

                case 3:
                    System.out.print("Digite o nome do contato que deseja remover: ");
                    String nameRemove = read.nextLine();
                    Contact contactRemove = agenda.removeContacts(nameRemove);

                    if (contactRemove != null) {
                        agenda.removeContacts(nameRemove);
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o nome,email ou telefone do contato que deseja buscar: ");
                    String searchTerm = read.nextLine();
                    Contact contactFound = agenda.searchContacts(searchTerm);
                    if (contactFound != null) {
                        contactFound.showDetails();
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 5:
                    agenda.listContacts();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    return;

                default:
                    System.out.println("Opção inválida. ");
                    break;



            }

        }

    }
}