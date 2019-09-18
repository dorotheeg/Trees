import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyStack<E> {
    private LinkedList<E> dataList = new LinkedList<E>();
    
    public void push(E element) {dataList.addFirst(element);
                                }
    public E pop() throws EmptyStackException {try 
    {
        return dataList.removeFirst();
                   }
                 catch (IndexOutOfBoundsException e) 
                              {
          throw new EmptyStackException();
                      }
                  }
    public E peek() throws EmptyStackException {
                   try {return dataList.getFirst();
                         } 
                catch (IndexOutOfBoundsException e) 
                         {
                  throw new EmptyStackException();
                              }
                               }
          public boolean isEmpty() 
                         {
                   return dataList.size() == 0;
                         }
                   public int size() 
                         {
                  return dataList.size();
                         }
                        }
