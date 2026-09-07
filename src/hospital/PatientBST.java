package hospital;

public class PatientBST {
	 private class Node {
	        patient patient;
	        Node left;
	        Node right;

	        Node(patient patient) {
	            this.patient = patient;
	            this.left = null;
	            this.right = null;
	        }
	    }

	    private Node root;

	    // Insert a new patient
	    public void insert(patient patient) {
	        root = insertRecursive(root, patient);
	    }

	    private Node insertRecursive(Node current, patient patient) {

	        if (current == null) {
	            return new Node(patient);
	        }

	        if (patient.getPatientId() < current.patient.getPatientId()) {
	            current.left = insertRecursive(current.left, patient);
	        }
	        else if (patient.getPatientId() > current.patient.getPatientId()) {
	            current.right = insertRecursive(current.right, patient);
	        }
	        else {
	            System.out.println("Patient ID already exists!");
	        }

	        return current;
	    }

	    // Search for a patient
	    public patient search(int patientId) {
	        Node result = searchRecursive(root, patientId);

	        if (result != null) {
	            return result.patient;
	        }

	        return null;
	    }

	    private Node searchRecursive(Node current, int patientId) {

	        if (current == null ||
	            current.patient.getPatientId() == patientId) {
	            return current;
	        }

	        if (patientId < current.patient.getPatientId()) {
	            return searchRecursive(current.left, patientId);
	        }

	        return searchRecursive(current.right, patientId);
	    }

	    // Display patients in ascending Patient ID order
	    public void displayInOrder() {
	        if (root == null) {
	            System.out.println("No patient records found.");
	            return;
	        }

	        inOrder(root);
	    }

	    private void inOrder(Node current) {

	        if (current != null) {

	            inOrder(current.left);

	            current.patient.displayPatient();

	            inOrder(current.right);
	        }
	
	    }
	 // Delete a patient
	    public void delete(int patientId) {
	        root = deleteRecursive(root, patientId);
	    }

	    private Node deleteRecursive(Node current, int patientId) {

	        if (current == null) {
	            System.out.println("Patient not found.");
	            return null;
	        }

	        if (patientId < current.patient.getPatientId()) {
	            current.left = deleteRecursive(current.left, patientId);
	        }
	        else if (patientId > current.patient.getPatientId()) {
	            current.right = deleteRecursive(current.right, patientId);
	        }
	        else {

	            // Case 1: No child
	            if (current.left == null && current.right == null) {
	                System.out.println("Patient deleted successfully.");
	                return null;
	            }

	            // Case 2: Only right child
	            if (current.left == null) {
	                System.out.println("Patient deleted successfully.");
	                return current.right;
	            }

	            // Case 3: Only left child
	            if (current.right == null) {
	                System.out.println("Patient deleted successfully.");
	                return current.left;
	            }

	            // Case 4: Two children
	            Node smallestNode = findSmallest(current.right);
	            current.patient = smallestNode.patient;
	            current.right = deleteRecursive(
	                    current.right,
	                    smallestNode.patient.getPatientId()
	            );
	        }

	        return current;
	    }

	    private Node findSmallest(Node root) {

	        if (root.left == null) {
	            return root;
	        }

	        return findSmallest(root.left);
	    }	    
}
