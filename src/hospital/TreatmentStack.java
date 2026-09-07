package hospital;

import java.util.Stack;

public class TreatmentStack {

    private Stack<patient> stack = new Stack<>();

    // Add treatment
    public void push(patient patient) {
        stack.push(patient);
        System.out.println("Treatment added to history.");
    }

    // Remove latest treatment
    public patient pop() {

        if (stack.isEmpty()) {
            System.out.println("Treatment history is empty.");
            return null;
        }

        patient patient = stack.pop();
        System.out.println("Latest treatment removed.");
        return patient;
    }

    // Display treatment history
    public void displayStack() {

        if (stack.isEmpty()) {
            System.out.println("No treatment history found.");
            return;
        }

        System.out.println("===== TREATMENT HISTORY =====");

        for (patient patient : stack) {
            patient.displayPatient();
        }
    }
}