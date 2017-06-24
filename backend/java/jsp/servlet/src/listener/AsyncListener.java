package listener;

import javax.servlet.AsyncEvent;
import java.io.IOException;

/**
 * Created by white on 17/6/24.
 */
public class AsyncListener implements javax.servlet.AsyncListener {

    @Override
    public void onComplete(AsyncEvent asyncEvent) throws IOException {
        System.out.println("async stopped");
    }

    @Override
    public void onTimeout(AsyncEvent asyncEvent) throws IOException {

    }

    @Override
    public void onError(AsyncEvent asyncEvent) throws IOException {

    }

    @Override
    public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
        System.out.println("async started");//不能捕获到开始事件

    }
}
