package hospital;

import java.util.LinkedList;
import java.util.Queue;

public class EmegencyQueue {

    private Queue<patient> queue = new LinkedList<>();

    // Add patient to queue
    public void enqueue(patient patient) {
        queue.add(patient);
        System.out.println("Patient added to emergency queue.");
    }

    // Remove patient from queue
    public patient dequeue() {

        if (queue.isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return null;
        }

        patient patient = queue.remove();
        System.out.println("Patient removed from emergency queue.");
        return patient;
    }

    // Display waiting patients
    public void displayQueue() {

        if (queue.isEmpty()) {
            System.out.println("No patients are waiting.");
            return;
        }

        System.out.println("===== EMERGENCY QUEUE =====");

        for (patient patient : queue) {
            patient.displayPatient();
        }
    }
}