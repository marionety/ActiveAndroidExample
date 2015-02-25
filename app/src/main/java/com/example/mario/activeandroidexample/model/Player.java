package com.example.mario.activeandroidexample.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mario on 18/02/2015.
 */
@Table(name = "Player")
public class Player extends Model implements Serializable {

    @Column(name = "name")
    public String _name;

    @Column(name = "image")
    public String _image;

    @Column(name = "level")
    public int _level;

    public Player() {
        super();
        this._name = "undefined";
        this._image = "undefined";
        this._level = 0;
    }

    public Player(String name) {
        super();
        this._name = name;
        this._image = "undefined";
        this._level = 0;
    }

    public Player(String name, String image) {
        super();
        this._name = name;
        this._image = image;
        this._level = 0;
    }

    public Player(String name, String image, int level) {
        super();
        this._name = name;
        this._image = image;
        this._level = level;
    }
}
