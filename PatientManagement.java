import java.util.ArrayList;
import java.util.Scanner;

interface method{
    void displayUserInfo();
}

// Abstract class representing a general user in the system
abstract class User implements method{
    private String id;
    private String name;
    private String gender;

    public User(String id, String name, String gender) {  // parametarised constructor
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Abstract method to be implemented by subclasses for displaying info
    //public abstract void displayUserInfo();
}

// Base class for Patient Management System
class Person extends User {
    private int age;

    public Person(String id, String name, String gender, int age) {
        super(id, name, gender);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void displayUserInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Gender: " + getGender());
        System.out.println("Age: " + age);
    }
}

// Derived class representing Patient
class Patient extends Person {
    private String date;
    private String disease;
    private String doctorName;

    public Patient(String patientID, String name, String gender, int age, String date, String disease, String doctorName) {
        super(patientID, name, gender, age);
        this.date = date;
        this.disease = disease;
        this.doctorName = doctorName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    // Override to display patient-specific information
    @Override
    public void displayUserInfo() {
        super.displayUserInfo();
        System.out.println("Date: " + date);
        System.out.println("Disease: " + disease);
        System.out.println("Doctor: " + doctorName);
        System.out.println("-----------------------------------");
    }
}

// Main class for managing patients
public class PatientManagement {
    private ArrayList<Patient> patientList = new ArrayList<>();   // signifies array list

    // Method to insert a patient
    public void insertPatient(String patientID, String name, String gender, int age, String date, String disease, String doctorName) {
        Patient patient = new Patient(patientID, name, gender, age, date, disease, doctorName);
        patientList.add(patient);
        System.out.println("Patient added successfully!");
    }

    // Method to update a patient by patient ID
    public void updatePatient(String patientID) {
        for (Patient patient : patientList) {
            if (patient.getId().equals(patientID)) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter new Name: ");
                patient.setName(sc.nextLine());
                System.out.println("Enter new Gender: ");
                patient.setGender(sc.nextLine());
                System.out.println("Enter new Age: ");
                patient.setAge(sc.nextInt());
                sc.nextLine(); // Consume newline
                System.out.println("Enter new Date: ");
                patient.setDate(sc.nextLine());
                System.out.println("Enter new Disease: ");
                patient.setDisease(sc.nextLine());
                System.out.println("Enter new Doctor Name: ");
                patient.setDoctorName(sc.nextLine());
                System.out.println("Patient details updated successfully!");
                return;
            }
        }
        System.out.println("Patient with ID " + patientID + " not found.");
    }

    // Method to delete a patient by patient ID
    public void deletePatient(String patientID) {
        for (Patient patient : patientList) {
            if (patient.getId().equals(patientID)) {
                patientList.remove(patient);
                System.out.println("Patient deleted successfully!");
                return;
            }
        }
        System.out.println("Patient with ID " + patientID + " not found.");
    }

    // Method to display all patients
    public void displayPatients() {
        if (patientList.isEmpty()) {
            System.out.println("No patients to display.");
        } else {
            for (Patient patient : patientList) {
                patient.displayUserInfo();
            }
        }
    }

    // Method to manage user choices
    public void managePatients() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Patient Management System:");
            System.out.println("1. Insert Patient");
            System.out.println("2. Update Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display Patients");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter Patient ID: ");
                    String patientID = sc.nextLine();
                    System.out.println("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Gender: ");
                    String gender = sc.nextLine();
                    System.out.println("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.println("Enter Date: ");
                    String date = sc.nextLine();
                    System.out.println("Enter Disease: ");
                    String disease = sc.nextLine();
                    System.out.println("Enter Doctor Name: ");
                    String doctorName = sc.nextLine();
                    insertPatient(patientID, name, gender, age, date, disease, doctorName);
                    break;
                case 2:
                    System.out.println("Enter Patient ID to update: ");
                    String updateID = sc.nextLine();
                    updatePatient(updateID);
                    break;
                case 3:
                    System.out.println("Enter Patient ID to delete: ");
                    String deleteID = sc.nextLine();
                    deletePatient(deleteID);
                    break;
                case 4:
                    displayPatients();
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        PatientManagement pm = new PatientManagement();
        pm.managePatients();
    }
}