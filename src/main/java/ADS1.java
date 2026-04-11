public class ADS1 {
    public static void main(String[] args) {
        System.out.println("===== ТЕСТИРОВАНИЕ БИНАРНОГО ДЕРЕВА =====");
        BinarySearchTree bst = new BinarySearchTree();

        // 1. Создание и вставка
        int[] elements = {50, 30, 20, 40, 70, 60, 80};
        for (int el : elements) bst.insert(el);
        bst.printTree();

        // 6. Высота
        System.out.println("Высота дерева: " + bst.getHeight());

        // 4. Min / Max
        bst.findMinMax();

        // 3. Четные / Нечетные
        bst.countEvenOdd();

        // 2. Удаление
        System.out.println("\nУдаляем элемент 20:");
        bst.delete(20);
        bst.printTree();

        // 5. Проверка на пустоту и удаление всего дерева
        System.out.println("Дерево пустое? " + bst.isEmpty());
        bst.clearTree();
        System.out.println("Дерево пустое? " + bst.isEmpty());
        System.out.println("Высота пустого дерева: " + bst.getHeight());


        System.out.println("\n===== ТЕСТИРОВАНИЕ ХЕШ-ТАБЛИЦЫ =====");
        HashTable ht = new HashTable(5);

        // 7. Добавление, удаление, вывод
        int[] hashElements = {15, 11, 27, 8, 12, 10, 4};
        for (int el : hashElements) ht.insert(el);
        ht.display();

        System.out.println("\nУдаляем элемент 12...");
        ht.delete(12);
        ht.display();

        // 8. Сумма
        ht.calculateSum();

        // 9. Min / Max
        ht.findMinMax();

        // 10. Четные / Нечетные
        ht.printEvenOdd();
    }
}


class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    // --- Задача 1: Вставка элемента ---
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value < root.value) root.left = insertRec(root.left, value);
        else if (value > root.value) root.right = insertRec(root.right, value);
        return root;
    }

    // Вывод дерева на экран (горизонтально для наглядности)
    public void printTree() {
        System.out.println("Структура дерева:");
        printTreeRec(root, 0);
        System.out.println();
    }

    private void printTreeRec(TreeNode root, int space) {
        if (root == null) return;
        space += 5;
        printTreeRec(root.right, space);
        System.out.print("\n");
        for (int i = 5; i < space; i++) System.out.print(" ");
        System.out.print(root.value + "\n");
        printTreeRec(root.left, space);
    }

    // --- Задача 2: Удаление элемента ---
    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private TreeNode deleteRec(TreeNode root, int value) {
        if (root == null) return root;

        if (value < root.value) root.left = deleteRec(root.left, value);
        else if (value > root.value) root.right = deleteRec(root.right, value);
        else {
            // Узел с одним потомком или без них
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Узел с двумя потомками: получаем наименьший в правом поддереве
            root.value = minValue(root.right);
            root.right = deleteRec(root.right, root.value);
        }
        return root;
    }

    // --- Задача 3: Количество четных и нечетных ---
    public void countEvenOdd() {
        int[] counts = new int[2]; // counts[0] - четные, counts[1] - нечетные
        countEvenOddRec(root, counts);
        System.out.println("Четных: " + counts[0] + ", Нечетных: " + counts[1]);
    }

    private void countEvenOddRec(TreeNode root, int[] counts) {
        if (root != null) {
            if (root.value % 2 == 0) counts[0]++;
            else counts[1]++;
            countEvenOddRec(root.left, counts);
            countEvenOddRec(root.right, counts);
        }
    }

    // --- Задача 4: Поиск Max и Min ---
    public void findMinMax() {
        if (root == null) {
            System.out.println("Дерево пустое.");
            return;
        }
        System.out.println("Min: " + minValue(root));
        System.out.println("Max: " + maxValue(root));
    }

    private int minValue(TreeNode root) {
        int minV = root.value;
        while (root.left != null) {
            minV = root.left.value;
            root = root.left;
        }
        return minV;
    }

    private int maxValue(TreeNode root) {
        int maxV = root.value;
        while (root.right != null) {
            maxV = root.right.value;
            root = root.right;
        }
        return maxV;
    }

    // --- Задача 5: Проверка на пустоту и удаление дерева ---
    public boolean isEmpty() {
        return root == null;
    }

    public void clearTree() {
        root = null; // В Java сборщик мусора сам очистит отвязанные узлы
        System.out.println("Дерево удалено.");
    }

    // --- Задача 6: Высота дерева ---
    public int getHeight() {
        return getHeightRec(root);
    }

    private int getHeightRec(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeightRec(root.left);
        int rightHeight = getHeightRec(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}


import java.util.LinkedList;

class HashTable {
    private LinkedList<Integer>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunction(int key) {
        return Math.abs(key) % size;
    }

    // --- Задача 7: Вставка, удаление и вывод ---
    public void insert(int key) {
        int index = hashFunction(key);
        if (!table[index].contains(key)) {
            table[index].add(key);
        }
    }

    public void delete(int key) {
        int index = hashFunction(key);
        table[index].remove((Integer) key);
    }

    public void display() {
        System.out.println("Хеш-таблица:");
        for (int i = 0; i < size; i++) {
            System.out.print("Индекс " + i + ": ");
            for (int key : table[i]) {
                System.out.print(key + " -> ");
            }
            System.out.println("null");
        }
    }

    // --- Задача 8: Сумма элементов ---
    public void calculateSum() {
        int sum = 0;
        for (LinkedList<Integer> list : table) {
            for (int key : list) sum += key;
        }
        System.out.println("Сумма элементов: " + sum);
    }

    // --- Задача 9: Max и Min элемент ---
    public void findMinMax() {
        Integer min = null;
        Integer max = null;

        for (LinkedList<Integer> list : table) {
            for (int key : list) {
                if (min == null || key < min) min = key;
                if (max == null || key > max) max = key;
            }
        }
        if (min != null) {
            System.out.println("Min в хеш-таблице: " + min);
            System.out.println("Max в хеш-таблице: " + max);
        } else {
            System.out.println("Хеш-таблица пуста.");
        }
    }

    // --- Задача 10: Четные и нечетные элементы ---
    public void printEvenOdd() {
        System.out.print("Четные: ");
        for (LinkedList<Integer> list : table) {
            for (int key : list) if (key % 2 == 0) System.out.print(key + " ");
        }
        System.out.print("\nНечетные: ");
        for (LinkedList<Integer> list : table) {
            for (int key : list) if (key % 2 != 0) System.out.print(key + " ");
        }
        System.out.println();
    }
}


