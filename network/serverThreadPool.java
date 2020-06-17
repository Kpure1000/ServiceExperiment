package network;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class serverThreadPool {
    /**
     * 单例
     */
    private static serverThreadPool instance = new serverThreadPool();

    /**
     * 获取单例
     * 
     * @return 单例的实例
     */
    public static serverThreadPool getInstance() {
        return instance;
    }

    /*--------------------------------------*/

    /**
     * 核心数量
     */
    private static final int corePoolSize = Runtime.getRuntime().availableProcessors();

    /**
     * 最大核心线程数量
     */
    private static final int maximumPoolSize = Runtime.getRuntime().availableProcessors() * 2;

    /**
     * 任务结束后存活时间
     */
    private static final long keepAliveTime = 200;

    /**
     * 线程池
     */
    private static ThreadPoolExecutor pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
            TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(64));

    /**
     * 加入任务
     */
    public static void pushTask(serverTask task) {
        System.out.println("加入任务");
        pool.execute(task);
    }

    /**
     * 关闭线程池
     */
    public static void QuitPool() {
        if (pool.isShutdown())
            return;
        System.out.println("关闭线程池");
        pool.shutdown();
    }

    /**
     * 立刻终止线程池
     */
    public static void QuitPoolNow() {
        if (pool.isShutdown())
            return;
        System.out.println("强行关闭线程池");
        pool.shutdownNow();
    }
}