package basic;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME) //表示这个注解可以在运行时通过反射访问, 不定义则信息不会保留到运行期
@Target(ElementType.TYPE)//表示注解只能用在类和接口上
@interface ClsAnno {
    int value();
    String name();
    int age() default 0;
}


@Retention(RetentionPolicy.RUNTIME) //表示这个注解可以在运行时通过反射访问, 不定义则信息不会保留到运行期
@Target(ElementType.METHOD)//表示注解只能用在方法上
@interface MethodAnno {
    int value();
    String name();
    int age() default 0;
}

@Retention(RetentionPolicy.RUNTIME) //表示这个注解可以在运行时通过反射访问, 不定义则信息不会保留到运行期
@Target(ElementType.PARAMETER)//表示注解只能用在参数上
@interface ParamAnno {
    int value();
    String name();
    int age() default 0;
}


@Retention(RetentionPolicy.RUNTIME) //表示这个注解可以在运行时通过反射访问, 不定义则信息不会保留到运行期
@Target(ElementType.FIELD)//表示注解只能用在类和接口上
@interface FieldAnno {
    int value();
    String name();
    int age() default 0;
}

/**
 * 反射允许检查或修改程序的运行时行为, 例如获取类, 接口, 变量及方法的信息
 * 自省是根据bean的设计模式来获取bean的属性, 事件和方法 的一系列自动化过程
 *
 * 注解: 描述代码的原数据, 由消费者(其他代码)获取并执行逻辑
 *
 * 自定义注解
 * @Documented: 注解是否将包含在javadoc里面
 * @Retention: 注解留存策略
 *      RetentionPolicy.SOURCE – 在编译阶段丢弃
 *      RetentionPolicy.CLASS – 在类加载的时候丢弃, 默认值
 *      RetentionPolicy.RUNTIME– 始终不会丢弃，运行期也保留该注解, 可以通过反射获取信息 
 * @Target: 适用对象
 *      ElementType.TYPE: 类, 接口, enum
 *      ElementType.FIELD: 描述类的属性
 *      ElementType.METHOD: 描述类的方法
 *      ElementType.PARAMETER: 描述类的方法参数
 *      ElementType.CONSTRUCTOR: 描述类的构造方法
 *      ElementType.LOCAL_VARIABLE: 描述局部变量
 *      ElementType.ANNOTATION_TYPE: 描述另一个注解
 *      ElementType.PACKAGE: 描述java文件的包
 *
 * @Inherited: 是否允许子类继承注解
 *
 * 1. 注解中所有的属性被定义成方法, 并且提供默认值, 属性的值只能是基本数据类型, String, 或Enum
 * 2. 如果注解只有一个属性, 则可以直接定义为value(), 使用时无需标注属性名 @Author("bob") 
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
        System.out.println("moving....");
    }
    public void alive(String b){
        System.out.println("alive ..." + b);
    }

    public static void clsMethod(){
        System.out.println("printed by class method");
    }
}
public class ReflectTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        MethodDemo md = new MethodDemo();
        Class mdCls = md.getClass();
        System.out.println(mdCls.getModifiers());
        System.out.println(Modifier.isFinal(mdCls.getModifiers()));
        System.out.println(Modifier.isStatic(mdCls.getModifiers()));

        //根据方法名获得方法
        Method method = mdCls.getDeclaredMethod("alive", String.class);
        method.invoke(md,"good");//调用时必须加上对象参数
        //private 的方法， 能反射到， 但不能调用

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

        try {
            System.out.println("=========================");
            Class cls = Class.forName("basic.MethodDemo");
            //cls.getSuperclass().getCanonicalName();//获取父类
            //cls.getSuperclass().getSimpleName();//获取父类 简短名
            //cls.getSuperclass().getModifiers();
            //cls.getSuperclass().getPackage(); 包名
            Object o = cls.newInstance();//调用无参构造
            Constructor con = cls.getConstructor(int.class, String.class);//获取有参构造
            Object op = con.newInstance(10, "good");//生成有参构造对象
            Method m1 = cls.getDeclaredMethod("move");//获取无参方法
            m1.invoke(op);
            Method m2 = cls.getDeclaredMethod("alive", String.class);
            m2.invoke(op, "paramValue");

            Method m3 = cls.getDeclaredMethod("clsMethod");//获取静态方法
            m3.invoke(op);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
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

