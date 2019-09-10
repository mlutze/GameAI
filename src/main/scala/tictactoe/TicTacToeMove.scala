package tictactoe

import common.Move

case class TicTacToeMove(row: Int, col: Int, tile: TicTacToeTile) extends Move[TicTacToeGameState] {
  override def apply(gameState: TicTacToeGameState): TicTacToeGameState = {
    gameState.withTile(row, col, tile).toggleActivePlayer
  }
}
