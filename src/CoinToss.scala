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
object CoinToss {
  case class GameState(tosses: Int, correctGuesses: Int)
  
  def showPrompt: Unit = println(s"\nChoose: (h)eads, (t)ails, or (q)uit: _ ")
  def getUserInput = scala.io.StdIn.readLine.trim.toUpperCase
  
  def tossResult(toss: String): String = toss match {
    case "H" => "Heads"
    case "T" => "Tails"
  }
  
  def printGameState(result: String, gameState: GameState): Unit = {
    print(s"Toss result was $result")
    printCurrentGameState(gameState)
  }
  
  def printCurrentGameState(gameState: GameState): Unit = {
    println(s"\n#Tosses: ${gameState.tosses}, #Correct: ${gameState.correctGuesses}")
  }
  
  def printGameOver: Unit = {
    println("\n===Game Over===")
  }
  
  val r = new scala.util.Random
  r.nextInt(2)
  
  def coinToss(r: Random) = {
    val i = r.nextInt(2)
    i match {
      case 0 => "H"
      case 1 => "T"
    }
  }
  
}