package common

class MiniMaxPlayer[G <: GameState](playerId: PlayerId[G],
                                    moveFinders: Map[PlayerId[G], MoveFinder[G]],
                                    gameStateScorers: Map[PlayerId[G], GameStateScorer[G]],
                                    depth: Int) extends Player[G] {
  require(depth >= 0)

  override def findMove(gameState: G): Move[G] = {
    val moves = moveFinders(playerId).findMoves(gameState)
    println(playerId)
    println(moves)
    println()
    println()
    moves.maxBy(scoreMove(_, gameState))
  } // TODO if multiple paths win, select shortest

  def scoreMove(move: Move[G], gameState: G): Double = {
    val nextGameState = move.apply(gameState)
    if (depth == 0 || nextGameState.complete) {
      gameStateScorers(playerId).score(nextGameState)
    } else {
      val nextPlayerId = nextGameState.activePlayer
      val nextMove = nextPlayer(nextPlayerId.asInstanceOf[PlayerId[G]]).findMove(nextGameState) // TODO fix to avoid this annoying cast
      gameStateScorers(playerId).score(nextMove.apply(nextGameState))
    }
  }

  private def nextPlayer(nextPlayerId: PlayerId[G]): MiniMaxPlayer[G] = {
    new MiniMaxPlayer[G](nextPlayerId, moveFinders, gameStateScorers, depth - 1)
  }
}
