import com.itea.dao.EntityDao;
import com.itea.dao.impl.MarkDaoImpl;
import com.itea.entity.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class JUnitTest {
    @Autowired
    @Qualifier("MarkDao")
    private EntityDao<Mark> dao;
    @Test
    public void isSaveAndLoad(){
        Teacher teacher = new Teacher("Maria","Ivanova","33568","mail.ua");
        Group group = new Group(2131, teacher);
        Lesson lesson = new Lesson("Algebra", "6.110в",group,teacher);
        Student student = new Student("Ivan", "Ivanov", group,13221,"ex.ua",41521);
        Mark mark = new Mark(lesson,teacher,student, 5, 123);
        dao.insert(mark);
        Mark m = dao.find(mark.getId());
        System.out.println(m);
        Assert.assertEquals(mark,m);
        Assert.assertEquals(m,mark);
    }
}
