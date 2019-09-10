package common

trait GameStateScorer[G <: GameState] {
  def score(gameState: G): Double
}

object GameStateScorer {
  val VICTORY: Double = Double.PositiveInfinity
  val DEFEAT: Double = Double.NegativeInfinity
}
