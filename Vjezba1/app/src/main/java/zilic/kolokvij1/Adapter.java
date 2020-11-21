package zilic.kolokvij1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Adapter extends RecyclerView.Adapter<Adapter.Red> {

    private List<Mjerenje> mjerenja;
    private LayoutInflater layoutInflater;
    private ItemClickListener itemClickListener;

    public Adapter(Context context){
        layoutInflater = LayoutInflater.from(context);
        mjerenja=new ArrayList<>();
    }

    public void setMjerenja(List<Mjerenje> mjerenja) {
        this.mjerenja = mjerenja;
    }

    @NonNull
    @Override
    public Red onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.red_layout, parent, false);
        return new Red(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Red holder, int position) {
        Mjerenje a = this.mjerenja.get(position);
        //ako nije String, npr. datum ili broj, morate ga pretvoriti u tekst s String.valueOf(ovdje ide varijabla)
        String datum_n = new SimpleDateFormat("H", Locale.getDefault()).format(a.getDatum());

        holder.datum.setText(datum_n);
        holder.iznos.setText(String.valueOf(a.getIznos()));
    }

    @Override
    public int getItemCount() {
        return this.mjerenja==null ? 0 : this.mjerenja.size();
    }

    public class Red extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView datum;
        private TextView iznos;

        public Red(@NonNull View itemView) {
            super(itemView);
            datum = itemView.findViewById(R.id.datum);
            iznos = itemView.findViewById(R.id.iznos);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(itemClickListener!=null){
                itemClickListener.onItemClick(mjerenja.get(getAdapterPosition()));
            }
        }
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(Mjerenje mjerenje);
    }

}
