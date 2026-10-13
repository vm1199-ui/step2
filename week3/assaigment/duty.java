import java.util.Arrays;

public class duty{

public static String[] rotateRoster(String[] names, int k) {
    int n = names.length;
    k = k % n;

    String[] rotated = new String[n];

    for (int i = 0; i < n; i++) {
        rotated[(i + k) % n] = names[i];
    }

    return rotated;
}

public static void main(String[] args) {
    String[] names = {"A", "B", "C", "D", "E"};
    int k = 2;

    String[] result = rotateRoster(names, k);

    System.out.println(Arrays.toString(result));
}

}
