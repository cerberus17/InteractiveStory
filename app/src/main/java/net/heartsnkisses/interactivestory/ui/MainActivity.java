package net.heartsnkisses.interactivestory.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.heartsnkisses.interactivestory.R;

public class MainActivity extends AppCompatActivity {
  private EditText nameField = null;
  private Button startButton = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    nameField = (EditText) findViewById(R.id.nameEditText);
    startButton = (Button) findViewById(R.id.startButton);

    startButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String name = nameField.getText().toString();

//        Toast.makeText(MainActivity.this, "Name: " + name, Toast.LENGTH_SHORT).show();

        startStory(name);
      }
    });
  }

  protected void onResume() {
    super.onResume();
    nameField.setText("");
  }

  private void startStory(String name) {
    Intent intent = new Intent(getApplicationContext(), StoryActivity.class);

    intent.putExtra(getString(R.string.key_name), name);

    startActivity(intent);
  }
}
