


public class Parse {


    String var;
    boolean isString = false;


    public String firstVar(String text) throws Exception {

            char[] symbols = text.toCharArray();// Собираем первую переменную, она всегда строковая
            if (symbols[0] != '"') {
                throw new Exception("Ошибка! Проверь как введена первая переменная!");
            }
            var = "";
            int n = symbols.length;
            for (int i = 1; i < n; i++) {
                if (symbols[i] != '\"') {  // собираем, пока не дойдем до след. кавычек
                    var = var + symbols[i];
                } else {
                    break;
                }
            }
        return var;
    }


        public String operation (String text) throws Exception{  // Выдергиваем математическое действие

                char[] symbols = text.toCharArray();
                var = "";
                int n = symbols.length;
                for (int i = 1; i < n; i++) {
                    if (symbols[i] == '\"') { // собираем, пока не дойдем до след. кавычек
                        n = i + 1;   //Запоминаем номер с которого продолжим парсить
                    }
                }
                if ((n+2) < symbols.length && symbols[n] == ' ' && (symbols[n + 1] == '/' | symbols[n + 1] == '*' | symbols[n + 1] == '+' | symbols[n + 1] == '-') && symbols[n + 2] == ' ') {   // Проверяем, идет ли после первой переменной пробел, потом проверяем идет ли дальше символы /или*или-или+  и есть ли дальше пробел
                    var = var + symbols[n + 1]; // Получили знак математического действиия
                } else {
                    throw new Exception("Ошибка! Проверь как введен знак математического действия!");
                }
            return var;
        }


        public String secondVar (String text) throws Exception{     // Собираем вторую переменную

                char[] symbols = text.toCharArray();
                var = "";
                int n = symbols.length;
                for (int i = 1; i < n; i++) {
                    if (symbols[i] == '\"') { // собираем, пока не дойдем до след. кавычек
                        n = i + 1;   //Запоминаем номер с которого продолжим парсить
                    }
                }
                if ((n+2) < symbols.length && symbols[n] == ' ' && (symbols[n + 1] == '/' | symbols[n + 1] == '*' | symbols[n + 1] == '+' | symbols[n + 1] == '-') && symbols[n + 2] == ' ') {   // Проверяем, идет ли после первой переменной пробел, потом проверяем идет ли дальше символы /или*или-или+  и есть ли дальше пробел
                    n = n + 3;   //Запоминаем номер с которого продолжим парсить
                }else {
                    throw new Exception("Ошибка! Проверь как введен знак математического действия!");
                }
                if (n < symbols.length && (symbols[n] == '"' | Character.isDigit(symbols[n]))) {  // Проверяем, чтобы третья переменная была строкой или числом. Для этого проверяем корректность записи
                    if (symbols[n] == '"' && symbols[symbols.length - 1] == '"' && n < symbols.length - 1) {  // Если запись верна и у нас кавычки - парсим дальше. Тут у нас собирается строка. Проверим ,чтобы она заканчивалась на ".
                        for (int i = n + 1; i < symbols.length; i++) {  // Собираем третью строковую переменную
                            if (symbols[i] != '\"') {
                                var = var + symbols[i];
                            }
                        }
                    } else {
                        if (n < symbols.length && Character.isDigit(symbols[n]) && symbols[n] != '0') {    //Если в конце цифра, и она не 0, то третья переменная - число
                            if (n == symbols.length - 1) {             // Проверяем, последний ли это символ в массиве?     Если да - то это и есть наша 3я переменная
                                var = var + symbols[n];
                            } else {  // Если нет, проверяем, является ли этот символ единицей, а следующий символ нулем и последним в массиве
                                if (symbols[n + 1] == '0' && symbols[n] == '1' && n + 1 == symbols.length - 1) {
                                    var = "10";  // Если да. то 10
                                } else {
                                    throw new Exception("Ошибка! Проверь как введена вторая переменная!");
                                }
                            }

                        } else {
                            throw new Exception("Ошибка! Проверь как введена вторая переменная!");
                        }
                    }
                } else {
                    throw new Exception("Ошибка! Проверь как введена вторая переменная!");
                }
            return var;
        }


        public boolean isString (String text) throws Exception {   // определяем чем является вторая переменная

                char[] symbols = text.toCharArray();
                int n = symbols.length;
                for (int i = 1; i < n; i++) {
                    if (symbols[i] == '\"') { // перебираем, пока не дойдем до след. кавычек
                        n = i + 1;   //Запоминаем номер с которого продолжим парсить
                    }
                }
                if ((n+2) < symbols.length && symbols[n] == ' ' && (symbols[n + 1] == '/' | symbols[n + 1] == '*' | symbols[n + 1] == '+' | symbols[n + 1] == '-') && symbols[n + 2] == ' ') {   // Проверяем, идет ли после первой переменной пробел, потом проверяем идет ли дальше символы /или*или-или+  и есть ли дальше пробел

                    n = n + 3;   //Запоминаем номер с которого продолжим парсить
                }else {
                    throw new Exception("Ошибка! Проверь как введен знак математического действия!");
                }
                if (n < symbols.length && (symbols[n] == '"' | Character.isDigit(symbols[n]))) {  // Проверяем, чтобы третья переменная была строкой или числом. Для этого проверяем корректность записи
                    if (symbols[n] == '"' && symbols[symbols.length - 1] == '"' && n < symbols.length - 1) {  // Если запись верна и у нас кавычки - парсим дальше. Тут у нас собирается строка. Проверим ,чтобы она заканчивалась на ".
                        isString = true; // флаг, что третья переменная - строка

                    }else {
                        if (n < symbols.length && Character.isDigit(symbols[n]) && symbols[n] != '0') {    //Если в конце цифра, и она не 0, то третья переменная - число
                            isString = false; // флаг, что третья переменная - число

                        } else {
                            throw new Exception("Ошибка! Проверь как введена вторая переменная!");
                        }
                    }
                } else {
                    throw new Exception("Ошибка! Проверь как введена вторая переменная!");
                }

            return isString;
        }

   }
