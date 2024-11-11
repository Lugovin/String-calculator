import java.util.Objects;
import java.util.Scanner;


public class Main {

    public static String inputText, answerText = "", string1 = "", string2 = "", string3 = "";
    public static int x;
    public static boolean flag = false;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        inputText = scanner.nextLine();   // считываем строку из консоли
        scanner.close();

        Mathemat mathemat =  new Mathemat();  // для математических расчетов
        Parse parse = new Parse();  // для разбора строки на части

        try {
            string1 = parse.firstVar(inputText);  // первая переменная
            string2 = parse.operation(inputText); // знак математического действия
            string3 = parse.secondVar(inputText); // вторая переменная
            flag = parse.isString(inputText); // вторая переменная true - строка, false - число
            Check.checkFunc(string1, string2, string3, flag); // Проверяем возможные косяки ввода


            // Умножаем
            if (Objects.equals(string2, "*") && !flag) {
                x = Integer.parseInt(string3);
                answerText = mathemat.multFunc(string1, x);
            }
            // Отнимаем
            if (Objects.equals(string2, "-") && flag) {
                answerText = mathemat.minusFunc(string1, string3);
            }
            // Складываем
            if (Objects.equals(string2, "+") && flag) {
                answerText = mathemat.plusFunc(string1, string3);
            }
            // Делим
            if (Objects.equals(string2, "/") && !flag) {
                x = Integer.parseInt(string3);
                answerText = mathemat.divFunc(string1, x);
            }
            if (answerText.length() > 42) {
                answerText = answerText.substring(0, 41) + "...\"";
            }
            System.out.println(answerText);

        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
