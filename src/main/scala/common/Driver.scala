package common

abstract class Driver[G <: GameState](initialGameState: G, players: Map[PlayerId[G], Player[G]]) {
  def run(): Unit = {
    onStart(initialGameState)
    var gameState = initialGameState
    while (!gameState.complete) {
      val playerId = gameState.activePlayer
      println(playerId)
      val player = players(playerId.asInstanceOf[PlayerId[G]]) // TODO get rid of cast
      val move = player.findMove(gameState)
      gameState = move.apply(gameState)
      onMove(playerId.asInstanceOf[PlayerId[G]], move, gameState) // TODO get rid of cast
    }
    onEnd(gameState)
  }

  def onStart(gameState: G): Unit
  def onMove(player: PlayerId[G], move: Move[G], newGameState: G): Unit
  def onEnd(gameState: G): Unit
}
