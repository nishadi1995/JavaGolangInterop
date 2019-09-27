package nativetest;

import com.sun.jna.Library;

public interface MyLibSimple extends Library {

    public int Add(int a, int b);

    public void SetNum(int i);

    public int GetNum();
}
