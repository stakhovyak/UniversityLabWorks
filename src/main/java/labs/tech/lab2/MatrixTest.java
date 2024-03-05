package labs.tech.lab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixTest {
    @Test
    public void testSubtractArithmeticalMeanFromEachElement() {
        double[][] data = {{1, 2, 3}, {4, 5, 6}};
        Matrix matrix = new Matrix(2, 3, data);
        matrix.subtractArithmeticalMeanFromEachElement();

        double[][] expected = {{-1, 0, 1}, {-1, 0, 1}};
        assertArrayEquals(expected, matrix.getValues());
    }

    @Test
    public void testAddArithmeticalMeanFromEachElement() {
        double[][] data = {{1, 2, 3}, {4, 5, 6}};
        Matrix matrix = new Matrix(2, 3, data);
        matrix.addArithmeticalMeanFromEachElement();

        double[][] expected = {{3, 4, 5}, {9, 10, 11}};
        assertArrayEquals(expected, matrix.getValues());
    }

    @Test
    public void testClone() throws CloneNotSupportedException {
        double[][] data = {{1, 2}, {3, 4}};
        Matrix originalMatrix = new Matrix(2, 2, data);
        Matrix clonedMatrix = originalMatrix.clone();

        assertNotSame(originalMatrix, clonedMatrix);
        assertArrayEquals(originalMatrix.getValues(), clonedMatrix.getValues());
    }
}
