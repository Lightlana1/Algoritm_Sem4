package Algoritmi.Sem4_Task;

import java.util.Scanner;

import static Algoritmi.Sem4_Task.Node_N.*;

public class Main_N {
    public static void main(String[] args) {

        Tree node = new Tree();
        Scanner scan = new Scanner(System.in);

        char ch;
        do {
            System.out.println("Введите целое число");

            int num = scan.nextInt();
            root = node.insert(root, num);

            node.inorder(root);
            System.out.println("\nВы хотите продолжить? (введите y или n)");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
}