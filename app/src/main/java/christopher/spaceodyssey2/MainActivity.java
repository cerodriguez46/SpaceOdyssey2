package christopher.spaceodyssey2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private GestureDetectorCompat gestureObject;

    ImageView sunImage;
    ImageView rocket;
    Animation animRotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        rocket = (ImageView)findViewById(R.id.imageViewRocket);

        sunImage = (ImageView)findViewById(R.id.imageView);
        // load the animation
        animRotate = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.mercuryanimation);
        sunImage.startAnimation(animRotate);

gestureObject = new GestureDetectorCompat(this, new learnGesture());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class learnGesture extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e2.getX() < e1.getX()){
Intent intent = new Intent (MainActivity.this, MercuryActivity.class);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                rocket.animate().translationXBy(1000f).setDuration(700);
                startActivity(intent);

            }
            else if (e2.getX() > e1.getX()){
                Intent intent = new Intent (MainActivity.this, NeptuneActivity.class);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                rocket.animate().translationXBy(1000f).setDuration(700);
                startActivity(intent);


            }
            return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
