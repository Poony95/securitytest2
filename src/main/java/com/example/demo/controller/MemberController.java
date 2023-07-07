package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

import lombok.Setter;

@Controller
@Setter
public class MemberController {
	
	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/join")
	public void joinForm() {
	}
	
	@PostMapping("/join")
	public ModelAndView joinSubmit(MemberVO m) {
		ModelAndView mav = new ModelAndView("redirect:/login");
		// insert 하기 전에 암호를 암호화 합니다.
		//String pwd = m.getPwd();
		//String encPwd = passwordEncoder.encode(pwd);
		//m.setPwd(encPwd);
		m.setPwd(passwordEncoder.encode(m.getPwd()));
		try {
			int re = dao.insert(m);
			if(re != 1) {
				mav.setViewName("error");
				mav.addObject("msg", "회원가입에 실패하였습니다.");
			}
		} catch (Exception e) {
			mav.setViewName("error");
			mav.addObject("msg", "회원가입에 실패하였습니다.");
		}
		return mav;
	}
	
	@GetMapping("/service1")
	public void service1(HttpServletRequest request) {
		// 인증된 (로그인) 회원의 정보를 갖고 오기 위해 먼저 시큐리티 인증객체가 필요합니다.
		// 먼저 시큐리티의 인증객체가 필요합니다.
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		// 이 인증객체를 통해 인증된(로그인한) User객체를 받아옵니다.
		User user = (User)authentication.getPrincipal();
		
		// 이 인증된 유저를 통해서 로그인 한 회원의 아이디를 갖고옵니다.
		String id = user.getUsername();
		
		// 이 정보를 세션에 상태유지합니다. 만약, id뿐이 아니라 로그인한 회원의 다른 정보도 필요하다면
		// dao를 통해 회원의 정보를 갖고 와서 상태유지합니다.
		HttpSession session = request.getSession();
		session.setAttribute("id",id);
	}
	
	@GetMapping("/login")
	public void login() {
		
	}
	
}
