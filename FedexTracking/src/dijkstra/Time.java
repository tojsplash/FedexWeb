package dijkstra;

import java.util.Calendar;

public class Time {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance(); // gets a calendar using the default time zone and locale.
		calendar.add(Calendar.SECOND, 60);
		String time = String.valueOf(calendar.getTime());
		System.out.println(time);
/*		
		for(int i =0;i<5;i++){
			
		
		
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		time = String.valueOf(calendar.getTime());
		
		System.out.println(time);
		}
		
		*/
	}

}