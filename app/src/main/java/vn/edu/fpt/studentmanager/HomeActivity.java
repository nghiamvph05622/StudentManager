package vn.edu.fpt.studentmanager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new NguoiDungFragment()).commit();
        getSupportActionBar().setTitle("Người Dùng");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_NguoiDung) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new NguoiDungFragment()).commit();
            getSupportActionBar().setTitle("Người Dùng");
            drawerLayout.closeDrawers();
        }
        else if (id == R.id.nav_theloai) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new LichHocFragment()).commit();
            getSupportActionBar().setTitle("Thể Loại");
            drawerLayout.closeDrawers();
        }
//
//        } else if (id == R.id.nav_Sach) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new SachFragment()).commit();
//            getSupportActionBar().setTitle("Sách");
//            drawerLayout.closeDrawers();
//
//        } else if (id == R.id.nav_HoaDon) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HoaDonFragment()).commit();
//            getSupportActionBar().setTitle("Hóa Đơn");
//            drawerLayout.closeDrawers();


//        }
//        else if (id == R.id.nav_SachBanChay) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new SachBanChayFragment()).commit();
//            getSupportActionBar().setTitle("Sách Bán Chạy");
//            drawerLayout.closeDrawers();
//
//        }
//        else if (id == R.id.nav_ThongKe) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new ThongKeFragment()).commit();
//            getSupportActionBar().setTitle("Thống Kê");
//            drawerLayout.closeDrawers();
//
//        }

        else if (id == R.id.nav_exit) {
            ShowAlertDialog();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void ShowAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thong bao!");
        builder.setMessage("Bạn có muốn thoát ứng dụng không!");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }
}
