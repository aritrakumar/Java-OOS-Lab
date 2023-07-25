
/*



24) Consider the following parallel binary search algorithm for series a1, a2…an sorted in
increasing order such that n mod 10 = 0. Element to be searched is e.
a) Create n/10 threads t1, t2,..,tn/10.
b) Distribute the numbers among threads such that ti will have numbers ai, ai+1, ….a2i-1.
c) Distribute the element e to all threads.
d) Each thread searches the element e in its sub-array using binary search algorithm.

*/



class BinarySearch {

    public int index;
    int key;
    private int ar[];

    BinarySearch(int ar[]) {
        this.ar = ar;
        index = -1;
        if (ar.length % 10 != 0) throw new IllegalArgumentException("Error!!");

    }

    public int bSearch(int key) throws InterruptedException {
        this.key = key;
        SearchTheard stAr[] = new SearchTheard[ar.length/10];
        for (int i = 0; i < ar.length / 10; i++) {
            stAr[i] = new SearchTheard(i * 10, (i + 1) * 10 - 1);
            stAr[i].start();
        }
        for (int i = 0; i < ar.length / 10; i++) {
            stAr[i].join();
        }
        return index;
    }

    class SearchTheard extends Thread {

        int lo;
        int hi;

        SearchTheard(int lo, int hi) {
            this.hi = hi;
            this.lo = lo;
        }

        public void run() {
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (ar[mid] == key) {
                    index = mid;
                    break;
                } else if (ar[mid] < key) lo = mid + 1;
                else hi = mid - 1;
            }
        }
    }


}


public class MainThread6 {
    public static void main(String[] args) {
        int ar[] = new int[20];

        for (int i = 0; i < 20; i++) {
            ar[i] = i + 1;
        }

        BinarySearch obj = new BinarySearch(ar);

        try {
            System.out.println(obj.bSearch(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
