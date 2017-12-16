import com.sun.jna.Native;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by kanishka on 12/16/17.
 */
public class BasicJNAIntegration {

    void test() {
        //initial sleep until connected with visualvm
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long t1 = System.currentTimeMillis();

        goBase64();
//      javaBase64()

        long t2 = System.currentTimeMillis();
        System.out.println("Elapsed time : " + (t2 - t1) + " ms");

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done with the program!");
    }
    
    void goBase64() {
        MyLib myLib = Native.loadLibrary("lib/x64/mylib.so", MyLib.class);
//
//        System.out.println("10+20=" + myLib.Add(10, 20));
//        System.out.println("Cos(60)=" + myLib.Cos(60));

        MyLib.GoString.ByValue goStrInput = new MyLib.GoString.ByValue();
        goStrInput.p = RandomStringUtils.random(100000);
        goStrInput.n = goStrInput.p.length();

        for (int i = 0; i < 10000; i++) {
//            System.out.println("Input : " + goStrInput.p);
            MyLib.GoString.ByValue returnRef = myLib.Base64(goStrInput);
//            System.out.println(returnRef.p);
        }
        System.out.println("Done with shared calls");
    }

    void javaBase64() {
        String input = RandomStringUtils.random(100000);
        for (int i = 0; i < 10000; i++) {
            Base64.encode(input.getBytes());
        }
    }

}
