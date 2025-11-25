import java.util.ArrayList;
import java.util.Iterator;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    // Add Student
    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added successfully!");
    }

    // Update Student by ID
    public void updateStudent(int id, String newName, int newAge, String newCourse) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(newName);
                s.setAge(newAge);
                s.setCourse(newCourse);
                System.out.println("Student updated!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Delete Student
    public void deleteStudent(int id) {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                System.out.println("Student deleted!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Search by ID
    public void searchById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("Record Found: " + s);
                return;
            }
        }
        System.out.println("No record found!");
    }

    // Search by Name
    public void searchByName(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                System.out.println("Record Found: " + s);
                return;
            }
        }
        System.out.println("No record found!");
    }

    // Display all students
    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No records available!");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
