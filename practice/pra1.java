import java.util.Scanner;
import java.util.Random;

public class pra1{


static String playRound(String playerMove, String computerMove) {
    if (playerMove.equals(computerMove)) {
        return "Draw";
    }

    if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
        (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
        (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
        return "Player Wins";
    }

    return "Computer Wins";
}

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    String[] moves = {"Rock", "Paper", "Scissors"};
    String[] playerMoves = new String[5];
    String[] computerMoves = new String[5];
    String[] results = new String[5];

    int wins = 0, losses = 0, draws = 0;

    for (int i = 0; i < 5; i++) {
        System.out.print("Enter your move (Rock/Paper/Scissors): ");
        String playerMove = sc.next().trim();

        if (playerMove.equalsIgnoreCase("Rock")) {
            playerMove = "Rock";
        } else if (playerMove.equalsIgnoreCase("Paper")) {
            playerMove = "Paper";
        } else if (playerMove.equalsIgnoreCase("Scissors")) {
            playerMove = "Scissors";
        } else {
            System.out.println("Invalid move! Try again.");
            i--;
            continue;
        }

        String computerMove = moves[random.nextInt(3)];

        playerMoves[i] = playerMove;
        computerMoves[i] = computerMove;
        results[i] = playRound(playerMove, computerMove);

        if (results[i].equals("Player Wins")) {
            wins++;
        } else if (results[i].equals("Computer Wins")) {
            losses++;
        } else {
            draws++;
        }

        System.out.println("Round " + (i + 1) + ": " + results[i]);
    }

    System.out.println("\n========== FINAL SCOREBOARD ==========");
    System.out.printf("%-10s %-15s %-15s %-15s%n",
            "Round", "Player Move", "Computer Move", "Result");

    for (int i = 0; i < 5; i++) {
        System.out.printf("%-10d %-15s %-15s %-15s%n",
                i + 1, playerMoves[i], computerMoves[i], results[i]);
    }

    double winPercentage = (wins / 5.0) * 100;

    System.out.println("\nWins: " + wins);
    System.out.println("Losses: " + losses);
    System.out.println("Draws: " + draws);
    System.out.printf("Win Percentage: %.1f%%%n", winPercentage);

    sc.close();
}


}
