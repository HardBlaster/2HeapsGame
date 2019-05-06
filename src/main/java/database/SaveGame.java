package database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class SaveGame {

    @GeneratedValue
    @Id
    private int id;

    @Column(nullable = false)
    private String player1;

    @Column(nullable = false)
    private String player2;

    @Column(nullable = false)
    private int rocks1;

    @Column(nullable = false)
    private int rocks2;

}

