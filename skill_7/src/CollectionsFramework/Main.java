package CollectionsFramework;

public class Main {
    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        ContactDetails contactDetails = new ContactDetails();

        Contact contact1 = new Contact("Alice", "123-456-7890", "alice@example.com");
        Contact contact2 = new Contact("Bob", "987-654-3210", "bob@example.com");

        contactManager.addContact(contact1);
        contactManager.addContact(contact2);
        contactDetails.addContact(contact1);
        contactDetails.addContact(contact2);

        System.out.println("Contacts from ContactManager:");
        contactManager.displayContacts();

        System.out.println("\nContacts from ContactDetails:");
        contactDetails.displayAllContacts();

        System.out.println("\nDoes Alice exist? " + contactManager.contactExists("Alice"));

        System.out.println("\nDetails of Bob: " + contactDetails.getContact("Bob"));
    }
}

