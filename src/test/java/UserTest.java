import com.toxa.phonebook2.config.RepositoryConfig;
import com.toxa.phonebook2.model.dao.UserDao;
import com.toxa.phonebook2.model.dao.impl.UserDaoImpl;
import com.toxa.phonebook2.model.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepositoryConfig.class)
public class UserTest extends AbstractJUnit4SpringContextTests{

    @Autowired
    private UserDao userDao;

    @Test
    public void testInsertFind(){
        User user = new User("login", "password", "fullName");
        try{
            User u = userDao.addUser(user);
            User userFind = userDao.getUser(u.getId());
            assertEquals(user, userFind);
            userDao.deleteUser(userFind);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testInsertFindUpdate(){
        User user = new User("login", "password", "fullName");
        try{
            User u = userDao.addUser(user);
            User userFind = userDao.getUser(u.getId());
            userFind.setFullName("second full name");
            userDao.updateUser(userFind);
            User userFindUpdate = userDao.getUser(userFind.getId());
            assertEquals(userFind, userFindUpdate);
            userDao.deleteUser(userFindUpdate);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete(){
        User user = new User("login", "password", "fullName");
        try{
            User u = userDao.addUser(user);
            User userFind = userDao.getUser(u.getId());
            userDao.deleteUser(userFind);
            User userAfterDeleting = userDao.getUser(u.getId());
            assertNull(userAfterDeleting);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
