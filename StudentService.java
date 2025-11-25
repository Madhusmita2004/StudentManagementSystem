import java.io.*;
import java.util.*;

public class StudentService {

    private ArrayList<Student> students;

    public StudentService() {
        students = new ArrayList<>();
        loadFromFile();  // Load data at program start
    }

    // Add Student
    public void addStudent(Student s) {
        students.add(s);
        saveToFile();
    }

    // Update Student
    public boolean updateStudent(int id, String name, int age, double marks) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(name);
                s.setAge(age);
                s.setMarks(marks);
                saveToFile();
                return true;
            }
        }
        return false;
    }

    // Delete Student
    public boolean deleteStudent(int id) {
        Iterator<Student> itr = students.iterator();
        while (itr.hasNext()) {
            Student s = itr.next();
            if (s.getId() == id) {
                itr.remove();
                saveToFile();
                return true;
            }
        }
        return false;
    }

    // Search by ID
    public Student searchById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    // Search by Name
    public List<Student> searchByName(String name) {
        List<Student> list = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                list.add(s);
            }
        }
        return list;
    }

    // Display all
    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // -----------------------------------
    // FILE HANDLING
    // -----------------------------------

    // Save data to file
    private void saveToFile() {
        try {
            FileWriter fw = new FileWriter("students.txt");
            for (Student s : students) {
                fw.write(s.getId() + "," + s.getName() + "," + s.getAge() + "," + s.getMarks() + "\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // Load data from file
    private void loadFromFile() {
        try {
            File file = new File("students.txt");
            if (!file.exists()) return;

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                double marks = Double.parseDouble(data[3]);

                students.add(new Student(id, name, age, marks));
            }

            br.close();
        } catch (Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
}
