public class MylinkedList implements List {
public static class Node{
    private Node next;
    private int val;
    private Node pre;
    private Node(int val){
        this.val=val;
        this.pre=null;
        this.next=null;
    }
    private Node(int val,Node pre,Node next){
        this(val);
        this.pre=pre;
        this.next=next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", val=" + val +
                ", pre=" + pre +
                '}';
    }
}
//记录链表的第一个节点
    private Node head=null;
//记录链表的最后一个节点
    private Node last=null;
//记录链表中元素的个数
    private int size=0;

    @Override
    public boolean add(int element) {
        return add(size,element);
    }

    /**
     *
     * @param index 下标
     * @param element 元素
     * @return true代表成功 false代表失败
     */
    @Override
    public boolean add(int index, int element) {
        //检查下标
        if(index<0||index>size){
            System.out.println("error");
            return false;
        }
        //考虑几种特殊情况 index==0；头插 index==size；尾插
        if(index==0){
            head=new Node(element,null,head);
            if(head.next==null){
                head.next.pre=head;
            }
            if(size==0){
                last=head;
            }
            size++;
            return true;
        }
       if(index==size){
           last=new Node(element,last,null);
           if(last.pre!=null){
               last.pre.next=null;
           }
           if(size==0){
               head=last;
           }
           size++;
           return true;
       }
        /**
         * 其他情况：
         * 找到index位置的结点node 若在左边，从head往后找，反之，从后往前找
         */
        Node node=getNode(index);
        Node newNode=new Node(element,node.pre,node);
        node.pre.next=newNode;
        node.pre=newNode;
        size++;
        return true;
    }

    private Node getNode(int index){
        if(index<size/2){
            Node cur=head;
            for(int i=0;i<index;i++){
                cur=cur.next;
            }
            return cur;
        }else{
            Node cur=last;
            for(int i=0;i<size-index-1;i++){
                cur=cur.pre;
            }
            return cur;
        }
    }
    @Override
    public int get(int index) {
        if(index<0||index>size){
            System.out.println("error");
            return -1;
        }
        return getNode(index).val;
    }

    @Override
    public int set(int index, int val) {
        if(index<0||index>size){
            System.out.println("error");
            return -1;
        }
        Node node=getNode(index);
        int oldValue=node.val;
        node.val=val;

        return oldValue;
    }

    @Override
    public int remove(int index) {
        if(index<0||index>size){
            System.out.println("error");
            return -1;
        }
        Node node=getNode(index);
        if(node.pre!=null){
            node.pre.next=node.next;
        }else{
            head=node.next;
        }
        if(node.next!=null){
            node.pre=node.next;
        }else{
            last=node.pre;
        }
        size--;
        return node.val;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public String toString() {
        String r="[";
        for(Node c=head;c!=null;c=c.next){
            r+=(c.val+",");
        }
            r+="]";
        return r;
    }
}
