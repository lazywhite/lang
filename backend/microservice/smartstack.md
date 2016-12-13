## Introduction
smartstack is an automated service registration and discovery framework.  

## Automation requirements of a pool of services  
1. Backends capable of serving requests for a particular service would automatically receive these requests
2. Load would be intelligently distributed among backends, so no backend is ever doing more work than the rest and so that requests are automatically routed to the least busy backend
3. A backend that develops problems would automatically stop receiving traffic
4. It should be possible to remove load from a backend without affecting anything else in the system, so that debugging is possible
5. There should be perfect introspection, so that you always know which backends are available, what kind of load they are receiving, and from which consumers
6. Consumers should be minimally affected by changes in the list of backends; ideally, such changes would be transparent to consumers
7. There should be no single points of failure – the failure of any machine anywhere in the system should have no impact
     
Possible solutions  
1. DNS  
2. central load balancing  
3. in-app registration/discovery  
4. smartstack way  
## Keyword  
```
components
    nerve: create ephemeral nodes in zookeeper which contains information about the address/port combo for a  backend available to serve requests
            for a particular service, in order to know whether a particular backend could be registered, it do "health check"
    synapse: read information from "zookeeper", then configure the local "HAProxy"

```

