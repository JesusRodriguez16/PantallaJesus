package com.example.pantallajesus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.BaseCardView;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;

public class MainFragment extends BrowseSupportFragment implements OnItemViewClickedListener {
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pantallainicio();

    }

    private void pantallainicio(){
        setTitle("Jesus Rodriguez");
        setHeadersState(HEADERS_ENABLED);
        setBrandColor(getResources().getColor(android.R.color.black));
        cargarDatos();
        setOnItemViewClickedListener(this);
    }

    private void cargarDatos(){
        HeaderItem categoria1 = new HeaderItem(0,"Acción");
        HeaderItem categoria2 = new HeaderItem(1,"Comedia");
        HeaderItem categoria3 = new HeaderItem(3,"Cartoon");
        HeaderItem categoria4 = new HeaderItem(3,"Anime");
        HeaderItem categoria5 = new HeaderItem(4,"SuperHeroes");
        HeaderItem categoria6 = new HeaderItem(5,"Comedia");

        ArrayObjectAdapter adapterFila1 = new ArrayObjectAdapter(new MyPresenter());
        adapterFila1.add(new SingleRowView("Baby Driver", getResources().getDrawable(R.drawable.baby_driver_banner)));
        adapterFila1.add(new SingleRowView("Pacific Rim", getResources().getDrawable(R.drawable.banner_pacific)));
        adapterFila1.add(new SingleRowView("Edge of Tomorrow", getResources().getDrawable(R.drawable.banner_edge)));
        adapterFila1.add(new SingleRowView("Kill Bill", getResources().getDrawable(R.drawable.banner_kill)));
        adapterFila1.add(new SingleRowView("Jhon Wick", getResources().getDrawable(R.drawable.banner_wick)));

        ArrayObjectAdapter adapterFila2 = new ArrayObjectAdapter(new MyPresenter());
        adapterFila2.add(new SingleRowView("Superbad", getResources().getDrawable(R.drawable.banner_super)));
        adapterFila2.add(new SingleRowView("Hangover", getResources().getDrawable(R.drawable.banner_hangover)));
        adapterFila2.add(new SingleRowView("Jojo Rabbit", getResources().getDrawable(R.drawable.banner_jojo)));
        adapterFila2.add(new SingleRowView("Grown Ups", getResources().getDrawable(R.drawable.banner_grown)));
        adapterFila2.add(new SingleRowView("Scott Pilgrimm", getResources().getDrawable(R.drawable.banner_scott)));

        ArrayObjectAdapter adapterFila3 = new ArrayObjectAdapter(new MyPresenter());
        adapterFila3.add(new SingleRowView("Toy Story", getResources().getDrawable(R.drawable.banner_toy)));
        adapterFila3.add(new SingleRowView("Up", getResources().getDrawable(R.drawable.banner_up)));
        adapterFila3.add(new SingleRowView("Lion King", getResources().getDrawable(R.drawable.banner_lion)));
        adapterFila3.add(new SingleRowView("Kung fu panda", getResources().getDrawable(R.drawable.banner_panda)));
        adapterFila3.add(new SingleRowView("Shrek", getResources().getDrawable(R.drawable.banner_shrek)));

        ArrayObjectAdapter adapterFila4 = new ArrayObjectAdapter(new MyPresenter());
        adapterFila4.add(new SingleRowView("One Piece RED", getResources().getDrawable(R.drawable.banner_piece)));
        adapterFila4.add(new SingleRowView("Heroes rising", getResources().getDrawable(R.drawable.banner_heroes)));
        adapterFila4.add(new SingleRowView("Your Name", getResources().getDrawable(R.drawable.banner_your)));
        adapterFila4.add(new SingleRowView("Suzume", getResources().getDrawable(R.drawable.banner_suzume)));
        adapterFila4.add(new SingleRowView("The last", getResources().getDrawable(R.drawable.banner_naruto)));

        ArrayObjectAdapter adapterFila5 = new ArrayObjectAdapter(new MyPresenter());
        adapterFila5.add(new SingleRowView("Civil War", getResources().getDrawable(R.drawable.banner_war)));
        adapterFila5.add(new SingleRowView("Avengers", getResources().getDrawable(R.drawable.banner_avengers)));
        adapterFila5.add(new SingleRowView("The Amazing Spider-man", getResources().getDrawable(R.drawable.banner_spiderman)));
        adapterFila5.add(new SingleRowView("Iron Man", getResources().getDrawable(R.drawable.banner_iron)));
        adapterFila5.add(new SingleRowView("Thor", getResources().getDrawable(R.drawable.banner_thor)));

        ArrayObjectAdapter adapterFila6 = new ArrayObjectAdapter(new MyPresenter());
        adapterFila6.add(new SingleRowView("Toy Story", getResources().getDrawable(R.drawable.banner_toy)));
        adapterFila6.add(new SingleRowView("Up", getResources().getDrawable(R.drawable.banner_up)));
        adapterFila6.add(new SingleRowView("Lion King", getResources().getDrawable(R.drawable.banner_lion)));
        adapterFila6.add(new SingleRowView("Kung fu panda", getResources().getDrawable(R.drawable.banner_panda)));
        adapterFila6.add(new SingleRowView("Shrek", getResources().getDrawable(R.drawable.banner_shrek)));




        ArrayObjectAdapter windowAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        windowAdapter.add(new ListRow(categoria1, adapterFila1));
        windowAdapter.add(new ListRow(categoria2, adapterFila2));
        windowAdapter.add(new ListRow(categoria3, adapterFila3));
        windowAdapter.add(new ListRow(categoria4, adapterFila4));
        windowAdapter.add(new ListRow(categoria5, adapterFila5));

        setAdapter(windowAdapter);
    }

    @Override
    public void onItemClicked(Presenter.ViewHolder itemViewHolder,
                              Object o, RowPresenter.ViewHolder rowViewHolder1, Row row) {
        Intent intent = new Intent(getActivity(),DetailsActivity.class);
        startActivity(intent);
    }

    private class MyPresenter extends Presenter{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
            ImageCardView icv = new ImageCardView(viewGroup.getContext());
            icv.setCardType(BaseCardView.CARD_TYPE_INFO_UNDER_WITH_EXTRA);
            icv.setInfoVisibility(BaseCardView.CARD_REGION_VISIBLE_ACTIVATED);
            return new ViewHolder(icv);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, Object object) {
            SingleRowView srv =(SingleRowView) object;
            ImageCardView icv = ((ImageCardView) viewHolder.view);
            icv.setMainImage(srv.getImage());
            icv.setMainImageDimensions(313,176);
            icv.setTitleText(srv.getName());
            icv.setContentText("Descripcion de la pelicula");
        }

        @Override
        public void onUnbindViewHolder(ViewHolder viewHolder) {

        }
    }
}