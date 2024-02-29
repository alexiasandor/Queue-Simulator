package Model;

import java.util.Comparator;

public class Task implements Comparable<Task>{
    private int id;
    private int arrivalTime;
    private int serviceTime;

    public Task(int id, int arrivalTime, int serviceTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }


    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }
    public int compareTo(Task tasks) {
        return this.arrivalTime-tasks.arrivalTime;
    }
    @Override
    public String toString() {
        return "Task(" + "id= " +id +", "+"timp sosire= " +arrivalTime+ ", "+"moment servire= "+ serviceTime + ")\n";
    }
}
