package common

trait Move[G <: GameState] {
  def apply(gameState: G): G
}
