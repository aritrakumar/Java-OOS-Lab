
/*



22) Consider a file that contains a number of integers. Create two threads. Call them ‘producer’
and ‘consumer’ thread. Producer thread will be reading the integers from the file continuously
while consumer thread will add them up. Use proper synchronization mechanism if needed.

*/



import java.io.*;

class MainThread4
{
    volatile int s = 10;
    public static void main(String args[])
    {
        MainThread4 m = new MainThread4();
        Producer p = new Producer(m);
        Consumer c = new Consumer(m);

        p.start();
        c.start();

        try
        {
            p.join();
            c.join();
        }
        catch(InterruptedException e)
        {}

        c.PrintSum();
    }

    synchronized int gets()
    {
        return s;
    }

    public void sets(int s)
    {
        synchronized(this)
        {
            this.s += s;}
    }
}

class Producer extends Thread
{
    MainThread4 m;
    Producer(MainThread4 m)
    {
        this.m = m;
    }
    public void run()
    {
        try(BufferedReader br = new BufferedReader(new FileReader("input")))
        {
            String line;
            line = br.readLine();
            while(line != null){
                m.sets(Integer.parseInt(line));
                line = br.readLine();

            }
        }
        catch(IOException e)
        {}
    }
}

class Consumer extends Thread
{
    MainThread4 m;
    int sum;
    Consumer(MainThread4 m)
    {
        sum = 0;
        this.m = m;
    }
    public void run()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch(Exception e){}
        sum+=m.gets();
    }

    void PrintSum()
    {
        System.out.println("Sum = "+sum);
    }
}
