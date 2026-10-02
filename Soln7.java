import java.util.*;
class Person {
    String name;
    String id;
    int age;
    Person(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }
    void displayDetails() {
        System.out.println("Person: " + name + ", ID: " + id + ", Age: " + age);
    }
}

class Student extends Person {
    Student(String name, String id, int age) {
        super(name, id, age);
    }
    @Override
    void displayDetails() {
        System.out.println("Student: " + name + ", ID: " + id + ", Age: " + age);
    }
}
class EngineeringStudent extends Student {
    String branch;
        EngineeringStudent(String name, String id, int age, String branch) {
        super(name, id, age);
        this.branch = branch;
    }
    @Override
    void displayDetails() {
        System.out.println("Engineering Student: " + name + ", ID: " + id +
                ", Age: " + age + ", Branch: " + branch);
    }
}
class CSEStudent extends EngineeringStudent {
    String specialization;
    CSEStudent(String name, String id, int age, String specialization) {
        super(name, id, age, "CSE");
        this.specialization = specialization;
    }
    @Override
    void displayDetails() {
        System.out.println("CSE Student: " + name + ", ID: " + id +
                ", Age: " + age + ", Specialization: " + specialization);
    }
}

public class Soln7{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            if (type.equals("STUDENT")) {
                String id = sc.next();
                String name = sc.next();
                int age = sc.nextInt();
                    people[i] = new Student(name, id, age);
            }
            else if (type.equals("ENGINEERING")) {
                String id = sc.next();
                String name = sc.next();
                int age = sc.nextInt();
                String branch = sc.next();
                people[i] = new EngineeringStudent(name, id, age, branch);
            }
            else {
                String id = sc.next();
                String name = sc.next();
                int age = sc.nextInt();
                String specialization = sc.next();
                people[i] = new CSEStudent(name, id, age, specialization);
            }
        }

        Person p = new CSEStudent("Test", "T101", 20, "Java");
        for (int i = 0; i < n; i++) {
            people[i].displayDetails();
        }
    }
}