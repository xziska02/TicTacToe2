package com.ziska.peter.tictactoe;

import com.ziska.peter.tictactoe.Model.Game;
import com.ziska.peter.tictactoe.Model.PlayerBadge;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void fillCell_correctValue() {
        Game game = new Game();
        game.fillCell(0,0);
        PlayerBadge badge = game.getCellBadge(0,0);
        assertEquals("Expected PlayerBadge.O",PlayerBadge.O.name(), badge.name());
        assertEquals("Expected null on empty cell",null,game.getCellBadge(1,1));
        game.changePlayer();
        game.fillCell(1,1);
        badge = game.getCellBadge(1,1);
        assertEquals("Switching player after one move (PlayerBadge.X)",PlayerBadge.X.name(), badge.name());
    }

    @Test
    public void gameReset(){
        Game game = new Game();
        game.fillCell(0,0);
        game.changePlayer();
        game.fillCell(1,1);
        game.restartGame();
        assertEquals("Game is not restarted",null,game.getCellBadge(0,0));
        assertEquals("Game is not restarted",null,game.getCellBadge(1,1));
        assertEquals("Game is not restarted",null,game.getCellBadge(2,2));
    }

}