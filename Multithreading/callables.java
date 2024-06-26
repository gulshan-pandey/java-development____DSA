
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;


//Wap create a fixed thred pool with a specified number of threads using fixedThread,submit multiple tasks to the executor,where each task should print the current thread's name and sleep for a random time between 1 and 5000 millisec.

class que2 implements Runnable {
    private int number;

    public que2(int number) {
        this.number = number;
    }

    private int getrandom() {
        double random = Math.random() * 5 + 1;
        return (int) random;
    }

    public void run() {

        System.out.println("started thread : " + Thread.currentThread().getName());
        try {
            Thread.sleep(getrandom() * 1000);
        } catch (InterruptedException e) {

        }
        System.out.println("ended Thread: " + Thread.currentThread().getName() + number);

    }

}

// Que2-- WAP uses an executor service to execute multiple Callable tasks.Each
// task should calculate and return the factorial of a number provided to it.Use
// Future objects to receive th results of the calcultaiopns.Aftwer all tasks
// are submitted,retrieve the result from the future,print them,and ensure the
// execurtor service sutsdown correctly!

class FetchFactorial implements Callable<Integer> {

    private final int num;

    public FetchFactorial(int n) {
        this.num = n;
    }

    public int fact(int num)  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }


    @Override
    public Integer call() throws InterruptedException {

        Thread.sleep(1000);
        return fact(num);
    }

}







public class callables {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        
        // ExecutorService executor = Executors.newFixedThreadPool(5);
        // for (int i = 0; i < 10; i++) {
        // que2 task = new que2(i);
        // executor.submit(task);
        // }
        // // this is wrapped in try with resoucess in which twe dont need to shutdown the executor ...try with resourse will take care of this
        // if (!executor.awaitTermination(4, TimeUnit.SECONDS)) {
        // System.out.println("emergency shuttingdown");
        // executor.shutdownNow();
        // }
    
        









        ExecutorService services = Executors.newFixedThreadPool(3);
            System.out.println("printing the factorial of 19,17,15,13,11,9,7,5,3");
         List<Future<Integer>> list =  new ArrayList<>();
        int j = 19;
        while (j > 2) {
            FetchFactorial fxt = new FetchFactorial(j);
            list.add(services.submit(fxt));
            j = j - 2;
        }
        for (Future<Integer> future : list) {
            System.out.printf("\n Result of factorial is : %d ",future.get());
        }

        services.shutdown();

        if(!services.awaitTermination(3,TimeUnit.SECONDS)){
            System.out.println("enough timeout shutting down");
            services.shutdownNow();
        }

    
    }

    

}

