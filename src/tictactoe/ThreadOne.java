package tictactoe;

public class ThreadOne implements Runnable {

    private Thread self;
    private Monitor mon;

    public ThreadOne(Monitor mon) {

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
            for (int i = 0; i < 10; i++) {
                System.out.print("Tic-");
                
                synchronized (mon) {
                    mon.sync = 2;
                    mon.notifyAll();
                    if (mon.sync != 1 && i < 9) {
                        mon.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            //...
        }

    }

}
