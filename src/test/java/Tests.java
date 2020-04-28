import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class Tests {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void standardConstructor() {
        Rational standard = new Rational();
        assertEquals("Standard constructor returns wrong numerator",
                0, standard.getNumerator());
        assertEquals("Standard constructor returns wrong denominator",
                1, standard.getDenominator());
    }

    @Test
    public void constructor_PositiveNominatorAndDenominator_SameValuesReturned() {
        Rational rational= new Rational(4,5);
        assertEquals("Сonstructor returns wrong numerator",
                4, rational.getNumerator());
        assertEquals("Сonstructor returns wrong denominator",
                5, rational.getDenominator());
    }

    @Test
    public void constructor_ZeroAsDenominator_ExceptionThrown() {
        thrown.expect(ArithmeticException.class);
        thrown.expectMessage("division by zero !");
        new Rational(4,0);
        thrown = ExpectedException.none();
    }

    @Test
    public void constructor_NegativeDenominator_PositiveDenominatorReturned(){
        Rational rational = new Rational(4,-5);
        assertEquals("Сonstructor returns wrong numerator",
                -4,rational.getNumerator());
        assertEquals("Сonstructor returns wrong denominator",
                5,rational.getDenominator());
    }

    @Test
    public void constructor_ZeroAsNominator_DenominatorReturnedAsOne(){
        Rational rational = new Rational(0,12);
        assertEquals("Сonstructor returns wrong numerator",
                0,rational.getNumerator());
        assertEquals("Сonstructor returns wrong denominator",
                1,rational.getDenominator());
    }

    @Test
    public void constructor_ReducibleRational_RationalReduced(){
        Rational rational = new Rational(14,30);
        assertEquals("Сonstructor returns wrong numerator",
                7, rational.getNumerator());
        assertEquals("Сonstructor returns wrong denominator",
                15, rational.getDenominator());
    }

    @Test
    public void setNumerator_RegularNumerator_CorrectRationalReturned(){
        Rational rational = new Rational(15,2);
        rational.setNumerator(7);
        assertEquals("Wrong numerator returned after setting up Numerator",
                7, rational.getNumerator());
        assertEquals("Wrong denominator returned after setting up Numerator",
                2, rational.getDenominator());
    }

    @Test
    public void setNumerator_ReducibleNominator_RationalReduced(){
        Rational rational = new Rational(1,30);
        rational.setNumerator(60);
        assertEquals("Rational is reduced incorrectly while setting up numerator: wrong numerator returned",
                2, rational.getNumerator());
        assertEquals("Rational is reduced incorrectly while setting up numerator: wrong denominator returned",
                1, rational.getDenominator());
    }

    @Test
    public void setDenominator_RegularDenominator_CorrectRationalReturned(){
        Rational standard = new Rational(12,1);
        standard.setDenominator(17);
        assertEquals("Wrong numerator returned after setting up Denominator",
                12, standard.getNumerator());
        assertEquals("Wrong denominator returned after setting up Denominator",
                17, standard.getDenominator());
    }

    @Test
    public void setDenominator_ReducibleDenominator_RationalReduced(){
        Rational rational = new Rational(12,1);
        rational.setDenominator(30);
        assertEquals("Rational reduced incorrectly after setting up denominator: wrong numerator returned",
                2, rational.getNumerator());
        assertEquals("Rational reduced incorrectly after setting up denominator: wrong denominator returned",
                5, rational.getDenominator());
    }

    @Test
    public void toString_RegularRational_CorrectStringReturned(){
        Rational rational = new Rational(-3,4);
        assertEquals("toString returns incorrect String","-3/4",
                rational.toString());
    }

    @Test
    public void equals_ArgumentIsNull_False(){
        Rational rational = new Rational(5,6);
        assertNotEquals("equals returns wrong result when argument is null",
                rational, null);
    }

    @Test
    public void equals_ArgumentIsDifferentClass_False(){
        Rational rational = new Rational(5,6);
        assertNotEquals("equals returns wrong result when argument is an instance of a different class",
                rational,"25");
    }

    @Test
    public void equals_ArgumentIsDifferentRational_False(){
        Rational rational = new Rational(5,6);
        assertNotEquals("equals returns wrong result when argument is not equal",
                rational,new Rational (10,11));
    }

    @Test
    public void equals_EqualArgument_True(){
        Rational rational = new Rational(5,6);
        assertEquals("equals returns wrong result when argument is equal",
                rational, new Rational(5, 6));
    }

    @Test
    public void less_ArgumentIsEqual_False(){
        Rational rational = new Rational(2,9);
        assertFalse("Function \"less\" returns wrong result when argument is equal",
                rational.less(new Rational(2,9)));
    }

    @Test
    public void less_EqualDenominatorsArgumentIsGreater_True(){
        Rational rational = new Rational(3,10);
        assertTrue("Function \"less\" returns wrong result when argument is greater",
                rational.less(new Rational(7,10)));
    }

    @Test
    public void less_EqualDenominatorsArgumentIsLess_False(){
        Rational rational = new Rational(3,10);
        assertFalse("Function \"less\" returns wrong result when argument is less",
                rational.less(new Rational(1,10)));
    }

    @Test
    public void less_NegativeRationalsEqualDenominatorsArgumentIsGreater_True(){
        Rational rational = new Rational(-7,10);
        assertTrue("Function \"less\" returns wrong result when comparing negative rationals",
                rational.less(new Rational(-3,10)));
    }

    @Test
    public void less_EqualNumeratorsArgumentIsGreater_True(){
        Rational rational = new Rational(5,6);
        assertFalse("Function \"less\" returns wrong result when argument is greater",
                rational.less(new Rational(5,22)));
    }


    @Test
    public void less_EqualNumeratorsArgumentIsLess_False(){
        Rational rational = new Rational(5,6);
        assertFalse("Function \"less\" returns wrong result when argument is less",
                rational.less(new Rational(5,22)));
    }

    @Test
    public void less_NegativeRatilonalsEqualNumeratorsArgumentIsGreater_True(){
        Rational rational = new Rational(-5,6);
        assertTrue("Function \"less\" returns wrong result when comparing negative rationals",
                rational.less(new Rational(-5,22)));
    }

    @Test
    public void less_ArgumentIsGreater_True(){
        Rational rational = new Rational(5,6);
        assertTrue("Function \"less\" returns wrong result when argument is greater",
                rational.less(new Rational(6,7)));
    }

    @Test
    public void less_NegativeRationalsArgumentIsGreater_True(){
        Rational rational = new Rational(-5,6);
        assertTrue("Function \"less\" returns wrong result",
                rational.less(new Rational(-3,4)));
    }

    @Test
    public void lessOrEqual_equalArgument_True(){
        Rational rational = new Rational(5,6);
        assertTrue("lessOrEqual returned wrong result",
                rational.lessOrEqual(new Rational(5,6)));
    }

    @Test
    public void lessOrEqual_ArgumentIsGreater_True(){
        Rational rational = new Rational(5,6);
        assertTrue("lessOrEqual returns wrong result",
                rational.lessOrEqual(new Rational(7,8)));
    }

    @Test
    public void lessOrEqual_ArgumentIsLess_False(){
        Rational rational = new Rational(5,6);
        assertFalse("lessOrEqual returns wrong result",
                rational.lessOrEqual(new Rational(4,5)));
    }

    @Test
    public void plus_RegularRational_CorrectSumReturned(){
        Rational firstSummand = new Rational(5,6);
        Rational secondSummand = new Rational(7,8);
        Rational correctSum = new Rational(41,24);

        assertEquals("plus returns wrong result",
                correctSum, firstSummand.plus(secondSummand));
    }

    @Test
    public void multiply_RegularRational_CorrectProductReturned(){
        Rational firstFactor = new Rational(2,3);
        Rational secondFactor = new Rational(3,4);
        Rational correctProduct = new Rational(1,2);

        assertEquals("multiply returns wrong result",
                correctProduct,firstFactor.multiply(secondFactor));
    }

    @Test
    public void minus_RegularRational_CorrectDifferenceReturned(){
        Rational minuend = new Rational(2,3);
        Rational subtrahend = new Rational (3,4);
        Rational correctDifference = new Rational(-1,12);

        assertEquals("minus returns wrong result",
                correctDifference, minuend.minus(subtrahend));
    }

    @Test
    public void divide_ZeroAsArgument_ExceptionThrown(){
        thrown.expect(ArithmeticException.class);
        thrown.expectMessage("division by zero !");

        Rational divisible = new Rational(2,3);
        divisible.divide(new Rational());

        thrown = ExpectedException.none();
    }

    @Test
    public void divide_RegularRational_CorrectQuotientReturned(){
        Rational divisible = new Rational(2,3);
        Rational divisor = new Rational(4,5);
        Rational correctQuotient = new Rational(5,6);

        assertEquals("divide returns wrong result",
                correctQuotient,divisible.divide(divisor));
    }
}