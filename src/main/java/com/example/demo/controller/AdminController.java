package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("/admin/menu1")
	public void menu1() {
		System.out.println("admin 컨트롤러의 메뉴1 요청 처리입니다.");
	}
	@GetMapping("/admin/menu2")
	public void menu2() {
		System.out.println("admin 컨트롤러의 메뉴2 요청 처리입니다.");
	}
}
