
import java.util.Arrays;
import java.util.Comparator;

public class log_csv {	
	public String IP;
	public String Time;
	public String URL;
	public String Status;

	public log_csv(String IP, String Time, String URL, String Status) {
		this.IP = IP;
		this.Status = Status;
		this.Time = Time;
		this.URL= URL;
	}
	public static Comparator<log_csv> IPComparator = new Comparator<log_csv>() {
		public int compare(log_csv log1,log_csv log2) {
			log_csv[] log= new log_csv[2];
			log[0]=log1;
			log[1]=log2;
			if(log1==null) return 0;
			if(log2==null) return 0;
			if(log1.IP.compareTo(log2.IP)==0) {
				Arrays.sort(log,TimeComparator);
				return 0;
			}
			return log1.IP.compareTo(log2.IP);		
		}
	};
	public static Comparator<log_csv> TimeComparator = new Comparator<log_csv>() {
		public int compare(log_csv log1,log_csv log2) {
			int Day1=0, Day2=0;
			int Mon1=0, Mon2=0;
			int Year1=0, Year2=0;
			int sec1=0,sec2=0;
			int min1=0,min2=0;
			int hour1 =0,hour2=0;
			String []tmp = new String[1000];
			String []temp = new String[1000];
			if(log1==null) return 0;
			tmp = log1.Time.split(":");
			temp = tmp[0].split("/");
			Day1 = Integer.parseInt(temp[0].substring(1));
			Mon1 = Month(temp[1]);
			Year1 = Integer.parseInt(temp[2]);
			hour1 = Integer.parseInt(tmp[1]);
			min1 = Integer.parseInt(tmp[2]);
			sec1 = Integer.parseInt(tmp[3]);
			if(log2==null) return 0;
			String []tmp2 = new String[1000];
			String []temp2 = new String[1000];
			tmp2 = log2.Time.split(":");
			temp2 = tmp2[0].split("/");
			Day2 = Integer.parseInt(temp2[0].substring(1));
			Mon2 = Month(temp2[1]);
			Year2 = Integer.parseInt(temp2[2]);
			hour2 = Integer.parseInt(tmp2[1]);
			min2 = Integer.parseInt(tmp2[2]);
			sec2 = Integer.parseInt(tmp2[3]);
			
			if(Year1 == Year2) {
				if(Mon1 == Mon2) {
					if(Day1 == Day2) {
						if(hour1 == hour2) {
							if(min1 == min2) {
								return sec1-sec2;
							}
							else return min1-min2;
						}
						else return hour1 - hour2;
					}
					else return Day1-Day2;
				}
				else return Mon1-Mon2;
			}
			else return Year1-Year2;		
		}
	};
	public static int Month(String mon)
	{
		if(mon.equalsIgnoreCase("Jan")) return 1;
		else if(mon.equalsIgnoreCase("Feb")) return 2;
		else if(mon.equalsIgnoreCase("Mar")) return 3;
		else if(mon.equalsIgnoreCase("Apr")) return 4;
		else if(mon.equalsIgnoreCase("May")) return 5;
		else if(mon.equalsIgnoreCase("Jone")) return 6;
		else if(mon.equalsIgnoreCase("July")) return 7;
		else if(mon.equalsIgnoreCase("Aug")) return 8;
		else if(mon.equalsIgnoreCase("Sept")) return 9;
		else if(mon.equalsIgnoreCase("Oct")) return 10;
		else if(mon.equalsIgnoreCase("Nov")) return 11;
		else if(mon.equalsIgnoreCase("Dec")) return 12;		
		return -1;
	}
}
