import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Base{

}
public class Test extends Base{

//    public void test() {
//        System.out.println(this.getClass().getSuperclass().getCanonicalName());
//    }
//    public static void main(String[] args) {
//        Test test = new Test();
//        test.test();
//    }

    public static void main(String[] args){
        Queue<String> s = new LinkedList<String>();

        s.add("AB");
        s.add("BC");
        s.add("CD");

        StringBuilder sb = new StringBuilder();

        while(!s.isEmpty()){
            sb.append(s.poll());
            sb.append("/");
        }

        System.out.println(sb.toString());

    }
}
