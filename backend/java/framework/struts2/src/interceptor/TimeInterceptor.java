package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by white on 17/6/22.
 */
public class TimeInterceptor extends AbstractInterceptor {


    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {

        long start = System.currentTimeMillis();
        //调用后续的action或者拦截器
        //如果action执行了
        System.out.println("before invoke");
        String result = actionInvocation.invoke();
        String className = actionInvocation.getAction().getClass().getSimpleName();
        String methodName = actionInvocation.getProxy().getMethod();
        System.out.println("after invoke");
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println(className + "." + methodName + " takes " + time + " ms");
        return result;
    }
}
