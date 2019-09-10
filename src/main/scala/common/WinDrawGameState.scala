package common

trait WinDrawGameState extends GameState {
  def winner: WinDraw[WinDrawGameState]
}
