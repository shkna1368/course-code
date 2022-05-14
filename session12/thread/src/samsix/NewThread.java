package samsix;

// Using join() to wait for threads to finish.
class NewThread implements Runnable {
   private String name; // name of thread
 private    Thread tr;
    NewThread(String threadname) {
        name = threadname;
        tr = new Thread(this, name);
        System.out.println("New thread: " + tr);
    }
    // This is the entry point for thread.
    public void run() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " exiting.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Thread getTr() {
        return tr;
    }

    public void setTr(Thread tr) {
        this.tr = tr;
    }
}