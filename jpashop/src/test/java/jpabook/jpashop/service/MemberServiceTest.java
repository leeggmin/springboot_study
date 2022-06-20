package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

//@RunWith(SpringRunner.class)
//@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService;

    @Test
    @DisplayName("회원가입")
    public void joinTest() throws Exception {
        //given
        Member member = new Member();
        member.setName("Kim");

        //when
        Long saveId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test
    public void validateDuplicateMemberTest() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("Kim");
        Member member2 = new Member();
        member2.setName("Kim");

        //when
        memberService.join(member1);

        //then
        IllegalStateException exception = assertThrows(IllegalStateException.class,
                ()-> memberService.join(member2));
        assertEquals("이미 존재하는 회원입니다.",exception.getMessage());
    }
}