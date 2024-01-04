
import model.Game;
import model.Hand;
import model.ScannerUserInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameTest {

    private Game game;

    @Mock
    private ScannerUserInput mockScannerUserInput;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        game = new Game(mockScannerUserInput);
    }

    @Test
    public void testSetNumRounds() {
        // Assume user enters a valid number 3 for rounds
        when(mockScannerUserInput.nextInt()).thenReturn(3);
        when(mockScannerUserInput.nextLine()).thenReturn(""); // simulate user hitting enter

        game.setNumRounds();
        assertEquals(3, game.getRoundsLeft(), "The number of rounds should be set to 3");
    }

    @Test
    public void testPlayRoundAndScoreUpdateWin() {
        // Mocking user input and computer hand
        when(mockScannerUserInput.nextLine()).thenReturn("R"); // User chooses Rock

        game = spy(game); // Spy on actual game object to mock internal methods

        doReturn(Hand.SCISSORS).when(game).requestComputerHand(); // Computer chooses Scissors

        game.playRound();
        assertEquals(1, game.getUserScore(), "User should have a score of 1");
        assertEquals(0, game.getComputerScore(), "Computer should have a score of 0");
    }

    @Test
    public void testPlayRoundAndScoreUpdateLoss() {
        // Mocking user input and computer hand
        when(mockScannerUserInput.nextLine()).thenReturn("S"); // User chooses Scissors

        game = spy(game); // Spy on actual game object to mock internal methods

        doReturn(Hand.ROCK).when(game).requestComputerHand(); // Computer gets Rock

        game.playRound();
        assertEquals(0, game.getUserScore(), "User should have a score of 0");
        assertEquals(1, game.getComputerScore(), "Computer should have a score of 1");
    }
}
