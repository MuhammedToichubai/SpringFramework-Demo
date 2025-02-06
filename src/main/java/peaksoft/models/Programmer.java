package peaksoft.models;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Entity
@Table(name = "programmers")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Programmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    public Programmer(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
