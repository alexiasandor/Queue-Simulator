package Model;

import GUI.SimulationFrame;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {
    private  SimulationFrame frame;
    private BlockingQueue<Task> tasks; // coada cu clienti
    AtomicInteger waitingPeriod; //cat asteapta
    WriteFile writeFile;
    private String string=" ";
    private boolean ok =true;
    public Server(SimulationFrame frame, WriteFile writeFile) throws IOException {
        this.waitingPeriod = new AtomicInteger();
        this.tasks= new LinkedBlockingDeque<>();
        this.frame= frame;
        this.writeFile= new WriteFile();
        this.writeFile.create();

    }
    public void addTask(Task newTask){
        this.tasks.add(newTask); // adaugam un nou task in coada
        waitingPeriod.getAndIncrement(); // crestem timpul de asteptare cu timpul necesar terminarii noului task
    }

    public BlockingQueue<Task> getTasks() {
        return tasks;
    }

    public void setTasks(BlockingQueue<Task> tasks) {
        this.tasks = tasks;
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }
    public void setWaitingPeriod(AtomicInteger waitingPeriod) {
        this.waitingPeriod = waitingPeriod;
    }
  public void notOK()
  {
      ok=false;
  }

    public void run() {
        while (ok) {
            Task t= tasks.peek(); //varful stivei
            if (t != null) {
                System.out.println(Thread.currentThread().getName()+ ": " + tasks );
                frame.setTextArea(Thread.currentThread().getName()+ ": " + tasks +"\n");
                try {
                    writeFile.writeInFile(Thread.currentThread().getName()+": "+   tasks+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                t.setServiceTime(t.getServiceTime()-1);
                waitingPeriod.getAndDecrement();
                if(t.getServiceTime()==0)
                    tasks.remove(t);
            } else{
                System.out.println(Thread.currentThread().getName()+"is closed");
                frame.setTextArea(Thread.currentThread().getName()+"is closed"+"\n");
                try{
                    writeFile.writeInFile(Thread.currentThread().getName()+"is closed");
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
    public String toString() {
        String string ="";
        for(Task t: tasks)
            string+=t.toString() +";";
        return string;
    }
}
