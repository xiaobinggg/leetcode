import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(2048 / 1024);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = "2019-04-08 17:43:02";
		System.out.println(currentTime + "!!!!!!!!!!!!!!");
		try {
			Date d = sdf.parse(currentTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
