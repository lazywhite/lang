package executor;

import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;

/**
 * Created by white on 17/6/24.
 */
public class TestExecutor implements Runnable {

    private AsyncContext ac = null;
    public TestExecutor(AsyncContext ac){
        this.ac = ac;
    }
    @Override
    public void run() {
        try{
            Thread.sleep(5 * 1000);
            ServletRequest req = ac.getRequest();
            req.setAttribute("message", "printed by async servlet");
            ac.dispatch("/async.jsp");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
