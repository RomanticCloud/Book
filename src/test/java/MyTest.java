import com.wang.pojo.Books;
import com.wang.service.BookService;
import com.wang.service.BookServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookServiceImpl bookServiceImpl = (BookServiceImpl) context.getBean("bookServiceImpl");
        for (Books queryAllBook : bookServiceImpl.queryAllBooks()) {
            System.out.println(queryAllBook);
        }
    }
}