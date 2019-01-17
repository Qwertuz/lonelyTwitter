package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<importantTweet> tweetlist = new ArrayList<importantTweet>();
	private ArrayAdapter<importantTweet> adapter;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				importantTweet tweet = new importantTweet();
				tweet.setMessage(text);
				tweetlist.add(tweet);
				adapter.notifyDataSetChanged();
				saveInFile();
				//finish();

			}
		});

		clearButton.setOnClickListener(new View.OnClickListener(){
		    public void onClick(View v){
		        setResult(RESULT_OK);
		        //following code borrowed from https://stackoverflow.com/questions/3802304/clear-listview-content on the 16th of January, 2019
		        oldTweetsList.setAdapter(null);



            }
        });
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<importantTweet>(this,
				R.layout.list_item, tweetlist);
		oldTweetsList.setAdapter(adapter);
	}

	private void loadFromFile() {
		//ArrayList<String> tweets = new ArrayList<String>();
		try {

			//FileInputStream fis = openFileInput(FILENAME);
			//BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			//String line = in.readLine();
			//while (line != null) {
				//tweets.add(line);
				//line = in.readLine();
			//}

			FileReader in = new FileReader(new File(getFilesDir(), FILENAME));
			Gson gson = new Gson();
			//following code taken from https://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt on the 16th of Janunary 2019
			Type type = new TypeToken<ArrayList<importantTweet>>(){}.getType();
			tweetlist = gson.fromJson(in, type);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void saveInFile() {
		try {

			//FileOutputStream fos = openFileOutput(FILENAME,Context.MODE_APPEND);
			//fos.write(new String(date.toString() + " | " + text).getBytes());
			//fos.close();

			FileWriter out = new FileWriter(new File(getFilesDir(),FILENAME));
			Gson gson = new Gson();
			gson.toJson(tweetlist, out);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}