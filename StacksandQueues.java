public class StacksandQueues {

    static class Stack {
        private int arraySize;
        private int top;
        private int[] array;

        public Stack(int size) {
            this.arraySize = size;
            this.array = new int[size];
            this.top = -1;
        }

        public void push(int value) {
            if (top == arraySize - 1) {
                System.out.println("La pila está llena");
            } else {
                top++;
                array[top] = value;
            }
        }

        public int pop() {
            if (top == -1) {
                System.out.println("La pila está vacía");
                return -1;
            } else {
                int value = array[top];
                top--;
                return value;
            }
        }

        public void printStack() {
            System.out.println("Contenido de la pila:");
            if (top == -1) {
                System.out.println("(vacía)");
            } else {
                for (int i = top; i >= 0; i--) {
                    System.out.println(array[i]);
                }
            }
        }
    }

    static class Queue {
        private int[] array;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        public Queue(int capacity) {
            this.capacity = capacity;
            this.array = new int[capacity];
            this.front = 0;
            this.rear = -1;
            this.size = 0;
        }

        public void enqueue(int value) {
            if (size == capacity) {
                System.out.println("La cola está llena");
            } else {
                rear = (rear + 1) % capacity;
                array[rear] = value;
                size++;
            }
        }

        public int dequeue() {
            if (size == 0) {
                System.out.println("La cola está vacía");
                return -1;
            } else {
                int value = array[front];
                front = (front + 1) % capacity;
                size--;
                return value;
            }
        }

        public void printQueue() {
            System.out.println("Contenido de la cola:");
            if (size == 0) {
                System.out.println("(vacía)");
            } else {
                for (int i = 0; i < size; i++) {
                    int index = (front + i) % capacity;
                    System.out.print(array[index] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Stack pila = new Stack(5);
        for (int i = 1; i <= 5; i++) {
            pila.push(i);
        }
        pila.printStack();
        pila.pop();
        pila.printStack();

        Queue cola = new Queue(5);
        for (int i = 1; i <= 5; i++) {
            cola.enqueue(i);
        }
        cola.printQueue();
        cola.dequeue();
        cola.printQueue();
    }
}
