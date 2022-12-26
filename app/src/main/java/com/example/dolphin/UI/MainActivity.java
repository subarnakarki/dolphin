package com.example.dolphin.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.dolphin.Database.Repository;
import com.example.dolphin.R;
import com.example.dolphin.entities.Part;
import com.example.dolphin.entities.Product;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
//        Product product = new Product(0, "bicycle", 100.00);
//        Repository repository = new Repository(getApplication());
//        repository.insert(product);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProductList.class);
                startActivity(intent);
            }
        });

    }
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.addSampleData:
            Product product = new Product(0, "bicycle", 100.00);
            Repository repository = new Repository(getApplication());
            repository.insert(product);
            Part part = new Part(0, "wheel", 10.00, 1);
            repository.insert(part);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}