import java.util.*;
public class Main{


    private static void printBoard(char board[][]){
    
    System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
    System.out.println("-+-+-");
    System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
    System.out.println("-+-+-");
    System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }

    private static void placeMove(char board[][], String position, char symbol){
    

    // player 1 is X
    switch(position){
        case "1": 
            board[0][0] = symbol;
            break;
        case "2": 
            board[0][1] = symbol;
            break;
        case "3": 
            board[0][2] = symbol;
            break;
        case "4": 
            board[1][0] = symbol;
            break;
        case "5": 
            board[1][1] = symbol;
            break;
        case "6": 
            board[1][2] = symbol;
            break;
        case "7": 
            board[2][0] = symbol;
            break;
        case "8": 
            board[2][1] = symbol;
            break;
        case "9": 
            board[2][2] = symbol;
            break;
    }
    System.out.println();

}


// method to check if a spot is filled already for the player or computer to move
    private static boolean isValid (char board[][], String position){
        switch(position){
        case "1": 
            if(board[0][0] == ' '){
                return true;
            }
            else{
                return false;
            }
        case "2": 
            if(board[0][1] == ' '){
                return true;
            }
            else{
                return false;
            }
        case "3": 
            if(board[0][2] == ' '){
                return true;
            }
            else{
                return false;
            }
        case "4": 
            if(board[1][0] == ' '){
                return true;
            }
            else{
                return false;
            }
        case "5": 
            if(board[1][1] == ' '){
                return true;
            }
            else{
                return false;
            }
        case "6": 
            if(board[1][2] == ' '){
                return true;
            }
            else{
                return false;
            }
        case "7": 
            if(board[2][0] == ' '){
                return true;
            }
            else{
                return false;
            }
        case "8": 
            if(board[2][1] == ' '){
                return true;
            }
            else{
                return false;
            }
        case "9": 
            if(board[2][2] == ' '){
                return true;
            }
            else{
                return false;
            }
            default:
            return false;
    }
}

//taking user input

    private static void playerTurn(char board[][]){
        String userInput;
        while(true){
        Scanner s = new Scanner(System.in);
        System.out.println("Where would you like to play? (1-9)");
		userInput = s.nextLine();
        if(isValid(board, userInput)){
            break;
        }
        else{
            System.out.println(userInput + " is invalid");
        }
    }
        placeMove(board, userInput, 'X');
    
    }
// Computer's turn
    private static void computerTurn(char board[][]){
            Random rand = new Random();
    int compMove;
    while(true){
    compMove = rand.nextInt(9) + 1;  //rand.nextInt(9) generates 0,1,2...8 so we add 1 to get 1,2,3...9
    if(isValid(board, Integer.toString(compMove)e)){
        break;// if we break out of the while loop, it's a valid move
    }
    }
    System.out.println();
    System.out.println("Computer's move: " + compMove);
    placeMove(board, Integer.toString(compMove), 'O');
    }

// Who wins
private static boolean Winner(char board[][], char symbol){
     if((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol)||
           (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol)||
           (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol)||
           
           (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol)||
           (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol)||
           (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol)||

           (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)||
           (board[0][2] == symbol && board[1][1] == symbol && board[0][2] == symbol)){
            return true;
           }
           return false;
}


//check if the game is finished
    private static boolean isGameFinished(char[][] board) {
        // Player wins
        if(Winner(board, 'X')){
        printBoard(board);
        System.out.println("Player wins!");
        }
        //Computer Wins
        if(Winner(board, 'X')){
        printBoard(board);
        System.out.println("Player wins!");
        }

        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("TIE!");
        return true;
    }

public static void main(String[] args) {
    char board[][] = {{' ', ' ', ' '}, 
                      {' ', ' ', ' '},
                      {' ', ' ', ' '}};
    printBoard(board);
    System.out.println();
while(true){
//take user input
playerTurn(board);
if(isGameFinished(board)){
  break;  
}
  printBoard(board);

//for computer's move
computerTurn(board);
if(isGameFinished(board)){
  break;  
}
printBoard(board);
}
}


}