package edu.ithaca.dragon.datastructures.stack;

import edu.ithaca.dragon.datastructures.node.LinkedNode;
import java.util.NoSuchElementException;

public class LinkedStack<T> implements Stack<T>{

    private LinkedNode<T> top;

    public LinkedStack(){
        top = null;
    }

    @Override
    public void push(T item) {
        LinkedNode<T> newNode = new LinkedNode<T>(item);
        newNode.setNext(top);
        top = newNode;
    }

    @Override
    public T pop() {
        if (top == null){
            throw new NoSuchElementException();
        }
        else{
            LinkedNode<T> returnVal = top;
            top = top.getNext();
            return returnVal.getItem();
        }
    
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void makeEmpty() {
        top = null;
    }
    
}
