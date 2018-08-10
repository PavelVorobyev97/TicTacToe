package tictactoe;

public class ThreadThree implements Runnable {

    private Thread self;
    private Monitor mon;

    public ThreadThree(Monitor mon) {

        self = new Thread(this);
        this.mon = mon;

    }

    void start() {
        self.start();
    }

    void join() {
        try {
            self.join();
        } catch (InterruptedException ex) {
            //...
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1);

            for (int i = 0; i < 10; i++) {
                System.out.println("Toe");

                synchronized (mon) {
                    mon.sync = 1;
                    mon.notifyAll();
                    if (mon.sync != 3 && i < 9) {
                        mon.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            //...
        }

    }

}
