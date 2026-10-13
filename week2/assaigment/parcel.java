import java.util.Scanner;

interface Insurable {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    double weight;

    Parcel(double weight) {
        this.weight = weight;
    }

    abstract double calculateCharge();

    double calculateInsurance(double declaredValue) {
        return 0.0;
    }
}

class StandardParcel extends Parcel {
    StandardParcel(double weight) {
        super(weight);
    }

    double calculateCharge() {
        return 40 + 10 * weight;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight) {
        super(weight);
    }

    double calculateCharge() {
        return 80 + 15 * weight;
    }

    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weight) {
        super(weight);
    }

    double calculateCharge() {
        return 40 + 10 * weight + 50;
    }

    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }
}

public class parcel{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            Parcel parcel;

            switch (type) {
                case "STANDARD":
                    parcel = new StandardParcel(weight);
                    break;
                case "EXPRESS":
                    parcel = new ExpressParcel(weight);
                    break;
                case "FRAGILE":
                    parcel = new FragileParcel(weight);
                    break;
                default:
                    continue;
            }

            double charge = parcel.calculateCharge();
            double insurance = 0.0;

            if (parcel instanceof Insurable) {
                insurance = ((Insurable) parcel)
                        .calculateInsurance(declaredValue);
            }

            double total = charge + insurance;
            grandTotal += total;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}