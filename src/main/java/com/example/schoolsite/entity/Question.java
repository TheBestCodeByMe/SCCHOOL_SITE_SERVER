package com.example.schoolsite.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {
    private String code;
    private String question;
    private String response;
    private boolean flag;

    public Question(String code, String question, String response, boolean flag) {
        this.code = code;
        this.question = question;
        this.response = response;
        this.flag = flag;
    }


}

/*
@Entity
@Table(name = "questionFromUsers")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "question", nullable = false)
    private String question;
    @Column(name = "response")
    private String response;
    @Column(name = "flag")
    private boolean flag;

    public Question(String question, String response, boolean flag) {
        this.question = question;
        this.response = response;
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return flag == question1.flag && Objects.equals(id, question1.id) && Objects.equals(question, question1.question) && Objects.equals(response, question1.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, response, flag);
    }
}
*/
