public class exp4{
static void analyzeInventory(int[] sectionA, int[] sectionB) {
if (sectionA.length != sectionB.length) {
System.out.println("Both sections must have equal length.");
return;
}

    if (sectionA.length == 0) {
        System.out.println("No Inventory Found");
        return;
    }

    int totalA = 0;
    int totalB = 0;

    for (int i = 0; i < sectionA.length; i++) {
        totalA += sectionA[i];
        totalB += sectionB[i];
    }

    String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

    int highest = sectionA[0];
    String section = "Section A";
    int index = 0;

    for (int i = 0; i < sectionA.length; i++) {
        if (sectionA[i] > highest) {
            highest = sectionA[i];
            section = "Section A";
            index = i;
        }

        if (sectionB[i] > highest) {
            highest = sectionB[i];
            section = "Section B";
            index = i;
        }
    }

    System.out.println("Section A Total: " + totalA
            + " | Section B Total: " + totalB
            + " | Status: " + status
            + " | Highest Quantity: " + highest
            + " (" + section + ", Item " + (index + 1) + ")");
}

public static void main(String[] args) {
    int[] sectionA = {20, 15, 30};
    int[] sectionB = {25, 10, 30};

    analyzeInventory(sectionA, sectionB);
}

}
