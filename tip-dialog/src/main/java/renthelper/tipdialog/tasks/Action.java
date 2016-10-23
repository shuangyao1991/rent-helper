package renthelper.tipdialog.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with by shuangyao on 2016/10/21.
 */
public class Action{

    private static final Logger logger = LoggerFactory.getLogger(Action.class);

    public static void main(String[] args) {
        logger.debug("Start initializing...");
        System.setProperty("spring.profiles.active", "test");
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("classpath*:/spring-context.xml");
        System.setProperty("spring.profile.active", "test");
        logger.debug("End initializing...");
    }



}
