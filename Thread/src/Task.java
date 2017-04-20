/**
 * Created by aravindheswaran on 4/9/17.
 */

public class Task implements Runnable{
    String taskName;
    int fileOperation;

    public Task(String name, int fileOperation){
        this.taskName = name;
        this.fileOperation = fileOperation;
    }

    @Override
    public void run(){
        System.out.println(taskName + " has started executing, " + "and it will sleep for " + fileOperation + " milliseconds");
        try {
            Thread.sleep(fileOperation);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(taskName + " has finished execution");
    }
}
