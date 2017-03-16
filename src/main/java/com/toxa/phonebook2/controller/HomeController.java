package com.toxa.phonebook2.controller;

import com.toxa.phonebook2.model.dao.PhoneDao;
import com.toxa.phonebook2.model.dao.UserDao;
import com.toxa.phonebook2.model.entity.Phone;
import com.toxa.phonebook2.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.plugin2.message.GetAuthenticationMessage;

@Controller
public class HomeController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PhoneDao phoneDao;

    @RequestMapping(value = {"/", "/index**"})
    public ModelAndView index(){
        User user = userDao.getUser(getPrincipal());
        return new ModelAndView("index","list", user.getPhones());
    }

    @RequestMapping(value = "/add_contact", method = RequestMethod.GET)
    public ModelAndView addPhonePage(){
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
        User user = userDao.getUser(getPrincipal());
        phoneDao.addPhone(new Phone(name, lastName, patronymic, phoneMobile, phoneHome, address, email, user));

        return new ModelAndView("redirect:/index");
    }

    @RequestMapping(value = "/contact/{phoneMobile}", method = RequestMethod.DELETE)
    public ModelAndView deleteItem(@PathVariable String phoneMobile){
        phoneDao.deletePhone(phoneMobile);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @RequestMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("register");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@RequestParam(value = "login") String login,
                                 @RequestParam(value = "fullName") String fullName,
                                 @RequestParam(value = "password") String password) {
        userDao.addUser(new User(login, password, fullName));
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/getUserInfo")
    public @ResponseBody String users(){

        String login = getPrincipal();

//        System.out.println("auth.getName() " + email);

        return userDao.getUser(login).getFullName();
    }

    private String getPrincipal(){
        String login = "";

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails)
            login = ((UserDetails)principal).getUsername();
        else
            login = principal.toString();

        return login;
    }



}
