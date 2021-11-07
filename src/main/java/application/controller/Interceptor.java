package application.controller;

import java.lang.reflect.Array;
import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import application.model.User;

@Component
public class Interceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {

    	try {  //Mivel minden request előtt fut, nem lenne valami jó ha dobna egy kivételt
	    	HttpSession session = request.getSession();
	    	
	    	User user = (User)session.getAttribute("user");
	    	boolean bejelentkezve = true;
	    	if(user == null) {
	    		bejelentkezve = false;
	    	}
	    	
	    	Cookie[] cookies = request.getCookies();
	    	boolean setBejelentkezve = false;
	    	
	    	for(Cookie cookie : cookies) {
	    		if(cookie.getName().equals("bejelentkezve")) {
	    			setBejelentkezve = true;
	    		}
	    	}
	    	
	    	if(!bejelentkezve && setBejelentkezve) {
				Cookie cookie = new Cookie("bejelentkezve", null);
				cookie.setPath("/");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
	    	}
	    	if(bejelentkezve && !setBejelentkezve) {
				String val = "1";
				if(user.getJogosultsag() == true) {
					val = "2";
				}
				Cookie cookie = new Cookie("bejelentkezve", val);
				
				response.addCookie(cookie);
	    	}
    	}
    	catch(Exception ex) {
    		
    	}
    	
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

        super.postHandle(request, response, handler, modelAndView);
    }

}
