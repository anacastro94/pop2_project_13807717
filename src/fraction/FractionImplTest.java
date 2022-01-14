// 13807717
// asilva14@student.bbk.ac.uk

package fraction;

import static org.junit.jupiter.api.Assertions.*;

class FractionImplTest {

    @org.junit.jupiter.api.Test
    void firstConstructor() {
        Fraction f = new FractionImpl(12, -8);
        assertEquals("-3/2", f.toString());
    }

    @org.junit.jupiter.api.Test
    void firstConstructorArithmeticException() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> new FractionImpl(12, 0));
        assertTrue(exception.getMessage().contains("Division by zero"));
    }

    @org.junit.jupiter.api.Test
    void secondConstructor() {
        Fraction f = new FractionImpl(8);
        assertEquals("8", f.toString());
    }

    @org.junit.jupiter.api.Test
    void thirdConstructor() {
        Fraction f = new FractionImpl("16  /-24  ");
        assertEquals("-2/3", f.toString());
    }

    @org.junit.jupiter.api.Test
    void thirdConstructorArithmeticException() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> new FractionImpl("12/0"));
        assertTrue(exception.getMessage().contains("Division by zero"));
    }

    @org.junit.jupiter.api.Test
    void thirdConstructorNumberFormatException() {
        NumberFormatException exception = assertThrows(NumberFormatException.class, () -> new FractionImpl("AA/BB"));
        assertTrue(exception.getMessage().contains("For input string: \"AA\""));
    }

    @org.junit.jupiter.api.Test
    void add() {
        Fraction f1 = new FractionImpl(12, 8);
        Fraction f2 = new FractionImpl(8, 12);
        Fraction fResult = f1.add(f2);
        assertEquals(new FractionImpl("13/6"), fResult);
    }

    @org.junit.jupiter.api.Test
    void subtract() {
        Fraction f1 = new FractionImpl(12, 8);
        Fraction f2 = new FractionImpl(8, 12);
        Fraction fResult = f1.subtract(f2);
        assertEquals(new FractionImpl("5/6"), fResult);
    }

    @org.junit.jupiter.api.Test
    void multiply() {
        Fraction f1 = new FractionImpl(12, 8);
        Fraction f2 = new FractionImpl(8, 12);
        Fraction fResult = f1.multiply(f2);
        assertEquals(new FractionImpl(1), fResult);
    }

    @org.junit.jupiter.api.Test
    void divide() {
        Fraction f1 = new FractionImpl(12, 8);
        Fraction f2 = new FractionImpl(8, 12);
        Fraction fResult = f1.divide(f2);
        assertEquals(new FractionImpl("9/4"), fResult);
    }

    @org.junit.jupiter.api.Test
    void abs() {
    }

    @org.junit.jupiter.api.Test
    void negate() {
    }

    @org.junit.jupiter.api.Test
    void testEquals1() {
        Fraction f1 = new FractionImpl(12, 8);
        Fraction f2 = new FractionImpl(8, 12);
        assertFalse(f1.equals(f2));
    }

    @org.junit.jupiter.api.Test
    void testEquals2() {
        Fraction f = new FractionImpl(8, 12);
        assertTrue(f.equals(new FractionImpl("2/3")));
    }

    @org.junit.jupiter.api.Test
    void inverse() {
    }

    @org.junit.jupiter.api.Test
    void compareTo() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        Fraction f1 = new FractionImpl(12, 8);
        assertEquals("3/2", f1.toString());
    }
}