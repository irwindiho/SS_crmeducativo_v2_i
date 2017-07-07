package com.consultoraestrategia.ss_crmeducativo.evaluacion.view.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.consultoraestrategia.ss_crmeducativo.R;

import java.util.List;

/**
 * Created by kelvi on 23/02/2017.
 */

public class MenuTrimestreAdapter extends ArrayAdapter<String> {

    private List<String> stringList;
    private Context context;
    private LayoutInflater layoutInflater;

    int positionPeriodo;

    public MenuTrimestreAdapter(Context context, List<String> objects,int positionPeriodo) {
        super(context, 0, objects);
        this.stringList = objects;
        this.positionPeriodo = positionPeriodo;
        this.context = context;
        layoutInflater = ((Activity) context).getLayoutInflater();
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.layout_item_menu_trimestre, parent, false);
        final TextView textView = (TextView) convertView.findViewById(R.id.textTitle);

        if (position == positionPeriodo) {
            textView.setBackgroundColor(Color.parseColor("#009cbf"));
            textView.setTextColor(Color.parseColor("#ffffff"));
        } else {
            textView.setBackgroundColor(Color.parseColor("#ffffff"));
            textView.setTextColor(Color.parseColor("#000000"));
        }


        textView.setText(stringList.get(position));
        return convertView;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return stringList.get(position);
    }


}
