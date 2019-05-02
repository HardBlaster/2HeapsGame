package sample;

import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Score {

    @GeneratedValue
    @Id
    private Long id;

    @Column(nullable = false)
    private String player_name;

    @Column(nullable = false)
    private int score;

}