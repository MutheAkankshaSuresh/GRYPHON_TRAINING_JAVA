package Calci;

class Print {
    public synchronized void show(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n * i);
        }
    }
}

class Table_5 extends Thread {
    Print f;

    Table_5(Print f) {
        this.f = f;
    }

    public void run() {
        f.show(5);
    }
}

class Table_7 extends Thread {
    Print s;

    Table_7(Print s) {
        this.s = s;
    }

    public void run() {
        s.show(7);
    }
}

public class Calci {
    public static void main(String[] args) {

        Print p1 = new Print();

        Table_5 t1 = new Table_5(p1);
        Table_7 t2 = new Table_7(p1);

        t1.start();
        t2.start();
    }
}
