/**
 * Created by kanishka on 12/9/17.
 */
public class Main {

    public static void main(String[] args) throws Exception {
//        new Main().testBasicJNAIntegration();
        new Main().testJNAArrays();
    }
    
    private void testJNAArrays() throws Exception {
        new JNAArrayIntegration().test();
    }

    private void testBasicJNAIntegration(){
        new BasicJNAIntegration().test();
    }
    
}
