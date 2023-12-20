package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//Controller 애노테이션이 있으면 스프링이 뜰때 알아서 만들어서 관리해준다.
@Controller
public class MemberController {
    private final MemberService memberService;

    //Autowired 를 사용하면 스프링 컨테이너에서 memberService를 가져다가 사용한다.
    //heloController는 스프링이 실행될 때 자동적으로 스프링 컨테이너에 등록된다.
    //그러나 memberService는 순수한 자바 클래스라서 스프링이 인식하지 못한다.
    //그렇기 때문에 @Service를 넣어주면 된다. (memberSErvice 클래스에)
    //그리고 Repository는 @Repository 해주어야 한다.


    /*
    스프링 빈을 등록하는 2가지 방법
    1. 컴포넌트 스캔과 자동 의존관계 설정 @Service, @Repository, @Autowired
    2. 카바 코드로 직접 스프링 빈 등록하기

    과거에는 원래 xml로 설정 하였다. 최근에는 잘 사용하지 않으므로 생략
    생성자를 통해서 set 하는것을 생성자 주입, DI에는 3가지 방법이 있는데 생성자 주입, 필드에 @Autowired 하는
    필드 주입 (변경 방법이 없음), setter주입(set이 public해지기 때문에 변경될 문제 있음)
    따라서 요즘은 의존관계가 실행중에 동적으로 변하는 경우가 거의 없기 때문에 생성자 주입 방식을 선호.

    실무에서는 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용한다. 그리고 정형화 되지 않거나,
    상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록한다.


     */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
