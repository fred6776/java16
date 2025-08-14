import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void shouldAddPlayersAndGetId() {
        Player player2 = new Player(21, "Роман", 45);
        int expected = 21;
        int actual = player2.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldRoundFirstPlayerWin() {
        Player player1 = new Player(11, "Виталий", 70);
        Player player2 = new Player(2, "Роман", 45);
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Виталий", "Роман");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldRoundFirstPlayerLose() {
        Player player1 = new Player(11, "Виталий", 40);
        Player player2 = new Player(2, "Роман", 45);
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Виталий", "Роман");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldRoundDraw() {
        Player player1 = new Player(11, "Виталий", 40);
        Player player2 = new Player(2, "Роман", 40);
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Виталий", "Роман");
        Assertions.assertEquals(expected, actual);
    }


    @Test
    void shouldNullNamePlayer1() {
        Player player1 = new Player(11, "Виталий", 40);
        Player player2 = new Player(2, "Роман", 45);
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Вита", "Роман");
        });
    }

    @Test
    void shouldNullNamePlayer2() {
        Player player1 = new Player(11, "Виталий", 40);
        Player player2 = new Player(2, "Роман", 45);
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Виталий", "Рома");
        });
    }
}
