
/*

Name : ARITRA KUMAR
Roll No. 302211001010
BE IT UG2 A3

25) Write a Java program using threading technology and print the thread index and location
where the element has been found.

*/




class BinarySearchMT {

    public int index;
    int key;
    private int ar[];

    BinarySearchMT(int ar[]) {
        this.ar = ar;
        index = -1;
        if (ar.length % 10 != 0) throw new IllegalArgumentException("Error!!");

    }

    public int bSearch(int key) throws InterruptedException {
        this.key = key;
        SearchThread stAr[] = new SearchThread[ar.length/10];
        for (int i = 0; i < ar.length / 10; i++) {
            stAr[i] = new SearchThread(i * 10, (i + 1) * 10 - 1);
            stAr[i].start();
        }
        for (int i = 0; i < ar.length / 10; i++) {
            stAr[i].join();
        }
        return index;
    }

    class SearchThread extends Thread {

        int lo;
        int hi;

        SearchThread(int lo, int hi) {
            this.hi = hi;
            this.lo = lo;
        }

        public void run() {
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (ar[mid] == key) {
                    System.out.println("Thread name : "+Thread.currentThread().getName() );
                    System.out.println("Thread id : "+Thread.currentThread().getId());
                    index = mid;
                    break;
                } else if (ar[mid] < key) lo = mid + 1;
                else hi = mid - 1;
            }
        }
    }


}


public class MainThread7 {
    public static void main(String[] args) {
        int ar[] = new int[20];

        for (int i = 0; i < 20; i++) {
            ar[i] = i + 1;
        }

        BinarySearchMT obj = new BinarySearchMT(ar);

        try {
            System.out.println("Index of 10 is : "+obj.bSearch(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}