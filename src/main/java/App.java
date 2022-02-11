import domain.model.*;
import domain.repository.PaymentRepository;
import infra.InMemoryMemberRepository;
import infra.InMemoryPaymentRepository;
import infra.PaymentFactory;
import domain.repository.MemberRepository;
import infra.MemberFactory;

import java.io.InvalidObjectException;

public class App {
    public static void main(String[] args) throws InvalidObjectException {
        MemberRepository memberRepository = new InMemoryMemberRepository();
        RegistrationService registrationService = new RegistrationService(memberRepository);
        Member tradesmanMember = MemberFactory.createTradesman(
                memberRepository.nextIdentity(),
                "John",
                "Doe",
                "JohnDoe@test.com");
        registrationService.registerMember(tradesmanMember);

        PaymentRepository paymentRepository = new InMemoryPaymentRepository();
        PaymentService paymentService = new PaymentService(paymentRepository, memberRepository);
        Payment payment = PaymentFactory.createInitialPayment(
                paymentRepository.nextIdentity(),
                tradesmanMember
        );
        paymentService.processPayment(payment);
    }
}
