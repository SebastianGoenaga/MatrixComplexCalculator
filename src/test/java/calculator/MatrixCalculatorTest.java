package calculator;

import model.Complex;
import model.ComplexMatrix;
import model.ComplexVector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixCalculatorTest {

    @Test
    void testSumVectors(){

        //TestCase
        ComplexVector v1 = new ComplexVector(2);
        ComplexVector v2 = new ComplexVector(2);

        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(4, 2);
        Complex c3 = new Complex(7, 1);
        Complex c4 = new Complex(-1, 6);

        v1.addToMatrix(0, c1);
        v1.addToMatrix(1, c2);

        v2.addToMatrix(0, c3);
        v2.addToMatrix(1, c4);

        ComplexMatrix answer = MatrixCalculator.matrixSum(v1,v2);
        ComplexMatrix answerExpected = new ComplexMatrix(2, 1);
        answerExpected.addToMatrix(0, 0, new Complex(10,5));
        answerExpected.addToMatrix(1, 0, new Complex(3,8));

        assertEquals(answerExpected, answer);
    }

    @Test
    void inverseVector(){

        //TestCase
        ComplexVector v1 = new ComplexVector(2);

        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(4, 2);

        v1.addToMatrix(0, c1);
        v1.addToMatrix(1, c2);

        ComplexMatrix answer = MatrixCalculator.negation(v1);
        ComplexMatrix answerExpected = new ComplexMatrix(2, 1);
        answerExpected.addToMatrix(0, 0, new Complex(-3,-4));
        answerExpected.addToMatrix(1, 0, new Complex(-4,-2));

        assertEquals(answerExpected, answer);

    }

    @Test
    void vectorScalarMultiplication() {

        //TestCase
        ComplexVector v1 = new ComplexVector(2);

        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(4, 2);
        Complex c3 = new Complex(2, 0);

        v1.addToMatrix(0, c1);
        v1.addToMatrix(1, c2);

        ComplexMatrix answer = MatrixCalculator.scalarMultiplication(c3, v1);
        ComplexMatrix answerExpected = new ComplexMatrix(2, 1);
        answerExpected.addToMatrix(0, 0, new Complex(6,8));
        answerExpected.addToMatrix(1, 0, new Complex(8,4));

        assertEquals(answerExpected, answer);

    }

    @Test
    void matrixSum() {

        //TestCase
        ComplexMatrix m1 = new ComplexMatrix(2, 2);
        ComplexMatrix m2 = new ComplexMatrix(2, 2);

        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(4, 2);
        Complex c3 = new Complex(7, 1);
        Complex c4 = new Complex(-1, 6);
        Complex c5 = new Complex(5, -1);
        Complex c6 = new Complex(2, 3);
        Complex c7 = new Complex(-3, 4);
        Complex c8 = new Complex(8, -5);

        m1.addToMatrix(0, 0, c1);
        m1.addToMatrix(0, 1, c2);
        m1.addToMatrix(1, 0, c3);
        m1.addToMatrix(1, 1, c4);

        m2.addToMatrix(0, 0, c5);
        m2.addToMatrix(0, 1, c6);
        m2.addToMatrix(1, 0, c7);
        m2.addToMatrix(1, 1, c8);

        ComplexMatrix answer = MatrixCalculator.matrixSum(m1, m2);
        ComplexMatrix answerExpected = new ComplexMatrix(2, 2);
        answerExpected.addToMatrix(0, 0, new Complex(8,3));
        answerExpected.addToMatrix(0, 1, new Complex(6,5));
        answerExpected.addToMatrix(1, 0, new Complex(4,5));
        answerExpected.addToMatrix(1, 1, new Complex(7,1));

        assertEquals(answerExpected, answer);

    }

    @Test
    void negation() {
        //TestCase
        ComplexMatrix m1 = new ComplexMatrix(2, 2);

        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(4, 2);
        Complex c3 = new Complex(1, -5);
        Complex c4 = new Complex(-2, 6);

        m1.addToMatrix(0, 0, c1);
        m1.addToMatrix(0, 1, c2);
        m1.addToMatrix(1, 0, c3);
        m1.addToMatrix(1, 1, c4);

        ComplexMatrix answer = MatrixCalculator.negation(m1);
        ComplexMatrix answerExpected = new ComplexMatrix(2, 2);
        answerExpected.addToMatrix(0, 0, new Complex(-3,-4));
        answerExpected.addToMatrix(0, 1, new Complex(-4,-2));
        answerExpected.addToMatrix(1, 0, new Complex(-1,5));
        answerExpected.addToMatrix(1, 1, new Complex(2,-6));

        assertEquals(answerExpected, answer);
    }

    @Test
    void scalarMultiplication() {

        //TestCase
        ComplexMatrix m1 = new ComplexMatrix(2, 2);

        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(4, 2);
        Complex c3 = new Complex(7, 1);
        Complex c4 = new Complex(-1, 6);
        Complex c5 = new Complex(2, 0);

        m1.addToMatrix(0, 0, c1);
        m1.addToMatrix(0, 1, c2);
        m1.addToMatrix(1, 0, c3);
        m1.addToMatrix(1, 1, c4);

        ComplexMatrix answer = MatrixCalculator.scalarMultiplication(c5, m1);
        ComplexMatrix answerExpected = new ComplexMatrix(2, 2);
        answerExpected.addToMatrix(0, 0, new Complex(6,8));
        answerExpected.addToMatrix(0, 1, new Complex(8,4));
        answerExpected.addToMatrix(1, 0, new Complex(14,2));
        answerExpected.addToMatrix(1, 1, new Complex(-2,12));

        assertEquals(answerExpected, answer);

    }

    @Test
    void transposedMatrix() {

        //TestCase
        ComplexMatrix m1 = new ComplexMatrix(2, 2);

        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(4, 2);
        Complex c3 = new Complex(7, 1);
        Complex c4 = new Complex(-1, 6);

        m1.addToMatrix(0, 0, c1);
        m1.addToMatrix(0, 1, c2);
        m1.addToMatrix(1, 0, c3);
        m1.addToMatrix(1, 1, c4);

        ComplexMatrix answer = MatrixCalculator.transposedMatrix(m1);
        ComplexMatrix answerExpected = new ComplexMatrix(2, 2);
        answerExpected.addToMatrix(0, 0, new Complex(3,4));
        answerExpected.addToMatrix(0, 1, new Complex(7,1));
        answerExpected.addToMatrix(1, 0, new Complex(4,2));
        answerExpected.addToMatrix(1, 1, new Complex(-1,6));

        assertEquals(answerExpected, answer);

    }

    @Test
    void conjugatedMatrix() {

        //TestCase
        ComplexMatrix m1 = new ComplexMatrix(2, 2);

        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(4, 2);
        Complex c3 = new Complex(7, 1);
        Complex c4 = new Complex(-1, 6);

        m1.addToMatrix(0, 0, c1);
        m1.addToMatrix(0, 1, c2);
        m1.addToMatrix(1, 0, c3);
        m1.addToMatrix(1, 1, c4);

        ComplexMatrix answer = MatrixCalculator.conjugatedMatrix(m1);
        ComplexMatrix answerExpected = new ComplexMatrix(2, 2);
        answerExpected.addToMatrix(0, 0, new Complex(3,-4));
        answerExpected.addToMatrix(0, 1, new Complex(4,-2));
        answerExpected.addToMatrix(1, 0, new Complex(7,-1));
        answerExpected.addToMatrix(1, 1, new Complex(-1,-6));

        assertEquals(answerExpected, answer);

    }

    @Test
    void adjointMatrix() {

        //TestCase
        ComplexMatrix m1 = new ComplexMatrix(2, 2);

        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(4, 2);
        Complex c3 = new Complex(7, 1);
        Complex c4 = new Complex(-1, 6);

        m1.addToMatrix(0, 0, c1);
        m1.addToMatrix(0, 1, c2);
        m1.addToMatrix(1, 0, c3);
        m1.addToMatrix(1, 1, c4);

        ComplexMatrix answer = MatrixCalculator.adjointMatrix(m1);
        ComplexMatrix answerExpected = new ComplexMatrix(2, 2);
        answerExpected.addToMatrix(0, 0, new Complex(3,-4));
        answerExpected.addToMatrix(0, 1, new Complex(7,-1));
        answerExpected.addToMatrix(1, 0, new Complex(4,-2));
        answerExpected.addToMatrix(1, 1, new Complex(-1,-6));

        assertEquals(answerExpected, answer);

    }

    @Test
    void matrixMultiplication() {

        //TestCase
        ComplexMatrix m1 = new ComplexMatrix(2, 2);
        ComplexMatrix m2 = new ComplexMatrix(2, 2);

        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(4, 2);
        Complex c3 = new Complex(7, 1);
        Complex c4 = new Complex(-1, 6);
        Complex c5 = new Complex(5, -1);
        Complex c6 = new Complex(2, 3);
        Complex c7 = new Complex(-3, 4);
        Complex c8 = new Complex(8, -5);

        m1.addToMatrix(0, 0, c1);
        m1.addToMatrix(0, 1, c2);
        m1.addToMatrix(1, 0, c3);
        m1.addToMatrix(1, 1, c4);

        m2.addToMatrix(0, 0, c5);
        m2.addToMatrix(0, 1, c6);
        m2.addToMatrix(1, 0, c7);
        m2.addToMatrix(1, 1, c8);

        ComplexMatrix answer = MatrixCalculator.matrixMultiplication(m1, m2);
        ComplexMatrix answerExpected = new ComplexMatrix(2, 2);
        answerExpected.addToMatrix(0, 0, new Complex(-1,27));
        answerExpected.addToMatrix(0, 1, new Complex(36,13));
        answerExpected.addToMatrix(1, 0, new Complex(15,-24));
        answerExpected.addToMatrix(1, 1, new Complex(33,76));

        assertEquals(answerExpected, answer);

    }

    @Test
    void actionOverVector() {

        //TestCase
        ComplexMatrix m1 = new ComplexMatrix(2, 2);
        ComplexVector v1 = new ComplexVector(2);

        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(4, 2);
        Complex c3 = new Complex(7, 1);
        Complex c4 = new Complex(-1, 6);
        Complex c5 = new Complex(5, -1);
        Complex c6 = new Complex(2, 3);

        m1.addToMatrix(0, 0, c1);
        m1.addToMatrix(0, 1, c2);
        m1.addToMatrix(1, 0, c3);
        m1.addToMatrix(1, 1, c4);

        v1.addToMatrix(0, c5);
        v1.addToMatrix(1, c6);

        ComplexMatrix answer = MatrixCalculator.actionOverVector(m1, v1);
        ComplexMatrix answerExpected = new ComplexMatrix(2, 1);
        answerExpected.addToMatrix(0, 0, new Complex(21,33));
        answerExpected.addToMatrix(1, 0, new Complex(16,7));

        assertEquals(answerExpected, answer);

    }

    @Test
    void norm() {

        //TestCase
        ComplexMatrix m1 = new ComplexMatrix(2, 2);

        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(4, 2);
        Complex c3 = new Complex(7, 1);
        Complex c4 = new Complex(-1, 6);

        m1.addToMatrix(0, 0, c1);
        m1.addToMatrix(0, 1, c2);
        m1.addToMatrix(1, 0, c3);
        m1.addToMatrix(1, 1, c4);

        double answer = MatrixCalculator.norm(m1);
        double answerExpected = 11.489125293076057;

        assertEquals(answerExpected, answer);

    }

    @Test
    void distance() {

        //TestCase
        ComplexMatrix m1 = new ComplexMatrix(2, 2);
        ComplexMatrix m2 = new ComplexMatrix(2, 2);

        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(4, 2);
        Complex c3 = new Complex(7, 1);
        Complex c4 = new Complex(-1, 6);
        Complex c5 = new Complex(5, -1);
        Complex c6 = new Complex(2, 3);
        Complex c7 = new Complex(-3, 4);
        Complex c8 = new Complex(8, -5);

        m1.addToMatrix(0, 0, c1);
        m1.addToMatrix(0, 1, c2);
        m1.addToMatrix(1, 0, c3);
        m1.addToMatrix(1, 1, c4);

        m2.addToMatrix(0, 0, c5);
        m2.addToMatrix(0, 1, c6);
        m2.addToMatrix(1, 0, c7);
        m2.addToMatrix(1, 1, c8);

        double answer = MatrixCalculator.distance(m1, m2);
        double answerExpected = 18.57417562100671;

        assertEquals(answerExpected, answer);

    }

    @Test
    void isHermitian() {

        //TestCase
        ComplexMatrix m1 = new ComplexMatrix(2, 2);

        Complex c1 = new Complex(7, 0);
        Complex c2 = new Complex(6, 5);
        Complex c3 = new Complex(6, -5);
        Complex c4 = new Complex(3, 0);

        m1.addToMatrix(0, 0, c1);
        m1.addToMatrix(0, 1, c2);
        m1.addToMatrix(1, 0, c3);
        m1.addToMatrix(1, 1, c4);

        assertTrue(MatrixCalculator.isHermitian(m1));

    }

    @Test
    void isUnitary() {

        //TestCase
        ComplexMatrix m1 = new ComplexMatrix(2, 2);

        Complex c1 = new Complex(1, 1);
        Complex c2 = new Complex(1, -1);
        Complex c3 = new Complex(1, -1);
        Complex c4 = new Complex(1, 1);

        Complex c5 = new Complex((double)1/2,0);

        System.out.println(2/4);

        m1.addToMatrix(0, 0, c1);
        m1.addToMatrix(0, 1, c2);
        m1.addToMatrix(1, 0, c3);
        m1.addToMatrix(1, 1, c4);

        m1 = MatrixCalculator.scalarMultiplication(c5, m1);

        assertTrue(MatrixCalculator.isUnitary(m1));

    }

    @Test
    void tensorProduct() {

        //TestCase
        ComplexVector v1 = new ComplexVector(3);
        ComplexVector v2 = new ComplexVector(2);

        Complex c1 = new Complex(3, 0);
        Complex c2 = new Complex(4, 0);
        Complex c3 = new Complex(7, 0);
        Complex c4 = new Complex(-1, 0);
        Complex c5 = new Complex(2, 0);

        v1.addToMatrix(0, c1);
        v1.addToMatrix(1, c2);
        v1.addToMatrix(2, c3);

        v2.addToMatrix(0, c4);
        v2.addToMatrix(1, c5);

        ComplexMatrix answer = MatrixCalculator.tensorProduct(v1, v2);
        ComplexMatrix answerExpected = new ComplexMatrix(v1.getN()*v2.getN(), v1.getM()*v2.getM());
        answerExpected.addToMatrix(0, 0, new Complex(-3,0));
        answerExpected.addToMatrix(1, 0, new Complex(6,0));
        answerExpected.addToMatrix(2, 0, new Complex(-4,0));
        answerExpected.addToMatrix(3, 0, new Complex(8,0));
        answerExpected.addToMatrix(4, 0, new Complex(-7,0));
        answerExpected.addToMatrix(5, 0, new Complex(14,0));

        assertEquals(answerExpected, answer);

    }
}