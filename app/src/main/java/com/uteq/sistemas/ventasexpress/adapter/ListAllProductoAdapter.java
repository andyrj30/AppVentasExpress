package com.uteq.sistemas.ventasexpress.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uteq.sistemas.ventasexpress.R;
import com.uteq.sistemas.ventasexpress.model.Producto;
import com.uteq.sistemas.ventasexpress.utils.UIUtil;

import java.util.List;

/**
 * Created by ANDRES on 01/08/2017.
 */
public class ListAllProductoAdapter extends RecyclerView.Adapter<ListAllProductoAdapter.ViewHolder> {

    Context context;
    List<Producto> productos;

    public ListAllProductoAdapter(Context context, List<Producto> productos) {
        this.context = context;
        this.productos = productos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_listallproducto, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }




    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombre.setText(productos.get(position).getNombre());
        holder.id.setText((productos.get(position).getCodigo()));
        holder.cantidad.setText(productos.get(position).getCantidad());

       /* holder.cantidad.setText(productos.get(position).getStockMaximo());
        holder.cantidad.setText(productos.get(position).getStockMinimo());
        holder.cantidad.setText(productos.get(position).getObservacion());*/

    }
    @Override
    public int getItemCount() {
        return productos.size();
    }

    @Override
    public void onViewAttachedToWindow(ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        UIUtil.animateCircularReveal(holder.itemView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView id;
        TextView codigo;
        TextView nombre;
        TextView cantidad;
        TextView precio;

        public ViewHolder(View item) {
            super(item);
            cardView = (CardView) item.findViewById(R.id.cvMenu);
            id = (TextView) item.findViewById(R.id.lblID);
            codigo = (TextView) item.findViewById(R.id.lblCodigo);
            nombre = (TextView) item.findViewById(R.id.LblTitulo);
            cantidad = (TextView) item.findViewById(R.id.lblStock);
            //precio = (TextView) item.findViewById(R.id.lbl);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    id = (TextView) v.findViewById(R.id.lblID);
                    Bundle b = new Bundle();
                    b.putString("id", (String) id.getText());
/*                   RutaProductosFragment fragment = new ProductoVistaFragment();
                     fragment.setArguments(b);
                     FragmentTransaction fragmentTransaction = Constants.fragmentManager.beginTransaction().addToBackStack(null);
                     fragmentTransaction.replace(R.id.fragment, fragment).addToBackStack(null);
                     fragmentTransaction.commit();*/

                }
            });
        }
    }
}