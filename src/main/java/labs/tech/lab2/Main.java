package labs.tech.lab2;

/**
 * Testing out how they are cloneable, Turning out they are cloneable as freak!
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        double[][] arr = {{1,2,3,4},{3,2,7,6},{9,0,1,4},{1,9,0,4}};
        var matrix1 = new Matrix(4,4, arr);
        var matrix2 = new Matrix(matrix1);
        matrix2.addArithmeticalMeanFromEachElement();
    }
}
