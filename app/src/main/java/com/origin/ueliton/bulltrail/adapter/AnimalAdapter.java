package com.origin.ueliton.bulltrail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.origin.ueliton.bulltrail.R;
import com.origin.ueliton.bulltrail.data.DataBase;
import com.origin.ueliton.bulltrail.interfaces.AnimalListOperation;
import com.origin.ueliton.bulltrail.model.Animal;
import com.origin.ueliton.bulltrail.util.DateUtil;

import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ueliton on 28/03/2016.
 */
public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>{

    private Context context;
    private List<Animal> animals;
    private AnimalListOperation animalListOperation;

    public AnimalAdapter(Context context, AnimalListOperation animalListOperation) {
        this.context = context;
        this.animals = Collections.emptyList();//DataBase.getAnimalsRepository().findAll();
        this.animalListOperation = animalListOperation;
    }

    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.animal_item_list, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AnimalViewHolder holder, int position) {

        if (animals != null) {
            Animal animal = animals.get(position);
            holder.setName(animal.getName());
            holder.setAge(DateUtil.age(animal.getBirthDate()));
            holder.setWeight(animal.getWeight());
        }
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    class AnimalViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.text_view_name)
        TextView name;

        @Bind(R.id.text_view_age)
        TextView age;

        @Bind(R.id.text_view_last_weight)
        TextView weight;

        public AnimalViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    animalListOperation.click(animals.get(getAdapterPosition()), getAdapterPosition());
                }
            });
        }

        public void setName(String name) {
            this.name.setText(name);
        }

        public void setAge(Integer age) {
            this.age.setText(age);
        }

        public void setWeight(Integer weight) {
            this.weight.setText(weight);
        }
    }
}
