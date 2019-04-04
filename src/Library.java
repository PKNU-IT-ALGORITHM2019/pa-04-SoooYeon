import java.util.Arrays;

public class Library {
	public static double librarySortTime(int []A, int n) 
	{
		double start = System.currentTimeMillis();
		Arrays.sort(A);
		double end = System.currentTimeMillis();
		return end - start;
	}
}
