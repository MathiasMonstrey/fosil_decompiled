package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.fossil.pk.a;
import com.fossil.rj;

public class AppCompatSeekBar extends SeekBar {
    private final rj akW;

    public AppCompatSeekBar(Context context) {
        this(context, null);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.seekBarStyle);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akW = new rj(this);
        this.akW.a(attributeSet, i);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.akW.b(canvas);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.akW.drawableStateChanged();
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.akW.jumpDrawablesToCurrentState();
    }
}
