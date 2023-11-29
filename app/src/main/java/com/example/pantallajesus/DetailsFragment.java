package com.example.pantallajesus;

import static  android.media.session.PlaybackState.ACTION_PLAY;
import static  android.media.session.PlaybackState.ACTION_REWIND;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ClassPresenterSelector;
import androidx.leanback.widget.DetailsOverviewRow;
import androidx.leanback.widget.DetailsOverviewRowPresenter;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.SparseArrayObjectAdapter;
import androidx.leanback.widget.Action;

public class DetailsFragment extends DetailsSupportFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        construirIU();
    }

    private void construirIU() {
        ClassPresenterSelector selector = new ClassPresenterSelector();
        selector.addClassPresenter(DetailsOverviewRow.class,
                new FullWidthDetailsOverviewRowPresenter(
                    new DetailsDescriptionPresenter()
                )
        );
        ArrayObjectAdapter madapter = new ArrayObjectAdapter(selector);
        DetailsOverviewRow detailsOverviewRow = new DetailsOverviewRow("Media item details");
        detailsOverviewRow
                .setImageDrawable(getActivity().getResources().getDrawable(R.drawable.baby_driver_banner));
        SparseArrayObjectAdapter actionAdap = new SparseArrayObjectAdapter();
        actionAdap.set((int) ACTION_PLAY, new Action(1,"Comprar 100.00"));
        actionAdap.set((int) ACTION_REWIND, new Action(2,"Rentar 10.00"));
        detailsOverviewRow.setActionsAdapter(actionAdap);
        madapter.add(detailsOverviewRow);
        setAdapter(madapter);
    }
}
