package edu.ithaca.dragon.datastructures.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class StackTest {

    @Test
    public void pushIsEmptyForTraceTest(){
        Stack<Integer> myStack = new LinkedStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        assertFalse(myStack.isEmpty());
    }
    
    @Test
    public void testStack(){
        int numItemsToTestWith = 1000;
        pushPopIsEmptyTest(new LinkedStack<String>(), numItemsToTestWith);
        testPopOnEmpty(new LinkedStack<String>());
        testMakeEmpty(new LinkedStack<String>(), numItemsToTestWith);
    }

    public void pushPopIsEmptyTest(Stack<String> myStack, int stackSize){
        assertTrue(myStack.isEmpty());
        
        for (int i=0; i<stackSize; i++){
            myStack.push(Integer.toString(i));
            assertFalse(myStack.isEmpty());
        }
        for (int i=stackSize-1; i>=0; i--){
            assertFalse(myStack.isEmpty());
            assertEquals(Integer.toString(i), myStack.pop());
        }
        assertTrue(myStack.isEmpty());

        myStack.push("a");
        myStack.push("b");
        myStack.push("c");
        assertFalse(myStack.isEmpty());
        assertEquals("c", myStack.pop());
        assertEquals("b", myStack.pop());
        assertFalse(myStack.isEmpty());
        myStack.push("x");
        myStack.push("y");
        assertFalse(myStack.isEmpty());
        assertEquals("y", myStack.pop());
        assertEquals("x", myStack.pop());
        assertEquals("a", myStack.pop());
        assertTrue(myStack.isEmpty());
    }

    public void testPopOnEmpty(Stack<String> emptyStack){
        assertTrue(emptyStack.isEmpty());
        assertThrows(NoSuchElementException.class, () -> emptyStack.pop());
    }

    public void testMakeEmpty(Stack<String> myStack, int stackSize){
        assertTrue(myStack.isEmpty());
        for (int i=0; i<stackSize; i++){
            myStack.push(Integer.toString(i));
            assertFalse(myStack.isEmpty());
        }
        myStack.makeEmpty();
        testPopOnEmpty(myStack);
        pushPopIsEmptyTest(myStack, stackSize);
    }

}
