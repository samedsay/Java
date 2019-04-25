class Texts {
    private String txt = null;
    private boolean newTxt = false;

    // invoked by Author to set a new text
    synchronized public void setText(String s) {
        while (newTxt) {
            try {
                wait();
            } catch (InterruptedException exc) {
            }
        }
        txt = s;
        newTxt = true;
        notify(); //invoked on 'this'
    }

    synchronized public String getText() {
        while (!newTxt) {
            try {
                wait();  //invoked on 'this'
            } catch (InterruptedException exc) {
            }
        }
        newTxt = false;
        notify();
        return txt;
    }
}

class Publisher extends Thread {
    private Texts txtArea;

    public Publisher(Texts t) {
        txtArea = t;
    }

    public void run() {
        String txt = null;
        while ((txt = txtArea.getText()) != null) {
            System.out.println("-> " + txt);
        }
    }
}

class Author extends Thread {
    private Texts txtArea;

    public Author(Texts t) {
        txtArea = t;
    }

    public void run() {
        String[] texts = {"Hamlet", "War and Peace",
                "Macbeth", "The Trial", "Crime and Punishment",
                "Madame Bovary", null};
        for (int i = 0; i < texts.length; i++) {
            try {
                // writing a book takes some time...
                sleep((int) (1500 + Math.random() * 300));
            } catch (InterruptedException ignored) {
            }

            txtArea.setText(texts[i]);
        }
    }
}


public class TCoordThread {
    public static void main(String[] args) {
        Texts t = new Texts();
        Thread t1 = new Author(t);
        Thread t2 = new Publisher(t);
        t1.start();
        t2.start();
    }

}
