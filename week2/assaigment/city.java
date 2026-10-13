import java.util.Scanner;

interface NightService {
    double calculateNightFare(double fare);
}

abstract class Cab {
    static final double MINIMUM_FARE = 100.0;

    abstract double getRate();

    double calculateFare(double km) {
        return Math.max(MINIMUM_FARE, km * getRate());
    }
}

class Mini extends Cab {
    double getRate() {
        return 10.0;
    }
}

class Sedan extends Cab implements NightService {
    double getRate() {
        return 14.0;
    }

    public double calculateNightFare(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {
    double getRate() {
        return 18.0;
    }

    public double calculateNightFare(double fare) {
        return fare * 1.20;
    }
}

public class city{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new Mini();
                    break;
                case "SEDAN":
                    cab = new Sedan();
                    break;
                case "SUV":
                    cab = new SUV();
                    break;
                default:
                    continue;
            }

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.calculateFare(km);

            if (time.equals("NIGHT")) {
                fare = ((NightService) cab).calculateNightFare(fare);
            }

            total += fare;

            System.out.printf("%s: %.2f%n", type, fare);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}