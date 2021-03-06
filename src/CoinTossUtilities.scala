import scala.util.Random
import scala.io.StdIn.readLine

object CoinTossUtilities {
  def showPrompt: Unit = println(s"\nChoose: (h)eads, (t)ails, or (q)uit: _ ")
  def getUserInput = readLine.trim.toUpperCase
  
  def printTossResult(toss: String) = toss match {
    case "H" => "Heads"
    case "T" => "Tails"
  }
  
  def printGameState(result: String, gameState: GameState): Unit = {
    print(s"Toss result was $result")
    printGameState(gameState)
  }
  
  def printGameState(gameState: GameState): Unit = {
    println(s"\n#Tosses: ${gameState.numTosses}, #Correct: ${gameState.correctGuesses}")
  }
  
  def printGameOver: Unit = {
    println("\n===Game Over===")
  }
  
  val r = new scala.util.Random
  r.nextInt(2)
  
  def coinToss(r: Random): String = {
    val i = r.nextInt(2)
    i match {
      case 0 => "H"
      case 1 => "T"
    }
  }
}