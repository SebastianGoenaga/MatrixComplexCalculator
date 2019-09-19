package model;

import java.util.Arrays;
import java.util.Objects;

public class ComplexMatrix {
	
	Complex[][] matrix;
	private int n, m;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexMatrix that = (ComplexMatrix) o;
        return equalsMatrix(matrix, that.matrix);
    }
    
    private boolean equalsMatrix(Complex[][] m1, Complex[][] m2){
		if (m1.length == m2.length && m1[0].length == m2[0].length) {
			for (int i = 0; i < n; i++) {
				if (!Arrays.equals(m1[i], m2[i])) return false;
			}
			return true;
		}else return false;

	}

    @Override
    public int hashCode() {
        int result = Objects.hash(n, m);
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }

    public int getN() {
		return n;
	}

	public int getM() {
		return m;
	}

	public ComplexMatrix(int n, int m) {
		matrix = new Complex[n][m];
		this.n = n;
		this.m = m;
	}
	
	public Complex getElement(int n, int m) {
		return matrix[n][m];
	}
	
	public void addToMatrix(int n, int m, Complex c) {
		matrix[n][m] = c;
	}

	public boolean isSquare (){
		return n == m;
	}
	
	@Override
	public String toString() {
		StringBuilder matrix = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix.append("  ").append(this.matrix[i][j]);
			}
			matrix.append("\n");
		}
		return matrix.toString();
	}

}
