package pl.kata.bielanski.firebaseuikata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.client.Firebase;

import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
	Firebase mRootRef;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		Firebase.setAndroidContext(this);
		mRootRef = new Firebase("https://glowing-torch-4628.firebaseio.com/BusStopList");
	}
}
