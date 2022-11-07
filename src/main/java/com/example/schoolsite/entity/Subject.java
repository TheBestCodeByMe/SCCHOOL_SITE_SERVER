package com.example.schoolsite.entity;

import com.google.firebase.database.annotations.NotNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
public class Subject {
    @Id
    @GeneratedValue //(strategy = GenerationType.AUTO)
    @GraphQLQuery(name="id", description = "A subject`s id")
    private Long id;
    //@Column(name = "subjectName", nullable = false)
    @GraphQLQuery(name="subject_name", description = "A subject`s name")
    private @NotNull
    String subjectName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(id, subject.id) && Objects.equals(subjectName, subject.subjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjectName);
    }
}
