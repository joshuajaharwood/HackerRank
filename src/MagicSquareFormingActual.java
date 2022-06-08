import java.util.Arrays;

/**
 * Local version for debugging - input is hardcoded.
 *
 * Medium difficulty. Nasty one - I solve it by getting all valid
 * 3x3 magic squares, evaluating the absolute cost for each, then
 * returning the lowest.
 */
public class MagicSquareFormingLocal {
    int[][] validSquares = {
            {4, 9, 2, 3, 5, 7, 8, 1, 6},
            {4, 3, 8, 9, 5, 1, 2, 7, 6},
            {2, 9, 4, 7, 5, 3, 6, 1, 8},
            {2, 7, 6, 9, 5, 1, 4, 3, 8},
            {8, 1, 6, 3, 5, 7, 4, 9, 2},
            {8, 3, 4, 1, 5, 9, 6, 7, 2},
            {6, 7, 2, 1, 5, 9, 8, 3, 4},
            {6, 1, 8, 7, 5, 3, 2, 9, 4},
    };

    int[][] invalidSquares = {
            {4, 9, 2, 3, 5, 7, 8, 1, 5},
            {4, 8, 2, 4, 5, 7, 6, 1, 6}
    };

    int[] scores = new int[validSquares.length];

    public static void main(String[] args) {
        MagicSquareFormingLocal m = new MagicSquareFormingLocal();

        m.solveMultipleSquares();
    }

    public void solveMultipleSquares() {
        for (int[] invalidSquare : invalidSquares) {
            System.out.println(solveSquare(invalidSquare));
        }
    }

    public int solveSquare(int[] invalidSquare) {
        for (int i = 0; i < validSquares.length; i++) {
            scores[i] = compareSquares(invalidSquare, validSquares[i]);
        }

        Arrays.sort(scores);

        return scores[0];
    }

    private static int compareSquares(int[] invalidSquare, int[] validSquare) {
        int score = 0;

        for (int i = 0; i < invalidSquare.length; i++) {
            int difference = Math.abs(invalidSquare[i] - validSquare[i]);
            if (difference != 0) {
                score += difference;
            }
        }

        return score;
    }
}
