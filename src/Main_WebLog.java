import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main_WebLog {
	public static int BUFFER_SIZE = 100000;
	public static int size=0;
	public static log_csv []log = new log_csv[BUFFER_SIZE];
	public static boolean sortTime=false;
	public static boolean sortIP = false;
	public static void main(String[] args) {

		String command = null; 
		String readfile = null;
		Scanner kb = new Scanner(System.in);
		while(true) {
			String data=null;
			System.out.print("$ ");
			command = kb.next();			
			if(command.equals("read")) { 
				readfile = kb.next();
				Read(readfile);
			}
			else if(command.equals("sort")) {
				data = kb.nextLine();
				data = data.substring(1);
				if(data.equals("-ip")) Sort_ip();
				else if(data.equals("-t")) Sort_time();
			}
			else if(command.equals("print")) {		
				Print();
			}
			else if(command.equals("exit")) break;
			else break;

		}kb.close();

	}
	public static void Read(String readfile)
	{				
		boolean First=false;
		FileReader f_reader = null;
		try {
			String cvsSplitBy = ",";
			f_reader = new FileReader(readfile);
			BufferedReader inFile = new BufferedReader(f_reader);
			while(true) {
				String tmp=null;
				tmp = inFile.readLine();
				if(tmp==null) break;
				String[] token = tmp.split(cvsSplitBy);
				String IP=null;
				String Time = null;
				String URL = null;
				String Status = null;
				IP=token[0];
				Time = token[1];
				URL = token[2];
				Status = token[3];
				if(First) {log[size] = new log_csv(IP,Time,URL,Status);size++;}
				First=true;
			}
			inFile.close();
			f_reader.close();

		}catch(FileNotFoundException e){e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
	}
	public static void Sort_time()
	{				
		Arrays.sort(log,log_csv.TimeComparator);
		sortTime=true;
	}
	public static void Sort_ip()
	{
		Arrays.sort(log, log_csv.IPComparator);
		sortIP=true;
	}
	public static void Print()
	{
		if(sortTime) {
			for(int i=0;i<size;i++) {
				System.out.println(log[i].Time.substring(1));
				System.out.println("\tIP: "+log[i].IP);
				System.out.println("\tURL: "+log[i].URL);
				System.out.println("\tStatus: "+log[i].Status);
			}	
			sortTime=false;
		}
		else if(sortIP) {
			for(int i=0;i<size;i++) {
				System.out.println(log[i].IP);
				System.out.println("\tTime: "+log[i].Time.substring(1));
				System.out.println("\tURL: "+log[i].URL);
				System.out.println("\tStatus: "+log[i].Status);
			}	
			sortIP=false;
		}
		else {
			for(int i=0;i<size;i++) {
				System.out.println("\tTime: "+log[i].Time.substring(1));
				System.out.println("\tIP: "+log[i].IP);
				System.out.println("\tURL: "+log[i].URL);
				System.out.println("\tStatus: "+log[i].Status);
			}	
		}
	}

}
