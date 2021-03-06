package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁
 * @Author qiangl
 * Created by qgl on 2018/10/24.
 */
public class ReentrantLockDemo {

    private static int count = 0;
    static Lock lock = new ReentrantLock();
    public static void inc(){
        lock.lock();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count ++;
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        //
        for(int i =0;i<10000;i++){
            new Thread(()->{ReentrantLockDemo.inc();}).start();
        }
        Thread.sleep(20000);
        System.out.println(count);

    }

}
