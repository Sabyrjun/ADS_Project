public class ADS2 {
    private Node head;

    // Внутренний класс для узла списка
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // 1. Добавление элемента в начало
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // 2. Добавление элемента в конец
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // 3. Удаление последнего элемента
    public void deleteLast() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // 4. Вывод всех элементов
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // 5. Поиск определенного элемента
    public boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) return true;
            current = current.next;
        }
        return false;
    }

    // 6. Вставка элемента в заданную позицию (0-индексация)
    public void insertAt(int data, int position) {
        if (position == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // 7. Удаление элемента по значению
    public void deleteByValue(int value) {
        if (head == null) return;
        if (head.data == value) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // 8. Объединение двух списков
    public void merge(ADS2 otherList) {
        if (otherList.head == null) return;
        if (this.head == null) {
            this.head = otherList.head;
            return;
        }
        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = otherList.head;
    }

    // 9. Обращение (переворот) списка
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    // 10. Сортировка вставками
    public void insertionSort() {
        Node sorted = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            sorted = sortedInsert(sorted, current);
            current = next;
        }
        head = sorted;
    }

    private Node sortedInsert(Node sortedHead, Node newNode) {
        if (sortedHead == null || sortedHead.data >= newNode.data) {
            newNode.next = sortedHead;
            return newNode;
        }
        Node current = sortedHead;
        while (current.next != null && current.next.data < newNode.data) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        return sortedHead;
    }

    public static void main(String[] args) {
        ADS2 list = new ADS2();

        // Пример использования
        list.addLast(10);
        list.addLast(20);
        list.addFirst(5);
        list.insertAt(15, 2);

        System.out.print("Список после добавления элементов: ");
        list.printList();

        list.reverse();
        System.out.print("Список после переворота: ");
        list.printList();

        list.insertionSort();
        System.out.print("Список после сортировки: ");
        list.printList();
    }
}
