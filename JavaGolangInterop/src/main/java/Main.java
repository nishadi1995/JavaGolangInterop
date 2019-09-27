/**
 * Created by kanishka on 12/9/17.
 */
public class Main {

    public static void main(String[] args) {
        new Main().testBasicJNAIntegration();
    }
    
    private void testJNAArrays() {
        new JNAArrayIntegration().test();
    }

    private void testBasicJNAIntegration(){
        new BasicJNAIntegration().test();
    }
    
}
