/*Simple Coin Toss Scala Game CLI
 *The user will be asked to select heads or tails the prompt will look like this:
 * Choose: (h)eads, (t)ails, or (q)uit: _
 * 
 * If the user selects heads or tails then the program "fips" a virtual coin and 
 * displays the output showing the result of the toss as well as number of total tosses
 * The number of correct guesses displays like this:
 * Toss result was Heads. #Tosses: 1, #Correct: 1
 * 
 * The end of the game displays the total number of tosses and the total number of correct
 * guesses as well displaying the end of the game.
 * 
 * */
import scala.util.Random
import scala.io.StdIn.readLine
import CoinTossUtilities._
import scala.annotation.tailrec

case class GameState(tosses: Int, correctGuesses: Int)

object CoinToss extends App{
	val r = Random
	val s = GameState(0, 0)

	mainLoop(s, r)

	@tailrec
	def mainLoop(gameState: GameState, random: Random) = {
			//prompt the user for input
			showPrompt

			//get the user's input
			val userInput = getUserInput

			userInput match {
					case "H" | "T" => {
  					//flip the coin
  					val coinTossResult = coinToss(random)
  					val newNumTosses = gameState.tosses + 1
  
  					//compare the user's input with toss result
  					if (userInput == coinTossResult) {
  						//then user guessed right
  						//write the output
  					 mainLoop(newGameState, random)
  					} 
  					else {
  					  //then user guessed wrong
  					  //write the output
  					  mainLoop(newGameState, random)
  					} 
					}
					case _ => {
					  //assume typed "Q"
					  printGameOver
					  printCurrentGameState(gameState)
					  //exit game
					}
			}

					//write the output

					//if user hasn't typed "q" then loop again
					mainLoop(newGameState, random)
	}

}



