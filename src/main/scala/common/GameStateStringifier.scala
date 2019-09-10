package common

trait GameStateStringifier[G <: GameState] {
  def stringify(gameState: G): String
}
