import com.toxa.phonebook2.config.RepositoryConfig;
import com.toxa.phonebook2.model.dao.PhoneDao;
import com.toxa.phonebook2.model.dao.UserDao;
import com.toxa.phonebook2.model.entity.Phone;
import com.toxa.phonebook2.model.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepositoryConfig.class)
public class PhoneTest extends AbstractJUnit4SpringContextTests{

    @Autowired
    private UserDao userDao;

    @Autowired
    private PhoneDao phoneDao;

    @Test
    public void testInsertPhonesWhitUser(){
        User user = new User("login", "password", "fullName");

        Set<Phone> phones = new HashSet<Phone>();
        Phone phone1 = new Phone("name1", "last name", "patronymic", "+380661234455",
                "0445551122", "Kyev", "email@gmail.com", user);
        Phone phone2 = new Phone("name2", "last name", "patronymic", "+380661234455",
                "0445551122", "Kyev", "email@gmail.com", user);
        Phone phone3 = new Phone("name3", "last name", "patronymic", "+380661234455",
                "0445551122", "Kyev", "email@gmail.com", user);
        Phone phone4 = new Phone("name4", "last name", "patronymic", "+380661234455",
                "0445551122", "Kyev", "email@gmail.com", user);

        phones.add(phone1);
        phones.add(phone2);
        phones.add(phone3);
        phones.add(phone4);

        user.setPhones(phones);

        try{
            User u = userDao.addUser(user);
            User userFind = userDao.getUser(u.getId());
            assertEquals(user, userFind);

            Set<Phone> phonesFind = userFind.getPhones();
            for(Phone ph : phonesFind)
                assertEquals(phones.contains(ph), true);

            userDao.deleteUser(userFind);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void InsertFinder(){
        User user = new User("login", "password", "fullName");
        Phone phone = new Phone("name123", "last name", "patronymic", "+380661234455",
                "0445551122", "Kyev", "email@gmail.com", user);

        try{
            userDao.addUser(user);
            Phone p = phoneDao.addPhone(phone);
            Phone phoneFinder = phoneDao.getPhone(p.getPhoneMobile());
            assertEquals(phone, phoneFinder);
            phoneDao.deletePhone(p.getPhoneMobile());
            userDao.deleteUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete(){
        User user = new User("login", "password", "fullName");
        Phone phone = new Phone("name12", "last name", "patronymic", "+380661234455",
                "0445551122", "Kyev", "email@gmail.com", user);
        try{
            userDao.addUser(user);
            Phone p = phoneDao.addPhone(phone);
            Phone phoneFinder = phoneDao.getPhone(p.getPhoneMobile());
            phoneDao.deletePhone(phoneFinder.getPhoneMobile());
            Phone phoneAfterDelete = phoneDao.getPhone(phoneFinder.getPhoneMobile());
            assertNull(phoneAfterDelete);
            userDao.deleteUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
