import com.itea.dao.EntityDao;
import com.itea.entity.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class JUnitTest {
    @Autowired
    private EntityDao dao;
    @Test
    public void isSaveAndLoad(){

        Teacher teacher = new Teacher();
        teacher.setName("Milana");
        teacher.setSurname("Vecherkovskaya");
        teacher.setPhone("12312");
        teacher.setEmail("mail.ua");

        Group group = new Group();
        group.setNumber(314);
        group.setCurator(teacher);

        Lesson lesson = new Lesson();
        lesson.setGroup(group);
        lesson.setRoom("6.104");
        lesson.setTeacher(teacher);
        lesson.setTitle("SE");

        Student student = new Student();
        student.setName("Vasya");
        student.setSurname("Pupkin");
        student.setGroup(group);
        student.setNumber(123);
        student.setEmail("ex.ua");
        student.setTickets(33);

        Mark mark = new Mark();
        mark.setTeacher(teacher);
        mark.setDate(123);
        mark.setLesson(lesson);
        mark.setMark(5);
        mark.setStudent(student);

        dao.insertTeacher(teacher);
        dao.insertGroup(group);
        dao.insertLesson(lesson);
        dao.insertStudent(student);
        dao.insertMark(mark);

        Student s = dao.findStudent(student.getId());
        //Mark m = dao.getMarksByStudent(s.getId()).get(0);
        Group g = dao.getAllGroups().get(0);

        //Assert.assertEquals(m,mark);
        //Assert.assertEquals(mark,m);

        Assert.assertEquals(s,student);
        Assert.assertEquals(student,s);

        Assert.assertEquals(g,group);
        Assert.assertEquals(group,g);

    }
}
