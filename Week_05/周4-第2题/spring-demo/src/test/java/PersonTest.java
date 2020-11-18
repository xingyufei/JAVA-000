import io.xingyufei.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: PersonTest
 * Description:
 * Author: xyf
 * Date: 2020-11-18 22:19
 * Version: 1.0
 **/
public class PersonTest
{
    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) applicationContext.getBean("person");
        person.hello();
    }
}
