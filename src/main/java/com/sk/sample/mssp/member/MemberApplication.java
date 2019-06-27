package com.sk.sample.mssp.member;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.querydsl.core.types.Predicate;

import com.sk.sample.mssp.member.domain.model.Member;
import com.sk.sample.mssp.member.domain.model.MemberType;

import com.sk.sample.mssp.member.domain.repository.MemberRepository;
import com.sk.sample.mssp.shared.domain.Address;

import springfox.documentation.annotations.ApiIgnore;

@SpringBootApplication
public class MemberApplication {
	public static void main(String[] args) {
		SpringApplication.run(MemberApplication.class, args);
	}

	@Bean
	public CommandLineRunner execSampleCode(MemberRepository memberRepository) {	
		return (args) -> {
			insertMembers(memberRepository);
			displayMembers(memberRepository);
			
		};
	}
		
	public void insertMembers(MemberRepository memberRepository) {
		
		Member member1 = new Member("id123","1234","hong@sk.com", "홍길동", "01012345678");
		member1.setAddress(new Address(12345, "서울시 강남구"));
		memberRepository.save(member1);
		
		Member member2 = new Member("kang","5678","kang@sk.com", "강호동", "01011114444");
		member2.setAddress(new Address(54321, "경기도 성남시"));
		memberRepository.save(member2);
		
		Member member3 = new Member("yu","12345","yu@gmail.com", "유재석", "01022334589");
		member3.setAddress(new Address(01112, "경기도 이천시"));
		memberRepository.save(member3);
		
		Member member4 = new Member("shin","0000","shin@sk.com", "신동엽", "01098765432");
		member4.setAddress(new Address(98765, "인천시 남동구"));
		memberRepository.save(member4);
	}
	
	public void displayMembers(MemberRepository memberRepository) {
		System.out.println("***************************************************************");
		
		Iterable<Member> memberList = memberRepository.findAll();
		for(Member member : memberList) {
			System.out.println(member.toString());	
		}
		
		System.out.println("***************************************************************");
	}
	
	
}
