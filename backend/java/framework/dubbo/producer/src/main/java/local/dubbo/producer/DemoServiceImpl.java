package local.dubbo.producer;

import local.dubbo.service.DemoService;
import com.alibaba.dubbo.rpc.RpcContext;

public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        return "Hello " + name + ", response form provider: " + RpcContext.getContext().getLocalAddress();
    }

}
