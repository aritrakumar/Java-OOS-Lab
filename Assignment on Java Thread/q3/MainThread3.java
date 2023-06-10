
/*

Name : ARITRA KUMAR
Roll No. 302211001010
BE IT UG2 A3

21) Consider the following series
x = 1+1/1! +1/2! + 1/3! + ………1/10!
Create two threads t1 &amp; t2. t1 will generate the denominators and t2 will form the term and add
them up. Finally print the result.

*/



public class MainThread3 {
    static int N;
    double []arr = new double[N+1];
    int flag = 0;

    static double factorial(int n){
        return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);
    }

    public void calTerm(){
        synchronized(this){
            while(flag<=N){
                arr[flag] = ((double)1/factorial(flag));
                System.out.println("Term number "+(flag+1)+" is "+1+"/"+flag+"!");
                flag += 1;

                notify();
            }
        }
    }

    public void calSum(){
        double sumFinal = 0.0;
        synchronized(this){
            flag = 0;
            while(flag<=N){
                sumFinal = sumFinal + arr[flag];
                flag += 1;
                notify();
            }

            System.out.println("Final Sum = "+sumFinal);
        }
    }

    public static void main(String []args){
        N=10;
        MainThread3 obj = new MainThread3();
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                obj.calTerm();
            }
        });
        Thread t2 = new Thread(new Runnable(){
            public void run(){
                obj.calSum();
            }
        });

        t1.start();
        t2.start();
    }
}