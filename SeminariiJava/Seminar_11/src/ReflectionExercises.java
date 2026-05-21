import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionExercises {

    static void main(String[] args) {
        try {

            Class<?> studentClass = Student.class;

            System.out.println("Class name:       " + studentClass.getName());
            System.out.println("Simple name:      " + studentClass.getSimpleName());
            System.out.println("Package:          " + studentClass.getPackageName());
            System.out.println("Superclass:       " + studentClass.getSuperclass().getName());

            Class<?>[] interfaces = studentClass.getInterfaces();
            if (interfaces.length == 0) {
                System.out.println("Interfaces:       none");
            } else {
                for (Class<?> i : interfaces) {
                    System.out.println("Interface:        " + i.getName());
                }
            }


            Field[] fields = studentClass.getDeclaredFields();
            for (Field field : fields) {
                String modifier = Modifier.toString(field.getModifiers());
                String type = field.getType().getSimpleName();
                String name = field.getName();
                System.out.println(modifier + " " + type + " " + name);
            }


            Method[] methods = studentClass.getDeclaredMethods();
            for (Method method : methods) {
                String modifier = Modifier.toString(method.getModifiers());
                String returnType = method.getReturnType().getSimpleName();
                String methodName = method.getName();


                StringBuilder params = new StringBuilder();
                for (Class<?> param : method.getParameterTypes()) {
                    if (params.length() > 0) params.append(", ");
                    params.append(param.getSimpleName());
                }

                System.out.println(modifier + " " + returnType + " " + methodName + "(" + params + ")");
            }


            Constructor<?> noArgConstructor = studentClass.getConstructor();
            Object student4 = noArgConstructor.newInstance();


            Constructor<?> fullConstructor = studentClass.getConstructor(String.class, int.class);
            Object student5 = fullConstructor.newInstance("Ana", 20);

            Method sayHello = studentClass.getMethod("sayHello");
            sayHello.invoke(student5);


            Object student6 = studentClass.getConstructor(String.class, int.class)
                    .newInstance("Mihai", 22);

            Field nameField = studentClass.getDeclaredField("name");
            nameField.setAccessible(true);

            System.out.println("Original name: " + nameField.get(student6));

            nameField.set(student6, "Mihai Ionescu");
            System.out.println("Modified name: " + nameField.get(student6));
            System.out.println("Object now:    " + student6);

            Object student7 = studentClass
                    .getConstructor(String.class, int.class, String.class)
                    .newInstance("Elena", 21, "elena@student.ro");

            Method secretInfo = studentClass.getDeclaredMethod("secretInfo");
            secretInfo.setAccessible(true);
            secretInfo.invoke(student7);


            Object s1 = studentClass.getConstructor().newInstance();
            System.out.println("Student() " + s1);


            Object s2 = studentClass.getConstructor(String.class).newInstance("Ion");
            System.out.println("Student(String) " + s2);


            Object s3 = studentClass.getConstructor(String.class, int.class).newInstance("Maria", 19);
            System.out.println("Student(String, int)  " + s3);

            Object s4 = studentClass.getConstructor(String.class, int.class, String.class)
                    .newInstance("Andrei", 23, "andrei@uni.ro");
            System.out.println("Student(String, int, String)  " + s4);

            Object studentToInspect = studentClass
                    .getConstructor(String.class, int.class, String.class)
                    .newInstance("Ana", 20, "ana@uni.ro");

            inspect(studentToInspect);

            Object studentForJson = studentClass
                    .getConstructor(String.class, int.class, String.class)
                    .newInstance("Ana", 20, "ana@uni.ro");

            String json = toJson(studentForJson);
            System.out.println(json);

            String csvHeader = "name,age,email";
            String csvRow = "Bogdan,25,bogdan@uni.ro";

            Object studentFromCsv = fromCsv(studentClass, csvHeader, csvRow);
            System.out.println("Created from CSV: " + studentFromCsv);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void inspect(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        System.out.println("Inspecting: " + clazz.getSimpleName());

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println("  " + field.getName() + " = " + field.get(obj));
        }
    }

    static String toJson(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            String fieldName = fields[i].getName();
            Object fieldValue = fields[i].get(obj);

            sb.append("\"").append(fieldName).append("\":");


            if (fieldValue instanceof String) {
                sb.append("\"").append(fieldValue).append("\"");
            } else {
                sb.append(fieldValue);
            }

            if (i < fields.length - 1) sb.append(",");
        }
        sb.append("}");
        return sb.toString();
    }

    static Object fromCsv(Class<?> clazz, String header, String row) throws Exception {
        String[] columns = header.split(",");
        String[] values = row.split(",");

        Object obj = clazz.getConstructor().newInstance();

        for (int i = 0; i < columns.length; i++) {
            String colName = columns[i].trim();
            String value = values[i].trim();

            try {
                Field field = clazz.getDeclaredField(colName);
                field.setAccessible(true);


                if (field.getType() == int.class) {
                    field.set(obj, Integer.parseInt(value));
                } else if (field.getType() == double.class) {
                    field.set(obj, Double.parseDouble(value));
                } else {
                    field.set(obj, value); // String
                }
            } catch (NoSuchFieldException e) {
                System.out.println("  Warning: no field named '" + colName + "' in " + clazz.getSimpleName());
            }
        }
        return obj;
    }
}
