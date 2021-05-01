import java.util.Random;

public class Test {
	public static void main(String[] args) throws Exception {
		
		System.out.printf("size \t timeAdd(ns) \t timePop(ns) \n");
		
		for (int n = 100; n <= 1000000; n *= 100) {
			int[] d = new int[n];
            for (int i = 0; i < n; i++) d[i] = i;
    	    Random rnd = new Random(1234567);
       	    for (int i = d.length - 1; i > 0; i--) swap(d, i, rnd.nextInt(i));
	        long time = 0;
	        
            int[] t = (int[])d.clone();
            Heap x = new Heap();
            long start = System.nanoTime();
            
            testAdd(t, x);
            long afterAdd = System.nanoTime();
            testPop(t, x);
            
            long end = System.nanoTime();
            
            long add = afterAdd - start;
            long pop = end - afterAdd;
 

	        System.out.printf("%d \t %d \t %d \n", n, add, pop);
		}
		System.out.println("Finished");

	}
	public static void testAdd(int[] t, Heap x) {
		for (int i=0;i < t.length;i++) {
        	x.add(t[i]);
        }
	}
	
	public static void testPop(int[] t, Heap x) throws Exception {
		for (int i=0;i < t.length;i++) {
        	x.pop();
        }
	}
	
	private static void swap(int[] d, int i, int j) {
	    int t = d[i]; d[i] = d[j]; d[j] = t;
	}
}
