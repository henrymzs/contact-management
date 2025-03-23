package services;

import models.Contact;

import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contact> contacts;

    public Agenda() {
        contacts = new ArrayList<>();
    }

    public void addContacts(Contact contact){
        contacts.add(contact);
        System.out.println(contact.getName() + " Foi adicionado a sua lista de contatos");
    }

    public Contact removeContacts(String name) {
        Contact contactRemove = null;

        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contactRemove = contact;
                break;
            }
        }

        if (contactRemove != null) {
            contacts.remove(contactRemove);
            System.out.println(name + " Foi removido da sua lista de contatos.");
        } else {
            System.out.println("Contato não encontrado.");
        }
        return contactRemove;
    }

    public Contact searchContacts(String searchTerm) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(searchTerm) ||
                contact.getTelephone().equals(searchTerm) ||
                contact.getEmail().equalsIgnoreCase(searchTerm)) {
                System.out.println("---------------");
                System.out.println("Contato Encontrado:");
                return contact;
            }
        }
        return null;
    }

    public void listContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Agenda está vazia.");
        } else {
            System.out.println("Contatos na agenda:");

            for (Contact contact : contacts) {
                contact.showDetails();
                System.out.println("---------------");
            }
        }
    }
}
