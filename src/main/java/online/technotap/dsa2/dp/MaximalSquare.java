package online.technotap.dsa2.dp;

/**
 * The class contains methods for computing size of square sub-matrices
 */
public class MaximalSquare {

    /**
     * Method that computes the max square sub-matrix size
     *
     * @param matrix the matrix containing either 0 or 1
     * @return maxSize of the square sub-matrix with all 1s
     */
    public int maximalSquare(char[][] matrix) {
        int nRows = matrix.length, nCols = matrix[0].length;
        int result = 0;

        for (int i = 0; i < nRows; i++) {
            int count = 0;
            for (int j = 0; j < nCols; j++) {
                if (matrix[i][j] == '0') {
                    count = matrix[i][j] = 0;
                    continue;
                }
                matrix[i][j] = (char) ++count;
                result = 1;
            }
        }

        for (int j = 0; j < nCols; j++) {
            matrix[0][j] = (char) (matrix[0][j] > 0 ? 1 : 0);
        }

        for (int j = 1; j < nCols; j++) {
            for (int i = 1; i < nRows; i++) {
                if (matrix[i][j] == 0) continue;
                matrix[i][j] = (char) Math.min(matrix[i][j], matrix[i - 1][j] + 1);
                matrix[i][j] = (char) Math.min(matrix[i][j], matrix[i][j - 1] + 1);
                matrix[i][j] = (char) Math.min(matrix[i][j], matrix[i - 1][j - 1] + 1);
                result = Math.max(result, matrix[i][j] * matrix[i][j]);
            }
        }

        return result;
    }
}
