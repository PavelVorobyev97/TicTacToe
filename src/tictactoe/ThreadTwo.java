package tictactoe;

public class ThreadTwo implements Runnable {

    private Thread self;
    private Monitor mon;

    public ThreadTwo(Monitor mon) {

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
                System.out.print("Tac-");

                synchronized (mon) {
                    mon.sync = 3;
                    mon.notifyAll();
                    if (mon.sync != 2 && i < 9) {
                        mon.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            //...
        }
    }

}
