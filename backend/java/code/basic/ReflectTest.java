import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/**
 * Created by white on 17/5/24.
 * 反射允许检查或修改程序的运行时行为, 例如获取类, 接口, 变量及方法的信息
 * 自省是根据bean的设计模式来获取bean的属性, 事件和方法 的一系列自动化过程
 */
 interface Alive{
    void move();
 }

@ClsAnno(name="clsAnno", value=100)
final class MethodDemo implements Alive{
    private int num = 2;
    @FieldAnno(name="fieldAnno", value=200)
    public String str = "hello";
    public MethodDemo(){
    }

    public MethodDemo(int num, String str){
        this.num = num;
        this.str = str;
    }
    public int getNum(){
        return this.num;
    }
    public void setNum(int num){
        this.num = num;
    }
    @MethodAnno(name="methodAnno", value=10)
    public int addResult(@ParamAnno(name="paramAnno", value=30)int addNum){
        return  num +  addNum;
    }
    public void move(){
    }
    private void alive(){
    }
}
public class ReflectTest {
    public static void main(String[] args) {
        MethodDemo md = new MethodDemo();
        Class mdCls = md.getClass();
        System.out.println(mdCls.getModifiers());
        System.out.println(Modifier.isFinal(mdCls.getModifiers()));
        System.out.println(Modifier.isStatic(mdCls.getModifiers()));

        Class intCls = Integer.class;
        System.out.println(intCls.getPackage());//获取类的包信息

        Class[] interfaces = mdCls.getInterfaces();//获取类实现的接口
        for(int i=0;i<interfaces.length;i++){
            System.out.println(interfaces[i]);
        }

        Constructor[] constructors = mdCls.getConstructors();
        for(int i=0;i<constructors.length;i++){
            System.out.println(constructors[i]);
            Constructor cst = constructors[i];
            Class[] c = cst.getParameterTypes();//获取参数信息
            for(int j=0;j<c.length;j++){
                System.out.println(c[j]);
            }
        }

        Method[] methods = mdCls.getMethods(); //获取所有public方法
        for(int k=0;k<methods.length;k++){
            if(isGetter(methods[k])){
                System.out.println("getter: " + methods[k]);
            }
            if(isSetter(methods[k])){
                System.out.println("setter: " + methods[k]);
            }

        }
        try {
//            Method addResult = mdCls.getMethod("addResult", new Class[]{String.class}); //error
//            Method addResult = mdCls.getMethod("addResult", new Class[]{Integer.class}); //error
            Method addResult = mdCls.getMethod("addResult", new Class[]{int.class});//根据方法名称和参数类型获取
            Annotation[][] paramAnnotations = addResult.getParameterAnnotations();
            Class[] paramTypes = addResult.getParameterTypes();
            for(Annotation[] annotations : paramAnnotations){
                for(Annotation annotation : annotations){
                    ParamAnno pa = (ParamAnno) annotation;
                    System.out.println("parameter anno name: " + pa.name());
                    System.out.println("parameter anno value: "  + pa.value());
                    System.out.println("parameter anno age: "  + pa.age());
                }
            }
            System.out.println(addResult.getReturnType()); //获取返回值类型
        }catch(NoSuchMethodException e){
            e.printStackTrace();
        }

        Method[] declaredMethods = mdCls.getDeclaredMethods();//获取所有类型方法, 包含protected, private, 不包含继承的方法
        for(int z=0;z<declaredMethods.length;z++){
            System.out.println("declared methods: " + declaredMethods[z]);
        }


        Field[] fields = mdCls.getFields();//列出所有public的属性, 包括从父类继承的
        for(int x=0;x<fields.length;x++){
            System.out.println(fields[x]);
        }
        try {
            Field f = mdCls.getField("str");//获取属性对象
            System.out.println(f.getName());//获取属性名称
            System.out.println(f.getType());//获取属性类型

            System.out.println(f.get(md));//根据Field获取, 修改对象的值
            f.set(md, "good");
            System.out.println(f.get(md));

            Annotation[] fAnnos = f.getAnnotations();
            for(Annotation fa: fAnnos){
                if(fa instanceof FieldAnno){
                    FieldAnno fAnno = (FieldAnno) fa;
                    System.out.println("field anno name: " + fAnno.name());
                    System.out.println("field anno value: " + fAnno.value());
                    System.out.println("field anno age: " + fAnno.age());
                }
            }
        }catch(NoSuchFieldException e){
            e.printStackTrace();
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }

        Field[] declaredFields = mdCls.getDeclaredFields();//返回所有类型属性, 排除继承来的属性
        for(int y=0;y<declaredFields.length;y++){
            System.out.println(declaredFields[y]);
        }

        Annotation[] annos = mdCls.getAnnotations(); //类注解
        for(Annotation anno: annos){
            if(anno instanceof ClsAnno){
                ClsAnno myAnno = (ClsAnno)anno;
                System.out.println("class anno name: " + myAnno.name());
                System.out.println("class anno value: " + myAnno.value());
                System.out.println("class anno age: " + myAnno.age());
            }
        }

        try {
            Method addMethod = MethodDemo.class.getMethod("addResult", int.class);
            Annotation[] methodAnnos = addMethod.getAnnotations();
            for(Annotation anno: methodAnnos){
                if(anno instanceof MethodAnno){
                    MethodAnno manno = (MethodAnno)anno;
                    System.out.println("method anno name: " + manno.name());
                    System.out.println("method anno value: " + manno.value());
                    System.out.println("method anno age: " + manno.age());
                }
            }
        }catch(NoSuchMethodException e){
            e.printStackTrace();
        }
    }

    public static boolean isGetter(Method method){
        if(!method.getName().startsWith("get"))      return false;
        if(method.getParameterTypes().length != 0)   return false;
        if(void.class.equals(method.getReturnType())) return false;
        return true;
    }

    public static boolean isSetter(Method method){
        if(!method.getName().startsWith("set")) return false;
        if(method.getParameterTypes().length != 1) return false;
        return true;
    }

}

