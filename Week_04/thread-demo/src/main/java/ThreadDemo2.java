import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ClassName: ThreadDemo2
 * Description:
 * Author: xyf
 * Date: 2020-11-11 20:21
 * Version: 1.0
 **/
public class ThreadDemo2
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(() -> 2);
        Integer ret = future.get();
        System.out.println(ret);
    }
}