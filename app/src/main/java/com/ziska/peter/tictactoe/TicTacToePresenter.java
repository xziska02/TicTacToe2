package com.ziska.peter.tictactoe;

import com.ziska.peter.tictactoe.Model.Game;

public class TicTacToePresenter implements Contract.TicTacToePresenterInt {

    private static final String TAG = TicTacToePresenter.class.getSimpleName();
    private Game mGame;
    private Contract.TicTacToeViewInt mView;

    public TicTacToePresenter() {
        this.mGame = new Game();
    }

    @Override
    public boolean onCellClicked(int row, int col) {
        if (!mGame.isCellTaken(row,col)){
            mGame.fillCell(row,col);
            mView.changeCellBadge(row,col,mGame.getCurrentPlayer());
            if (mGame.hasGameEnd()){
                if (mGame.getWinner() == null){
                    mView.showWinner(null);
                }else {
                    mView.showWinner(mGame.getWinner());
                }

            }
            mGame.changePlayer();
            return true;
        }
        mView.showTakenCellToast();
        return false;
    }

    @Override
    public void onNewGame() {
        mGame.restartGame();
        mView.clearBoard();
        mView.hideWinnerMsg();
    }

    @Override
    public void attachView(Contract.TicTacToeViewInt view) {
        mView =  view;
    }

    @Override
    public void detachView() {
        mView = null;
    }


}
