package bai11_dsa_stack_queue.bai_tap.trien_khai_queue;

public class TestQueue {
    public static void main(String[] args) {
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        linkedListQueue.enQueue(1);
        linkedListQueue.enQueue(2);
        linkedListQueue.enQueue(3);
        linkedListQueue.enQueue(4);
        linkedListQueue.enQueue(5);
        linkedListQueue.deQueue();
        linkedListQueue.deQueue();
        linkedListQueue.enQueue(6);
        linkedListQueue.enQueue(7);
        linkedListQueue.enQueue(8);
        linkedListQueue.enQueue(9);
        linkedListQueue.enQueue(10);
        System.out.println("Dequeue item is: " + linkedListQueue.deQueue().data);


    }
}
