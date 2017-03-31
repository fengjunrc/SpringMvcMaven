package com.danmo.controller;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.danmo.base.BaseController;
import com.danmo.model.User;
import com.danmo.service.UserService;
import com.danmo.utils.Json;
import com.danmo.utils.PageHelper;
import com.danmo.utils.PageResult;
@Controller  
public class UserController  extends BaseController{
	private final static Logger log= Logger.getLogger(UserController.class);
	@Resource
	private UserService userService;
	
    @RequestMapping(value="userList",method=RequestMethod.GET)  
    public void queryList(Model model){  
    	List<User> list =userService.queryList();
        model.addAttribute("userList", list);  
        System.out.println(list.size());  
    } 
    
    
    @RequestMapping(value="user/login",method=RequestMethod.POST)  
    public String login(Model model,@RequestParam("username")String username,
    		@RequestParam("password")String password){  
    	User user = new User();
    	user.setUsername(username);
    	user.setPassword(password);
    	List<User> list = userService.queryByName(username);
    	if(list.size()==0){
    		userService.insert(user);
    	}
    	System.out.println(list.size());
        model.addAttribute("username", username);  
    	return "webuploader";
    }  
    
    @RequestMapping(value="user/queryByPage",method=RequestMethod.POST)  
    public Json queryByPage(Model model,PageHelper page){
    	Json json = new Json();
    	long total = userService.queryTotal();
    	List<User> list = userService.queryByPage(page);
    	model.addAttribute("list", list);
    	model.addAttribute("total", total);
    	json.setObj(model);
		return null;
    }
    
    
    @RequestMapping(value="toPage",method=RequestMethod.GET)  
    public String toPage(){
		return "userPage";
    }
    
    
   /* @ResponseBody  
    @RequestMapping(value="queryByPage",method=RequestMethod.POST)  
	public String  queryByPage(Integer pageNumber,Integer pageSize ,String userName){  
    	try {  
            PageResult<User> pageResult = userService.queryByPage(userName, pageNumber,pageSize);
           return responseSuccess(pageResult);  
        } catch (Exception e) {  
            return responseFail(e.getMessage());
        	
        }  
	}  */

    
    @ResponseBody  
    @RequestMapping(value="queryByPage",method=RequestMethod.POST)  
	public Json  queryByPage(Integer pageNumber,Integer pageSize ,String userName){  
    	Json json = new Json();
    	try {  
            PageResult<User> pageResult = userService.queryByPage(userName, pageNumber,pageSize);
            json.setObj(pageResult);
            json.setMsg("success");
            return json;
           // return responseSuccess(pageResult);  
        } catch (Exception e) {  
            //return responseFail(e.getMessage());
        	json.setMsg("fail");
        	return json;
        }  
	}  
    
    @RequestMapping(value="updateUser",method=RequestMethod.GET)
    public void update(){
    	User user = new User(); 
    	user.setId(1);
    	user.setUsername("update1");
    	user.setPassword("pass1");
    	User user2 = new User(); 
    	user2.setId(2);
    	user2.setUsername("update2222");
    	userService.update(user);
    	userService.update(user2);
    }
    
    
    @RequestMapping(value="addUser",method=RequestMethod.GET)
	public void addUserTest(){  
	    User user = new User();
	    user.setUsername("111");
	    user.setPassword("111");
	    userService.addUser(user);
	}  
    
    
    
   
}  