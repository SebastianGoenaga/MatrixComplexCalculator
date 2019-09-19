package model;

public class ComplexVector extends ComplexMatrix {

    public ComplexVector(int n) {
        super(n, 1);
    }

    public ComplexVector(ComplexMatrix m) {
        super(m.getN(), 1);
        if (m.getM()==1) {
            for (int i = 0; i < m.getN(); i++) {
                matrix[i][0] = m.getElement(i, 0);
            }
        
        }
    }

    public void addToMatrix(int n, Complex c) {
        super.addToMatrix(n, 0, c);
    }

    public Complex getElement(int n){
        return super.getElement(n, 0);
    }
}
