package study.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); // ConcurrentHashMap 사용해야함.. 동시성 이슈..

    @Override
    public void save(Member member) {

        store.put(member.getId(), member);

    }

    @Override
    public Member findById(Long memberId) {

        return store.get(memberId);
    }
}
