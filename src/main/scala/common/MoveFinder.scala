package common

trait MoveFinder[G <: GameState] {
  def findMoves(gameState: G): Seq[Move[G]]
}
