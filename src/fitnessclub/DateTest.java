package fitnessclub;

import static org.junit.Assert.*;

public class DateTest {

    @org.junit.Test
    public void isValid() {
        Date date = new Date(2,29,2015);
        assertFalse(date.isValid());

        Date date2 = new Date(2,29,2000);
        assertTrue(date2.isValid());

        Date date3 = new Date(2,29,1900);
        assertFalse(date3.isValid());

        Date date4 = new Date(2,29,2012);
        assertTrue(date4.isValid());

        Date date5 = new Date(3,16,1899);
        assertFalse(date5.isValid());

        Date date6 = new Date(2,10,2025);
        assertFalse(date6.isValid());

        Date date7 = new Date(6,31,2016);
        assertFalse(date7.isValid());

    }

    public void isValid2(){
        Date date2 = new Date(2,29,2000);
        assertTrue(date2.isValid());
    }

}