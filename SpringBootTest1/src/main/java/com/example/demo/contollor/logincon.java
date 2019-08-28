package com.example.demo.contollor;

import com.example.demo.Repository.Dao;
import com.example.demo.Repository.DaoImgl;
import com.example.demo.domain.User;
import com.example.demo.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;


@RestController
public class logincon {
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/login")
    //@ResponseBody
    public Result login( @RequestBody Map map){
        User user = new User((String) map.get("username"),(String)map.get("password"));
        System.out.println("登录 ： "+user.getName() + " 密码　："+user.getPassword());
        Dao dao = DaoImgl.getInstance();
        User user1 = dao.login(user.getName(),user.getPassword());
        if(user1 != null){
            return new Result(200);
        }
        else {
            return new Result(400);
        }
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/register")
    //@ResponseBody
    public Result register(@RequestBody  Map map){
        User user = new User((String) map.get("username"),(String)map.get("password"));
        Dao dao = DaoImgl.getInstance();
        dao.register(user);
        return new Result(400);

    }
}