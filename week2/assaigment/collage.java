import java.util.Scanner;

abstract class Student {
    String name;

    static final double TRANSPORT_FEE = 12000.0;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateTuition();

    abstract boolean usesBus();

    double calculateTotalFee() {
        return calculateTuition()
                + (usesBus() ? TRANSPORT_FEE : 0.0);
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000.0;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000.0 + 60000.0;
    }

    boolean usesBus() {
        return false;
    }
}

class Scholar extends Student {
    Scholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 20000.0;
    }

    boolean usesBus() {
        return true;
    }
}

public class collage{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();

            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new Scholar(name);
                    break;
                default:
                    continue;
            }

            double fee = student.calculateTotalFee();
            totalCollected += fee;

            System.out.printf("%s: %.2f%n", name, fee);
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}