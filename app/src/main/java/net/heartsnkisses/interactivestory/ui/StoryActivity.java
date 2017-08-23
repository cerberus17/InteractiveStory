package net.heartsnkisses.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.heartsnkisses.interactivestory.R;
import net.heartsnkisses.interactivestory.model.Page;
import net.heartsnkisses.interactivestory.model.Story;

import java.util.Stack;

public class StoryActivity extends AppCompatActivity {
  private static final String TAG = StoryActivity.class.getSimpleName();

  private String name = null;

  private Story story = null;
  private ImageView storyImageView;
  private TextView storyTextView;
  private Button choice1Button;
  private Button choice2Button;

  private Stack<Integer> pageStack = new Stack<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_story);

    storyImageView = (ImageView) findViewById(R.id.storyImageView);
    storyTextView = (TextView) findViewById(R.id.storyTextView);
    choice1Button = (Button) findViewById(R.id.choice1Button);
    choice2Button = (Button) findViewById(R.id.choice2Button);

    Intent intent = getIntent();

    name = intent.getStringExtra(getResources().getString(R.string.key_name));
    Log.d(TAG, name);

    story = new Story();
    loadPage(0);
  }

  private void loadPage(int pageNum) {
    pageStack.push(pageNum);

    final Page page = story.getPage(pageNum);

    storyImageView.setImageDrawable(ContextCompat.getDrawable(this, page.getImageId()));

    String pageText = getString(page.getStoryTextId());
    pageText = String.format(pageText, name);
    storyTextView.setText(pageText);

    if (page.isFinalPage()) {
      choice1Button.setVisibility(View.INVISIBLE);
      choice2Button.setText(R.string.play_again_button_text);

      choice2Button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          finish();
        }
      });
    }
    else {
      choice1Button.setVisibility(View.VISIBLE);
      choice1Button.setText(page.getFirstChoice().getTextId());
      choice1Button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          loadPage(page.getFirstChoice().getNextPage());
        }
      });

      choice2Button.setVisibility(View.VISIBLE);
      choice2Button.setText(page.getSecondChoice().getTextId());
      choice2Button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          loadPage(page.getSecondChoice().getNextPage());
        }
      });
    }
  }

  @Override
  public void onBackPressed() {
    pageStack.pop();

    if (pageStack.isEmpty())
      super.onBackPressed();
    else
      loadPage(pageStack.pop());
  }
}
