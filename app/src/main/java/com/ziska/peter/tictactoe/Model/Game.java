package com.ziska.peter.tictactoe.Model;

import android.util.Log;

public class Game {

    private static final String TAG = Game.class.getSimpleName();
    private PlayerBadge mCurrentPlayer = PlayerBadge.O;
    private Cell[][] mBoard = new Cell[3][3];
    private int mGameMoves;
    private PlayerBadge mWinner;

    public Game(){
        GameInit();
    }

    private void GameInit(){
        for (int col = 0; col < 3; col++){
            for (int row = 0; row < 3; row++){
                mBoard[col][row] = new Cell();
            }
        }
        mWinner = null;
        mGameMoves = 0;
    }

    private void GameReset(){
        for (int col = 0; col < 3; col++){
            for (int row = 0; row < 3; row++){
                mBoard[col][row] = null;
            }
        }
        mWinner = null;
        mGameMoves = 0;
    }

    public boolean hasGameEnd(){
        if (hasThreeSameHorizontalCells() || hasThreeSameVerticalCells() || hasThreeSameDiagonalCells()) {
            mWinner = mCurrentPlayer;
            return true;
        }
        if (isBoardFull()){
            mWinner = null;
            return true;
        }
        return false;
    }

    public boolean hasThreeSameHorizontalCells() {
        try {
            for (int i = 0; i < 3; i++)
                if (areEqual(mBoard[i][0], mBoard[i][1], mBoard[i][2]))
                    return true;

            return false;
        } catch (NullPointerException e) {
            Log.e(TAG, e.getMessage());
            return false;
        }
    }


    public boolean hasThreeSameVerticalCells() {
        try {
            for (int i = 0; i < 3; i++)
                if (areEqual(mBoard[0][i], mBoard[1][i], mBoard[2][i]))
                    return true;
            return false;
        } catch (NullPointerException e) {
            Log.e(TAG, e.getMessage());
            return false;
        }
    }

    public boolean hasThreeSameDiagonalCells() {
        try {
            return areEqual(mBoard[0][0], mBoard[1][1], mBoard[2][2]) ||
                    areEqual(mBoard[0][2], mBoard[1][1], mBoard[2][0]);
        } catch (NullPointerException e) {
            Log.e(TAG, e.getMessage());
            return false;
        }
    }

    /**
     * 2 cells are equal if:
     * - Both are none null
     * - Both have non null values
     * - both have equal values
     *
     * @param cells: Cells to check if are equal
     * @return
     */
    private boolean areEqual(Cell... cells) {
        if (cells == null || cells.length == 0)
            return false;

        for (Cell cell : cells)
            if (cell == null || cell.getmOccupationPlayer() == null || cell.getmOccupationPlayer() == PlayerBadge.TIE)
                return false;

        Cell comparisonBase = cells[0];
        for (int i = 1; i < cells.length; i++)
            if (!comparisonBase.getmOccupationPlayer().equals(cells[i].getmOccupationPlayer()))
                return false;

        return true;
    }

    private boolean isBoardFull(){
        return mGameMoves == 3*3;
    }

    public PlayerBadge getWinner(){
        return mWinner;
    }

    public boolean isCellTaken(int row, int col){
        Cell it = mBoard[row][col];
        if (it.isTaken()){
            return true;
        }
        return false;
    }

    public void fillCell(int row, int col){
        mBoard[row][col].setTaken(true);
        mBoard[row][col].setmOccupationPlayer(mCurrentPlayer);
        mGameMoves++;
    }

    public void restartGame(){
        GameReset();
    }

    public PlayerBadge getCellBadge(int row, int col){
        if (mBoard[row][col] == null){
            return null;
        }
        return mBoard[row][col].getmOccupationPlayer();
    }

    public void changePlayer(){
        mCurrentPlayer = (mCurrentPlayer == PlayerBadge.O) ? PlayerBadge.X : PlayerBadge.O;
    }

    public PlayerBadge getCurrentPlayer() {
        return mCurrentPlayer;
    }
}
