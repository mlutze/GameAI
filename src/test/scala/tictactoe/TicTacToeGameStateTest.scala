package tictactoe

import common.WinDraw.Win
import org.scalatest.FlatSpec
import tictactoe.TicTacToeTile.{EMPTY, O, X}

class TicTacToeGameStateTest extends FlatSpec {

  private val xWonBoards = Seq(

    Seq(
      Seq(X, X, X),
      Seq(EMPTY, EMPTY, EMPTY),
      Seq(EMPTY, EMPTY, EMPTY)
    ),
    Seq(
      Seq(X, EMPTY, EMPTY),
      Seq(EMPTY, X, EMPTY),
      Seq(EMPTY, EMPTY, X)
    ),
    Seq(
      Seq(X, EMPTY, EMPTY),
      Seq(X, EMPTY, EMPTY),
      Seq(X, EMPTY, EMPTY)
    ),
    Seq(
      Seq(EMPTY, EMPTY, X),
      Seq(EMPTY, X, EMPTY),
      Seq(X, EMPTY, EMPTY)
    )
  )

  "A won board" should "find a winner" in {
    xWonBoards map {
      board => new TicTacToeGameState(board)
    } foreach {
      gameState => assert(gameState.winner.equals(Win(TicTacToePlayerId.X)))
    }
  }

  "A won board" should "be complete" in {
    xWonBoards map {
      board => new TicTacToeGameState(board)
    } foreach {
      gameState => assert(gameState.complete)
    }
  }

  "A full board" should "be complete" in {
    val board = Seq(
      Seq(O, X, X),
      Seq(X, X, O),
      Seq(O, O, X)
    )

    val gameState = new TicTacToeGameState(board)
    assert(gameState.complete)
  }
}
