package study.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.core.AppConfig;
import study.core.member.MemberService;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //1. 조회 : 호출할 떄 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        //2. 조회 : 호출할 떄 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        // 참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1 != memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }


    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        System.out.println("instance1 = " + instance1);
        System.out.println("instance2 = " + instance2);

        Assertions.assertThat(instance1).isSameAs(instance2);
        // same -> ==
        // equal -> 자바의 equal
        instance1.logic();
    }


//    싱글톤 패턴을 적용하면 고객의 요청이 올 때 마다 객체를 생성하는 것이 아니라,
//    이미 만들어진 객체를 공유해서 효율적으로 사용할 수 있다.
//    하지만 싱글톤 패턴은 다음과 같은 수 많은 문제점들을 가지고 있다.

//    [싱글톤 패턴 문제점]
//    싱글톤 패턴을 구현하는 코드 자체가 많이 들어간다.
//    의존관계상 클라이언트가 구체 클래스에 의존한다. DIP를 위반한다.
//    클라이언트가 구체 클래스에 의존해서 OCP 원칙을 위반할 가능성이 높다.
//    테스트하기 어렵다.
//    내부 속성을 변경하거나 초기화 하기 어렵다.
//    private 생성자로 자식 클래스를 만들기 어렵다.
//    결론적으로 유연성이 떨어진다.
//    안티패턴으로 불리기도 한다.
}
