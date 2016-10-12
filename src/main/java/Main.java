import com.itea.dao.EntityDao;
import com.itea.dao.impl.MarkDaoImpl;
import com.itea.entity.Lesson;
import com.itea.entity.Mark;
import com.itea.entity.Student;
import com.itea.entity.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx =new ClassPathXmlApplicationContext("classpath:application-context.xml");
        EntityDao<Mark> dao = ctx.getBean(MarkDaoImpl.class);
        //Mark mark = new Mark(new Lesson("Alg"),
        //            new Teacher("Maria","Ivanova","33568","mail.ua"),
        //            new Student("Ivan","Ivaanov"), 5, new Date(12));
        //dao.insert(mark);
        //System.out.println(dao.find(mark.getId()));
    }
}
