package edu.javaee.core.web.controller;
import javax.servlet.http.HttpSession;
import edu.javaee.core.po.User;
import edu.javaee.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: customerManager
 * @description: ..
 * @author: 张清
 * @create: 2019-06-27 23:04
 **/
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 跳转到登录界面
     * */
    @RequestMapping(value = "/login.action" ,method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }
    /**
     * 用户登录操作
     * */
    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    public String login(String usercode, String password, Model model,HttpSession session){
        User user = userService.findUser(usercode, password);
        if(user != null){
            session.setAttribute("USER_SESSION", user);
			return "customer";
//            return "redirect:customer/list.action";
        }
        model.addAttribute("msg", "账号或密码错误！");
        return "login";
    }

    /**
     * 退出登录
     * */
    @RequestMapping(value = "/logout.action")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:login.action";
    }
}
