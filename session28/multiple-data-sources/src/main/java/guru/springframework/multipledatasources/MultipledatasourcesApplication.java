package guru.springframework.multipledatasources;

import guru.springframework.multipledatasources.model.card.Card;
import guru.springframework.multipledatasources.model.cardholder.CardHolder;
import guru.springframework.multipledatasources.model.member.Member;
import guru.springframework.multipledatasources.repository.card.CardRepository;
import guru.springframework.multipledatasources.repository.cardholder.CardHolderRepository;
import guru.springframework.multipledatasources.repository.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MultipledatasourcesApplication implements ApplicationRunner {
    
    @Autowired
    CardRepository cardRepository;

    @Autowired
    CardHolderRepository cardHolderRepository;

    @Autowired
    MemberRepository memberRepository;

    public static void main(String[] args) {
        SpringApplication.run(MultipledatasourcesApplication.class, args);
        System.out.println();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Card card = new Card();
        card.setExpirationMonth(6956);
        card.setName("cs");
        card.setExpirationYear(2021);
        cardRepository.save(card);
        ////////////////////////////////////////////

        CardHolder cardHolder = new CardHolder();
        cardHolder.setCardNumber("3232");
        cardHolder.setMemberId("6596");
        cardHolderRepository.save(cardHolder);

        //////////////////////////////////////
        Member member = new Member();
        member.setMemberId("545");
        member.setName("6596");
        memberRepository.save(member);


    }
}
