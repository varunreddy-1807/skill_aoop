package CollectionsFramework;

import java.util.HashSet;
import java.util.Set;

public class ContactManager {
    private Set<Contact> contacts;

    public ContactManager() {
        contacts = new HashSet<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public void displayContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public boolean contactExists(String name) {
        return contacts.contains(new Contact(name, null, null));
    }
}
