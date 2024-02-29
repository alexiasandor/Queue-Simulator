package BusinessLogic;

import GUI.SimulationFrame;
import Model.Server;
import Model.Task;
import Model.WriteFile;

import java.io.IOException;
import java.util.*;

public class SimulationManager implements Runnable{
    // date cititte de la UI
    public int timeLimit ;
    private int minimArrivalTime;
    private int maxArrivalTime;
    public int maxProcessingTime;
    public int minProcessingTime;
    public int numberOfServers;
    public int numberOfClients;
    private float averageWaitingTime;
    private WriteFile writeFile;
    public SelectionPolicy selectionPolicy =SelectionPolicy.SHORTEST_TIME;

    // entity responsible with queue manangement and client distribution
    private Scheduler scheduler;
    // frame for dsplaying simualtion
    private SimulationFrame frame;
    // pool of tasks (client shopping in the store)
    private List<Task> generatedTasks;
    public SimulationManager(SimulationFrame frame)throws IOException {
         this.frame=frame;
         this.numberOfServers=frame.getNrCozi();
         this.numberOfClients=frame.getNrClienti();
         this.timeLimit=frame.getField_limitTime();
         this.minimArrivalTime=frame.getTimp_min_sosire();
         this.maxArrivalTime=frame.getTimp_max_sosire();
         this.minProcessingTime=frame.getTimp_min_serv();
         this.maxProcessingTime=frame.getTimp_max_serv();
         this.writeFile= new WriteFile();
         this.writeFile.create();

        // se initializeaza scheduler:

        scheduler=new Scheduler(numberOfServers,numberOfClients,frame);
        generatedTasks= generateNRandomTasks(numberOfClients);
        System.out.println(("Clienti random: "+generatedTasks));

    }

    /*public static Comparator<Task> comparator = new Comparator<Task>() {
        public int compare(Task t1, Task t2) {
            return t1.getArrivalTime() - t2.getArrivalTime();
        }
    };*/
    private List <Task> generateNRandomTasks(int numberOfClients){
        Random rand = new Random();
        List<Task>tasks= new ArrayList<>();
        for(int i=0;i<numberOfClients;i++){
            int randArrivalTime=rand.nextInt(minimArrivalTime,maxArrivalTime);
            int randServiceTime=rand.nextInt(minProcessingTime,maxProcessingTime);
            Task task = new Task(i,randArrivalTime,randServiceTime);
            tasks.add(task);
        }
        Collections.sort(tasks);
        return tasks;
    }
    @Override
    public void run() {
        int currentTime=0;
        float waitingTime=0;
        while(currentTime<timeLimit) {
         System.out.println("\nTime "+ currentTime);
         frame.setTextArea("\nTime "+currentTime+"\n");
       //  int count=0;
            for (int i = 0; i < generatedTasks.size(); i++) {
                if (generatedTasks.get(i).getArrivalTime() == (currentTime)) {
                    scheduler.dispatchTask(generatedTasks.get(i));
                    generatedTasks.remove(generatedTasks.get(i));
                }
            }
            System.out.println("Clienti care asteapta sa intre: " +generatedTasks);
            frame.setTextArea("Clienti care asteapta sa intre: " +generatedTasks+"\n");
            try{
                writeFile.writeInFile("Clienti care asteapta sa intre: " +generatedTasks);
            }catch(IOException e){
                e.printStackTrace();
            }
            for(Task tasks:generatedTasks)
                waitingTime=waitingTime+tasks.getServiceTime();
                averageWaitingTime=waitingTime/frame.getNrClienti();

                try{
                    writeFile.writeInFile("Average waiting time is " + averageWaitingTime+"\n");

                }catch(IOException e){
                    e.printStackTrace();
                }
                System.out.println("Average waiting time is " +averageWaitingTime+ "\n");
                frame.setTextArea("average waiting time is "+ averageWaitingTime+ "\n");
                currentTime++;
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(Server s: scheduler.getServers())
                        s.notOK();

                }
          for(Thread thread : scheduler.getThreads()){
              thread.interrupt();
          }
    }

}
