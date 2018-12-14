import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class test
{
	public static void main(String[] args)
	{
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy MM dd");
		String exDates = "2018 01 31&";
		String string1 = exDates.substring(0, exDates.indexOf("&"));
		System.out.println(string1);
		
		LocalDate localDate = LocalDate.now();
		String string2 = DateTimeFormatter.ofPattern("yyyy MM dd").format(localDate);
        
		try {
		    Date date1 = myFormat.parse(string1);
		    Date date2 = myFormat.parse(string2);
		    long diff = date2.getTime() - date1.getTime();
		    System.out.println ("Days: " + (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1));
		} catch (ParseException e) {
		    e.printStackTrace();
		}
	}
}
