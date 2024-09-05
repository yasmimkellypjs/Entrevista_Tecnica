import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Fibonacciseq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> lista = new ArrayList<>();
        Integer num = sc.nextInt();

        int a = 0;
        int b = 1;

        for(int i = 2; i < (num*2); i++){
            int prox = a + b;
            lista.add(prox);
            a = b;
            b = prox;
        }

        if(lista.contains(num)){
            System.out.println("Número está na sequência!");
        } else{
            System.out.println("Número não está na sequência!");
        }
    
    }
}
