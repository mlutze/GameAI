package common

class GridBasedGameStateStringifier[G <: GridBasedGameState] extends GameStateStringifier[G] {
  override def stringify(gameState: G): String = ???
}
