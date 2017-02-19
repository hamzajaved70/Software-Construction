package lab1;

class TvManager
{
    protected Channel head;
    protected Channel tail ;
    public int size ;
 
    public TvManager(){
        head = null;
        tail = null;
        size = 0;
    }
    
    public boolean isEmpty()
    {
        return head == null;
    }
    
    public int getSize()
    {
        return size;
    }    
    
    public void insertAtEnd(String val)
    {
        Channel npointer = new Channel(val,null);    
        size++ ;    
        if(head == null) {
            head = npointer;
            tail = head;
        }
        else {
            tail.setNext(npointer);
            tail = npointer;
        }
    }
    
    public void replace(String val, int pos){
        Channel pointer = head;
        
        for (int i = 1; i < size; i++) 
        {
            if (i == pos) 
            {
                pointer.setData(val);
            }
            pointer = pointer.getNext();
        }
    }
    
    public void deleteAtPos(int pos)
    {        
        if (pos == 1) 
        {
            head = head.getNext();
            size--; 
            return ;
        }
        if (pos == size) 
        {
            Channel s = head;
            Channel t = head;
            while (s != tail)
            {
                t = s;
                s = s.getNext();
            }
            tail = t;
            tail.setNext(null);
            size --;
            return;
        }
        Channel pointer = head;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++) 
        {
            if (i == pos) 
            {
                Channel tmp = pointer.getNext();
                tmp = tmp.getNext();
                pointer.setNext(tmp);
                break;
            }
            pointer = pointer.getNext();
        }
        size-- ;
    }    
    
    public String getURL(int pos){
        
        Channel pointer = head;
        
        for (int i = 1; i < size; i++) 
        {
            if (i == pos) 
            {
                return pointer.getData();
            }
            pointer = pointer.getNext();
        }
        return null;
    }
    
    public void printChannel(){
        if (size == 0){
            System.out.print("empty\n");
            return;
        }    
        if (head.getNext() == null) {
            System.out.println(head.getData()+ "\n" );
            return;
        }
        Channel pointer = head;
        System.out.print(head.getData()+ "\n");
        pointer = head.getNext();
        while (pointer.getNext() != null)
        {
            System.out.print(pointer.getData() + "\n");
            pointer = pointer.getNext();
        }
        System.out.print(pointer.getData()+ "\n");
    }
    
}
