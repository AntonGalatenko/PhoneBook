package com.toxa.phonebook2.controller;

import com.toxa.phonebook2.model.dao.PhoneDao;
import com.toxa.phonebook2.model.dao.UserDao;
import com.toxa.phonebook2.model.entity.Phone;
import com.toxa.phonebook2.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

//    private Items items = new Items();

    @Autowired
    private UserDao userDao;

    @Autowired
    private PhoneDao phoneDao;

    @RequestMapping(value = {"/", "/index**"})
    public ModelAndView index(){

        System.out.println("!!!!!!!!!!!!!!! INDEX");


//        User user = new User("log", "pass", "FULL");

//        Phone phone = new Phone("name", "lastName", "patronymic", "phoneMobile", "phoneHome", "address", "email");

//        user.setPhone(phone);


//        userServise.doSomeThings(user);

        return new ModelAndView("index","list", phoneDao.getAllPhones());
    }

    @RequestMapping(value = "/add_contact", method = RequestMethod.GET)
    public ModelAndView addPhonePage(){
        User user = new User("login", "password", "fullName");
        userDao.addUser(user);
        Phone phone1 = new Phone("name1", "last name", "patronymic", "+380661234451",
                "0445551121", "Kyev", "email1@gmail.com", user);
        Phone phone2 = new Phone("name2", "last name", "patronymic", "+380661234452",
                "0445551122", "Kyev", "email2@gmail.com", user);
        Phone phone3 = new Phone("name3", "last name", "patronymic", "+380661234453",
                "0445551123", "Kyev", "email3@gmail.com", user);
        Phone phone4 = new Phone("name4", "last name", "patronymic", "+380661234454",
                "0445551124", "Kyev", "email4@gmail.com", user);
        phoneDao.addPhone(phone1);
        phoneDao.addPhone(phone2);
        phoneDao.addPhone(phone3);
        phoneDao.addPhone(phone4);
        return new ModelAndView("add_contact");
    }

    @RequestMapping(value = "/add_contact", method = RequestMethod.POST)
    public ModelAndView addPhoneForm(@RequestParam(value = "name") String name,
                                     @RequestParam(value = "last_name") String lastName,
                                     @RequestParam(value = "patronymic") String patronymic,
                                     @RequestParam(value = "phone_mobile") String phoneMobile,
                                     @RequestParam(value = "phone_home") String phoneHome,
                                     @RequestParam(value = "address") String address,
                                     @RequestParam(value = "email") String email){
        User user = userDao.getUser(1);
        phoneDao.addPhone(new Phone(name, lastName, patronymic, phoneMobile, phoneHome, address, email, user));

        return new ModelAndView("redirect:/index");
    }

    @RequestMapping(value = "/contact/{phoneMobile}", method = RequestMethod.DELETE)
    public ModelAndView deleteItem(@PathVariable String phoneMobile){
        System.out.println("!!!!!!!!!!!! method = RequestMethod.DELETE " + phoneMobile);
        phoneDao.deletePhone(phoneMobile);
        return new ModelAndView("redirect:/index");
    }


//////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/login")
    public ModelAndView login(){

        System.out.println("!!!!!!!!!!!!!!! 123");
        return new ModelAndView("login");
    }

    @RequestMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("register");
    }





}
