package domain.model;

public class Member {
    private final MemberId id;
    private final String firstname;
    private final String lastname;
    private final String email;

    protected Member(MemberId id, String firstname, String lastname, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public static Member of(MemberId id, String firstname, String lastname, String email) {
        return new Member(id, firstname, lastname, email);
    }

    public MemberId getId() {
        return id;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }
}
