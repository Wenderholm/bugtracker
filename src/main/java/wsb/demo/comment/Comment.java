package wsb.demo.comment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import wsb.demo.person.Person;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date dateCreated;

    @OneToMany(mappedBy = "comment")
    @JsonIgnoreProperties("comment")
    private Set<Person> people;

    @Column(nullable = false)
    private String content;

    public Comment(String content) {
        this.dateCreated = new Date();
        this.content = content;
    }

    public Comment() {

    }

    public Date getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    public Set<Person> getPeople() {
        return people;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
