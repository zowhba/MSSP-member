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

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/members")
public class MemberRestController implements MemberService {
	@Autowired
	private MemberService memberService;
	
	@Override
	@GetMapping
	@ApiOperation(value="전체 회원 조회")
	public List<Member> findAll() {
		return memberService.findAll(); 
	}
	
	@Override
	@ApiIgnore
	@GetMapping("/{id}")
	public Member findById(@PathVariable("id") Long id) {
		return memberService.findById(id);
	}

	@Override
	@PostMapping
	@ApiOperation(value="회원가입")
	public Member register(@RequestBody Member member) {
		return memberService.register(member);
	}

	@Override
	@ApiIgnore
	@PutMapping("/{id}")
	public Member update(@PathVariable("id") Long id, @RequestBody Member member) {
		return memberService.update(id, member);
	}

	@Override
	@ApiIgnore
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		memberService.delete(id);
	}
	
	@Override
	@ApiIgnore
	@GetMapping("/search/name")
	public List<Member> findByNameLike(@RequestParam("name") String name) {
		return memberService.findByNameLike(name);
	}

	@Override
	@ApiIgnore
	@GetMapping("/search/email")
	public Member findByEmail(@RequestParam("email") String email) {
		return memberService.findByEmail(email);
	}
	
	@Override
	@GetMapping("/search/userId")
	public Member findByUserId(@RequestParam("userId") String userId) {
		return memberService.findByUserId(userId);
	}

	@Override
	//@GetMapping
	public Page<Member> findAll(Pageable pageable) {
		return memberService.findAll(pageable); 
	}


}
