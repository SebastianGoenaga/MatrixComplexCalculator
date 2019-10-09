package calculator;

import model.Complex;
import model.ComplexMatrix;
import model.ComplexVector;

public class MatrixCalculator {

    public static ComplexMatrix matrixSum(ComplexMatrix m1, ComplexMatrix m2) {
        if (m1.getN() == m2.getN() && m1.getM() == m2.getM()) {
            ComplexMatrix m3 = new ComplexMatrix(m1.getN(), m1.getM());
            for (int n = 0; n < m1.getN(); n++)
                for (int m = 0; m < m1.getM(); m++) {
                    m3.addToMatrix(n, m, Functions.CSum(m1.getElement(n, m), m2.getElement(n, m)));

                }
            return m3;
        } else {
            return null;
        }
    }

    public static ComplexMatrix matrixSubtraction(ComplexMatrix m1, ComplexMatrix m2) {
        return matrixSum(m1, negation(m2));
    }

    public static ComplexMatrix negation(ComplexMatrix m1) {
        ComplexMatrix m3 = new ComplexMatrix(m1.getN(), m1.getM());
        for (int n = 0; n < m1.getN(); n++)
            for (int m = 0; m < m1.getM(); m++) {
                m3.addToMatrix(n, m, Functions.CProduct(m1.getElement(n, m), new Complex(-1, 0)));
            }
        return m3;
    }

    public static ComplexMatrix scalarMultiplication(Complex c1, ComplexMatrix m1) {
        ComplexMatrix m3 = new ComplexMatrix(m1.getN(), m1.getM());
        for (int n = 0; n < m1.getN(); n++) {
            for (int m = 0; m < m1.getM(); m++) {
                m3.addToMatrix(n, m, Functions.CProduct(m1.getElement(n, m), c1));
            }
        }
        return m3;
    }

    public static ComplexMatrix transposedMatrix(ComplexMatrix m1) {
        ComplexMatrix m3 = new ComplexMatrix(m1.getM(), m1.getN());
        for (int n = 0; n < m1.getN(); n++) {
            for (int m = 0; m < m1.getM(); m++) {
                m3.addToMatrix(m, n, m1.getElement(n, m));
            }
        }
        return m3;
    }

    public static ComplexMatrix conjugatedMatrix(ComplexMatrix m1) {
        ComplexMatrix m3 = new ComplexMatrix(m1.getN(), m1.getM());
        for (int n = 0; n < m1.getN(); n++) {
            for (int m = 0; m < m1.getM(); m++) {
                m3.addToMatrix(n, m, Functions.Conjugate(m1.getElement(n, m)));
            }
        }
        return m3;
    }

    public static ComplexMatrix adjointMatrix(ComplexMatrix m1) {
        ComplexMatrix m3 = new ComplexMatrix(m1.getM(), m1.getN());
        for (int n = 0; n < m1.getN(); n++) {
            for (int m = 0; m < m1.getM(); m++) {
                m3.addToMatrix(m, n, Functions.Conjugate(m1.getElement(n, m)));
            }
        }
        return m3;
    }

    public static ComplexVector adjointMatrix(ComplexVector v1) {
        return new ComplexVector(adjointMatrix((ComplexMatrix) v1));
    }

    public static ComplexMatrix matrixMultiplication(ComplexMatrix m1, ComplexMatrix m2) {
        if (m1.getM() == m2.getN()) {
            ComplexMatrix m3 = new ComplexMatrix(m1.getN(), m2.getM());
            for (int n = 0; n < m1.getN(); n++) {
                for (int m = 0; m < m2.getM(); m++) {
                    Complex sum = new Complex(0, 0);
                    for (int k = 0; k < m1.getM(); k++) {
                        sum = Functions.CSum(sum, Functions.CProduct(m1.getElement(n, k), m2.getElement(k, m)));
                    }
                    m3.addToMatrix(n, m, sum);
                }
            }
            return m3;
        } else {
            System.out.println("Matrices de dimensiones no compatibles");
            return null;
        }
    }

    public static ComplexVector actionOverVector(ComplexMatrix m1, ComplexVector v1) {
        if (m1.getN() == m1.getM())
            return new ComplexVector(matrixMultiplication(m1, v1));
        else {
            System.out.println("La matriz debe ser cuadrada");
            return null;
        }
    }

    public static Complex innerProduct(ComplexMatrix m1, ComplexMatrix m2) {
        //noinspection ConstantConditions
        return trace(matrixMultiplication(adjointMatrix(m1), m2));
    }

    public static Complex innerProduct(ComplexVector v1, ComplexVector v2) {
        //noinspection ConstantConditions
        return innerProduct((ComplexMatrix) v1,(ComplexMatrix) v2);
    }

    public static Complex trace(ComplexMatrix m1) {
        if (m1.isSquare()) {
            Complex sum = new Complex(0, 0);
            for (int i = 0; i < m1.getN(); i++) {
                sum = Functions.CSum(sum, m1.getElement(i, i));
            }
            return sum;
        } else {
            System.out.println("La matriz debe ser cuadrada");
            return null;
        }
    }

    public static double norm(ComplexMatrix m1) {
        return Math.sqrt(innerProduct(m1, m1).getpReal());
    }

    public static double norm(ComplexVector v1) {
        return norm((ComplexMatrix) v1);
    }

    public static double distance(ComplexMatrix m1, ComplexMatrix m2) {
        return norm(matrixSubtraction(m1, m2));
    }

    public static boolean isHermitian(ComplexMatrix m1) {
        for (int n = 0; n < m1.getN(); n++) {
            for (int m = 0; m < m1.getM(); m++) {
                if (!m1.getElement(n, m).equals(Functions.Conjugate(m1.getElement(m, n)))) {
                   return false;
                }
            }
        }
        return true;
    }

    @SuppressWarnings("ConstantConditions")
    public static boolean isUnitary(ComplexMatrix m1){
        if (m1.isSquare()) {
            ComplexMatrix mAdj = adjointMatrix(m1);
            ComplexMatrix mAns = matrixMultiplication(mAdj,m1);
            for (int i = 0; i < m1.getN(); i++) {
                for (int j = 0; j < m1.getM(); j++) {
                    if (i==j){
                        if (!new Complex(1,0).equals(mAns.getElement(i,j))) return false;
                    }
                    else{
                        if (!new Complex(0,0).equals(mAns.getElement(i,j))) return false;
                    }
                }
            }
            return true;
        } else {
            System.out.println("La matriz debe ser cuadrada");
            return false;
        }
    }

    public static ComplexMatrix tensorProduct(ComplexMatrix m1, ComplexMatrix m2){
        ComplexMatrix mAns = new ComplexMatrix(m1.getN()*m2.getN(), m1.getM()*m2.getM());
        int m = m1.getN();
        int n = m2.getN();
        for (int j = 0; j < mAns.getN(); j++) {
            for (int k = 0; k < mAns.getM(); k++) {
                Complex c1 = m1.getElement(j/n, k/m);
                Complex c2 = m2.getElement(j%n,k%m);
                mAns.addToMatrix(j, k, Functions.CProduct(c1,c2));
            }
        }
        return mAns;
    }

}
