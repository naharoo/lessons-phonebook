import java.io.*;
import java.util.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Contact {

    private String name;
    private String phoneNumber;

    public Contact(String line) {
        this(line.split(" - ")[0], line.split(" - ")[1]);
    }

    public Contact(String name, String phoneNumber) {
        setName(name);
        setPhoneNumber(phoneNumber);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", getName(), getPhoneNumber());
    }
}