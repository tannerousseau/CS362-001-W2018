package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Generate Random Tests that tests Appt Class.
	 */
	@Test
	public void radnomtest()  throws Throwable  {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				int appts = 0;
				int startDay = ValuesGenerator.getRandomIntBetween(random,-5,35);
				int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 12);
				int startYear=ValuesGenerator.getRandomIntBetween(random, 0, 5000);
				GregorianCalendar temp = new GregorianCalendar(startYear, startMonth, startDay);
				CalDay calday = new CalDay(temp);
				for (int i = 0; i < NUM_TESTS; i++) {
					int startMinute = ValuesGenerator.getRandomIntBetween(random, -30, 90);
					int startHour = ValuesGenerator.getRandomIntBetween(random, -30, 90);

					String title="Birthday Party";
					String description="This is my birthday party.";
					//Construct a new Appointment object with the initial data
					Appt appt = new Appt(startHour,
							startMinute,
							startDay,
							startMonth,
							startYear,
							title,
							description);

					calday.addAppt(appt);
					if(appt.getValid()){
						appts++;
					}
					assertEquals(appts, calday.getAppts().size());

				}

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		System.out.println("Done testing...");
	}



}