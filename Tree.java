package Algoritmi.Sem4_Task;// Программа для реализации операции вставки в красно-черном дереве.
import Algoritmi.Sem4_Task.*;

import java.util.Scanner;



public class Tree {


    // Функция для поворота узла против часовой стрелки.
    Node_N rotateLeft(Node_N myNode) {
        System.out.printf("поворот влево!\n");
        Node_N child = myNode.right;
        Node_N childLeft = child.left;

        child.left = myNode;
        myNode.right = childLeft;

        return child;
    }

    // Функция для поворота узла по часовой стрелке.
    Node_N rotateRight(Node_N myNode) {
        System.out.printf("вращение вправо\n");
        Node_N child = myNode.left;
        Node_N childRight = child.right;

        child.right = myNode;
        myNode.left = childRight;

        return child;
    }

    // Функция для проверки того, является ли узел красного цвета или нет.
    boolean isRed(Node_N myNode) {
        if (myNode == null) {
            return false;
        }
        return (myNode.color == true);
    }

    // Функция для изменения цвета двух узлы.
    void swapColors(Node_N node1, Node_N node2) {
        boolean temp = node1.color;
        node1.color = node2.color;
        node2.color = temp;
    }

    // вставка в левостороннее Красно-черное дерево.
    Node_N insert(Node_N myNode, int data) {
// Обычный код вставки для любого двоичного файла
        if (myNode == null) {
            return new Node_N(data);
        }

        if (data < myNode.data) {
            myNode.left = insert(myNode.left, data);
        } else if (data > myNode.data) {
            myNode.right = insert(myNode.right, data);
        } else {
            return myNode;
        }

// случай 1.
        // когда правый дочерний элемент красный, а левый дочерний элемент черный или не существует.
        if (isRed(myNode.right) && !isRed(myNode.left)) {
// Повернуть узел  влево
            myNode = rotateLeft(myNode);

// Поменять местами цвета дочернего узла всегда должен быть красным
            swapColors(myNode, myNode.left);
        }

// случай 2
        // когда левый ребенок, а также левый внук выделены красным цветом
        if (isRed(myNode.left) && isRed(myNode.left.left)) {
// Повернуть узел в право
            myNode = rotateRight(myNode);
            swapColors(myNode, myNode.right);
        }

// случай 3
        // когда и левый, и правый дочерние элементы окрашены в красный цвет.
        if (isRed(myNode.left) && isRed(myNode.right)) {
// Инвертировать цвет узла это левый и правый дети.
            myNode.color = !myNode.color;

// Изменить цвет на черный.
            myNode.left.color = false;
            myNode.right.color = false;
        }

        return myNode;
    }

    // Обход по порядку
    public void inorder(Node_N node) {
        if (node != null)
        {
            inorder(Node_N.left);
            char c = '●';
            if (node.color == false)
                c = '◯';
            System.out.print(node.data + ""+c+" ");
            inorder(node.right);
        }
    }

}