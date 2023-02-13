
/*3/18/19
 * 
 * The GameofLifeClass reads a string in as a 2 dimensional array to create a game of life board. Contains methods used to modify the game of life board, 
 * return properties of the board, and create the next generation of the game of life board using Conway's rules to the game of life.
 * 
 * William Field
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameofLifeBoard {

	private boolean[][] current;// represents the current game baord
	private boolean[][] next;// represents the next game board
	
	public GameofLifeBoard(java.lang.String file_name) throws FileNotFoundException {// constructor, throws
																						// FileNotFoundException in the
																						// case of difficulty in finding
																						// the file

		Scanner input;// reads from the file
		int rows;
		int columns;
		String board;// represents the board in string form

		input = new Scanner(new File(file_name));

		rows = input.nextInt();// reading array length in rows and columns
		columns = input.nextInt();

		current = new boolean[rows][columns];// Initializing both arrays
		next = new boolean[rows][columns];
		board = "";// board starts as an empty string

		while (input.hasNext()) {// reads the rest of the file and adds into board
			board += input.nextLine();

		}

		for (int row = 0; row < current.length; row++) {// nested for loops creates the board
			for (int column = 0; column < current.length; column++) {
				char x;// x is the current char in board
				int place = (int) (((double) row + (0.1 * (double) column)) * 10);// place is made equal to row.column *
																					// 10, this is each cells place in
																					// the string

				x = board.charAt(place);
				if (x == '*') {// makes the bool array true or false depending on what char 'x' is
					current[row][column] = true;
				} else if (x == '.')
					current[row][column] = false;
				else {
				}

			}

		}

		input.close();// closing input
	}

	public int rows() {// returns how many rows are in the array
		return current.length;
	}

	public int columns() {// returns how many columns are in the array
		return current[0].length;
	}

	public void toggle(int row, int column) {// inverts the occupancy of a cell
		boolean b;
		b = current[row][column];

		current[row][column] = !b;
	}

	public boolean isAlive(int row, int column) {// returns whether a cell is alive

		return current[(row + rows()) % rows()][(column + columns()) % columns()];// wraps the board at the edges
	}

	public int neighbours(int row, int column) {// determines and returns how many neighbors a cell has
		int neighbours;
		neighbours = 0;

		if (isAlive(row - 1, column)) {// if statements check whether each neighboring cell at the inputed row and
										// column is alive
			neighbours++;
		}

		if (isAlive(row + 1, column)) {
			neighbours++;
		}

		if (isAlive(row, column + 1)) {
			neighbours++;
		}

		if (isAlive(row, column - 1)) {
			neighbours++;
		}

		if (isAlive(row + 1, column + 1)) {
			neighbours++;
		}

		if (isAlive(row - 1, column + 1)) {
			neighbours++;
		}

		if (isAlive(row + 1, column - 1)) {
			neighbours++;
		}

		if (isAlive(row - 1, column - 1)) {
			neighbours++;

		}

		return neighbours;
	}

	public boolean lives(boolean occupied, int neighbours) {// applies the GameofLife rules to determine whether a cell
															// is alive in the next generation
		boolean lives;
		lives = false;
		if (occupied && (neighbours == 2 || neighbours == 3)) {// if the cell is occupied and has 2 or 3 neighbors it
																// lives
			lives = true;
		} else if (!occupied && neighbours == 3) {// if a cell is not alive and has 3 neighbors it lives
			lives = true;

		} else if (neighbours < 2 || 3 < neighbours) {// if a cell has less than 2 or more than 3 neighbors it dies
			lives = false;
		}
		return lives;
	}

	public void nextGeneration() {// creates the next generation of the GameofLifeBoard
		boolean[][] temp;// used to reassign the boards

		for (int row = 0; row < current.length; row++) {// nested for loop creates the board
			for (int column = 0; column < current[row].length; column++) {
				next[row][column] = lives(current[row][column], neighbours(row, column));// creates the next board using
																							// the lives method

			}
		}

		temp = current;// temp made equal to the current board
		current = next;// next is now the current board
		next = temp;// next is made equal to the temp board

	}

	public void printNeighbours() {// prints a board the same size as the GameofLifeBoard that shows how many
									// neighbors each cell has in integers

		for (int row = 0; row < current.length; row++) {// nested for loop prints the neighbors of each cell
			for (int column = 0; column < current[row].length; column++) {
				System.out.print(neighbours(row, column));
			}
			System.out.print('\n');// breaks the line of the string at each row
		}
	}

	public String toString() {// returns the output of the board as a string
		String result;

		result = "";

		for (int row = 0; row < current.length; row++) {// nested for loop creates the string
			for (int column = 0; column < current[row].length; column++) {
				if (current[row][column] == true) {// if true at [row] [column] an asterisk is added to the string
					result = result + "*";
				} else if (current[row][column] == false) {// if false at [row] [column] a period is added to the string
					result = result + ".";
				} else {
				}
			}
			result = result + '\n';// breaks the line at each row
		}

		return result;
	}

}
