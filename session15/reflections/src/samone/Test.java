package samone;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test{
    public static void main(String args[]) throws Exception {
        Class c=Class.forName("samone.Dog");
        System.out.println(c.getName());
        System.out.println(c.getConstructor());

        Dog d1 = new Dog();

        // create an object of Class
        // using getClass()
        Class obj = d1.getClass();

        // get name of the class
        String name = obj.getName();
        System.out.println("Name: " + name);

        // get the access modifier of the class
        int modifier = obj.getModifiers();

        // convert the access modifier to string
        String mod = Modifier.toString(modifier);
        System.out.println("Modifier: " + mod);

        // get the superclass of Dog
        Class superClass = obj.getSuperclass();
        System.out.println("Superclass: " + superClass.getName());


        Method[] methods = obj.getDeclaredMethods();

        // create an object of the Method class
        for (Method m : methods) {

            // get names of methods
            System.out.println("Method Name: " + m.getName());

            // get the access modifier of methods
            int methodModifier = m.getModifiers();
            System.out.println("Modifier: " + Modifier.toString(methodModifier));

            // get the return types of method
            System.out.println("Return Types: " + m.getReturnType());
            System.out.println(" ");

        }
        System.out.println("----------");
        Field[] fields = obj.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("fieled name:"+field.getName());
            System.out.println("fieled modifier:"+Modifier.toString(field.getModifiers()));

        }

// access the private field color
        Field field1 = obj.getDeclaredField("color");

        // allow modification of the private field
        field1.setAccessible(true);

        // set the value of color
        field1.set(d1, "brown");

        // get the value of field color
        String colorValue = (String) field1.get(d1);
        System.out.println("Value: " + colorValue);

        System.out.println("-------------");

        // get all constructors of Dog
        Constructor[] constructors = obj.getDeclaredConstructors();

        for (Constructor cons : constructors) {

            // get the name of constructors
            System.out.println("Constructor Name: " + cons.getName());

            // get the access modifier of constructors
            // convert it into string form
            int consmodifier = cons.getModifiers();
            String consmod = Modifier.toString(consmodifier);
            System.out.println("Modifier: " + consmod);

            // get the number of parameters in constructors
            System.out.println("Parameters: " + cons.getParameterCount());
            System.out.println("");
        }

        //run method
        Method method = obj.getDeclaredMethod("display", null);
        method.invoke(d1, null);

         Method method2 = obj.getDeclaredMethod("makeSound", null);
        method2.setAccessible(true);

        method2.invoke(d1, null);

         Method method3 = obj.getDeclaredMethod("print", String.class);
        method3.setAccessible(true);

        method3.invoke(d1, new Object[]{"Dojjj"});





    }
} 