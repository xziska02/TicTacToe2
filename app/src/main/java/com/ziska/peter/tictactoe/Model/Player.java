package com.ziska.peter.tictactoe.Model;

public class Player {

    private PlayerBadge mPlayerBadge;
    private String name;

    public Player(PlayerBadge mPlayerBadge, String name) {
        this.mPlayerBadge = mPlayerBadge;
        this.name = name;
    }

    public PlayerBadge getmPlayerBadge() {
        return mPlayerBadge;
    }

    public void setmPlayerBadge(PlayerBadge mPlayerBadge) {
        this.mPlayerBadge = mPlayerBadge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
