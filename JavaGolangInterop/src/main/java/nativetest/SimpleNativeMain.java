package nativetest;

import com.sun.jna.Native;

public class SimpleNativeMain {
    public static void main(String[] args) {
        //Native.extractFromResourcePath("lib/x64/mylib.so");
        MyLibSimple myLib = Native.loadLibrary("lib/x64/mylib.so", MyLibSimple.class);

        int nativeSum = myLib.Add(10,20);
        System.out.println(nativeSum);

        for (int i = 0; i < 100; i++) {
            myLib.SetNum(i);
            System.out.println(myLib.GetNum());
        }
    }
}


/**
 go build -o mylib.so -buildmode=c-shared mylib.go
 cp mylib.so JavaGolangInterop/src/main/resources/lib/x64/

 **/