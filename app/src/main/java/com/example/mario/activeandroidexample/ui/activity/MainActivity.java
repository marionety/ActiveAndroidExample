package com.example.mario.activeandroidexample.ui.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.example.mario.activeandroidexample.R;
import com.example.mario.activeandroidexample.model.Group;
import com.example.mario.activeandroidexample.model.GroupPlayer;
import com.example.mario.activeandroidexample.model.Player;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbTest();
    }

    private void dbTest() {
        Group g = new Group("Group 1");
        Player p = new Player("Player 1");
        Player p2 = new Player("Player 2");
        GroupPlayer gp = new GroupPlayer(g, p);
        GroupPlayer gp2 = new GroupPlayer(g, p2);
        g.save();
        p.save();
        p2.save();
        gp.save();
        gp2.save();

        List<GroupPlayer> enrolments = new Select().from(GroupPlayer.class).where("course = ?",
                g.getId()).execute();

        List<Player> playersInGroup = new ArrayList<Player>();
        for(GroupPlayer enrolment:enrolments)
            playersInGroup.add(enrolment._player);

        for(Player player: playersInGroup) {
            Toast.makeText(this, player._name, Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
