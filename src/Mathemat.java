


public class Mathemat {  // считаем


    // Метод сложения сток
    public String plusFunc (String a, String b){
        return "\"" + a + b + "\"";
    }

    // Метод умножения строки на число
    public String multFunc (String a,int c){
        return "\"" + a.repeat(c) + "\"";
    }

    // Метод вычитания строки
    public String minusFunc (String a, String b){
        String minus;
        int index = a.indexOf(b);
        if (index >= 0) {
            minus = "\"" + a.substring(0, index) + a.substring(b.length() + index) + "\"";
        } else {
            minus = "\"" + a + "\"";
        }
        return minus;
    }

    // Метод деления строки
    public String divFunc (String a,int c){
        int g = a.length() / c;
        return "\"" + a.substring(0, g) + "\"";
    }
}
