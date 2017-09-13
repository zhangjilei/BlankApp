package org.blankapp.examples;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class SimpleGridViewHolder extends RecyclerView.ViewHolder {

    public TextView mUsername;
    public TextView mName;

    public SimpleGridViewHolder(View itemView) {
        super(itemView);
        mUsername = (TextView) itemView.findViewById(R.id.username);
        mName = (TextView) itemView.findViewById(R.id.name);
    }
}
