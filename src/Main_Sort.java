
public class Main_Sort {
	public static int N1 = 1000;
	public static int N2 = 10000;
	public static int N3 = 100000;
	public static int [] data_ran = new int [N1];
	public static int [] data_ran2 = new int [N2];	
	public static int [] data_ran3 = new int [N3];

	public static int [] data_tmpran = new int [N1];
	public static int [] data_tmpran2 = new int [N2];	
	public static int [] data_tmpran3 = new int [N3];

	public static int [] data_rev = new int [N1];
	public static int [] data_rev2 = new int [N2];
	public static int [] data_rev3 = new int [N3];
	public static void main(String[] args) {
		double HsumTime1=0,HsumTime2=0,HsumTime3=0;
		double LsumTime1=0,LsumTime2=0,LsumTime3=0;
		System.out.println("\t\tRandom1000\tReverse1000\tRandom10000\tReverse10000\tRandom100000\tReverse100000");

		for(int i=0;i<10;i++) {
			data_ran=madeRandom(N1);
			data_ran2=madeRandom(N2);
			data_ran3=madeRandom(N3);

			System.arraycopy(data_ran, 0, data_tmpran, 0, N1);
			System.arraycopy(data_ran2, 0, data_tmpran2, 0, N2);
			System.arraycopy(data_ran3, 0, data_tmpran3, 0, N3);

			HsumTime1 += HeapSort.heapTime(data_ran, N1);
			HsumTime2 += HeapSort.heapTime(data_ran2, N2);
			HsumTime3 += HeapSort.heapTime(data_ran3, N3);

			System.arraycopy(data_tmpran, 0, data_ran, 0, N1);
			System.arraycopy(data_tmpran2, 0, data_ran2, 0, N2);
			System.arraycopy(data_tmpran3, 0, data_ran3, 0, N3);
			
			LsumTime1 += Library.librarySortTime(data_ran, N1);
			LsumTime2 += Library.librarySortTime(data_ran2, N2);
			LsumTime3 += Library.librarySortTime(data_ran3, N3);
		}
		data_rev = madeReverse(N1);
		data_rev2 = madeReverse(N2);
		data_rev3 = madeReverse(N3);
		System.out.print("Heap\t\t"+HsumTime1/10000);
		System.out.print("\t\t"+HeapSort.heapTime(data_rev, N1)/1000);
		System.out.print("\t\t"+HsumTime2/10000);
		System.out.print("\t\t"+HeapSort.heapTime(data_rev2, N2)/1000);
		System.out.print("\t\t"+HsumTime3/10000); 
		System.out.println("\t\t"+HeapSort.heapTime(data_rev3, N3)/1000);
		data_rev = madeReverse(N1);
		data_rev2 = madeReverse(N2);
		data_rev3 = madeReverse(N3);
		System.out.print("Library\t\t"+LsumTime1/10000);
		System.out.print("\t\t"+Library.librarySortTime(data_rev, N1)/1000);
		System.out.print("\t\t"+LsumTime2/10000);
		System.out.print("\t\t"+Library.librarySortTime(data_rev2, N2)/1000);
		System.out.print("\t\t"+LsumTime3/10000); 
		System.out.println("\t\t"+Library.librarySortTime(data_rev3, N3)/1000);
	}
	public static int[] madeReverse(int n)
	{
		int [] data_rev = new int[n];
		int j=n;
		for(int i=0;i<n;i++) {
			data_rev[i] = j;
			j--;
		}
		return data_rev;
	}
	public static int[] madeRandom(int n)
	{
		int [] data_ran = new int[n];
		for(int k=0;k<n;k++) {
			data_ran[k] = (int)(Math.random()*n)+1;
		}
		return data_ran;
	}
}
