package com.ziska.peter.tictactoe;

import com.ziska.peter.tictactoe.Model.PlayerBadge;

public interface Contract {
    interface TicTacToeViewInt{
        void showWinner(PlayerBadge winnerBadge);
        void showTakenCellToast();
        void changeCellBadge(int row,int col,PlayerBadge cellBadge);
        void clearBoard();
        void updateUI();

    }
    interface TicTacToePresenterInt{

        boolean onCellClicked(int row,int col);

        void onNewGame();

        void attachView(Contract.TicTacToeViewInt view);

        void detachView();
    }
}
