import com.itea.dao.EntityDao;
import com.itea.dao.impl.MarkDaoImpl;
import com.itea.entity.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JUnitTest {
    @Test
    public void isSaveAndLoad(){
        ApplicationContext ctx =new ClassPathXmlApplicationContext("classpath:application-context.xml");
        EntityDao<Mark> dao = ctx.getBean(MarkDaoImpl.class);
        Teacher teacher = new Teacher("Maria","Ivanova","33568","mail.ua");
        Group group = new Group(123, teacher);
        Lesson lesson = new Lesson("Algebra", "6.110в",group,teacher);
        Student student = new Student("Ivan", "Ivanov", group,13221,"ex.ua",41521);
        Mark mark = new Mark(lesson,teacher,student, 5, 123);
        dao.insert(mark);
        Mark m = dao.find(mark.getId());
        Assert.assertEquals(mark,m);
        Assert.assertEquals(m,mark);
    }
}
