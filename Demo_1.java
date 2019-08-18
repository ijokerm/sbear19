import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;

public class Demo_1 {
    public static void main(String[] args) {
        Collection<String> list=new ArrayList<>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add("he");
        list.add("is");
        list.add("piggy");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        Object[] array=list.toArray();
        System.out.println(Arrays.toString(array));
        for(String s:list){
            System.out.println(s);
        }
        list.remove("he");
        for(String s:list){
            System.out.println(s);
        }
        list.clear();
        System.out.println(list.size());
        System.out.println(list.isEmpty());

    }
}
