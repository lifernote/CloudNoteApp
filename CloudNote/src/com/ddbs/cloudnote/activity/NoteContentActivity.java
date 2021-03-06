package com.ddbs.cloudnote.activity;

import com.ddbs.cloudnote.R;
import com.ddbs.cloudnote.entity.Note;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class NoteContentActivity extends BaseActivity{
	private TextView noteTitleTextView;
	private TextView noteContentTextView;
	private Button editButton;
	private Note note;
	public static void start(Context context,Note note){
		Intent intent = new Intent(context, NoteContentActivity.class);
		intent.putExtra("note", note);
		context.startActivity(intent);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.note_content);
		note = (Note) getIntent().getSerializableExtra("note");
		String titleStr = note.getTitle();
		String contentStr = note.getContent();
		noteTitleTextView = (TextView) findViewById(R.id.note_title);
		noteContentTextView = (TextView) findViewById(R.id.note_content);
		editButton = (Button) findViewById(R.id.save_note);
		noteTitleTextView.setText(titleStr);
		noteContentTextView.setText(contentStr);
		editButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditActivity.start(NoteContentActivity.this, note);
				NoteContentActivity.this.finish();
			}
		});
	}
	
	

}
