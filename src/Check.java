
import java.util.Objects;

public class Check {  // Проверка правильности ввода условия


    public static void checkFunc(String string1, String string2, String string3, boolean flag) throws Exception {

        if ((Objects.equals(string2, "*") | Objects.equals(string2, "/")) && flag) {
            throw new Exception("Ошибка! Умножать и делить можно ТОЛЬКО на число от 1 до 10!");
        }
        if ((Objects.equals(string2, "+") | Objects.equals(string2, "-")) && !flag) {
            throw new Exception("Ошибка! Складывать и вычитать можно ТОЛЬКО строку!");
        }
        if (string3.length() > 10) {
            throw new Exception("Ошибка! Строка 2 не может быть длиннее 10 символов!");
        }
        if (string1.length() > 10) {
            throw new Exception("Ошибка! Строка 1 не может быть длиннее 10 символов!");
        }
    }
}
