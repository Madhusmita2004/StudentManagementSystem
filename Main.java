import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search by ID");
            System.out.println("5. Search by Name");
            System.out.println("6. Display All Students");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    service.addStudent(new Student(id, name, age, marks));
                    System.out.println("Student Added.");
                    break;

                case 2:
                    System.out.print("Enter ID to Update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String uname = sc.nextLine();

                    System.out.print("Enter New Age: ");
                    int uage = sc.nextInt();

                    System.out.print("Enter New Marks: ");
                    double umarks = sc.nextDouble();

                    if (service.updateStudent(uid, uname, uage, umarks))
                        System.out.println("Student Updated.");
                    else
                        System.out.println("Student Not Found.");
                    break;

                case 3:
                    System.out.print("Enter ID to Delete: ");
                    int did = sc.nextInt();
                    if (service.deleteStudent(did))
                        System.out.println("Student Deleted.");
                    else
                        System.out.println("Student Not Found.");
                    break;

                case 4:
                    System.out.print("Enter ID to Search: ");
                    int sid = sc.nextInt();
                    Student s = service.searchById(sid);
                    if (s != null)
                        System.out.println(s);
                    else
                        System.out.println("No Student Found.");
                    break;

                case 5:
                    System.out.print("Enter Name: ");
                    sc.nextLine();
                    String sname = sc.nextLine();
                    List<Student> list = service.searchByName(sname);
                    if (list.isEmpty())
                        System.out.println("No Student Found.");
                    else
                        list.forEach(System.out::println);
                    break;

                case 6:
                    service.displayAll();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
