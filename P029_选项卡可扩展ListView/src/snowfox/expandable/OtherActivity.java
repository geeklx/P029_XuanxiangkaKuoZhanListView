package snowfox.expandable;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class OtherActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);
	}

	public void goBack(View v) {
		this.finish();
	}
}
