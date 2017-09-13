package org.blankapp.examples;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.blankapp.app.ListActivity;

import java.util.ArrayList;
import java.util.List;

public class SimpleListActivity extends ListActivity<SimpleListViewHolder, User, List<User>> {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);
        this.initLoader();
    }

    @Override
    public void onRefresh() {
        getItemsSource().clear();
        getAdapter().notifyDataSetChanged();
//        new Handler().postDelayed(() -> {
//            this.forceLoad();
//        }, 1000);
    }

    @Override
    public SimpleListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_simple_list_item, parent, false);
        return new SimpleListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SimpleListViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        User user = getItemsSource().get(position);
        holder.mName.setText(user.getName());
        holder.mUsername.setText(user.getUsername());
    }

    @Override
    protected void onListItemClick(RecyclerView rv, View v, int position, long id) {
        Toast.makeText(this, "Item:" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadStart() {

    }

    @Override
    public List<User> onLoadInBackground() throws Exception {
        List<User> users = new ArrayList<>();
        users.add(new User("zhangjilei01", "zhangjilei01"));
        users.add(new User("zhangjilei02", "zhangjilei02"));
        users.add(new User("zhangjilei03", "zhangjilei03"));
        users.add(new User("zhangjilei04", "zhangjilei04"));
        users.add(new User("zhangjilei05", "zhangjilei05"));
        return users;
    }

    @Override
    public void onLoadComplete(List<User> data) {
        getItemsSource().addAll(data);
        getAdapter().notifyDataSetChanged();
        onRefreshComplete();
    }

    @Override
    public void onLoadError(Exception e) {

    }
}
