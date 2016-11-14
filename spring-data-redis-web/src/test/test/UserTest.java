import com.shinyleo.spring.model.User;
import com.shinyleo.spring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhugh on 16/11/14.
 */
public class UserTest {

    public static void main(String[] args){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-test.xml");
        UserService userService = ctx.getBean("userService",UserService.class);

        User user = new User();
        user.setUserName("zhugh");
        user.setAge("20");
        userService.save(user.getUserName(),user);

        User user1 = userService.getUser(user.getUserName());
        System.out.println("user.age:" + user1.getAge());

    }
}
