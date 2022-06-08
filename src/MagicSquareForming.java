import java.util.Arrays;

/**
 * Medium difficulty. Nasty one - I solve it by getting all valid
 * 3x3 magic squares, evaluating the absolute cost for each, then
 * returning the lowest.
 */
public class MagicSquareForming {
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
        MagicSquareForming m = new MagicSquareForming();

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

    private int compareSquares(int[] invalidSquare, int[] validSquare) {
        int score = 0;

        for (int i = 0; i < invalidSquare.length; i++) {
            if (getAbsDifference(invalidSquare[i], validSquare[i]) != 0) {
                score += getAbsDifference(invalidSquare[i], validSquare[i]);
            }
        }

        return score;
    }

    private int getAbsDifference(int i, int j) {
        return Math.abs(i - j);
    }
}
