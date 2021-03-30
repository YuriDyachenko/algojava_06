package kurs;

public class Main {

    public static void main(String[] args) {
        //задание 6.1
        exampleOfUsingTreeStructure();
        //задание 6.2
        theTask62();
        //задание 6.3
        theTask63();
        //задание 6.4
        theTask64();
        //задание 6.5
        theTask65();
        //задание 6.6
        theTask66();
        //задание 6.7
        exampleOfUsingBalancedTree();
    }

    private static void exampleOfUsingBalancedTree() {
        System.out.println("- - - - - Задание 6.7 - - - - -");
        System.out.println(" Примеры использования сбалансированного дерева:");
        System.out.println("  - TreeSet");
        System.out.println("  - TreeMap");
    }

    private static void theTask66() {
        System.out.println("- - - - - Задание 6.6 - - - - -");
        Duration duration = new Duration();
        ArraysMethods am = new ArraysMethods();
        System.out.println(" разные методы сортировки массива из 400 слов: ");
        String[] words = am.getCopyOfBaseArray();
        duration.fix();
        HeapSortString.sort(words);
        duration.outAndFix("  пирамидальная сортировка");
        words = am.getCopyOfBaseArray();
        duration.fix();
        am.sort(words);
        duration.outAndFix("  быстрая сортировка");
        words = am.getCopyOfBaseArray();
        duration.fix();
        am.bubbleSort(words);
        duration.outAndFix("  пузырьковая сортировка");
        words = am.getCopyOfBaseArray();
        duration.fix();
        am.selectionSort(words);
        duration.outAndFix("  сортировка методом выбора");
        words = am.getCopyOfBaseArray();
        duration.fix();
        am.byInsertionSort(words);
        duration.outAndFix("  сортировка методом вставки");
    }

    private static void theTask65() {
        System.out.println("- - - - - Задание 6.5 - - - - -");
        Duration duration = new Duration();
        Tree tree = createFilledTree();
        System.out.println(" до удаления id = 2: " + tree);
        tree.delete(2);
        System.out.println(" после удаления id = 2: " + tree);
        Person petr = new Person("Petr", 5);
        System.out.println(" базовые операции: ");
        duration.fix();
        tree.insert(petr);
        duration.outAndFix("  insert");
        tree.find(4);
        duration.outAndFix("  find");
        tree.max();
        duration.outAndFix("  max");
        tree.max();
        duration.outAndFix("  min");
        tree.delete(4);
        duration.outAndFix("  delete");
        tree.toString();
        duration.outAndFix("  toString");
        System.out.println(" " + tree);
    }

    private static void theTask64() {
        System.out.println("- - - - - Задание 6.4 - - - - -");
        Tree tree = createFilledTree();
        System.out.println(" min() = " + tree.min());
        System.out.println(" max() = " + tree.max());
        System.out.println(" " + tree);
    }

    private static void theTask63() {
        System.out.println("- - - - - Задание 6.3 - - - - -");
        Tree tree = createFilledTree();
        System.out.println(" " + tree);
        System.out.println(" find(3) = " + tree.find(3));
    }

    private static Tree createFilledTree() {
        Tree tree = new Tree();
        Person anton = new Person("Anton", 1);
        Person ivan = new Person("Ivan", 2);
        Person nick = new Person("Nick", 3);
        Person serg = new Person("Serg", 4);
        tree.insert(nick);
        tree.insert(anton);
        tree.insert(ivan);
        tree.insert(serg);
        return tree;
    }

    private static void theTask62() {
        System.out.println("- - - - - Задание 6.2 - - - - -");
        Person anton = new Person("Anton", 1);
        Node node = new Node(anton);
        Tree tree = new Tree();
        System.out.println(" " + anton);
        System.out.println(" " + node);
        System.out.println(" " + tree);
    }

    private static void exampleOfUsingTreeStructure() {
        System.out.println("- - - - - Задание 6.1 - - - - -");
        System.out.println(" Примеры использования древовидной структуры:");
        System.out.println("  - генеалогическое древо");
        System.out.println("  - структура организации / предприятия");
    }
}
