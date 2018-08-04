package github.com.letelete.sleepcyclealarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import github.com.letelete.sleepcyclealarm.model.preferences.MenuActivity;

public class MainActivity extends AppCompatActivity
    implements BottomNavigationBar.OnTabSelectedListener,
    Toolbar.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();
        setupBottomNavigationBar();
    }

    private void setupToolbar() {
        Toolbar appToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(appToolbar);
        appToolbar.setOnMenuItemClickListener(this);
    }

    private void setupBottomNavigationBar() {
        BottomNavigationBar bottomNavigationBar = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home, getResources().getString(R.string.sleep_now_tab)))
                .addItem(new BottomNavigationItem(R.drawable.ic_watch, getResources().getString(R.string.wake_up_at_tab)))
                .addItem(new BottomNavigationItem(R.drawable.ic_access_alarm, getResources().getString(R.string.alarms_tab)))
                .setBarBackgroundColor(R.color.light_theme_color_primary)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(int position) {

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.three_dot_menu, menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        String itemTittle = item.getTitle().toString();

        String ID_KEY = getResources().getString(R.string.MENU_ITEM_ID_KEY);
        String TITLE_KEY = getResources().getString(R.string.MENU_ITEM_TITLE_KEY);

        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        intent.putExtra(ID_KEY, id);
        intent.putExtra(TITLE_KEY, itemTittle);
        startActivity(intent);

        return true;
    }
}
