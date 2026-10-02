import java.util.*;

abstract class Course {
    String courseCode;
    String courseName;
    int credits;

    Course(String courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }
    abstract double calculateFee();
    abstract void displayCourseDetails();
}
class RegularCourse extends Course {
    RegularCourse(String code, String name, int credits) {
        super(code, name, credits);
    }

    @Override
    double calculateFee() {
        return credits * 5000;
    }

    @Override
    void displayCourseDetails() {
        System.out.println(courseName + " (" + courseCode +
                ") - RegularCourse - Fee: " + calculateFee());
    }
}

class OnlineCourse extends Course {
    OnlineCourse(String code, String name, int credits) {
        super(code, name, credits);
    }

    @Override
    double calculateFee() {
        return credits * 3000;
    }

    @Override
    void displayCourseDetails() {
        System.out.println(courseName + " (" + courseCode +
                ") - OnlineCourse - Fee: " + calculateFee());
    }
}

class CertificateCourse extends Course {
    CertificateCourse(String code, String name, int credits) {
        super(code, name, credits);
    }

    @Override
    double calculateFee() {
        return (credits * 2000) + 1000;
    }

    @Override
    void displayCourseDetails() {
        System.out.println(courseName + " (" + courseCode +
                ") - CertificationCourse - Fee: " + calculateFee());
    }
}

public class Soln4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Course[] courses = new Course[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String code = sc.next();
            String name = sc.next();
            int credits = sc.nextInt();

            if (type.equals("REGULAR")) {
                courses[i] = new RegularCourse(code, name, credits);
            }
            else if (type.equals("ONLINE")) {
                courses[i] = new OnlineCourse(code, name, credits);
            }
            else {
                courses[i] = new CertificateCourse(code, name, credits);
            }
        }

        for (int i = 0; i < n; i++) {
            courses[i].displayCourseDetails();
        }
    }
}