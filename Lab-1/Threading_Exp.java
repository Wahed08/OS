package OOP;

/**
 *
 * @author wahed
 */
class Banking {

    int value = 100000;

    public synchronized void display(int value) {
        this.value = this.value - value;
    }
}

public class Threading_Exp {

    public static void main(String[] args) throws InterruptedException {
        Banking ob = new Banking();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                ob.display(1000);

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                ob.display(500);

            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {

                ob.display(300);

            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {

                ob.display(800);

            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        
        System.out.println("the count is: " + ob.value);
    }
}
