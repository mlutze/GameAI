package common

trait PlayerInputInterpreter[G <: GameState] {
  def interpret(input: String): Move[G]
}
