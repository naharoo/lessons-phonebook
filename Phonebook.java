import java.io.*;
import java.util.*;
public class Phonebook {

    private static final int INITIAL_CAPACITY = 10;
    
    private final File file = new File("phonebook.txt");
    private Contact[] contacts = new Contact[INITIAL_CAPACITY];
    private int count = 0;

    public Phonebook() throws Exception {

        if (!file.exists()) {
            file.createNewFile();
        }

        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();

            increaseIfNeeded();
            contacts[count++] = new Contact(line);
        }
    }

    public void addContact(Contact contact) throws Exception {
        increaseIfNeeded();
        contacts[count++] = contact;
        writeToFile();
    }

    public void updateContact(int index, Contact contact) throws Exception {
    }

    public void deleteContact(int index) throws Exception {
        for (int i = index; i < count; i++) {
            if (i != count - 1) {
                contacts[i] = contacts[i + 1];
            }
        }
        count--;
        writeToFile();
    }

    public Contact[] getContacts() {
        return contacts;
    }

    public int getCount() {
        return count;
    }

    private void writeToFile() throws Exception {
        FileOutputStream fos = new FileOutputStream(file);

        for (int i = 0; i < count; i++) {
            Contact contact = contacts[i];

            fos.write(contact.toString().getBytes());

            if (i != count - 1) {
                fos.write('\n');
            }
        }
    }

    private void increaseIfNeeded() {
        int currentCapacity = contacts.length;
        if (count == currentCapacity) {
            Contact[] temp = new Contact[currentCapacity * 2];
            for (int i = 0; i < count; i++) {
                temp[i] = contacts[i];
            }
            contacts = temp;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {    
            builder.append(i);
            builder.append(": ");
            builder.append(contacts[i].toString());
            if (i != count - 1) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }
}
