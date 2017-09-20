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

case class GameState(numTosses: Int, correctGuesses: Int)

object CoinToss extends App{
	val r = new Random
	val s = GameState(0, 0)

	mainLoop(s, r)

	@tailrec
	def mainLoop(gameState: GameState, random: Random): Unit = {
			//prompt the user for input
			showPrompt
			//get the user's input
			val userInput = getUserInput
			userInput match {
					case "H" | "T" => {
  					//flip the coin
  					val coinTossResult = coinToss(random)
  					val newNumTosses = gameState.numTosses + 1
  
  					//compare the user's input with toss result
  					if (userInput == coinTossResult) {
  						//then user guessed right
  					  val newNumCorrect = gameState.correctGuesses + 1
  					  val newGameState = gameState.copy(numTosses = newNumTosses, correctGuesses = newNumCorrect)
  						printGameState(printTossResult(coinTossResult), newGameState)
  					 mainLoop(newGameState, random)
  					} 
  					else {
  					  val newGameState = gameState.copy(numTosses = newNumTosses)
  					  printGameState(printTossResult(coinTossResult), newGameState)
  					  //write the output
  					  mainLoop(newGameState, random)
  					} 
					}
					case _ => {
					  //assume typed "Q"
					  //exit game
					  printGameOver
					  printGameState(gameState)
					}
			}
	}

}



