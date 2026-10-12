public class exp5{
static void classifyWordLengths(String review) {
int shortCount = 0;
int mediumCount = 0;
int longCount = 0;

    String[] words = review.trim().split("\\s+");

    if (review.trim().isEmpty()) {
        System.out.println("Short: 0 | Medium: 0 | Long: 0");
        return;
    }

    for (String word : words) {
        int length = word.length();

        if (length >= 1 && length <= 4) {
            shortCount++;
        } else if (length >= 5 && length <= 8) {
            mediumCount++;
        } else {
            longCount++;
        }
    }

    System.out.println("Short: " + shortCount
            + " | Medium: " + mediumCount
            + " | Long: " + longCount);
}

public static void main(String[] args) {
    String review = "This movie was absolutely fantastic and thrilling";
    classifyWordLengths(review);
}

}
