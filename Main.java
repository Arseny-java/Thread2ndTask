import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> myCallable1 = new MyCall(1, "Задача 1");
        Callable<Integer> myCallable2 = new MyCall(2, "Задача 2");
        Callable<Integer> myCallable3 = new MyCall(3, "Задача 3");
        Callable<Integer> myCallable4 = new MyCall(4, "Задача 4");

        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        Future<Integer> task1 = threadPool.submit(myCallable1);
        Future<Integer> task2 = threadPool.submit(myCallable2);
        Future<Integer> task3 = threadPool.submit(myCallable3);
        Future<Integer> task4 = threadPool.submit(myCallable4);

        System.out.println("Результат Задачи 1 = " + task1.get());
        System.out.println("Результат Задачи 2 = " + task2.get());
        System.out.println("Результат Задачи 3 = " + task3.get());
        System.out.println("Результат Задачи 4 = " + task4.get());

        List<Callable<Integer>> list = new ArrayList<>();
        list.add(myCallable1);
        list.add(myCallable2);
        list.add(myCallable3);
        list.add(myCallable4);

        System.out.println();
        Integer fastest = threadPool.invokeAny(list);
        System.out.println("Самая быстрая задача на диком Западе: " +  fastest);

        threadPool.shutdown();
    }
}
