线程处于就绪和运行状态, isAlive()返回true, 其他返回false
Thread.currentThread().getId()返回线程的唯一标示
终止正在运行的线程的方法
    使线程正常退出
    使用stop方法强行终止, 但不推荐, 跟suspend(), resume()一样已经废弃
    使用interrupt()终止
        return 
        raise InterruptException
Thread.sleep()需要捕获InterruptedException
如果线程正在执行sleep(), 此时对其调用interrupt(), 则线程直接进入catch语句, 并且isInterrupted()返回false
stop()会强制停止线程
    导致清理工作无法完成
    会自动释放掉获得的锁
yield()的作用是放弃当前cpu资源, 让给其他任务去执行, 但放弃的时间不确定, 有可能刚放弃又得到cpu时间片
java中, 线程的优先级具有继承性, 如果A线程启动B线程, 则B线程的优先级跟A是一样的
高优先级的线程更容易得到cpu时间片, 仅此而已
线程分为两种: 用户线程, 守护线程, 当用户线程全部退出, 则守护线程将自动销毁
进程退出, 则所有线程也退出
因为方法内部的变量是私有的, 所以局部变量永远是线程安全的, 只有实例变量才会牵扯到线程安全
sychronized 取得的锁是基于对象的, 只有多个线程访问通过一个对象才生效, 有多少个对象会产生多少个对应的锁
Obj具有sync methodA, sync methodB, async methodC, 线程A执行methodA时, 线程B可执行methodC, 阻塞在methodB
通过synchronized获取的对象锁是可重入的, sync方法内部可调用自身其他的sync方法
子类可以通过sync可重入锁执行父类的sync 方法
当线程执行出现异常时, 会自动释放所持有的锁
synchronized(this){}可以修饰方法内的一段代码, 其他部分仍是async执行的
如果线程A正在执行Obj的一个方法内的sync(this)代码块, 则线程B对obj所有其他方法中的sync(this)代码段的访问将被阻塞
synchronized可以修饰静态方法,普通方法, 任意对象,this, class ,修饰静态方法相当于对class加锁, 修饰普通方法是对对象加锁, 修饰this也是对对象加锁
类锁可以对所有属于此类的对象生效
因为jvm有String常量池, 所以大多数情况下同步代码块不适用String作为锁对象

如果一个对象有两个sync方法, 其中一个是死循环, 则其他线程永远无法执行另一个方法, 解决方法是使用同步块
jps jstack -l <pid>可检测是否存在死锁现象
a.join() 当前线程会等待a线程执行完毕才继续执行, 底层是wait()
a.join(time) 只等待一段时间
wait()会释放锁, sleep()不会释放
sleep()对象会让其他线程获取运行机会, 不考虑优先级, yield()则只会让优先级大于等于自己的线程运行
sleep()后进入TimeWaiting状态, yield()之后进入Runnable状态
新建的线程通过start()启动, 才能作为独立的线程接受线程调度器管理,  通过run()启动, 相当于在主线程执行了一个普通方法, 不是多线程
