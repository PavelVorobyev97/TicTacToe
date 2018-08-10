package tictactoe;

public class TicTacToe {

    public static void main(String[] args) {
        Monitor monitor =  new Monitor();
        
        ThreadOne t1 = new ThreadOne(monitor);
        ThreadTwo t2 = new ThreadTwo(monitor);
        ThreadThree t3 = new ThreadThree(monitor);
        
        t1.start();
        t2.start();
        t3.start();
        
        t1.join();
        t2.join();
        t3.join();
    }
    
}
