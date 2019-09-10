package tictactoe

import org.scalatest.FlatSpec
import tictactoe.TicTacToeTile.{EMPTY, O, X}

class TicTacToeMoveFinderTest extends FlatSpec {
  it should "find all empty tiles" in {
    val board = Seq(
      Seq(X, O, EMPTY),
      Seq(EMPTY, O, X),
      Seq(X, EMPTY, O)
    )


    val gameState = new TicTacToeGameState(board)
    val sut = new TicTacToeMoveFinder(TicTacToePlayerId.X)

    val expected = Seq(
      TicTacToeMove(0, 2, X),
      TicTacToeMove(1, 0, X),
      TicTacToeMove(2, 1, X)
    )
    val actual = sut.findMoves(gameState)

    assert(expected == actual)
  }
}
