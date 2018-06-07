package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.RatingBar;
import com.fossil.li;
import com.fossil.pk.a;
import com.fossil.ri;

public class AppCompatRatingBar extends RatingBar {
    private final ri akV;

    public AppCompatRatingBar(Context context) {
        this(context, null);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.ratingBarStyle);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akV = new ri(this);
        this.akV.a(attributeSet, i);
    }

    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap ox = this.akV.ox();
        if (ox != null) {
            setMeasuredDimension(li.resolveSizeAndState(ox.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
