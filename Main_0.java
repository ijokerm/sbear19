public class Main_0 {
public static void testList(List list){
    list.add(1);
    list.add(2);
    list.add(2);
    list.add(3);
    System.out.println(list.get(4));
    System.out.println(list);

}

    public static void main(String[] args) {
        MylinkedList linkedList=new MylinkedList();
        testList(linkedList);
    }
}
