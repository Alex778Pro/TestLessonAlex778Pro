import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Программа банка");
        System.out.println("Пример ввода: Внести 40.50 RUB");
        System.out.println("Операции: Внести, Вывести, Обмен, Баланс");
        System.out.println("");
        System.out.print("Введите операцию: ");

        String operation = scan.nextLine();

        UserBankLogic ballansFile = new UserBankLogic();
        ballansFile.operation(operation);


    }
}