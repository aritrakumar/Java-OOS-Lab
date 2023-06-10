
/*

Name : ARITRA KUMAR
Roll No. 302211001010
BE IT UG2 A3

23) Consider the series 1+2+3+…+100. This can be considered as
(1+3+5+…+99)+(2+4+6+…+100). Create two threads to compute two series in parallel (do not
use simplified equation). Finally print the final sum.

*/



public class MainThread5 {

    int flag = 1;
    int evensum =0;
    int oddsum = 0;
    static int n;

    public void evenSum(){
        synchronized(this){
            while(flag<=n){
                if(flag %2 == 0){
                    evensum += flag;
                }
                flag++;
                notify();
            }

            System.out.println("Even Sum is : "+ evensum);
        }
    }

    public void oddSum(){
        flag = 1;
        synchronized(this){
            while(flag<n){
                if(flag %2 == 1){
                    oddsum += flag;
                }
                flag++;
                notify();
            }

            System.out.println("Odd Sum is : "+ oddsum);
        }
    }

    public void finalSum(){
        int sum = oddsum + evensum;

        System.out.println("Final Sum is : "+ sum);
    }
    public static void main(String []args){
        n = 100;
        MainThread5 obj = new MainThread5();
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                obj.evenSum();
            }
        });
        Thread t2 = new Thread(new Runnable(){
            public void run(){
                obj.oddSum();
                obj.finalSum();
            }
        });

        t1.start();
        t2.start();

    }
}
