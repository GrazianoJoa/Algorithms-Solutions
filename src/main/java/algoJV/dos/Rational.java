package algoJV.dos;

public class Rational {
	private int numerator, denominator;
	
	Rational(int numerator, int denominator) {
		if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be 0.");
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public Rational plus(Rational r) {
		return simplify(new Rational(this.numerator*r.denominator + r.numerator*this.denominator, 
				this.denominator * r.denominator));
	}
	
	public Rational minus(Rational r) {
		return plus(new Rational(-r.numerator, r.denominator));
	}
	
	public Rational times(Rational r) {
		return simplify(new Rational(this.numerator * r.numerator, this.denominator * r.denominator));
	}
	
	public Rational divides(Rational r) {
		if (r.numerator == 0) return new Rational(this.numerator, this.denominator);
		return times(new Rational(this.denominator, this.numerator));
	}
	
	private Rational simplify(Rational r) {
		int gcd = gcd(r.numerator, r.denominator);
		r.numerator /= gcd;
		r.denominator /= gcd;
		return r;
	}
	
	private int gcd(int a, int b) {
		while (b != 0) {
			int tmp = b;
			b = a % b;
			a = tmp;
		}
		
		return Math.abs(a);
	}
	
	public boolean equal(Rational r) {
		if ((this.numerator == r.numerator) && (this.denominator == r.denominator)) return true;
		return false;
	}
	
	public void print() {
		System.out.println(this.numerator + " " + this.denominator);
	}
}
