package stady.hibernate.myhibernate.first;

import javax.persistence.*;

@Entity
@Table(name = "UserMessage")
public class UserMassage {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Message", unique = false, updatable = true )
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
