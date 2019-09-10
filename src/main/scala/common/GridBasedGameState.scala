package common

trait GridBasedGameState extends GameState {
  def grid[G <: GameState]: Seq[Seq[Tile[G]]]
}
