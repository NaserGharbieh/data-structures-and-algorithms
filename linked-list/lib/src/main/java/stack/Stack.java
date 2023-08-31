package stack;

public class Stack <T>{
 Node <T> top;

        public Stack() {
            this.top = null;
        }

        public void push(T value) {
            Node<T> newNode = new Node<>(value);
            newNode.next = top;
            top = newNode;
        }

        public T pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            T value = top.value;
            top = top.next;
            return value;
        }

        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return top.value;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }



