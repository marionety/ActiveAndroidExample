package com.example.mario.activeandroidexample.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mario on 18/02/2015.
 */
@Table(name = "Group")
public class Group extends Model implements Serializable {

    @Column(name = "name")
    public String _name;

    public List<Player> players() {
        return getMany(Player.class, "Group");
    }

    public Group() {
        this._name = "undefined";
    }

    public Group(String name) {
        this._name = name;
    }
}
