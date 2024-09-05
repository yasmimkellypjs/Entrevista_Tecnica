import java.util.Scanner;

public class InverterString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String txt = scanner.nextLine();
        scanner.close();
        char[] car = txt.toCharArray();
        int inicio = 0;
        int fim = car.length - 1;
        while (inicio < fim) {
            char temp = car[inicio];
            car[inicio] = car[fim];
            car[fim] = temp;
            inicio++;
            fim--;
        }
        String textoInv = new String(car);
        System.out.println(textoInv);
    }
}

