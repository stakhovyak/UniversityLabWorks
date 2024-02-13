package labs.tech.lab2;
// fff
import java.util.Scanner;
import java.util.function.DoubleBinaryOperator;

/**
 * The class has a method which allows to perform mathematical
 * operations with each element of current matrix and its rows
 * arithmetic mean.
 */
public final class Matrix implements Cloneable{
    private final int length;
    private final int height;
    private final double[][] values;

    /**
     * Regular constructor of the class.
     * @param length The length user wants the matrix to have.
     * @param height The height user wants the matrix to have.
     * @param data Takes two-dimensional array of doubles as a parameter.
     */
    public Matrix(int length, int height, double[][] data) {
        this.length = length;
        this.height = height;
        values = new double[length][height];
        for (var i = 0; i < values.length; i++) {
            System.arraycopy(data[i], 0, values[i], 0, height);
        }
    }

    /**
     * Copy constructor of the Matrix class.
     * @param matrix Takes another matrix as a parameter and makes a shallow copy of immutable matrix
     * @throws CloneNotSupportedException Throws an exception if clone method is not supported
     */
    public Matrix(Matrix matrix) throws CloneNotSupportedException {
        this(matrix.clone().length,
                matrix.clone().height,
                matrix.clone().values);
    }

    /**
     * The clone method of the class.
     * @return returns cloned matrix using clone() method of Object class
     * @throws CloneNotSupportedException Throws an exception if cloning is not supported
     */
    public Matrix clone() throws CloneNotSupportedException {
        return (Matrix) super.clone();
    }

    /**
     * The method subtracts arithmetical mean from each element of row.
     */
    public void subtractArithmeticalMeanFromEachElement() {
        traverse((e, mean) -> e - mean);
    }

    /**
     * The method add arithmetical mean to each element of row
     */
    public void addArithmeticalMeanFromEachElement() {
        traverse((e, mean) -> e + mean);
    }

    /**
     * toString method implementation for Matrix class.
     * @return Returns string of matrix contents.
     */
    public String toString() {
        var sb = new StringBuilder();

        for (var i = 0; i < length; i++) {
            sb.append("\n");
            for (var j = 0; j < height; j++) {
                sb.append(values[i][j]);
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * TODO Better to come up with better name for it.
     * The method traverses each row of the current matrix, calculating
     * rows mean ONCE FOR EACH ROW and applies lambda for each element
     * @param operation A functional interface.
     */
    private void traverse(DoubleBinaryOperator operation) {
        for (int i = 0; i < length; i++) {
            double rowMean = calculateArithmeticMean(values[i]);
            for (int j = 0; j < height; j++) {
                values[i][j] = operation.applyAsDouble(values[i][j], rowMean);
            }
        }
    }

    /**
     * The name speaks for itself.
     * @param row Takes row of matrix as an argument
     * @return Returns mean.
     */
    private double calculateArithmeticMean(double[] row) {
        double sum = 0;
        for (var element : row) {
            sum += element;
        }
        return sum / row.length;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of rows: ");
            int rows = scanner.nextInt();
            System.out.print("Enter the number of columns: ");
            int columns = scanner.nextInt();

            double[][] data = new double[rows][columns];
            System.out.println("Enter the matrix elements:");

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    data[i][j] = scanner.nextDouble();
                }
            }

            var matrix = new Matrix(rows, columns, data);
            System.out.println("\nOriginal Matrix:");
            System.out.println(matrix.toString());

            matrix.subtractArithmeticalMeanFromEachElement();

            System.out.println("\nMatrix after subtracting the arithmetic mean from each element:");
            System.out.println(matrix.toString());
        }
        catch (Exception e) {
            System.out.println("Error: Invalid input.");
        }
    }
}

