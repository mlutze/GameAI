package tictactoe

import common.{Move, MoveFinder}

class TicTacToeMoveFinder(playerId: TicTacToePlayerId) extends MoveFinder[TicTacToeGameState] {
  override def findMoves(gameState: TicTacToeGameState): Seq[Move[TicTacToeGameState]] = {
    require(gameState.activePlayer == playerId)
    Seq.range(0, TicTacToeGameState.DIM).flatMap {
      row =>
        Seq.range(0, TicTacToeGameState.DIM).map {
          col => (row, col)
        }.filter {
          case (row, col) => gameState.getTile(row, col) == TicTacToeTile.EMPTY
        }
    }.map {
      case (row, col) => TicTacToeMove(row, col, playerId.tile)
    }
  }
}
