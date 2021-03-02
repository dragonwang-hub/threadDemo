package demo.thread.synchronizedRecursion;

public class SynchronizedRecursion {

    int countOne = 0;
    int countTwo = 0;

    // 在递归调用时不需要等上一次调用先释放后再获取，而是直接进入，这说明了synchronized的可重入性.
    synchronized void methodOne() {
        System.out.println("methodOne 正在执行， countOne = " + countOne);
        if (countOne == 0) {
            countOne++;
            methodOne();
        }
        System.out.println("methodOne 执行完毕， countOne = " + countOne);
    }

    synchronized void methodTwo() {
        System.out.println("methodTwo 正在执行， countTwo = " + countTwo);
        if (countTwo == 0) {
            methodOne();
        }
        System.out.println("methodTwo 执行完毕， countTwo = " + countTwo);
    }


}
