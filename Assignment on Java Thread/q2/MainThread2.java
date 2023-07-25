
/*



20) Create two threads and call them EvenThread and OddThread. EvenThread will print number
as 2 4 6 8 10... and OddThread will print number as 1 3 5…. Now synchronize these two thread
to get the output as 1 2 3 4 5 6 7 8.

*/



public class MainThread2 {
    int count = 1;
    static int N;

    public void oddNum(){
        synchronized(this){
            while(count<N){
                while(count%2==0){
                    try{
                        wait();
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }

                System.out.print(count+" ");
                count++;
                notify();
            }
        }
    }

    public void evenNum(){
        synchronized(this){
            while(count<=N){
                while(count%2==1){
                    try{
                        wait();
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }

                System.out.print(count + " ");
                count++;
                notify();
            }
        }
    }

    public static void main(String []args){
        N = 10;
        MainThread2 obj = new MainThread2();

        Thread OddPrint = new Thread(new Runnable(){
            public void run(){
                obj.oddNum();
            }
        });
        Thread EvenPrint = new Thread(new Runnable(){
            public void run(){
                obj.evenNum();
            }
        });

        OddPrint.start();
        EvenPrint.start();
    }
}
