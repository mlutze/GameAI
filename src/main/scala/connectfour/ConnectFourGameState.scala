package connectfour

import common.{GameState, PlayerId}

class ConnectFourGameState extends GameState {
  override def complete: Boolean = {
    // someone has four in a row
    // board is full
  }

  private def getRows: Seq(Seq()) = ???

  override def activePlayer: PlayerId[GameState] = ???
}

object ConnectFourGameState {
  val WIDTH = 7
  val HEIGHT = 6
  val CONNECT_COUNT = 4
}