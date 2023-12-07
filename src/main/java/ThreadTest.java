import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ThreadTest implements Runnable{

    FileWriter fileWriter;
    int id;

    public ThreadTest(int id, FileWriter fileWriter) throws IOException {
        this.id=id;
        this.fileWriter=fileWriter;
    }

    @Override
    public void run() {
        try {
            if(id==1) {
                Thread.sleep(1000);
            }
            fileWriter.write(""+this.id+" "+System.currentTimeMillis()+"\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Thread thread1 = new Thread(new ThreadTest(1,  new FileWriter(new File("test.txt"))));
        Thread thread2 = new Thread(new ThreadTest(2, new FileWriter(new File("test1.txt"))));
        Thread thread3 = new Thread(new ThreadTest(3,new FileWriter(new File("test2.txt"))));
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
    }
}
