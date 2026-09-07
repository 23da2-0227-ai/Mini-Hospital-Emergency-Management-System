package hospital;

public class VisitHistory {

    // Node for Linked List
    private class Node {
        int visitId;
        String date;
        String doctorName;
        String diagnosis;
        String treatment;
        Node next;

        Node(int visitId, String date, String doctorName,
             String diagnosis, String treatment) {

            this.visitId = visitId;
            this.date = date;
            this.doctorName = doctorName;
            this.diagnosis = diagnosis;
            this.treatment = treatment;
            this.next = null;
        }
    }

    private Node head;

    // Add a new visit
    public void addVisit(int visitId, String date,
                         String doctorName, String diagnosis,
                         String treatment) {

        Node newNode = new Node(
                visitId, date, doctorName, diagnosis, treatment
        );

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Visit added successfully.");
    }

    // Display all visits
    public void displayVisits() {

        if (head == null) {
            System.out.println("No visit history found.");
            return;
        }

        System.out.println("===== PATIENT VISIT HISTORY =====");

        Node current = head;

        while (current != null) {

            System.out.println("Visit ID: " + current.visitId);
            System.out.println("Date: " + current.date);
            System.out.println("Doctor: " + current.doctorName);
            System.out.println("Diagnosis: " + current.diagnosis);
            System.out.println("Treatment: " + current.treatment);
            System.out.println("-----------------------------");

            current = current.next;
        }
    }

    // Search for a visit
    public void searchVisit(int visitId) {

        Node current = head;

        while (current != null) {

            if (current.visitId == visitId) {
                System.out.println("Visit found!");
                System.out.println("Visit ID: " + current.visitId);
                System.out.println("Date: " + current.date);
                System.out.println("Doctor: " + current.doctorName);
                System.out.println("Diagnosis: " + current.diagnosis);
                System.out.println("Treatment: " + current.treatment);
                return;
            }

            current = current.next;
        }

        System.out.println("Visit not found.");
    }

    // Remove a visit
    public void removeVisit(int visitId) {

        if (head == null) {
            System.out.println("Visit history is empty.");
            return;
        }

        if (head.visitId == visitId) {
            head = head.next;
            System.out.println("Visit removed successfully.");
            return;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.visitId == visitId) {
                current.next = current.next.next;
                System.out.println("Visit removed successfully.");
                return;
            }

            current = current.next;
        }

        System.out.println("Visit not found.");
    }
}