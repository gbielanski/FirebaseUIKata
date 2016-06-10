package pl.kata.bielanski.firebaseuikata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
	@Bind(R.id.bus_stop_list)
	ListView listView;
	Firebase mRootRef;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		Firebase.setAndroidContext(this);
		mRootRef = new Firebase("https://glowing-torch-4628.firebaseio.com/BusStopList");

		FirebaseListAdapter<String> adapter = new FirebaseListAdapter<String>(this, String.class,
				android.R.layout.simple_list_item_1, mRootRef) {
			@Override
			protected void populateView(View view, String s, int i) {
				TextView textView = (TextView)view.findViewById(android.R.id.text1);
				textView.setText(s);
				Log.v("GREG", "ALLO");
			}
		};

		listView.setAdapter(adapter);
	}
}
