package tictactoe

import common.WinDraw.{Draw, Win}
import common.{GameState, PlayerId, WinDraw, WinDrawGameState}
import tictactoe.TicTacToePlayerId.{O, X}

class TicTacToeGameState(board: Seq[Seq[TicTacToeTile]] = TicTacToeGameState.EMPTY_BOARD,
                         activePlayer: TicTacToePlayerId = TicTacToePlayerId.X) extends WinDrawGameState {

  def getTile(row: Int, col: Int): TicTacToeTile = {
    board(row)(col)
  }

  def withTile(row: Int, col: Int, tile: TicTacToeTile): TicTacToeGameState = {
    val newBoard = board.updated(row, board(row).updated(col, tile))
    new TicTacToeGameState(newBoard, activePlayer)
  }

  def toggleActivePlayer: TicTacToeGameState = {
    val newPlayer = activePlayer match {
      case X => O
      case O => X
    }
    withActivePlayer(newPlayer)
  }

  def withActivePlayer(playerId: TicTacToePlayerId): TicTacToeGameState = {
    new TicTacToeGameState(board, playerId)
  }

  override def winner: WinDraw[WinDrawGameState] = {
    winnerOption match {
      case Some(player) => Win(player)
      case None => Draw
    }
  }

  private def winnerOption: Option[PlayerId[TicTacToeGameState]] = {
    findWinnableLines.flatMap(findWinnerForLine).headOption
  }

  private def findWinnerForLine(line: Seq[TicTacToeTile]): Option[PlayerId[TicTacToeGameState]] = {
    Seq(TicTacToePlayerId.X, TicTacToePlayerId.O).find(playerId => line.forall(tile => playerId.tile == tile))
  }

  private def findWinnableLines: Seq[Seq[TicTacToeTile]] = {
    getRows ++ getCols ++ getDiagonals
  }

  private def getRows: Seq[Seq[TicTacToeTile]] = board

  private def getCols: Seq[Seq[TicTacToeTile]] = board.transpose

  private def getDiagonals: Seq[Seq[TicTacToeTile]] = {
    Seq(
      Seq.range(0, TicTacToeGameState.DIM).map {
        i => getTile(i, i)
      },
      Seq.range(0, TicTacToeGameState.DIM).map {
        i => getTile(i, TicTacToeGameState.DIM - i - 1)
      }
    )
  }

  override def activePlayer: PlayerId[GameState] = activePlayer

  override def complete: Boolean = {
    winnerOption.isDefined || board.forall(row => !row.contains(TicTacToeTile.EMPTY))
  }
}

object TicTacToeGameState {
  val DIM: Int = 3
  private val EMPTY_BOARD: Seq[Seq[TicTacToeTile]] = Seq.fill(DIM, DIM)(TicTacToeTile.EMPTY)
}
