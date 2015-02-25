package com.example.mario.activeandroidexample.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mario on 18/02/2015.
 */
@Table(name = "PlayerGroup")
public class Group extends Model implements Serializable {

    @Column(name = "name")
    public String _name;

    public Group() {
        super();
        this._name = "undefined";
    }

    public Group(String name) {
        super();
        this._name = name;
    }

}
