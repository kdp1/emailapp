package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 10;
    private String email;
    private String department;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "kdp1company.com";
    
    // Constructor to receive first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.firstName + " " 
                + this.lastName);
        
        // Call a method asking for the deparment - return the deparment
        this.department = setDepartment();
        
        
        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);
        
        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" +
                department + "." + companySuffix;
        System.out.println("Your email is: " + email);
    }
    
    // Ask for the department
    private String setDepartment() {
        System.out.println("New worker " + firstName + ". DEPARTMENT CODES\n1 for Sales\n"
                + "2 for Development\n3 for Account\n0 for none\nEnter department code:");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        switch (departmentChoice) {
            case 1:
                return "sales";
            case 2:
                return "dev";
            case 3:
                return "acct";
            default:
                return "";
        }
    }           
    
    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVXYZ0123456789!@#$%^&*";
        char[] password = new char[length];
        for(int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    
    // Set the mailbox capacity
    public void setMailBoxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }
    
    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
    
    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }
    
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }
    
    public String getAlternateEmail() {
        return alternateEmail;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName + "\n" 
                + "COMPANY EMAIL: " + email + "\n" 
                + "MAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
