public class pra3{

static String getBmiStatus(double bmi) {
    if (bmi < 18.5) {
        return "Underweight";
    } else if (bmi < 25.0) {
        return "Normal";
    } else if (bmi < 30.0) {
        return "Overweight";
    } else {
        return "Obese";
    }
}

static void printWellnessReport(double[] heights, double[] weights) {
    if (heights.length != weights.length) {
        System.out.println("Heights and weights must have equal lengths.");
        return;
    }

    System.out.printf("%-10s %-15s %-15s %-10s %-15s%n",
            "Person", "Height (m)", "Weight (kg)", "BMI", "Status");

    for (int i = 0; i < heights.length; i++) {
        if (heights[i] <= 0 || weights[i] < 0) {
            System.out.println("Invalid height or weight for Person " + (i + 1));
            continue;
        }

        double bmi = weights[i] / (heights[i] * heights[i]);
        String status = getBmiStatus(bmi);

        System.out.printf("%-10d %-15.2f %-15.2f %-10.2f %-15s%n",
                i + 1, heights[i], weights[i], bmi, status);
    }
}

public static void main(String[] args) {
    double[] heights = {1.75, 1.60, 1.80, 1.65, 1.70};
    double[] weights = {70, 90, 85, 50, 95};

    printWellnessReport(heights, weights);
}


}
