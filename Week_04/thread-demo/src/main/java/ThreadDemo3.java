import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * ClassName: ThreadDemo3
 * Description:
 * Author: xyf
 * Date: 2020-11-11 20:25
 * Version: 1.0
 **/
public class ThreadDemo3
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 2);
        Integer ret = future.get();
        System.out.println(ret);
    }
}