package common

import java.io.PrintStream

class ConsoleDriver[G <: GameState](console: PrintStream,
                                    gameStateStringifier: GameStateStringifier[G],
                                    initialGameState: G,
                                    players: Map[PlayerId[G], Player[G]]) extends Driver[G](initialGameState, players) {
  override def onStart(gameState: G): Unit = {
    console.println(gameStateStringifier.stringify(gameState))
  }

  override def onMove(player: PlayerId[G], move: Move[G], newGameState: G): Unit = {
    console.println(gameStateStringifier.stringify(newGameState))
  }

  override def onEnd(gameState: G): Unit = {
    console.println(gameStateStringifier.stringify(gameState))
  }
}
