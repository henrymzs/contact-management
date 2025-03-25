# Contact Management System

This project aims to implement a simple contact management system using Java, MySQL, and JDBC. The system allows users to add, search, list, and remove contacts from a MySQL database. It also enables filtered searches by name, phone number, or email.

I am always looking to improve my skills, so any feedback on the project, code, architecture, or best practices is greatly appreciated! If you would like to contribute with suggestions, you can:

- 📧 Send me an email: henrykaua21@gmail.com
- 🔗 Connect with me on [LinkedIn](https://www.linkedin.com/in/henry-kaua/)
- 🐛 Open an [issue](https://github.com/henrymzs/contact-management/issues) in this repository

Any help is highly appreciated and will help me grow as a developer. 🚀

## Features

The system offers the following features:

- **Add Contact**: Adds a personal or professional contact to the list.
- **Remove Contact**: Removes a specific contact from the list by name.
- **Search Contact**: Allows searching for contacts by name, phone number, or email.
- **List Contacts**: Displays all stored contacts with their details.

## Project Structure

### Classes

#### **1. `Contacts` Class**
- Base class for contacts, containing common attributes.

  **Attributes**:
  - `name`: Contact's name.
  - `telephone`: Contact's phone number.
  - `email`: Contact's email.

  **Methods**:
  - `showDetails()`: Displays the basic details of the contact.

#### **2. `PersonalContact` Class**
- Inherits from the `Contacts` class and adds specific attributes for personal contacts.

  **Additional Attributes**:
  - `birthday`: Contact's birthday.
  - `address`: Contact's address.

  **Methods**:
  - `showDetails()`: Overrides the base class method to include personal details.

#### **3. `ProfessionalContact` Class**
- Inherits from the `Contacts` class and adds specific attributes for professional contacts.

  **Additional Attributes**:
  - `enterprise`: Company name.
  - `jobPosition`: Contact's job position in the company.

  **Methods**:
  - `showDetails()`: Overrides the base class method to include professional details.

#### **4. `ContactDAO` Class**
- Manages the contact list and provides methods for data manipulation.

  **Attributes**:
  - `contacts`: List of contact objects.

  **Methods**:
  - `addContacts(contact)`: Adds a contact to the list.
  - `removeContacts(name)`: Removes a contact by name.
  - `searchContacts(searchTerm)`: Searches for a contact by name, phone number, or email.
  - `listContacts()`: Lists all stored contacts.

#### **5. `Main` File**
- The system entry point that presents an interactive menu in the console for the user.

## Usage Example

When running the program, the interactive menu is displayed:

```bash
--- MENU ---
1. Add personal contact:
2. Add professional contact:
3. Remove contact:
4. Search contact:
5. List contacts:
0. Exit
Choose an option: 1
Name: John
Phone number: 12345678
Email: john@email.com
Birthday: 01/01/2000
Address: Street A
```
- Example output:
```bash
Contacts in the address book:
Name: John
Phone number: 12345678
Email: john@email.com
Birthday: 01/01/2000
Address: Street A
-------------------
```

## Technologies Used
- **Java**
- **MySQL**
- **MySQL Workbench** for table management

## Database Configuration

**Database Setup:**
- In MySQL, create the database and the table to store contacts:
    ```sql
    CREATE DATABASE any_name;
    USE created_name;

    CREATE TABLE contacts (
        id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(100),
        phone VARCHAR(20),
        email VARCHAR(100),
        contact_type VARCHAR(20),
        birthday DATE,
        address VARCHAR(255),
        company VARCHAR(100),
        job_position VARCHAR(100)
    );
    ```

## How to Clone the Repository

1. **Install Java**:
  - To install Java on your system, follow the instructions specific to your operating system.

2. **Clone the repository**:
   Clone this repository to your local machine:
   ```bash
   git clone https://github.com/henrymzs/contact-management.git
   ```

