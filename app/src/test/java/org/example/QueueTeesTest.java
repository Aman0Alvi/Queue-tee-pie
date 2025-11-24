package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QueueTeesTest {

    @Test
    void newQueueHasSizeZero() {
        QueueTees queue = new QueueTees();
        assertEquals(0, queue.size());
    }

    @Test
    void enqueueIncreasesSize() {
        QueueTees queue = new QueueTees();
        queue.enqueue(new Puppy());
        queue.enqueue(new Kitty());
        queue.enqueue(new PygmyMarmoset());

        assertEquals(3, queue.size());
    }

    @Test
    void dequeueReturnsItemsInFifoOrder() {
        QueueTees queue = new QueueTees();
        Puppy puppy = new Puppy();
        Kitty kitty = new Kitty();
        PygmyMarmoset marmoset = new PygmyMarmoset();

        queue.enqueue(puppy);
        queue.enqueue(kitty);
        queue.enqueue(marmoset);

        assertSame(puppy, queue.dequeue());
        assertSame(kitty, queue.dequeue());
        assertSame(marmoset, queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    void enqueueWhenFullDoesNotChangeSize() {
        QueueTees queue = new QueueTees(2);
        Puppy puppy = new Puppy();
        Kitty kitty = new Kitty();
        PygmyMarmoset marmoset = new PygmyMarmoset();

        queue.enqueue(puppy);
        queue.enqueue(kitty);
        assertEquals(2, queue.size());

        queue.enqueue(marmoset);

        assertEquals(2, queue.size());
        assertSame(puppy, queue.dequeue());
        assertSame(kitty, queue.dequeue());
        assertNull(queue.dequeue()); 
    }

    @Test
    void dequeueOnEmptyQueueReturnsNull() {
        QueueTees queue = new QueueTees();

        assertEquals(0, queue.size());
        assertNull(queue.dequeue());
        assertEquals(0, queue.size());
    }
}
