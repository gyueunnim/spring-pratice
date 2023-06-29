package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// Spring 컨터이너에 컨트롤러를 넣어두고 관리함
@Controller
public class MemberController {

    private final MemberService memberService;

    // 생성자 주입 -> 가장 권장
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

//    다른 방식 - 필드 주입 -> 별로 안좋음
//    @Autowired private MemberService memberService;

//    다른 방식 - 세터 주입 -> 중간에 잘못 바뀔 우려
//    private MemberService memberService;
//
//    @Autowired
//    public MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }
}
