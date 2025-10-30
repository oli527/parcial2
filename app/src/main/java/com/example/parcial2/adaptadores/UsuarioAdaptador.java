package com.example.parcial2.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial2.DetailActivity;
import com.example.parcial2.R;
import com.example.parcial2.clases.Usuario;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UsuarioAdaptador extends RecyclerView.Adapter<UsuarioAdaptador.ViewHolder> {

    private List<Usuario> lista;
    private Context ctx;

    public UsuarioAdaptador(List<Usuario> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public UsuarioAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ctx = parent.getContext();
        View v = LayoutInflater.from(ctx).inflate(R.layout.item_usuario, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioAdaptador.ViewHolder holder, int position) {
        Usuario u = lista.get(position);

        holder.txtNombre.setText(u.getNombre());
        holder.txtCurso.setText(u.getCurso());

        // Cargamos la imagen piccssooo
        Picasso.get()
                .load(u.getFotoUrl())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imgUsuario);

        // botosnes incluyendo el de ver
        holder.btnVer.setOnClickListener(v -> {
            Intent i = new Intent(ctx, DetailActivity.class);
            i.putExtra("nombre", u.getNombre());
            i.putExtra("curso", u.getCurso());
            i.putExtra("foto", u.getFotoUrl());
            i.putExtra("descripcion", u.getDescripcion());
            ctx.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgUsuario;
        TextView txtNombre, txtCurso;
        Button btnVer;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUsuario = itemView.findViewById(R.id.img_usuario);
            txtNombre = itemView.findViewById(R.id.txt_nombre_usuario);
            txtCurso = itemView.findViewById(R.id.txt_curso_usuario);
            btnVer = itemView.findViewById(R.id.btn_ver);
        }
    }
}
