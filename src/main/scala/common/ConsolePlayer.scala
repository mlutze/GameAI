package common

import java.util.Scanner

class ConsolePlayer[G <: GameState](console: Scanner,
                                    playerInputInterpreter: PlayerInputInterpreter[G]) extends Player[G] {

  override def findMove(gameState: G): Move[G] = {
    val input = console.nextLine()
    playerInputInterpreter.interpret(input)
  }
}
