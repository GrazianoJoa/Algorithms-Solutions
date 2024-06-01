package algoJV.dos;

public class Ex16 {
	public static void main(String[] args) {
	
		Rational r1 = new Rational(4, 2);
		Rational r2 = new Rational(2, 2);
		Rational r3 = r1.minus(r2);
		r3.print();
	}
}
