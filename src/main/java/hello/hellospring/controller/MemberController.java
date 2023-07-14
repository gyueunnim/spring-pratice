package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// Spring 컨터이너에 컨트롤러를 넣어두고 관리함
@Controller
public class MemberController {

    private final MemberService memberService;

    // 생성자 주입 -> 가장 권장, 생성 시 객체 결정
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

//    다른 방식 - 필드 주입 -> 별로 안좋음
//    @Autowired private MemberService memberService;

//    다른 방식 - 세터 주입 -> 중간에 잘못 바뀔 우려
//    private MemberService memberService;
//    @Autowired
//    public void setMemberController(MemberService memberService) { // Setter 호출
//        this.memberService = memberService;
//    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "/members/memberList";
    }
}
