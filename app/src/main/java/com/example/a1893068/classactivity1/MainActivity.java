package com.example.harsh.pokerecycledemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.a1893068.classactivity1.Pokemon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {


    Pokemonadapter adapter;
    ArrayList<Pokemon> pokelst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pokelst = new ArrayList<>();

        String link = "https://next.json-generator.com/api/json/get/E14trR2lD";

        try {


            // progs.setVisibility(View.VISIBLE);
            String data = new Asycdata(MainActivity.this).execute(link).get();
            System.out.println("This is from Main Activity :" + data);


            JSONObject mainobj = new JSONObject(data);
            JSONArray pokearray = mainobj.getJSONArray("Pokemon");

            for (int i = 0; i < pokearray.length(); i++) {
                JSONObject child = pokearray.getJSONObject(i);

                String img = child.getString("image");
                String name = child.getString("name");
                String type = child.getString("type");
                String ability = child.getString("ability");
                String height = child.getString("height");
                String weight = child.getString("weight");
                String desc = child.getString("description");

                String keyname = child.toString();


                pokelst.add(new Pokemon(name, img, type, ability, height, weight, desc));
            }


            adapter = new Pokemonadapter(pokelst,getApplicationContext());

            intiPokemonView();


        }catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    public void intiPokemonView()
    {
        @SuppressLint("WrongConstant") LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerView = findViewById(R.id.recycle_poke);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(onItemClickListenerwish);
    }


    private View.OnClickListener onItemClickListenerwish = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            /*RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
*/

            Toast.makeText(getApplicationContext(),"Done!",Toast.LENGTH_SHORT).show();

        }
    };
}
