package net.caimito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ScheduleTest {

	@Test
	public void tryIt() {
		Map<String, List<String>> schedule = new HashMap<>() ;
		
		schedule.put(WeekDays.MONDAY.name(), new ArrayList()) ;
		schedule.get(WeekDays.MONDAY.name()).add("breakfast") ;
		
		System.out.println(schedule);
	}
	
}
