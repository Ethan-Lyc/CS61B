/*first part of proj1a
Deque implemented by Linked List
@author Yicheng Liao*/
public class LinkedListDeque<T>{
    /*inner class Node*/
    public class Node{
        private  T item;
        private  Node pre;
        private  Node next;

        public Node(T n,Node ppre,Node nnext){
            this.item=n;
            this.pre=ppre;
            this.next=nnext;
        }

        public Node(Node ppre,Node nnext){
            this.pre=ppre;
            this.next=nnext;
        }
    }
/*    sentinel node */
    private Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel=new Node(null,null);
        size=0;
        sentinel.pre=sentinel;
        sentinel.next=sentinel;

    }
    public T getRecursive(int index){
        if(index>=size){
            return null;
        }else{
            return getRecursiveHelp(sentinel.next,index);
        }

    }
    public T getRecursiveHelp(Node ln,int index){
        if(index==0){
            return ln.item;
        }else{
            return getRecursiveHelp(ln.next,index-1);
        }
    }

    public void addFirst(T item){
        Node first=new Node(item,sentinel,sentinel.next);
        sentinel.next.pre=first;
        sentinel.next=first;
        size+=1;

    }
    public void addLast(T item){
        Node last=new Node(item,sentinel.pre,sentinel);
        sentinel.pre.next=last;
        sentinel.pre=last;
        size+=1;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        Node cur=sentinel.next;
        while(cur!=sentinel){
            System.out.println(cur.item);
            cur=cur.next;
        }
    }
    public T removeFirst(){
        if(size==0){
            return null;
        }
        T result=sentinel.next.item;
        sentinel.next.next.pre=sentinel;
        sentinel.next=sentinel.next.next;
        size-=1;
        return result;
    }
    public T removeLast(){
        if(size==0){
            return  null;
        }
        T result=sentinel.pre.item;
        sentinel.pre.pre.next=sentinel;
        sentinel.pre=sentinel.pre.pre;
        size-=1;
        return result;

    }
    public T get(int index){
        Node cur=sentinel.next;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur.item;
    }
}
