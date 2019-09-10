package tictactoe

import common.{Move, PlayerInputInterpreter}

class TicTacToePlayerInputInterpreter(playerId: TicTacToePlayerId) extends PlayerInputInterpreter[TicTacToeGameState]{
  override def interpret(input: String): Move[TicTacToeGameState] = {
    input match {
      case "7" => TicTacToeMove(0, 0, playerId.tile)
      case "8" => TicTacToeMove(0, 1, playerId.tile)
      case "9" => TicTacToeMove(0, 2, playerId.tile)
      case "4" => TicTacToeMove(1, 0, playerId.tile)
      case "5" => TicTacToeMove(1, 1, playerId.tile)
      case "6" => TicTacToeMove(1, 2, playerId.tile)
      case "1" => TicTacToeMove(2, 0, playerId.tile)
      case "2" => TicTacToeMove(2, 1, playerId.tile)
      case "3" => TicTacToeMove(2, 2, playerId.tile)
    }
  }
}
