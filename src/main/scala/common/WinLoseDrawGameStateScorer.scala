package common

import common.WinDraw.{Draw, Win}
import tictactoe.{TicTacToeGameState, TicTacToeGameStateStringifier}

class WinLoseDrawGameStateScorer[G <: WinDrawGameState](playerId: PlayerId[G]) extends GameStateScorer[G] {
  override def score(gameState: G): Double = {
    if (!gameState.complete) {
      0.0
    } else {
      println(TicTacToeGameStateStringifier.stringify(gameState.asInstanceOf[TicTacToeGameState]))
      gameState.winner match {
        case Win(`playerId`) => println(s"$playerId Win"); Double.PositiveInfinity
        case Win(_) => println(s"$playerId Lose"); Double.NegativeInfinity
        case Draw => println("Draw"); 0.0
      }
    }
  }
}
