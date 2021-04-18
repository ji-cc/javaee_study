
import duck.Duck;
import duck.Duck2;
import duck.Duck3;
import duck.DuckShop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        /*
        spring 开启容器的方式：ApplicationContext 应用上下文（可以配置并管理Bean对象）
        ClassPathXmlApplicationContext 根据classpath 路径，指定一个xml文件（配置文件）
        并根据配置文件完成配置工作（如Bean实例化对象）
         */
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applications.xml");

        Duck d1 = (Duck) context.getBean("d1");
        System.out.println(d1);   // Duck{name='duck', age=12}

        Duck2 d2 = (Duck2) context.getBean("d2");
        System.out.println(d2);  // Duck{name='烤鸭', age=2}

        Duck3 d3 = (Duck3) context.getBean("dk1");
        System.out.println(d3);
        // Duck3{name='北京烤鸭', age=2, next=Duck3{name='甜皮鸭', age=1, next=Duck3{name='酱鸭', age=3, next=null}}}

        DuckShop duckShop = (DuckShop) context.getBean("shop");
        System.out.println(duckShop);
        // DuckShop{ducks=[Duck{name='s1', age=12}, Duck{name='s2', age=12}, Duck{name='s3', age=12}]}


    }
}
