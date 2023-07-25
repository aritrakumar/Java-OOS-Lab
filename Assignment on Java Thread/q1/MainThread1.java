
/*



19) Write a program to create two threads. Print “In main thread” in main thread and “In child
thread” in child thread.

*/



class ChildThread extends Thread
{
    public void run() {
        System.out.println("In child thread");
    }
}

class MainThread {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println("In main thread");

        ChildThread ct= new ChildThread();
        ct.start();
    }
}
