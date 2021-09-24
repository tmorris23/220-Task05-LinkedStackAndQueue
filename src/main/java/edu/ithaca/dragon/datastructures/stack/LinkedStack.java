package edu.ithaca.dragon.datastructures.stack;

import edu.ithaca.dragon.datastructures.node.LinkedNode;

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
        // TODO
        return null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void makeEmpty() {
        // TODO
    }
    
}
