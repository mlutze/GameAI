package common

import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec

class MiniMaxPlayerTest extends FlatSpec with MockFactory {
  "A 0-depth player" should "choose the best-scoring move" in {
    val playerId = stub[PlayerId[GameState]]
    val moveFinder = stub[MoveFinder[GameState]]
    val moveFinders = Map(playerId -> moveFinder)
    val gameStateScorer = stub[GameStateScorer[GameState]]
    val gameStateScorers = Map(playerId -> gameStateScorer)
    val depth = 0

    val initialGameState = stub[GameState]
    val moves = Seq.fill(5)(stub[Move[GameState]])
    val gameStates = Seq.fill(5)(stub[GameState])
    val scores = Seq(10, 20, 0, 30, 4)
    (moves, gameStates).zipped.foreach {
      case (move, gameState) => (move.apply _) when (initialGameState) returns (gameState)
    }
    (gameStates, scores).zipped.foreach {
      case (gameState, score) => (gameStateScorer.score _) when (gameState) returns (score)
    }
    (moveFinder.findMoves _) when (initialGameState) returns (moves)

    val sut = new MiniMaxPlayer[GameState](playerId, moveFinders, gameStateScorers, depth)

    val expected = moves(3)
    val actual = sut.findMove(initialGameState)

    assert(expected == actual)
  }
}
