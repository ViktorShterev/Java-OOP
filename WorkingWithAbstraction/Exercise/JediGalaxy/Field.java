package WorkingWithAbstraction.Exercise.JediGalaxy;

public class Field {
    private int[][] matrix;

    public Field(int rows, int cols) {
        this(rows, cols, 0);
    }

    public Field(int rows, int cols, int beginValue) {
        this.matrix = new int[rows][cols];
        this.fillValues(beginValue);
    }

    private void fillValues(int beginValue) {
        for (int row = 0; row < this.matrix.length; row++) {
            for (int col = 0; col < this.matrix[row].length; col++) {
                this.matrix[row][col] = beginValue++;
            }
        }
    }
    public boolean isInBounds(int row, int col) {
        return row >= 0 && row < this.matrix.length && col >= 0 && col < this.matrix[row].length;
    }
    public void setValue(int row, int col, int newValue) {
        this.matrix[row][col] = newValue;
    }
    public int getValue(int row, int col) {
        return this.matrix[row][col];
    }
    public int getColLength(int row) {
        return this.matrix[row].length;
    }
}
