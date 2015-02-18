package com.example.mario.activeandroidexample.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mario on 18/02/2015.
 */
@Table(name = "GroupPlayer")
public class GroupPlayer extends Model implements Serializable {

    @Column(name = "Group")
    public Group _group;

    @Column(name = "Player")
    public Player _player;

    public GroupPlayer(Group group, Player player) {
        this._group = group;
        this._player = player;
    }

    public List<Group> groups() {
        return getMany(Group.class, "GroupPlayer");
    }

    public List<Player> players() {
        return getMany(Player.class, "GroupPlayer");
    }
}
