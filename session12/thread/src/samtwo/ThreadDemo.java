package samtwo;

class ThreadDemo {
    public static void main(String[] args) {



        NewThread nt = new NewThread(); // create a new thread
        Thread threadChild=new Thread(nt);
        threadChild.setName("child thread");
        threadChild.start();



        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");
    }
}