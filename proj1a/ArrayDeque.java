public class ArrayDeque<T> {
    private T[] items;
    private int left;
    private int right;
    private int capacity=8;

    public ArrayDeque(){
        items=(T[]) new Object[capacity];
        left=right=0;

    }

    public void addFirst(T item){
        if(isfull()){
            resize((int)(capacity*1.5));
        }
        left=(left-1+capacity)%capacity;
        items[left]=item;
    }
    public void addLast(T item){
        if(isfull()){
            resize((int)(capacity*1.5));
        }
        items[right]=item;
        right=(right+1)%capacity;
    }
    public boolean isEmpty(){
        return left==right;
    }
    public int size(){
        return Math.abs(left-right)%capacity;
    }
    public void printDeque(){
        if(left<right){
            for(int i=left;i<right;i++) {
                System.out.println(items[i]);
            }
        }else if(left>right){
            for(int j=left;j<capacity;j++){
                System.out.println(items[j]);
            }
            for(int i=0;i<right;i++){
                System.out.println(items[i]);
            }
        }
    }
    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        T res =items[left];
        left=(left+1)%capacity;
        return res;
    }
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        T res=items[right];
        right=(right-1)%capacity;
        return res;
    }
    public T get(int index){
        if(index<0||isEmpty()||index>=size()){
            return null;
        }
        if(left<right){
            return items[index+left];
        }else{
            return items[(left+index)%capacity];
        }
    }
    private boolean isfull(){
        return size()==capacity-1;

    }
    private void resize(int newSize){
        T[] newArray=(T[])new Object[newSize];
        int size=size();
        if(left<right){
            for(int i=left,j=0;i<right&&j<size;i++,j++){
                newArray[j]=items[i];
            }
        }
        else if (left > right) {
            int j=0;
            for(int i=left;j<capacity-left;i++,j++){
                newArray[j]=items[i];
            }
            for(int i=0;i<right;i++,j++){
                newArray[j]=items[i];
            }
        }
        left=0;
        right=size;
        items=newArray;
        capacity=newSize;
    }


}
