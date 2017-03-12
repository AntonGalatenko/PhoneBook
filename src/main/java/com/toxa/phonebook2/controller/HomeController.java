package com.toxa.phonebook2.controller;

import com.toxa.phonebook2.Item;
import com.toxa.phonebook2.Items;
import com.toxa.phonebook2.model.Repository;
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

    private Items items = new Items();

//    @Autowired
//    private SessionFactory sessionFactory;

    @Autowired
    private Repository userServise;

    @RequestMapping("/")
    public ModelAndView index(){

//        Session session = sessionFactory.openSession();
        System.out.println("!!!!!!!!!!!!!!! 123");

        User user = new User("log", "pass", "FULL");

//        Phone phone = new Phone("name", "lastName", "patronymic", "phoneMobile", "phoneHome", "address", "email");

//        user.setPhone(phone);

//        session.save(user);
//        session.getTransaction().commit();
//        session.close();
//        new Repository().doSomeThings(user);

        userServise.doSomeThings(user);

        return new ModelAndView("index","list", items.get());
    }

    @RequestMapping("/admin")
    public ModelAndView admin(){
        return new ModelAndView("admin");
    }

    @RequestMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @RequestMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("register");
    }

    @RequestMapping(value = "/add_contact", method = RequestMethod.GET)
    public ModelAndView addPhonePage(){
        return new ModelAndView("add_contact");
    }

    @RequestMapping(value = "/add_contact", method = RequestMethod.POST)
    public ModelAndView addPhoneForm(@RequestParam(value = "name") String name,
                                     @RequestParam(value = "lastname") String lastName,
                                     @RequestParam(value = "phone") String phone,
                                     @RequestParam(value = "description") String description){
        items.add(new Item(name, lastName, phone, description));

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/contact/{phone}", method = RequestMethod.DELETE)
    public ModelAndView deleteItem(@PathVariable String phone){
        items.delete(phone);
        return new ModelAndView("redirect:/");
    }

}
