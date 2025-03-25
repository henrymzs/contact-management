package Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import models.Contact;
import models.PersonalContact;
import models.ProfessionalContact;

public class ContactDAO {
    public void addContacts(Contact contact) {
        String sql = "INSERT INTO contatos (nome, telefone, email, tipo_contato, data_aniversario, endereco, empresa, cargo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getTelephone());
            stmt.setString(3, contact.getEmail());
            stmt.setString(4, contact instanceof PersonalContact ? "Pessoal" : "Profissional");

            if (contact instanceof PersonalContact) {
                PersonalContact personalContact = (PersonalContact) contact;
                stmt.setString(5, personalContact.getBirthday());
                stmt.setString(6, personalContact.getAddress());
                stmt.setNull(7, java.sql.Types.VARCHAR);
                stmt.setNull(8, java.sql.Types.VARCHAR);

            } else if (contact instanceof ProfessionalContact) {
                ProfessionalContact professionalContact = (ProfessionalContact) contact;
                stmt.setNull(5, java.sql.Types.VARCHAR);
                stmt.setNull(6, java.sql.Types.VARCHAR);
                stmt.setString(7, professionalContact.getEnterprise());
                stmt.setString(8, professionalContact.getJobPosition());
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeContacts(String criterio, String value) {
        String sql = "";

        if (criterio.equalsIgnoreCase("id")) {
            sql = "DELETE FROM contatos WHERE id = ?";
        } else if (criterio.equalsIgnoreCase("nome")) {
            sql = "DELETE FROM contatos WHERE nome = ?";
        } else if (criterio.equalsIgnoreCase("telefone")) {
            sql = "DELETE FROM contatos WHERE telefone = ?";
        } else if (criterio.equalsIgnoreCase("email")) {
            sql = "DELETE FROM contatos WHERE email = ?";
        } else {
            System.out.println("Critério inválido.");
            return;
        }

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, value);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Contato removido com sucesso!");
            } else {
                System.out.println("Nenhum contato encontrado para o critério: " + criterio + " = " + value);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Contact> searchContact(String valueSearch, String criterio) {
        List<Contact> contactsFound = new ArrayList<>();
        String sql = "";

        switch (criterio.toLowerCase()) {
            case "nome":
                sql = "SELECT * FROM contatos WHERE nome LIKE ?";
                break;
            case "telefone":
                sql = "SELECT * FROM contatos WHERE telefone LIKE ?";
                break;
            case "email":
                sql = "SELECT * FROM contatos WHERE email LIKE ?";
                break;
            default:
                System.out.println("Critério inválido.");
                return null;
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + valueSearch + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Contact contact = null;
                String tipeContact = rs.getString("tipo_contato");

                if (tipeContact.equalsIgnoreCase("Pessoal")) {
                    Date dataAniversario = rs.getDate("data_aniversario");
                    String dataAniversarioStr = dataAniversario != null ? dataAniversario.toString() : null;

                    contact = new PersonalContact(
                            rs.getString("nome"),
                            rs.getString("telefone"),
                            rs.getString("email"),
                            dataAniversarioStr,
                            rs.getString("endereco")
                    );
                } else if (tipeContact.equalsIgnoreCase("Profissional")) {
                    contact = new ProfessionalContact(
                            rs.getString("nome"),
                            rs.getString("telefone"),
                            rs.getString("email"),
                            rs.getString("empresa"),
                            rs.getString("cargo")
                    );
                }

                if (contact != null) {
                    contactsFound.add(contact);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contactsFound;
    }

    public List<Contact> listContacts() {
        List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT * FROM contatos";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Contact contact = null;
                String typeContact = rs.getString("tipo_contato");

                if (typeContact.equalsIgnoreCase("Pessoal")) {
                    Date dataAniversario = rs.getDate("data_aniversario");
                    String dataAniversarioStr = dataAniversario != null ? dataAniversario.toString() : null;

                    contact = new PersonalContact(
                            rs.getString("nome"),
                            rs.getString("telefone"),
                            rs.getString("email"),
                            dataAniversarioStr,
                            rs.getString("endereco")
                    );
                } else if (typeContact.equalsIgnoreCase("Profissional")) {
                    contact = new ProfessionalContact(
                            rs.getString("nome"),
                            rs.getString("telefone"),
                            rs.getString("email"),
                            rs.getString("empresa"),
                            rs.getString("cargo")
                    );
                }

                if (contact != null) {
                    contacts.add(contact);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao acessar o banco de dados: " + e.getMessage());
            e.printStackTrace();
        }

        return contacts;
    }
}
