
public class HeapSort {

	public static double heapTime(int []A, int n) 
	{
		int heapSizeA = A.length;
		double start = System.currentTimeMillis();
		heapSort(A, heapSizeA);
		double end = System.currentTimeMillis();
		return end - start;
	}
	public static void MAX_HEAPIFY(int []A, int i, int heapSizeA)
	{//노드 i를 루트로 하는 서브트리를 heapify 한다.
		while((2*i+1)<heapSizeA) {
			int k=0;
			if((2*i+2)>= heapSizeA) k = 2*i+1;
			else { 
				int max = Math.max(A[2*i+1], A[(2*i)+2]);
				if (max == A[2*i+2]) k = 2*i+2;
				else if (max == A[2*i+1]) k = 2*i+1;
			}			
			if(A[i]>=A[k]) return;
			swap(A,i,k);
			i=k;
		}
	}
	public static void swap(int []A, int a, int b)
	{
		int tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
	}
	public static void Build_Max_heap(int []A,int heapSizeA)
	{
		for(int i=(heapSizeA/2)-1 ; i>=0 ;i--)
		{
			MAX_HEAPIFY(A,i,heapSizeA); 
		}
	}
	public static void heapSort(int []A,int heapSizeA)
	{
		Build_Max_heap(A,heapSizeA);
		for(int i=heapSizeA-1; i>=1 ; i--) {
			swap(A,0,i);
			heapSizeA -= 1;
			MAX_HEAPIFY(A,0,heapSizeA);
		}
	}
}
