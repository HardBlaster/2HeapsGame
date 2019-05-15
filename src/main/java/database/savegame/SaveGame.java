package database.savegame;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Class representing the data of a saved game.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class SaveGame {

    /**
     * The generated ID of the saved game.
     */
    @GeneratedValue
    @Id
    private int id;

    /**
     * The name of the first player.
     */
    @Column(nullable = false)
    private String player1;

    /**
     * The name of the second player.
     */
    @Column(nullable = false)
    private String player2;

    /**
     * Amount of rocks in the first heap.
     */
    @Column(nullable = false)
    private int rocks1;

    /**
     * Amount of rocks in the second heap.
     */
    @Column(nullable = false)
    private int rocks2;

    /**
     * Shows which player has to take rocks next.
     */
    @Column(nullable = false)
    private boolean isActivePlayer;

}

