package common

sealed trait WinDraw[+G <: WinDrawGameState]

object WinDraw {

  case class Win[G <: WinDrawGameState](playerId: PlayerId[G]) extends WinDraw[G]

  case object Draw extends WinDraw[Nothing]

}
