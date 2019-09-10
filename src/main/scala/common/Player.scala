package common

trait Player[G <: GameState] {
  def findMove(gameState: G): Move[G]
}
