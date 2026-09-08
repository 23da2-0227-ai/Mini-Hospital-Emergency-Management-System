# Mini Hospital Emergency Management System

## Project Description

The Mini Hospital Emergency Management System is a Java-based application
developed to manage patient records, emergency patients, treatment history,
and patient visit history using different data structures.

## Data Structures Used

### 1. Binary Search Tree (BST)
Used to store and manage patient records using Patient ID as the key.

Operations:
- Insert patient records
- Search patients
- Delete patients
- Display patients using in-order traversal

### 2. Queue
Used to manage emergency patients using the FIFO
(First In, First Out) principle.

Operations:
- Enqueue patients
- Dequeue patients
- Display waiting patients
- Handle empty queue

### 3. Stack
Used to manage treatment history using the LIFO
(Last In, First Out) principle.

Operations:
- Push treatment records
- Pop latest treatment
- Display treatment history
- Handle empty stack

### 4. Singly Linked List
Used to manage patient visit history.

Operations:
- Add visit
- Search visit
- Remove visit
- Display visit history

## Patient Information

The system stores:
- Patient ID
- Patient Name
- Age
- Contact Number
- Medical Condition

## Technologies Used

- Java
- Eclipse IDE
- Git
- GitHub

## Project Structure

- `Main.java` - Main menu and system integration
- `Patient.java` - Patient information
- `PatientBST.java` - Binary Search Tree implementation
- `EmergencyQueue.java` - Emergency Queue implementation
- `TreatmentStack.java` - Treatment Stack implementation
- `VisitHistory.java` - Singly Linked List implementation

## How to Run

1. Open the project in Eclipse.
2. Open `Main.java`.
3. Right-click `Main.java`.
4. Select **Run As → Java Application**.
5. Use the main menu to test the system.

## Testing

The system was tested for:
- Patient searching
- Patient deletion
- Queue enqueue and dequeue
- Stack push and pop
- Visit history add, search and remove
- Empty queue and stack handling

## Author

23da2-0227-ai

## Repository

GitHub:
https://github.com/23da2-0227-ai/Mini-Hospital-Emergency-Management-System