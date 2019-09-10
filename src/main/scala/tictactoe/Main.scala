package tictactoe

import java.util.Scanner

import common.{ConsoleDriver, ConsolePlayer, MiniMaxPlayer, WinLoseDrawGameStateScorer}

object Main extends App {
  val input = new Scanner(System.in)
  val output = System.out
  val ticTacToeGameStateStringifier = TicTacToeGameStateStringifier
  val playerId = TicTacToePlayerId.X
  val aiPlayerId = TicTacToePlayerId.O
  val ticTacToePlayerInputInterpreter = new TicTacToePlayerInputInterpreter(playerId)
  val consolePlayer = new ConsolePlayer[TicTacToeGameState](input, ticTacToePlayerInputInterpreter)
  val playerMoveFinder = new TicTacToeMoveFinder(playerId)
  val aiMoveFinder = new TicTacToeMoveFinder(aiPlayerId)
  val playerGameStateScorer = new WinLoseDrawGameStateScorer[TicTacToeGameState](playerId)
  val aiGameStateScorer = new WinLoseDrawGameStateScorer[TicTacToeGameState](aiPlayerId)
  val aiPlayer = new MiniMaxPlayer[TicTacToeGameState](aiPlayerId, Map(playerId -> playerMoveFinder, aiPlayerId -> aiMoveFinder), Map(playerId -> playerGameStateScorer, aiPlayerId -> aiGameStateScorer), 1)
  val driver = new ConsoleDriver[TicTacToeGameState](output, ticTacToeGameStateStringifier, new TicTacToeGameState(), Map(playerId -> consolePlayer, aiPlayerId -> aiPlayer))

  driver.run()
}
