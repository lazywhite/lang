package listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Created by white on 17/6/11.
 */
public class RequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        ServletRequest req = servletRequestEvent.getServletRequest();
        System.out.println("request对象: " + req + " destroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        ServletRequest req = servletRequestEvent.getServletRequest();
        System.out.println("request对象: " + req + " initialized");

    }
}
