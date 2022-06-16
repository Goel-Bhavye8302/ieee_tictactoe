package com.ai.game.ieeetictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    // 1 == x and 0 == o and 2 == empty

    int currMov = 1;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] win = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    boolean gameOver = false;

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();
            }
        });

    }

    public void onClick(View view){
        ImageView imageView = (ImageView) view;

        int currPos = Integer.parseInt(imageView.getTag().toString());

        if(gameState[currPos] == 2 && gameOver == false){
            gameState[currPos] = currMov;

            if(currMov == 1){
                imageView.setImageResource(R.drawable.x);
                currMov = 0;
            }
            else{
                imageView.setImageResource(R.drawable.o);
                currMov = 1;
            }
            imageView.animate().alpha(1).setDuration(1000);
        }

        for(int i = 0; i < win.length; i++){
            if(gameState[win[i][0]] == gameState[win[i][1]] && gameState[win[i][1]] == gameState[win[i][2]] && gameState[win[i][0]] != 2){
                gameOver = true;
                break;
            }
        }

        if(gameOver == true){
            Toast.makeText(this, "Game Over!", Toast.LENGTH_SHORT).show();

            if(currMov == 0){
                textView.setText("X won!");
            }
            else textView.setText("O won!");

            textView.setVisibility(View.VISIBLE);
            button.setVisibility(View.VISIBLE);

        }

    }
}