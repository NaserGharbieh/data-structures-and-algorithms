package queue;

import stack.Stack;

public class PseudoQueue<T> implements Queueable{
    int size =0;

    Stack s1=new Stack();
    Stack s2=new Stack();


    @Override
    public void enqueue(Object value) {


      if(!s2.isEmpty()) {
          while (s2.top != null) {
              s1.push(s2.pop());
          }
      } s1.push(value);

    }

    @Override
    public Object dequeue() {

        Object dequeued=null;

        if(!s1.isEmpty()){
            while (s1.top !=null){
                s2.push(s1.pop());
            }
           } dequeued= s2.pop();
   return dequeued; }

    @Override
    public Object peek() {
        Object peeked=null;
        if(!s1.isEmpty()){
            while (s1.top !=null){
                s2.push(s1.pop());
            }
        } peeked= s2.top.value;
        return peeked;
    }

    public boolean isEmpity (){
        return (s1.isEmpty() && s2.isEmpty());
    }

}


