package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

import com.example.demo.db.DBManager;
import com.example.demo.vo.MemberVO;

@SpringBootApplication
public class Securitytest2Application {

	public static void main(String[] args) {
		
		/* 실습을 위해 메인에서 직접 membervo에 정보를 넣어서 insert함 , 암호는 암호화 하여 넣어줍니다.
		MemberVO kim = new MemberVO();
		kim.setId("kim");
		kim.setPwd(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("kim"));
		kim.setName("김연아");
		kim.setRole("user");
		
		MemberVO lee = new MemberVO();
		lee.setId("lee");
		lee.setPwd(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("lee"));
		lee.setName("이순신");
		lee.setRole("admin");
		
		DBManager.insertMember(kim);
		DBManager.insertMember(lee);
		System.out.println("두명의 사용자를 추가함!");
		*/
		SpringApplication.run(Securitytest2Application.class, args);
	}

}
