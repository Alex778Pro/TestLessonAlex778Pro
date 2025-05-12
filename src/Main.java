import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Программа банка");
        System.out.println("Пример ввода: Внести 40.50 RUB");
        System.out.println("Операции: Внести, Вывести, Обмен, Баланс\n");

        String operation;

        while (true) {
            System.out.print("\nВведите операцию: ");
            try {
                operation = scan.nextLine();
                UserBankLogic ballansFile = new UserBankLogic();
                ballansFile.operation(operation);
            } catch (Exception e) {
                System.out.println("ERROR! EXIT PROGRAM");
                break;
            }
        }


    }
}