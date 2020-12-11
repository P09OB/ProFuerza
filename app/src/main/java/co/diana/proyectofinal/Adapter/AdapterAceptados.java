package co.diana.proyectofinal.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import co.diana.proyectofinal.Clases.Solicitud;
import co.diana.proyectofinal.R;

public class AdapterAceptados extends BaseAdapter {


    private ArrayList<Solicitud> solicitud;

    public AdapterAceptados() {

        solicitud = new ArrayList<>();

    }

    public void addEmployee(Solicitud soli) {

        solicitud.add(soli);
        notifyDataSetChanged();

    }

    public void clear() {
        solicitud.clear();
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return solicitud.size();
    }

    @Override
    public Object getItem(int i) {
        return solicitud.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup list) {

        LayoutInflater inflater = LayoutInflater.from(list.getContext());
        View rowView = inflater.inflate(R.layout.rowsolicitud,null);

        Solicitud sol = solicitud.get(i);

        TextView name = rowView.findViewById(R.id.nameEmployee3);
        TextView servicio = rowView.findViewById(R.id.tipo);

        name.setText(sol.getNombreTrabajador());
        servicio.setText(sol.getTipoServicio());


        return rowView;
    }
}
