package common

trait Tile[G <: GameState] {
  def toChar: Char
}
