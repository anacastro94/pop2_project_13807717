// 13807717
// asilva14@student.bbk.ac.uk

package fraction;

public class FractionImpl implements Fraction {
    /**
     * Parameters are the <em>numerator</em> and the <em>denominator</em>.
     * Normalize the fraction as you create it.
     * For instance, if the parameters are <pre>(8, -12)</pre>, create a <pre>Fraction</pre> with numerator
     * <pre>-2</pre> and denominator <pre>3</pre>.
     * <p>
     * The constructor should throw an <pre>ArithmeticException</pre> if the denominator is zero.
     *
     * @param numerator
     * @param denominator
     */

    private final int numerator;
    private final int denominator;

    public FractionImpl(int numerator, int denominator) {
        if (denominator == 0) throw new ArithmeticException("Division by zero");
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int gdc = findGDC(numerator, denominator); // GDC == greatest common divisor
        // Converting the fractions into their reduced forms
        numerator = numerator / gdc;
        denominator = denominator / gdc;
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {
        this.numerator = wholeNumber;
        this.denominator = 1;
    }

    /**
     * The parameter is a <pre>String</pre> containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     * Allow blanks around (but not within) integers.
     * The constructor should throw an <pre>ArithmeticException</pre>
     * if given a string representing a fraction whose denominator is zero.
     * <p>
     * You may find it helpful to look at the available String API methods in the Java API.
     *
     * @param fraction the string representation of the fraction
     */
    public FractionImpl(String fraction) {
        // Finding all spaces and non-visible characters in the parameter
        // fraction and removing them
        fraction = fraction.replaceAll("\\s+", "");
        int numerator, denominator;
        int i = fraction.indexOf('/'); // Finding the position of '/' in the string fraction
        // i == -1 when '/' was not found (whole number)
        if (i != -1) {
            numerator = Integer.parseInt(fraction.substring(0, i));
            denominator = Integer.parseInt(fraction.substring(i + 1));
        } else {
            numerator = Integer.parseInt(fraction);
            denominator = 1;
        }
        if (denominator == 0) throw new ArithmeticException("Division by zero");
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int gdc = findGDC(numerator, denominator); // GDC == greatest common divisor
        // Converting the fractions into their reduced forms
        numerator = numerator / gdc;
        denominator = denominator / gdc;
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Returns a new <pre>Fraction</pre> that is the <em>sum</em> of <pre>this</pre> and the parameter:
     * <pre>a/b + c/d</pre> is <pre>(ad + bc)/bd</pre>
     *
     * @param f the fraction to add to the current fraction
     * @return the result of the addition
     */
    @Override
    public Fraction add(Fraction f) {
        FractionImpl fCopy = (FractionImpl) f;
        int n = (numerator * fCopy.denominator + denominator * fCopy.numerator);
        int d = denominator * fCopy.denominator;
        return new FractionImpl(n, d);
    }

    /**
     * Returns a new <pre>Fraction</pre> that is the <em>difference</em> of <pre>this</pre> minus the parameter
     * <pre>a/b - c/d</pre> is <pre>(ad - bc)/bd</pre>
     *
     * @param f the fraction to subtract from the current fraction
     * @return the result of the subtraction
     */
    @Override
    public Fraction subtract(Fraction f) {
        FractionImpl fCopy = (FractionImpl) f;
        int n = (numerator * fCopy.denominator - denominator * fCopy.numerator);
        int d = denominator * fCopy.denominator;
        return new FractionImpl(n, d);
    }

    /**
     * Returns a new <pre>Fraction</pre> that is the <em>product</em> of <pre>this</pre> and the parameter
     * <pre>(a/b) * (c/d)</pre> is <pre>(a*c)/(b*d)</pre>
     *
     * @param f the fraction to multiply with the current fraction
     * @return the result of the multiplication
     */
    @Override
    public Fraction multiply(Fraction f) {
        FractionImpl fCopy = (FractionImpl) f;
        int n = numerator * fCopy.numerator;
        int d = denominator * fCopy.denominator;
        return new FractionImpl(n, d);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Returns <pre>true</pre> if <pre>obj</pre> is a <pre>Fraction</pre> equal to <pre>this</pre>,
     * and <pre>false</pre> in all other cases.
     *
     * @param obj the object to compare this one to
     * @return whether the true fractions are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fraction) {
            FractionImpl fCopy = new FractionImpl(obj.toString());
            // Two fractions in the reduced form are equal when their numerators and denominators are equal
            if (numerator == fCopy.numerator && denominator == fCopy.denominator) return true;
            else return false;
        } else {
            return false;
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction inverse() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        return 0;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        if (denominator == 1) return "" + numerator;
        else return numerator + "/" + denominator;
    }

    /**
     * The method findGDC returns the Greatest Common Divisor (GDC)
     * of the absolute value of two integers n1 and n2
     *
     * @param n1 first integer
     * @param n2 second integer
     * @return The GDC which is also an integer
     */
    private int findGDC(int n1, int n2) {
        n1 = Math.abs(n1);
        n2 = Math.abs(n2);
        while (n1 != 0 && n2 != 0) {
            if (n1 > n2) n1 = n1 % n2;
            else n2 = n2 % n1;
        }
        if (n1 == 0 && n2 != 0) return n2;
        else if (n2 == 0 && n1 != 0) return n1;
        else return 1;
    }
}