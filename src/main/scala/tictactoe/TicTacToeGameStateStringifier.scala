package tictactoe

import common.GameStateStringifier

object TicTacToeGameStateStringifier extends GameStateStringifier[TicTacToeGameState] {
  override def stringify(gameState: TicTacToeGameState): String = {
    Seq.range(0, TicTacToeGameState.DIM).map {
      row => Seq.range(0, TicTacToeGameState.DIM).map {
        col => charForTile(gameState.getTile(row, col))
      }.mkString("|")
    }.mkString(rowDiv(TicTacToeGameState.DIM))
  }

  private def rowDiv(length: Int): String = {
    System.lineSeparator() + Seq.fill(length)('-').mkString("+") + System.lineSeparator()
  }
  private def charForTile(tile: TicTacToeTile): Char = {
    tile match {
      case TicTacToeTile.X => 'X'
      case TicTacToeTile.O => 'O'
      case TicTacToeTile.EMPTY => ' '
    }
  }
}
