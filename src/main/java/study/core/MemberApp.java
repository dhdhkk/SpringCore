package study.core;

import study.core.member.Grade;
import study.core.member.Member;
import study.core.member.MemberService;
import study.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();

        Member memberA = new Member(1L, "memberA", Grade.VIP);

        memberService.join(memberA);

        Member memberFind = memberService.findMember(1L);

        System.out.println("memberA = " + memberA.getName());
        System.out.println("memberFind = " + memberFind.getName());
    }
}
