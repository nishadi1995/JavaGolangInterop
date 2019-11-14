import com.sun.jna.Memory;
import com.sun.jna.Native;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

/**
 * Created by kanishka on 12/16/17.
 */
public class JNAArrayIntegration {
    void test() throws Exception {
//        //Native.extractFromResourcePath("lib/x64/mylib.so");
//        MyLib myLib = Native.loadLibrary("lib/x64/mylib.so", MyLib.class);
//        //java array
//        long[] numArray = new long[]{10, 20, 50, 33, 100};
//        //allocate memory for the array
//        Memory arrayMem = new Memory(numArray.length * Native.getNativeSize(Long.TYPE));
//        //create native array
//        arrayMem.write(0, numArray, 0, numArray.length);
//        //type mapping
//        MyLib.GoSlice.ByValue goSlice = new MyLib.GoSlice.ByValue();
//        goSlice.data = arrayMem;
//        goSlice.len = numArray.length;
//        goSlice.cap = numArray.length;
//
//
//        //it's time to call native method!
//        long sumResult = myLib.Sum(goSlice);
//        System.out.println("Summation result : " + sumResult);
        System.out.println("Press any key to start");
        System.in.read();
        long t1 = System.currentTimeMillis();
        test3();
        long t2 = System.currentTimeMillis();
        System.out.println("Total time: " + (t2 - t1) + "\nPress anykey to exit");
        System.in.read();
    }

    void test2() throws Exception {
        MyLib myLib = Native.loadLibrary("lib/x64/mylib.so", MyLib.class);

        for (int i = 0; i < 10000; i++) {
            //get random bytes from random file
            byte[] data = readFile("/home/kanishka/tmp/randFile");

            //allocate memory for the array
            Memory arrayMem = new Memory(data.length * Native.getNativeSize(Byte.TYPE));

            //create native array
            arrayMem.write(0, data, 0, data.length);

            //type mapping
            MyLib.GoSlice.ByValue goSlice = new MyLib.GoSlice.ByValue();
            goSlice.data = arrayMem;
            goSlice.len = data.length;
            goSlice.cap = data.length;

            myLib.ByteTest(goSlice);
        }

    }

    void test3() throws Exception {
        MyLib myLib = Native.loadLibrary("lib/x64/mylib.so", MyLib.class);

        for (int i = 0; i < 10000; i++) {
            //get random bytes from random file
            byte[] data = "/home/kanishka/tmp/randFile".getBytes();
            //allocate memory for the array
            Memory arrayMem = new Memory(data.length * Native.getNativeSize(Byte.TYPE));

            //create native array
            arrayMem.write(0, data, 0, data.length);

            //type mapping
            MyLib.GoSlice.ByValue goSlice = new MyLib.GoSlice.ByValue();
            goSlice.data = arrayMem;
            goSlice.len = data.length;
            goSlice.cap = data.length;

            myLib.FilePassTest(goSlice);
        }

    }

    private byte[] readFile(String filePath) throws Exception {
        return IOUtils.toByteArray(new FileInputStream(filePath));
    }

}
