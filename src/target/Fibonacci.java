package target;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        int a = 1, b = 0, c = 0;
        boolean achou = false;
        Scanner ler = new Scanner(System.in);

        int num = ler.nextInt();

        while(c < num) {
            c = a + b;
            a = b;
            b = c;

            if(c == num){
                achou = true;
            }
        }

        if(achou) {
            System.out.println("O número " + num + " pertence a sequência");
        } else {
            System.out.println("O número " + num + " não pertence a sequência");
        }
    }
}
