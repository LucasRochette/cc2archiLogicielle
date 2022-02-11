package infra;

import domain.model.Contractor;
import domain.model.Member;
import domain.model.Contractor;
import domain.model.MemberId;
import domain.model.Tradesman;
import domain.repository.MemberRepository;


import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MemberFactory implements MemberRepository {

    private static final String EMAIL_PATTERN = "^(.+)@(\\S+)$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);


    public static boolean emailIsValid(final String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    public static Member createContractor(MemberId id, String firstname, String lastname, String email) {
        Member contractor = Contractor.of(id, firstname, lastname, email);
        if(contractor.getFirstName().equals("") || contractor.getLastName().equals("")) {
            throw new IllegalArgumentException("Firstname and Lastname can't be empty");
        }
        if(!emailIsValid(contractor.getEmail())){
            throw new IllegalArgumentException("Invalid email");
        }
        return contractor;
    }

    public static Member createTradesman(MemberId id, String firstname, String lastname, String email) {
        Member tradesman = Tradesman.of(id, firstname, lastname, email);
        if(tradesman.getFirstName().equals("") || tradesman.getLastName().equals("")) {
            throw new IllegalArgumentException("Firstname and Lastname can't be empty");
        }
        if(!emailIsValid(tradesman.getEmail())){
            throw new IllegalArgumentException("Invalid email");
        }
        return tradesman;
    }

    @Override
    public MemberId nextIdentity() {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public Member findById(MemberId id) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public Optional<Member> findById(String email) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public void save(Member member) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }


}
