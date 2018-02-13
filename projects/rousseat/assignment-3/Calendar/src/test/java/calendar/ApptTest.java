package calendar;

import org.junit.Test;

import static org.junit.Assert.*;

public class ApptTest{
    @Test
    public void testMakeAppt(){
        int startHour = 21;
        int startMinute = 30;
        int startDay = 15;
        int startMonth = 01;
        int startYear = 2018;
        String title = "Birthday Party";
        String description = "This is my birthday party.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);

        assertTrue(appt.getValid());
        assertEquals(21, appt.getStartHour());
        assertEquals(30, appt.getStartMinute());
        assertEquals(15, appt.getStartDay());
        assertEquals(01, appt.getStartMonth());
        assertEquals(2018, appt.getStartYear());
        assertEquals("Birthday Party", appt.getTitle());
        assertEquals("This is my birthday party.", appt.getDescription());
    }


    @Test
    public void testMinute(){
        Appt appt;
        appt = new Appt(1, 2, 3, 4, 2018, "title", "description");
        assertTrue(appt.getValid());
        appt.setStartMinute(0);
        assertTrue(appt.getValid());
        appt.setStartMinute(59);
        assertTrue(appt.getValid());
        assertEquals(59, appt.getStartMinute());
        appt.setStartMinute(-1);
        assertFalse(appt.getValid());
        assertEquals(-1, appt.getStartMinute());
        appt.setStartMinute(60);
        assertFalse(appt.getValid());
        assertEquals(60, appt.getStartMinute());
    }

    @Test
    public void testHour(){
        Appt appt;
        appt = new Appt(1, 2, 3, 4, 5, "title", "description");
        assertTrue(appt.getValid());
        appt.setStartHour(0);
        assertTrue(appt.getValid());
        assertEquals(0, appt.getStartHour());
        appt.setStartHour(23);
        assertTrue(appt.getValid());
        assertEquals(23, appt.getStartHour());
        appt.setStartHour(-1);
        assertFalse(appt.getValid());
        assertEquals(-1, appt.getStartHour());
        appt.setStartHour(24);
        assertFalse(appt.getValid());
        assertEquals(24, appt.getStartHour());
    }


    @Test
    public void testDay(){
        Appt appt;
        appt = new Appt(1, 2, 3, 1, 2018, "title", "description");
        assertTrue(appt.getValid());
        appt.setStartDay(1);
        assertTrue(appt.getValid());
        assertEquals(1, appt.getStartDay());
        appt.setStartDay(11);
        assertTrue(appt.getValid());
        assertEquals(11, appt.getStartDay());
        appt.setStartDay(30);
        assertTrue(appt.getValid());
        assertEquals(30, appt.getStartDay());
        appt.setStartDay(31);
        assertTrue(appt.getValid());
        assertEquals(31, appt.getStartDay());
        appt.setStartDay(0);
        assertFalse(appt.getValid());
        assertEquals(0, appt.getStartDay());
        appt.setStartDay(32);
        assertFalse(appt.getValid());
        assertEquals(32, appt.getStartDay());
    }

    @Test
    public void testMonth(){
        Appt appt;
        appt = new Appt(1, 2, 3, 4, 2018, "title", "description");
        assertTrue(appt.getValid());
        appt.setStartMonth(1);
        appt.setStartDay(30);
        assertTrue(appt.getValid());
        assertEquals(1, appt.getStartMonth());
        assertEquals(30, appt.getStartDay());
        appt.setStartMonth(12);
        appt.setStartDay(30);
        assertEquals(12, appt.getStartMonth());
        assertEquals(30, appt.getStartDay());        
    }

    @Test
    public void testYear(){
        Appt appt;
        appt = new Appt(1, 2, 3, 4, 2018, "title", "description");
        assertTrue(appt.getValid());
        appt.setStartYear(10);
        assertEquals(10, appt.getStartYear());
    }


    @Test
    public void testTitle(){
        Appt appt;
        appt = new Appt(1, 2, 3, 4, 2018, "title", "description");
        appt.setTitle("new title");
        assertEquals("new title", appt.getTitle());
        
        appt.setTitle("");
        assertEquals("", appt.getTitle());
    }


    @Test
    public void testDescription(){
        Appt appt;
        appt = new Appt(1, 2, 3, 4, 2018, "title", "description");
        appt.setDescription("new description");
        assertEquals("new description", appt.getDescription());
        
        appt.setDescription("");
        assertEquals("", appt.getDescription());
    }

   
    @Test
    public void testgetRecurNum(){
        int num = 2;
        Appt appt = new Appt(1, 2, 3, 4, 2018, "title", "description");
        int [] arr = new int [0];
        appt.setRecurrence(arr, 1, 1, 1);
        num = appt.getRecurNumber();
        assertEquals(1, num);
    }

    @Test
    public void testRecurBy(){
        Appt appt;
        int num;
        int [] arr = new int [0];
        appt = new Appt(1, 2, 3, 4, 2018, "title", "description");
        assertFalse(appt.isRecurring());
        appt.setRecurrence(arr, 1, 1, 1);
        num = appt.getRecurBy();
        assertEquals(1, num);
    }


    @Test
    public void testgetRecurDays(){
        Appt appt = new Appt(1, 2, 3, 4, 2018, "title", "description");
        int[] arr = {1, 2};
        appt.setRecurrence(arr, 3, 4, 5);
        assertEquals(arr, appt.getRecurDays());
        assertTrue(appt.isRecurring());
        assertEquals(3, appt.getRecurBy());
        assertEquals(4, appt.getRecurIncrement());
        assertEquals(5, appt.getRecurNumber());
        appt.setRecurrence(null, 3, 4, 5);
        assertEquals(0, appt.getRecurDays().length);
        assertTrue(appt.isRecurring());
        assertEquals(3, appt.getRecurBy());
        assertEquals(4, appt.getRecurIncrement());
        assertEquals(5, appt.getRecurNumber());
    }

    @Test
    public void testCompareTo(){
        Appt appt1, appt2, appt3, appt4, appt5, appt6;
        appt1 = new Appt(2, 2, 3, 4, 2018, "title", "description");
        appt2 = new Appt(2, 2, 3, 4, 2018, "title", "description");
        appt3 = new Appt(2, 2, 3, 4, 2017, "title", "description");
        appt4 = new Appt(2, 2, 3, 3, 2017, "title", "description");
        appt5 = new Appt(2, 2, 2, 3, 2017, "title", "description");
        appt6 = new Appt(1, 2, 2, 3, 2017, "title", "description");
        assertEquals(0, appt1.compareTo(appt2));
        assertEquals(1, appt2.compareTo(appt3));
        assertEquals(1, appt3.compareTo(appt4));
        assertEquals(1, appt4.compareTo(appt5));
        assertEquals(1, appt5.compareTo(appt6));
    }

    @Test
    public void testtoString(){
        Appt appt = new Appt(1, 15, 3, 4, 2018, "title", "description");
        String mssg = "\t4/3/2018 at 1:15am ,title, description\n";
        assertEquals(mssg, appt.toString());
        appt.setStartHour(12);
        mssg = "\t4/3/2018 at 12:15pm ,title, description\n";
        assertEquals(mssg, appt.toString());
        appt.setStartHour(24);
        assertEquals(null, appt.toString());
        appt.setStartHour(11);
        mssg = "\t4/3/2018 at 11:15am ,title, description\n";
        assertEquals(mssg, appt.toString());
        appt.setStartHour(0);
        mssg = "\t4/3/2018 at 12:15am ,title, description\n";
        assertEquals(mssg, appt.toString());


    }

}