package com.ziska.peter.tictactoe.Model;

public class Cell {

    private boolean isTaken = false;
    private PlayerBadge mOccupationPlayer = null;

    public Cell(){

    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public PlayerBadge getmOccupationPlayer() {
        return mOccupationPlayer;
    }

    public void setmOccupationPlayer(PlayerBadge mOccupationPlayer) {
        this.mOccupationPlayer = mOccupationPlayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell that = (Cell) o;
        return mOccupationPlayer == that.mOccupationPlayer;
    }

}
