/*
 * Copyright 2019 TEAM 07
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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

/**
 *  The basic functionally and design of the lonely twitter app
 *
 * @author cjmiller
 * @version 1.0
 * @see importantTweet
 * @see Tweet
 * @since 1.0
 *
 */
/*
 *
 * LonelyTwitterActivity
 *
 * Version: 1.3
 *
 * 23rd January, 2019
 *
 *
 *
 */
public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<importantTweet> tweetlist = new ArrayList<importantTweet>();
	private ArrayAdapter<importantTweet> adapter;
	/** Called when the activity is first created. Creates the basic functionally of the layout as well as governing how the buttons work.
     *
     * @param savedInstanceState
     * @since 1.0
     *
     */
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
                tweetlist.clear();
                saveInFile();
            }
        });
	}

    /**
     * Loads in the data when the app is resumed
     *
     * @since 1.0
     */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<importantTweet>(this,
				R.layout.list_item, tweetlist);
		oldTweetsList.setAdapter(adapter);
	}

    /**
     * Retrieves the list of previous tweets when called from an external file
     *
     * @since 1.0
     */
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
    /**
     * Saves the list of previous tweets to an external file
     *
     * @since 1.0
     */
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