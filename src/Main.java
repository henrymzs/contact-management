import Database.ContactDAO;
import models.Contact;
import models.PersonalContact;
import models.ProfessionalContact;
import java.util.Scanner;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        ContactDAO contactDAO = new ContactDAO();
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
                    contactDAO.addContacts(personalContact);
                    System.out.println("Contato adicionado com sucesso! ");
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
                    contactDAO.addContacts(professionalContact);
                    System.out.println("Contato adicionado com sucesso! ");

                    break;

                case 3:
                    System.out.println("Por qual critério você deseja remover o contato?");
                    System.out.println("1 - Remover por ID");
                    System.out.println("2 - Remover por nome");
                    System.out.println("3 - Remover por telefone");
                    System.out.println("4 - Remover por email");
                    System.out.print("Escolha uma opção: ");
                    int optionRemove = read.nextInt();
                    read.nextLine();

                    System.out.print("Digite o valor para o critério escolhido: ");
                    String valueRemove = read.nextLine();

                    switch (optionRemove) {
                        case 1:
                            contactDAO.removeContacts("id", valueRemove);
                            break;
                        case 2:
                            contactDAO.removeContacts("nome", valueRemove);
                            break;
                        case 3:
                            contactDAO.removeContacts("telefone", valueRemove);
                            break;
                        case 4:
                            contactDAO.removeContacts("email", valueRemove);
                            break;
                        default:
                            System.out.println("Opção inválida para remoção.");
                    }
                    break;

                case 4:
                    System.out.println("Critérios de Busca:");
                    System.out.println("1 - Nome");
                    System.out.println("2 - Telefone");
                    System.out.println("3 - Email");
                    System.out.print("Escolha um critério: ");

                    int optionValue = read.nextInt();
                    read.nextLine();

                    String criterio = "";
                    switch (optionValue) {
                        case 1: criterio = "nome"; break;
                        case 2: criterio = "telefone"; break;
                        case 3: criterio = "email"; break;
                        default:
                            System.out.println("Critério inválido.");
                            continue;
                    }

                    System.out.print("Digite o valor para o critério escolhido: ");
                    String valueSearch = read.nextLine();


                    List<Contact> contactsFound = contactDAO.searchContact(valueSearch, criterio);

                    if (contactsFound == null || contactsFound.isEmpty()) {
                        System.out.println("Nenhum contato encontrado com o critério fornecido.");
                    } else {
                        System.out.println("Contatos encontrados:");
                        for (Contact contact : contactsFound) {
                            contact.showDetails();
                            System.out.println("--------------------");
                        }
                    }


                case 5:
                    List<Contact> contatos = contactDAO.listContacts();
                    if (contatos.isEmpty()) {
                        System.out.println("Nenhum contato encontrado. ");
                    } else {
                        System.out.println("Lista de Contatos: ");
                    } for (Contact contato : contatos) {
                    contato.showDetails();
                    System.out.println("-----------------");
                }
                    break;


                case 0:
                    System.out.println("Saindo...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        read.close();
    }
}

