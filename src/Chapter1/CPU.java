package Chapter1;

/**
 * Created by shuoshu on 2018/1/1.
 */
public class CPU {
    public void showCPUUtilize() throws InterruptedException {
        while (true) {
            //busy
            for (int i =0; i < 9600000; i++) {

            }
            //idle
            Thread.sleep(10);
        }
    }
}
