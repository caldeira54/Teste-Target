package target;

import java.util.Scanner;

public class InverteString {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        String palavra = ler.next();
        StringBuilder resultado = new StringBuilder(palavra.length());

        for (String s : palavra.split(" ")) {
            if (resultado.length() != 0) resultado.append(' ');
            for (int x = s.length() - 1; x >= 0; x--) {
                resultado.append(s.charAt(x));
            }
        }
        
        System.out.println(resultado);
    }
}
