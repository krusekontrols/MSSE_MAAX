package edu.umn.contactviewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailsActivity extends Activity {
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.details);
		 ToolbarConfig toolbar = new ToolbarConfig(this, "Contact Details");
	
		    // setup the about button
		    Button button = toolbar.getToolbarRightButton();
		    button.setText("Edit");
			button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					Intent intent = new Intent(getApplicationContext(), EditActivity.class);
					intent.putExtra("contactId", getIntent().getStringExtra("contactId"));
			    	intent.putExtra("name", getIntent().getStringExtra("name"));
			    	intent.putExtra("email", getIntent().getStringExtra("email"));
			    	intent.putExtra("title", getIntent().getStringExtra("title"));
			    	intent.putExtra("phone", getIntent().getStringExtra("phone"));
			    	intent.putExtra("twitterId", getIntent().getStringExtra("twitterId"));
			    	startActivityForResult(intent, 0);
				}
			});
		
		TextView textViewName = (TextView) findViewById(R.id.details_name);
		String name = getIntent().getStringExtra("name");
		textViewName.setText(name);
		
		TextView textViewPhone = (TextView) findViewById(R.id.details_phone);
		String phone = getIntent().getStringExtra("phone");
		textViewPhone.setText(phone);
		
		TextView textViewTitle = (TextView) findViewById(R.id.details_title);
		String title = getIntent().getStringExtra("title");
		textViewTitle.setText(title);
		
		TextView textViewEmail = (TextView) findViewById(R.id.details_email);
		String email = getIntent().getStringExtra("email");
		textViewEmail.setText(email);
		
		TextView textViewTwitterId = (TextView) findViewById(R.id.details_twitterId);
		String twitterId = getIntent().getStringExtra("twitterId");
		textViewTwitterId.setText(twitterId);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
            Intent data) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
            	TextView textViewName = (TextView) findViewById(R.id.details_name);
        		String name = data.getStringExtra("name");
        		textViewName.setText(name);
        		getIntent().putExtra("name", name);
        		
        		TextView textViewPhone = (TextView) findViewById(R.id.details_phone);
        		String phone = data.getStringExtra("phone");
        		textViewPhone.setText(phone);
        		getIntent().putExtra("phone", phone);
        		
        		TextView textViewTitle = (TextView) findViewById(R.id.details_title);
        		String title = data.getStringExtra("title");
        		textViewTitle.setText(title);
        		getIntent().putExtra("title", title);
        		
        		TextView textViewEmail = (TextView) findViewById(R.id.details_email);
        		String email = data.getStringExtra("email");
        		textViewEmail.setText(email);
        		getIntent().putExtra("email", email);
        		
        		TextView textViewTwitterId = (TextView) findViewById(R.id.details_twitterId);
        		String twitterId = data.getStringExtra("twitterId");
        		textViewTwitterId.setText(twitterId);
        		getIntent().putExtra("twitterId", twitterId);
            }
        }
    }
}
