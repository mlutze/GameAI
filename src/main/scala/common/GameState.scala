package common

trait GameState {
  def complete: Boolean
  def activePlayer: PlayerId[GameState]
}
