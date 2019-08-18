import java.util.Arrays;

public class ArrayList implements  List {
    int[] array;
    int size;

    /**
     *确保有足够的容量 即扩容
     */

    private void ensureCapacity(){
        //若容量足够，则直接返回
        if(array!=null&&size<array.length){
            return;
        }
        //2 计算新容量的大小
        int capacity;
        if(array==null){
            capacity=10;
        }else{
            capacity=2*array.length;
        }
        //3 申请新节点 搬家
        if(array!=null){
            array=Arrays.copyOf(array,capacity);
            //关于capacity
        }else{
            array=new int[capacity];
        }
    }

    @Override
    public boolean add(int element) {
        return add(size,element);
    }

    @Override
    public boolean add(int index, int element) {
        int size = size();
        if (index < 0 || index > size) {
            System.out.println("error");
            return false;
        }
        ensureCapacity();
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index]=element;
        size++;
        return true;
    }

    @Override
    public int get(int index) {
//判断下标的合法性
        if(index<0||index>size){
            System.out.println("error");
            return -1;
        }
        return array[index];
    }

    /**
     *
     * @param index 要判断index的合法性
     * @param val
     * @return
     */
    @Override
    public int set(int index, int val) {
        if(index<0||index>size){
            System.out.println("error");
            return -1;
        }
        int OldVal=array[index];
        array[index]=val;
        return OldVal;
    }

    @Override
    public int remove(int index) {
        if(index<0||index>size){
            System.out.println("error");
            return -1;
        }
        int oldVal=array[index];
        System.arraycopy(array,index+1,array,index,size-index-1);
        size--;
        return oldVal;
    }

    @Override
    public int size() {
        int size = array.length;
        return size;
    }


    @Override
    public boolean isEmpty() {

        return size==0;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array,size));
    }

    public static void main(String[] args) {
        int[] array = {10, 9, 7, 5, 5, 4};
        ArrayList arrayList = new ArrayList(array);
        System.out.println(arrayList.toString());
        arrayList.add(2,21);
        System.out.println(arrayList.toString());
        arrayList.remove(5);
        System.out.println(arrayList.toString());
    }
}












