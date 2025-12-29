import java.util.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter marks: ");
            int marks = sc.nextInt();
            sc.nextLine();
            students.add(new Student(name, marks));
        }

        students.sort((s1, s2) -> s2.marks - s1.marks);

        Map<String, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < students.size(); i++) {
            if (i > 0 && students.get(i).marks < students.get(i - 1).marks) {
                rank = i + 1;
            }
            rankMap.put(students.get(i).name, rank);
        }

        System.out.println("\nStudent Rankings:");
        for (Student s : students) {
            System.out.println("Name: " + s.name + ", Marks: " + s.marks + ", Rank: " + rankMap.get(s.name));
        }

        System.out.print("\nEnter the name of the student to find their rank: ");
        String searchName = sc.nextLine();
        if (rankMap.containsKey(searchName)) {
            System.out.println(searchName + "'s rank is: " + rankMap.get(searchName));
        } else {
            System.out.println("Student not found.");
        }

        sc.close();
    }
}
