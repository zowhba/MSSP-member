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
			
			executeExample1(memberRepository);
		};
	}
		
	public void insertMembers(MemberRepository memberRepository) {
		
		Member account1 = new Member("id123","1234","hong@sk.com", "홍길동", "01012345678");
		memberRepository.save(account1);
		
		Member account2 = new Member("kang","5678","kang@sk.com", "강호동", "01011114444");
		memberRepository.save(account2);
		
		Member account3 = new Member("yu","12345","yu@gmail.com", "유재석", "01022334589");
		memberRepository.save(account3);
		
		Member account4 = new Member("shin","0000","shin@sk.com", "신동엽", "01098765432");
		memberRepository.save(account4);
	}
	
	public void displayMembers(MemberRepository memberRepository) {
		System.out.println("***************************************************************");
		
		Iterable<Member> memberList = memberRepository.findAll();
		for(Member member : memberList) {
			System.out.println(member.toString());	
		}
		
		System.out.println("***************************************************************");
	}
	
	
	public void executeExample1(MemberRepository memberRepository) {
		Member member = memberRepository.findByEmail("hong@sk.com");
		
//		account.setAddress(Address.builder().zipCode(10000).homeAddress("경기도 성남시").build());
//		accountRepository.save(account);
//		
		displayMembers(memberRepository);
	}
		
	
}
