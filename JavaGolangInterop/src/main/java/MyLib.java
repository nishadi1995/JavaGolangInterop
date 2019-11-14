import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kanishka on 12/9/17.
 */
public interface MyLib extends Library {

    //typedef struct { const char *p; GoInt n; } GoString;
    public class GoString extends Structure {
        public static class ByValue extends GoString implements Structure.ByValue {
        }

        public String p;
        public long n;

        protected List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"p", "n"});
        }
    }

    //typedef struct { void *data; GoInt len; GoInt cap; } GoSlice;
    public class GoSlice extends Structure {
        public static class ByValue extends GoSlice implements Structure.ByValue {
        }

        public Pointer data;
        public long len;
        public long cap;

        protected List<String> getFieldOrder() {
            return Arrays.asList(new String[]{"data", "len", "cap"});
        }
    }

    //native functions
    public int Add(int a, int b);

    public double Cos(double x);

    public GoString.ByValue Base64(GoString.ByValue str);

    public long Sum(GoSlice.ByValue nums);

    public void ByteTest(GoSlice.ByValue data);

    public void FilePassTest(GoSlice.ByValue data);
}
