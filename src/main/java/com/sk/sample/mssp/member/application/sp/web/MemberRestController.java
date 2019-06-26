package com.sk.sample.mssp.member.application.sp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sk.sample.mssp.member.domain.model.Member;
import com.sk.sample.mssp.member.domain.service.MemberService;

@RestController
@RequestMapping("/members")
public class MemberRestController implements MemberService {
	@Autowired
	private MemberService memberService;

	@Override
	@GetMapping
	public List<Member> findAll() {
		return memberService.findAll(); 
	}
	
	@Override
	@GetMapping("/{id}")
	public Member findById(@PathVariable("id") Long id) {
		return memberService.findById(id);
	}

	@Override
	@PostMapping
	public Member register(@RequestBody Member member) {
		return memberService.register(member);
	}

	@Override
	@PutMapping("/{id}")
	public Member update(@PathVariable("id") Long id, @RequestBody Member member) {
		return memberService.update(id, member);
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		memberService.delete(id);
	}
	
	@Override
	@GetMapping("/search/name")
	public List<Member> findByNameLike(@RequestParam("name") String name) {
		return memberService.findByNameLike(name);
	}

	@Override
	@GetMapping("/search/email")
	public Member findByEmail(@RequestParam("email") String email) {
		return memberService.findByEmail(email);
	}

	@Override
	//@GetMapping
	public Page<Member> findAll(Pageable pageable) {
		return memberService.findAll(pageable); 
	}


}
