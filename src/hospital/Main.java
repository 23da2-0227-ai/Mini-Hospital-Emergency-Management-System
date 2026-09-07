package hospital;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    // Patient records
    static patient p1 = new patient(
            1005,
            "Nimal Silva",
            42,
            "0712345678",
            "Fever"
    );

    static patient p2 = new patient(
            1001,
            "Kamal Perera",
            35,
            "0771234567",
            "Chest Pain"
    );

    static patient p3 = new patient(
            1010,
            "Saman Perera",
            28,
            "0763456789",
            "Injury"
    );

    // Data structures
    static PatientBST patientBST = new PatientBST();
    static EmegencyQueue emergencyQueue = new EmegencyQueue();
    static TreatmentStack treatmentStack = new TreatmentStack();
    static VisitHistory visitHistory = new VisitHistory();

    public static void main(String[] args) {

        // Insert patients into BST
        patientBST.insert(p1);
        patientBST.insert(p2);
        patientBST.insert(p3);

        int choice;

        do {

            System.out.println();
            System.out.println("========================================");
            System.out.println("   MINI HOSPITAL EMERGENCY MANAGEMENT");
            System.out.println("========================================");
            System.out.println("1. Patient Management");
            System.out.println("2. Emergency Queue");
            System.out.println("3. Treatment History");
            System.out.println("4. Patient Visit History");
            System.out.println("5. Exit");
            System.out.println("========================================");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    patientManagement();
                    break;

                case 2:
                    emergencyQueueManagement();
                    break;

                case 3:
                    treatmentHistoryManagement();
                    break;

                case 4:
                    visitHistoryManagement();
                    break;

                case 5:
                    System.out.println();
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }

    // =========================================
    // PATIENT MANAGEMENT - BST
    // =========================================

    public static void patientManagement() {

        int choice;

        do {

            System.out.println();
            System.out.println("=================================");
            System.out.println("       PATIENT MANAGEMENT");
            System.out.println("=================================");
            System.out.println("1. Display All Patients");
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Back to Main Menu");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.println();
                    System.out.println("===== PATIENT RECORDS =====");
                    patientBST.displayInOrder();
                    break;

                case 2:

                    System.out.print("Enter Patient ID to search: ");
                    int searchId = scanner.nextInt();

                    patient found = patientBST.search(searchId);

                    if (found != null) {
                        System.out.println();
                        System.out.println("Patient found!");
                        found.displayPatient();
                    } else {
                        System.out.println("Patient not found.");
                    }

                    break;

                case 3:

                    System.out.print("Enter Patient ID to delete: ");
                    int deleteId = scanner.nextInt();

                    patientBST.delete(deleteId);
                    break;

                case 4:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);
    }

    // =========================================
    // EMERGENCY QUEUE
    // =========================================

    public static void emergencyQueueManagement() {

        int choice;

        do {

            System.out.println();
            System.out.println("=================================");
            System.out.println("       EMERGENCY QUEUE");
            System.out.println("=================================");
            System.out.println("1. Add Patients to Queue");
            System.out.println("2. Remove Patient");
            System.out.println("3. Display Waiting Patients");
            System.out.println("4. Back to Main Menu");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    emergencyQueue.enqueue(p1);
                    emergencyQueue.enqueue(p2);
                    emergencyQueue.enqueue(p3);

                    break;

                case 2:

                    patient emergencyPatient = emergencyQueue.dequeue();

                    if (emergencyPatient != null) {
                        System.out.println();
                        System.out.println("Removed Patient:");
                        emergencyPatient.displayPatient();
                    }

                    break;

                case 3:

                    emergencyQueue.displayQueue();
                    break;

                case 4:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);
    }

    // =========================================
    // TREATMENT HISTORY - STACK
    // =========================================

    public static void treatmentHistoryManagement() {

        int choice;

        do {

            System.out.println();
            System.out.println("=================================");
            System.out.println("       TREATMENT HISTORY");
            System.out.println("=================================");
            System.out.println("1. Add Treatment");
            System.out.println("2. Remove Latest Treatment");
            System.out.println("3. Display Treatment History");
            System.out.println("4. Back to Main Menu");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    treatmentStack.push(p1);
                    treatmentStack.push(p2);
                    treatmentStack.push(p3);

                    break;

                case 2:

                    patient latestTreatment = treatmentStack.pop();

                    if (latestTreatment != null) {
                        System.out.println();
                        System.out.println("Latest Treatment Removed:");
                        latestTreatment.displayPatient();
                    }

                    break;

                case 3:

                    treatmentStack.displayStack();
                    break;

                case 4:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);
    }

    // =========================================
    // PATIENT VISIT HISTORY - LINKED LIST
    // =========================================

    public static void visitHistoryManagement() {

        int choice;

        do {

            System.out.println();
            System.out.println("=================================");
            System.out.println("      PATIENT VISIT HISTORY");
            System.out.println("=================================");
            System.out.println("1. Add Visit");
            System.out.println("2. Search Visit");
            System.out.println("3. Remove Visit");
            System.out.println("4. Display Visit History");
            System.out.println("5. Back to Main Menu");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    visitHistory.addVisit(
                            1,
                            "2026-09-01",
                            "Dr. Perera",
                            "Fever",
                            "Medication"
                    );

                    break;

                case 2:

                    System.out.print("Enter Visit ID to search: ");
                    int searchVisitId = scanner.nextInt();

                    visitHistory.searchVisit(searchVisitId);
                    break;

                case 3:

                    System.out.print("Enter Visit ID to remove: ");
                    int removeVisitId = scanner.nextInt();

                    visitHistory.removeVisit(removeVisitId);
                    break;

                case 4:

                    visitHistory.displayVisits();
                    break;

                case 5:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }
}