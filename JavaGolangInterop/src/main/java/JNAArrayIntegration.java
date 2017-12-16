import com.sun.jna.Memory;
import com.sun.jna.Native;

import java.io.IOException;

/**
 * Created by kanishka on 12/16/17.
 */
public class JNAArrayIntegration {
    void test() {
        //Native.extractFromResourcePath("lib/x64/mylib.so");
        MyLib myLib = Native.loadLibrary("lib/x64/mylib.so", MyLib.class);
        //java array
        long[] numArray = new long[]{10, 20, 50, 33, 100};
        //allocate memory for the array
        Memory arrayMem = new Memory(numArray.length * Native.getNativeSize(Long.TYPE));
        //create native array
        arrayMem.write(0, numArray, 0, numArray.length);
        //type mapping
        MyLib.GoSlice.ByValue goSlice = new MyLib.GoSlice.ByValue();
        goSlice.data = arrayMem;
        goSlice.len = numArray.length;
        goSlice.cap = numArray.length;
        //it's time to call native method!
        long sumResult = myLib.Sum(goSlice);
        System.out.println("Summation result : " + sumResult);

    }
}
