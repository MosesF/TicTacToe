import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
	
	
	public static void main(String[] args){
		Scanner in;
		String[] board;
		String turn;
		in = new Scanner(System.in);
		board = new String[9];
		turn = "X";
		String winner = null;
		createBoard(board);
		System.out.println("Welcome to Tic Tac Toe");
		showBoard(board);
		System.out.println("X will go first, where would you like to place X?");
		
		while (winner == null) {
			int input;
			try {
				input = in.nextInt();
				if (!(input > 0 && input <= 9)) {
					System.out.println("Invalid input; re-enter slot number:");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input; re-enter slot number:");
				continue;
			}
			if (board[input-1].equals(String.valueOf(input))) {
				board[input-1] = turn;
				if (turn.equals("X")) {
					turn = "O";
				} else {
					turn = "X";
				}
				showBoard(board);
				winner = checkWinner(board, turn);
			} else {
				System.out.println("Slot already taken; re-enter slot number:");
				continue;
			}
		}
		if (winner.equalsIgnoreCase("draw")) {
			System.out.println("It's a draw! Thanks for playing.");
		} else {
			System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
		}
		
	}
	
	static String checkWinner(String[] board, String turn){
		String winner = null;
		if((board[0] == board[1] && board[0] == board[2]) || (board[0] == board[3] && board[0] == board[6]) || (board[0] == board[4] && board[0] == board[8])){
			winner = board[0];
			return winner;
		} else if((board[3] == board[4] && board[4] == board[5]) || (board[1] == board[4] && board[4] == board[7]) || (board[2] == board[4] && board[4] == board[6])){
			winner  = board[4];
			return winner;
		}else if((board[6] == board[8] && board[8] == board[7]) || (board[2] == board[8] && board[8] == board[5])){
			winner = board[8];
			return winner;
		}
		
		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(String.valueOf(a+1))) {
				break;
			}
			else if (a == 8) return "draw";
		}
		
		System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
		return null;
	}
	
	public static void showBoard(String[] board){
		System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
		System.out.println("---|---|---");
		System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
		System.out.println("---|---|---");
		System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
	}
	
	public static void createBoard(String[] board){
		for(int a = 0; a < 9; a++){
			board[a] = String.valueOf(a+1);
		}
	}
}
