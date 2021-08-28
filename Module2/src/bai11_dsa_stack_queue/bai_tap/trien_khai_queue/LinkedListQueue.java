package bai11_dsa_stack_queue.bai_tap.trien_khai_queue;

public class LinkedListQueue {
    private Node front;
    private Node rear;

    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
    }

    public void enQueue(int data){
        Node temp = new Node(data);
        if (this.rear == null){
            this.front = this.rear =temp;
            return;
        }
        this.rear.link = temp;
        this.rear = temp;

    }

    public Node deQueue(){
        if (this.front == null){
            return null;
        }
        Node temp = this.front;
        this.front = this.front.link;
        if (this.front == null){
            this.rear = null;
        }
        return temp;
    }

}
