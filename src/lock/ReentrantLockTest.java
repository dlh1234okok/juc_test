package lock;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dulihong
 * @since 2020-06-29
 */
public class ReentrantLockTest {

    private static final Lock lock = new ReentrantLock();

    public int publicSource = 0;

    Set<Integer> hisSource = new HashSet<>();

    public static void main(String[] args) {
        new ReentrantLockTest().complete();
    }

    public void complete() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                increment();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                increment();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                increment();
            }
        }).start();
        // System.out.println("size:" + hisSource.size());
    }

    public void increment() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 1
        /*publicSource++;
        System.out.println(publicSource);*/
        // 2
        /*try {
            lock.lock();
            publicSource++;
        } catch (Exception e) {
            // todo
        } finally {
            lock.unlock();
        }
        System.out.println(publicSource);*/
        //3
        /*lock.tryLock();
        publicSource++;
        System.out.println(publicSource);*/
    }
}



