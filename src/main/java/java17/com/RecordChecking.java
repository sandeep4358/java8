package java17.com;

import java.lang.reflect.Field;

public class RecordChecking {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
    new RecordChecking().go();
    }

    public  void go() throws NoSuchFieldException, IllegalAccessException {

        Employee employee = new Employee(12,"AAAAA");
        System.out.println("before :: "+employee);

        Field nameField = employee.getClass().getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(employee,"BBBBB");

        System.out.println("after :: "+employee);

    }

    private static void changeTheFinalFieldValueForNoRecord(){



    }


    final class Employee{
        private final int id;
        private final String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
