package com.example.mario.activeandroidexample;

import android.test.ActivityInstrumentationTestCase2;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.example.mario.activeandroidexample.model.GroupToPlayer;
import com.example.mario.activeandroidexample.model.Player;
import com.example.mario.activeandroidexample.ui.activity.TestActivity;

import junit.framework.Assert;

/**
 * Created by mario on 24/02/2015.
 */
public class BDTest extends ActivityInstrumentationTestCase2<TestActivity> {

    private Player player;

    public BDTest() {
        super(TestActivity.class);
    }

    public BDTest(Class<TestActivity> activityClass) {
        super(activityClass);
    }

    public void setUp() throws Exception {
        super.setUp();
        ActiveAndroid.initialize(getActivity());
        new Delete().from(GroupToPlayer.class).execute();
        new Delete().from(Player.class).execute();
    }

    public void testPlayerInsertDefault() {
        player = new Player();
        player.save();

        player = new Select().from(Player.class).executeSingle();
        Assert.assertEquals(player._name, "undefined");
    }

    public void testPlayerInsert() {
        player = new Player("Player");
        player.save();
        player = new Select().from(Player.class).executeSingle();
        Assert.assertEquals(player._name, "Player");
    }

    public void testPlayerInsert2() {
        player = new Player("Player", "image");
        player.save();
        player = new Select().from(Player.class).executeSingle();
        Assert.assertEquals(player._name, "Player");
        Assert.assertEquals(player._image, "image");
    }

    public void testPlayerDelete() {
        player = new Player("Player");
        player.save();
        Assert.assertEquals(new Select().from(Player.class).count(),1);
        new Delete().from(Player.class).where("name = ?", "Player").execute();
        Assert.assertEquals(new Select().from(Player.class).count(),0);
    }

    public void testPlayerDelete2() {
        player = new Player("Player");
        player.save();
        player = new Player("Player 2");
        player.save();
        Assert.assertEquals(new Select().from(Player.class).count(),2);
        new Delete().from(Player.class).where("name = ?", "Player").execute();
        Assert.assertEquals(new Select().from(Player.class).where("name = ?", "Player").count(),0);
        Assert.assertEquals(new Select().from(Player.class).count(),1);
        new Delete().from(Player.class).where("name = ?", "Player 2").execute();
        Assert.assertEquals(new Select().from(Player.class).count(),0);
    }

    public void tearDown() throws Exception {
        super.tearDown();
        ActiveAndroid.dispose();
    }
}
