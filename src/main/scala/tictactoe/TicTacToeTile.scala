package tictactoe

sealed trait TicTacToeTile

object TicTacToeTile {

  case object X extends TicTacToeTile

  case object O extends TicTacToeTile

  case object EMPTY extends TicTacToeTile

}
