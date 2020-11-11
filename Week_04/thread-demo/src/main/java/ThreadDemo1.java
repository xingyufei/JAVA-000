import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * ClassName: ThreadDemo1
 * Description:
 * Author: xyf
 * Date: 2020-11-11 20:10
 * Version: 1.0
 **/
public class ThreadDemo1
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        FutureTask<Integer> futureTask = new FutureTask(()->2);
        Thread thread = new Thread(futureTask);
        thread.start();
        Integer ret = futureTask.get();
        System.out.println(ret);
    }
}