package CollectionsFramework;

import java.util.HashMap;
import java.util.Map;

public class ContactDetails {
    private Map<String, Contact> contactMap;

    public ContactDetails() {
        contactMap = new HashMap<>();
    }

    public void addContact(Contact contact) {
        contactMap.put(contact.getName(), contact);
    }

    public void removeContact(String name) {
        contactMap.remove(name);
    }

    public Contact getContact(String name) {
        return contactMap.get(name);
    }

    public void displayAllContacts() {
        for (Contact contact : contactMap.values()) {
            System.out.println(contact);
        }
    }
}

