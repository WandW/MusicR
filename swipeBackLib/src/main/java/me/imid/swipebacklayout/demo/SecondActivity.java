package me.imid.swipebacklayout.demo;

import android.os.Bundle;
import main.java.me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class SecondActivity extends SwipeBackActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_layout);
		
		setEdgeFromLeft();
	}
}
