package java17.com.switchcase;

public class TestSwitch {
    public static void main(String[] args) {
        System.out.println(formatter(Integer.valueOf(124)));

    }

    static  String formatter(Object o){
        String formatted = "unknown";
        if(o instanceof Integer i){
            formatted = String.format("int %d",i);
        } else if (o instanceof Long l) {
            formatted = String.format("long %d",l);
        }
        return formatted;
    }
}
