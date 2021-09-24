package edu.ithaca.dragon.datastructures.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class QueueTest {

    @Test
    public void enqueueIsEmptyForTraceTest(){
        Queue<Integer> myQueue = new LinkedQueue<>();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        assertFalse(myQueue.isEmpty());
    }

    @Test
    public void testQueues(){
        int numToTestWith=1000;
        enqueueDequeueIsEmptyTest(null, numToTestWith);
        testDequeueOnEmpty(null);
        testMakeEmpty(null, numToTestWith);
    }

    public void enqueueDequeueIsEmptyTest(Queue<String> myQueue, int queueSize){
        assertTrue(myQueue.isEmpty());
        for (int i=0; i<queueSize; i++){
            myQueue.enqueue(Integer.toString(i));
            assertFalse(myQueue.isEmpty());
        }
        for (int i=0; i<queueSize; i++){
            assertFalse(myQueue.isEmpty());
            assertEquals(Integer.toString(i), myQueue.dequeue());
        }
        assertTrue(myQueue.isEmpty());

        myQueue.enqueue("a");
        myQueue.enqueue("b");
        myQueue.enqueue("c");
        assertEquals("a", myQueue.dequeue());
        assertEquals("b", myQueue.dequeue());
        myQueue.enqueue("x");
        myQueue.enqueue("y");
        assertEquals("c", myQueue.dequeue());
        assertEquals("x", myQueue.dequeue());
        assertEquals("y", myQueue.dequeue());
    }

    public void testDequeueOnEmpty(Queue<String> emptyQueue){
        assertTrue(emptyQueue.isEmpty());
        assertThrows(NoSuchElementException.class, () -> emptyQueue.dequeue() );
    }

    public void testMakeEmpty(Queue<String> myQueue, int queueSize){
        assertTrue(myQueue.isEmpty());
        for (int i=0; i<queueSize; i++){
            myQueue.enqueue(Integer.toString(i));
            assertFalse(myQueue.isEmpty());
        }
        myQueue.makeEmpty();
        testDequeueOnEmpty(myQueue);
        enqueueDequeueIsEmptyTest(myQueue, queueSize);
    }
}