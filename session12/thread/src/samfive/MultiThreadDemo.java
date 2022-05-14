package samfive;

// Create multiple threads.
public class MultiThreadDemo {
    public static void main(String[] args) {
        NewThread nt1 = new NewThread("One");
        NewThread nt2 = new NewThread("Two");
        NewThread nt3 = new NewThread("Three");

        SampleRunnable sampleRunnable=new SampleRunnable();
        Thread tr=new Thread(sampleRunnable);
        tr.start();


// Start the threads.
        nt1.getTr().start();
        nt2.getTr().start();
        nt3.getTr().start();
        try {
// wait for other threads to end
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Main thread exiting.");
    }
}

