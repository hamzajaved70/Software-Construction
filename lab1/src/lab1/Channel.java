package lab1;

public class Channel
{
    private String value;
    private int channelNum;
    private Channel nextChannel;
  
    public Channel(){
      value = null;
      nextChannel = null;
    }				
  
    public Channel(String value, Channel newChannel){
     this.value = value;
     this.nextChannel = newChannel;
    }                  
    public void setNext(Channel ch){
        nextChannel = ch;
    }    
  
    public void setData(String name){
        value = name;
    }   
    
    public Channel getNext(){
        return nextChannel;
    }    

    public String getData(){
        return value;
    }
 }				

