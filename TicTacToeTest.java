import static org.junit.Assert.*;

import org.junit.Test;

public class TicTacToeTest {

	@Test
	public void test() {
		TicTacToe ob = new TicTacToe();
		String[] a1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
		String out = TicTacToe.checkWinner(a1, "X");
		assertEquals(null, out);
		String[] a2 = {"X", "O", "X", "O", "X", "O", "X", "8", "9"};
		String out2 = TicTacToe.checkWinner(a2, "X");
		assertEquals("X", out2);
		String[]a3 = {"O", "O", "O", "X", "5", "X", "X", "8", "9"};
		String out3 = TicTacToe.checkWinner(a3, "X");
		assertEquals("O", out3);
		String[] a4 = {"X", "O", "X", "X", "O", "O", "O", "X", "X"};
		String out4 = TicTacToe.checkWinner(a4, "X");
		assertEquals("draw", out4);
		String[] a5 = {"O", "O", "X", "O", "O", "6", "X", "X", "X"};
		String out5 = TicTacToe.checkWinner(a5, "X");
		assertEquals("X", out5);
		
	}

}
