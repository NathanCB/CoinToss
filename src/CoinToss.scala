/*Simple Coin Toss Scala Game CLI
 *The user will be asked to select heads or tails the prompt will look like this:
 * Choose: (h)eads, (t)ails, or (q)uit: _
 * 
 * If the user selects heads or tails then the program "fips" a virtual coin and 
 * displays the output  showing the result of the flip as well as number of total flips
 * and the number of correct guesses like this:
 * Flip was Heads. #Flips: 1, #Correct: 1
 * 
 * */

object CoinToss {
  case class GameState(flips: Int, correctGuesses: Int)
  def showPrompt: Unit = println(s"\nChoose: (h)eads, (t)ails, or (q)uit: _ ")
  def getUserInput = scala.io.StdIn.readLine.trim.toUpperCase
  
  
}