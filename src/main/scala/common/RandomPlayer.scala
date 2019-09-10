package common

import scala.util.Random

class RandomPlayer[G <: GameState](random: Random, moveFinder: MoveFinder[G]) extends Player[G] {
  override def findMove(gameState: G): Move[G] = {
    val moves = moveFinder.findMoves(gameState)
    val index = random.nextInt(moves.size)
    moves(index)
  }
}
