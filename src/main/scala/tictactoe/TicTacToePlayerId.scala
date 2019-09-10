package tictactoe

import common.PlayerId

sealed trait TicTacToePlayerId extends PlayerId[TicTacToeGameState] {
  def tile: TicTacToeTile
}

object TicTacToePlayerId {

  case object X extends TicTacToePlayerId {
    override val tile: TicTacToeTile = TicTacToeTile.X
  }

  case object O extends TicTacToePlayerId {
    override val tile: TicTacToeTile = TicTacToeTile.O
  }

}
