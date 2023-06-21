package Algoritmi.Sem4_Task;

public class Node_N {

    public static Node_N root = null;
    public static Node_N left;
    public Node_N right;
    public int data;

    // красный ==> true, черный ==> false
    public boolean color;

    Node_N(int data) {
        this.data = data;
        left = null;
        right = null;

// Новый узел, который создается, является всегда красного цвета.
        color = true;
    }
}