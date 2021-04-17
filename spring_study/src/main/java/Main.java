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
    }
}