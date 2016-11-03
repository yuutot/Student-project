import com.itea.dao.EntityDao;
import com.itea.entity.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
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
        teacher.setPassword("123");

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
        student.setPassword("123");

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
        Mark m = dao.getMarksByStudent(s.getId(), lesson.getId()).get(0);
        Group g = dao.getAllGroups().get(0);
        Lesson l = dao.getLessonsByGroup(g.getNumber()).get(0);
        Teacher t = dao.findTeacher(teacher.getId());
        Student sp = dao.getStudentByPassword(student.getEmail(),student.getPassword());
        Teacher tp = dao.getTeacherByPassword(teacher.getEmail(),teacher.getPassword());
        Lesson lt = dao.getLessonsByTeacher(t.getId(),g.getNumber()).get(0);
        Group gr = dao.getAllGroups().get(0);

        Assert.assertEquals(m,mark);
        Assert.assertEquals(mark,m);

        Assert.assertEquals(s,student);
        Assert.assertEquals(student,s);

        Assert.assertEquals(g,group);
        Assert.assertEquals(group,g);

        Assert.assertEquals(l,lesson);
        Assert.assertEquals(lesson,l);

        Assert.assertEquals(t,teacher);
        Assert.assertEquals(teacher,t);

        Assert.assertEquals(tp,teacher);
        Assert.assertEquals(teacher,tp);

        Assert.assertEquals(sp,student);
        Assert.assertEquals(student, sp);

        Assert.assertEquals(lt,lesson);
        Assert.assertEquals(lesson,lt);

        Assert.assertEquals(gr,group);
        Assert.assertEquals(group,gr);
    }
}
