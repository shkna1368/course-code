package samsix;


    class DemoJoin {
        public static void main(String[] args) {
            NewThread nt1 = new NewThread("One");
            NewThread nt2 = new NewThread("Two");
            NewThread nt3 = new NewThread("Three");
// Start the threads.
            nt1.getTr().start();
            nt2.getTr().start();
            nt3.getTr().start();
            System.out.println("Thread One is alive: "
                    + nt1.getTr().isAlive());
            System.out.println("Thread Two is alive: "
                    + nt2.getTr().isAlive());
            System.out.println("Thread Three is alive: "
                    + nt3.getTr().isAlive());
// wait for threads to finish

          //  System.out.println("Waiting for threads to finish.");

            try {
                System.out.println("Waiting for threads to finish.");
                nt1.getTr().join();
                nt2.getTr().join();
                nt3.getTr().join();
            } catch (InterruptedException e) {
                System.out.println("Main thread Interrupted");
            }
            System.out.println("Thread One is alive: "
                    + nt1.getTr().isAlive());
            System.out.println("Thread Two is alive: "
                    + nt2.getTr().isAlive());
            System.out.println("Thread Three is alive: "
                    + nt3.getTr().isAlive());
            System.out.println("Main thread exiting.");
        }
    }

