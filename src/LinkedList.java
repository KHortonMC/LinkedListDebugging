public class LinkedList <T> {
    class Node <T>{
        T data;
        Node next;
        public Node(T data) {
            this.data = data;
        }
    }

    Node<T> head;
    public LinkedList() {
        head = null;
    }

    public void append(T data) {
        if (head == null) {
            head = new Node<>(data);
        }
        else {
            Node<T> newNode = new Node<>(data);
            Node<T> node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
        }
    }

    public void prepend(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
    }

    public void insert(T data, int index) {
        Node<T> node = head;
        while (index > 0) {
            index--;
            if (node.next == null) {
                node.next = new Node<>(data);
                return;
            }
            node = node.next;
        }
        Node<T> newNode = new Node<>(data);
        newNode.next = node.next;
        node.next = head;
    }

    public void remove(T data) {
        if (head != null) {
            Node<T> node = head;
            if (head.data == data) {
                head = head.next;
                return;
            }
            // not the head, but a link
            while (node.next != null) {
                if (node.next.data == data) {
                    node.next = node.next.next;
                    return; // found it!
                }
                else {
                    node = node.next;
                }
            }
        }
    }

    public int size() {
        Node<T> node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public T get(int index) {
        Node<T> node = head;
        while (index > 0) {
            index--;
            node = node.next;
            if (node == null) {
                return null;
            }
        }
        return node.data;
    }

    public boolean contains(T data) {
        Node<T> node = head;
        while (node != null) {
            if (node.data == data) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public boolean isLooped() {
        Node<T> s = head;
        Node<T> d = head;
        int count = 0;

        while (s != null) {
            s = s.next;

            if (d != null && d.next != null && d.next.next != null) {
                d = d.next.next;
            }

            if (s == d) {
                return true;
            }
            count++;
        }
        return false;
    }

    public String toString() {
        String retval = "";

        Node<T> node = head;
        while (node != null) {
            retval += node.data + ", ";
            node = node.next;
        }

        return retval;
    }
}
