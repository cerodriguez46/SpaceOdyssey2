package christopher.spaceodyssey2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class VenusActivity extends AppCompatActivity {
    ImageView rocket;
    ImageView venusImage;
    Animation animRotate;

    private GestureDetectorCompat gestureObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_venus);

        rocket = (ImageView)findViewById(R.id.rocket);

        venusImage = (ImageView)findViewById(R.id.imageViewVenus);
        // load the animation
        animRotate = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.venusanimation);
       venusImage.startAnimation(animRotate);

        gestureObject = new GestureDetectorCompat(this, new learnGesture());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class learnGesture extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e2.getX() < e1.getX()){
                Intent intent = new Intent (VenusActivity.this, EarthActivity.class);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                rocket.animate().translationXBy(1000f).setDuration(700);
                startActivity(intent);

            }
            else if (e2.getX() > e1.getX()){
                Intent intent = new Intent (VenusActivity.this, MercuryActivity.class);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                rocket.animate().translationXBy(1000f).setDuration(700);
                startActivity(intent);
            }
            return true;
        }
    }
}
