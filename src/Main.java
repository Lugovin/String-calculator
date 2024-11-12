/*
Калькулятор умеет выполнять операции сложения строк, вычитания строки из строки, умножения строки на число и деления строки на число: "a" + "b", "a" - "b", "a" * b, "a" / b. Данные передаются в одну строку (смотрите пример)! Решения, в которых каждая строка, число и арифметическая операция передаются с новой строки считаются неверными.
Значения строк передаваемых в выражении выделяются двойными кавычками.
Результатом сложения двух строк, является строка состоящая из переданных.
Результатом деления строки на число n, является строка в n раз короче исходной (смотрите пример).
Результатом умножения строки на число n, является строка, в которой переданная строка повторяется ровно n раз.
Результатом вычитания строки из строки, является строка, в которой удалена переданная подстрока или сама исходная строка, если в нее нет вхождения вычитаемой строки (смотрите пример).
Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. И строки длинной не более 10 символов. Если строка, полученная в результате работы приложения длиннее 40 символов, то в выводе после 40 символа должны стоять три точки (...)
Калькулятор умеет работать только с целыми числами.
Первым аргументом выражения, подаваемого на вход, должна быть строка, при вводе пользователем выражения вроде 3 + "hello", калькулятор должен выбросить исключение и прекратить свою работу.
При вводе пользователем неподходящих чисел, строк или неподдерживаемых операций (например, деление строки на строку) приложение выбрасывает исключение и завершает свою работу.
При вводе пользователем выражения, не соответствующего одной из вышеописанных арифметических операций, приложение выбрасывает исключение и завершает свою работу.

 */





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
