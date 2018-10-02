package com.ziska.peter.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ziska.peter.tictactoe.Model.PlayerBadge;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TicTacToeActivity extends AppCompatActivity implements Contract.TicTacToeViewInt{

    private String TAG = TicTacToeActivity.class.getSimpleName();
    private Contract.TicTacToePresenterInt mPresenter;

    @BindView(R.id.buttonGrid) GridLayout mBoardLayout;
    @BindView(R.id.winnerPlayerViewGroup)
    LinearLayout mWinnerLayout;
    @BindView(R.id.winnerPlayerLabel)TextView mWinnerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        attachPresenter();
    }

    public void onCellClicked(View v) {
        Button cell = (Button)v;
        String tag = cell.getTag().toString();
        int row = Integer.valueOf(tag.substring(0,1));
        int col = Integer.valueOf(tag.substring(1,2));
        mPresenter.onCellClicked(row,col);

    }

    @Override
    public void showWinner(PlayerBadge winnerBadge) {
        if (winnerBadge == null) {
            winnerBadge = PlayerBadge.TIE;
        }
        mWinnerName.setText(winnerBadge.toString());
        mWinnerLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void showTakenCellToast() {
        Toast.makeText(this,"Cell is taken",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void changeCellBadge(int row, int col,PlayerBadge cellBadge) {
        Button btn = (Button) mBoardLayout.findViewWithTag("" + row + col);
        if(btn != null) {
            btn.setText(cellBadge.toString());
        }
    }

    @Override
    public void clearBoard() {
        for( int i = 0; i < mBoardLayout.getChildCount(); i++ ) {
            ((Button) mBoardLayout.getChildAt(i)).setText("");
            ((Button) mBoardLayout.getChildAt(i)).setEnabled(true);

        }
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void hideWinnerMsg() {
        mWinnerLayout.setVisibility(View.INVISIBLE);
    }

    private void attachPresenter(){
        mPresenter = (Contract.TicTacToePresenterInt) getLastCustomNonConfigurationInstance();
        if (mPresenter == null) {
            mPresenter = new TicTacToePresenter();
        }
        mPresenter.attachView(this);
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    public void onRestartButtonClick(View view) {
        Button restartBtn = (Button) view;
        mPresenter.onNewGame();
    }
}
