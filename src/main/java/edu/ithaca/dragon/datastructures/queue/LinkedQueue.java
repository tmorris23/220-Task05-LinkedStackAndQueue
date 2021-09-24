package edu.ithaca.dragon.datastructures.queue;

import edu.ithaca.dragon.datastructures.node.LinkedNode;

public class LinkedQueue<T> implements Queue<T>{

    private LinkedNode<T> front;
    private LinkedNode<T> end;

    public LinkedQueue(){
        front = null;
        end = null;
    }

    @Override
    public void enqueue(T item) {
        LinkedNode<T> newNode = new LinkedNode<T>(item);
        if (front == null){
            front = newNode;
            end = newNode;
        }
        else {
            end.setNext(newNode);
            end = newNode;
        }
    }

    @Override
    public T dequeue() {
        // TODO 
        return null;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public void makeEmpty() {
        // TODO
    }
    
}
