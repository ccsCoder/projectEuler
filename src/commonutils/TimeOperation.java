/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commonutils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author NISHANTG
 */
public class TimeOperation {
    public static long timeTaken;
    private static Method method;
    private static Object []args;
    

    public static void init(Method method,Object []arguments) {
        System.out.println(arguments.length);
        TimeOperation.method = method;
        args = new Object[arguments.length];
        TimeOperation.args=arguments;
    }
    
    
    
    public static Object executeWithTimer() {
        Object invoke = null;
        try {
            TimeOperation.timeTaken = System.currentTimeMillis();
            System.out.println(args[0]);
            invoke = method.invoke(args,null);
            TimeOperation.timeTaken = System.currentTimeMillis() - timeTaken ;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        
        return invoke;
        
    }
    
   
    
    
}
