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

        Teacher teacher = new Teacher();
        teacher.setName("Maria");
        teacher.setSurname("Ivanova");
        teacher.setPhone("12312");
        teacher.setEmail("mail.ua");

        Group group = new Group();
        group.setNumber(new Random().nextInt());
        group.setCurator(teacher);

        Lesson lesson = new Lesson();
        lesson.setGroup(group);
        lesson.setRoom("6.104");
        lesson.setTeacher(teacher);
        lesson.setTitle("Algebra");

        Student student = new Student();
        student.setName("Ivan");
        student.setSurname("Ivan");
        student.setGroup(group);
        student.setNumber(123123);
        student.setEmail("ex.ua");
        student.setTickets(62312);

        Mark mark = new Mark();
        mark.setTeacher(teacher);
        mark.setDate(123);
        mark.setLesson(lesson);
        mark.setMark(5);
        mark.setStudent(student);

        dao.insert(mark);
        Mark m = dao.find(mark.getId());
        Assert.assertEquals(m,mark);
        Assert.assertEquals(mark,m);
    }
}
