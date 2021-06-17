package rozdzial6.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TraceHandler implements InvocationHandler {
    private Object target;
    /*
    Tworzy obiekt TraceHandler
    parametr 'target' niejawny wywolania metody
     */

    public TraceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //Drukowanie argumentu niejawnego
        System.out.print(target);
        //Drukowanie nazwy metody
        System.out.print("." + method.getName() + "(");
        //Drukowanie argumentow jawych
        if(args != null){
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
                if (i<args.length - 1)
                    System.out.println(", ");
            }
        }
        System.out.println(")");
        //rzeczywiste wywolanie metody
        return method.invoke(target, args);
    }
}
