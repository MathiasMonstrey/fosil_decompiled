package com.fossil;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.fossil.dh.C2251c;

@TargetApi(14)
class co extends dh {
    private static final String[] FI = new String[]{"android:changeBounds:bounds", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static cu FJ = new cu();
    int[] FK = new int[2];
    boolean FL = false;
    boolean FM = false;

    class C22521 extends C2251c {
        boolean FN = false;
        final /* synthetic */ co FO;

        C22521(co coVar) {
            this.FO = coVar;
        }

        public void mo1903a(dh dhVar) {
            if (!this.FN) {
            }
        }

        public void mo1904b(dh dhVar) {
        }

        public void mo1905c(dh dhVar) {
        }
    }

    class C22532 extends C2251c {
        boolean FN = false;
        final /* synthetic */ co FO;

        C22532(co coVar) {
            this.FO = coVar;
        }

        public void mo1903a(dh dhVar) {
            if (!this.FN) {
            }
        }

        public void mo1904b(dh dhVar) {
        }

        public void mo1905c(dh dhVar) {
        }
    }

    class C22543 extends AnimatorListenerAdapter {
        final /* synthetic */ co FO;

        C22543(co coVar) {
            this.FO = coVar;
        }

        public void onAnimationEnd(Animator animator) {
        }
    }

    co() {
    }

    public String[] getTransitionProperties() {
        return FI;
    }

    private void m7317c(dn dnVar) {
        View view = dnVar.view;
        dnVar.values.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        dnVar.values.put("android:changeBounds:parent", dnVar.view.getParent());
        dnVar.view.getLocationInWindow(this.FK);
        dnVar.values.put("android:changeBounds:windowX", Integer.valueOf(this.FK[0]));
        dnVar.values.put("android:changeBounds:windowY", Integer.valueOf(this.FK[1]));
    }

    public void mo1864a(dn dnVar) {
        m7317c(dnVar);
    }

    public void mo1866b(dn dnVar) {
        m7317c(dnVar);
    }

    public Animator mo1907a(ViewGroup viewGroup, dn dnVar, dn dnVar2) {
        if (dnVar == null || dnVar2 == null) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) dnVar.values.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) dnVar2.values.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        final View view = dnVar2.view;
        Object obj = (viewGroup2 == viewGroup3 || viewGroup2.getId() == viewGroup3.getId()) ? 1 : null;
        int intValue;
        int intValue2;
        int intValue3;
        int intValue4;
        if (this.FM && obj == null) {
            intValue = ((Integer) dnVar.values.get("android:changeBounds:windowX")).intValue();
            intValue2 = ((Integer) dnVar.values.get("android:changeBounds:windowY")).intValue();
            intValue3 = ((Integer) dnVar2.values.get("android:changeBounds:windowX")).intValue();
            intValue4 = ((Integer) dnVar2.values.get("android:changeBounds:windowY")).intValue();
            if (!(intValue == intValue3 && intValue2 == intValue4)) {
                viewGroup.getLocationInWindow(this.FK);
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
                view.draw(new Canvas(createBitmap));
                final Drawable bitmapDrawable = new BitmapDrawable(createBitmap);
                view.setVisibility(4);
                dq.m9314D(viewGroup).add(bitmapDrawable);
                Rect rect = new Rect(intValue - this.FK[0], intValue2 - this.FK[1], (intValue - this.FK[0]) + view.getWidth(), (intValue2 - this.FK[1]) + view.getHeight());
                Rect rect2 = new Rect(intValue3 - this.FK[0], intValue4 - this.FK[1], (intValue3 - this.FK[0]) + view.getWidth(), (intValue4 - this.FK[1]) + view.getHeight());
                Animator ofObject = ObjectAnimator.ofObject(bitmapDrawable, "bounds", FJ, new Object[]{rect, rect2});
                final ViewGroup viewGroup4 = viewGroup;
                ofObject.addListener(new AnimatorListenerAdapter(this) {
                    final /* synthetic */ co FO;

                    public void onAnimationEnd(Animator animator) {
                        dq.m9314D(viewGroup4).remove(bitmapDrawable);
                        view.setVisibility(0);
                    }
                });
                return ofObject;
            }
        }
        Rect rect3 = (Rect) dnVar.values.get("android:changeBounds:bounds");
        rect2 = (Rect) dnVar2.values.get("android:changeBounds:bounds");
        intValue2 = rect3.left;
        intValue3 = rect2.left;
        int i = rect3.top;
        int i2 = rect2.top;
        int i3 = rect3.right;
        int i4 = rect2.right;
        int i5 = rect3.bottom;
        int i6 = rect2.bottom;
        int i7 = i3 - intValue2;
        int i8 = i5 - i;
        int i9 = i4 - intValue3;
        int i10 = i6 - i2;
        intValue4 = 0;
        if (!(i7 == 0 || i8 == 0 || i9 == 0 || i10 == 0)) {
            if (intValue2 != intValue3) {
                intValue4 = 1;
            }
            if (i != i2) {
                intValue4++;
            }
            if (i3 != i4) {
                intValue4++;
            }
            if (i5 != i6) {
                intValue4++;
            }
        }
        if (intValue4 > 0) {
            Animator ofPropertyValuesHolder;
            if (this.FL) {
                if (i7 != i9) {
                    view.setRight(Math.max(i7, i9) + intValue3);
                }
                if (i8 != i10) {
                    view.setBottom(Math.max(i8, i10) + i2);
                }
                if (intValue2 != intValue3) {
                    view.setTranslationX((float) (intValue2 - intValue3));
                }
                if (i != i2) {
                    view.setTranslationY((float) (i - i2));
                }
                float f = (float) (intValue3 - intValue2);
                float f2 = (float) (i2 - i);
                i = i9 - i7;
                i2 = i10 - i8;
                intValue4 = 0;
                if (f != 0.0f) {
                    intValue4 = 1;
                }
                if (f2 != 0.0f) {
                    intValue4++;
                }
                if (!(i == 0 && i2 == 0)) {
                    intValue4++;
                }
                PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[intValue4];
                if (f != 0.0f) {
                    intValue4 = 1;
                    propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat("translationX", new float[]{view.getTranslationX(), 0.0f});
                } else {
                    intValue4 = 0;
                }
                if (f2 != 0.0f) {
                    intValue = intValue4 + 1;
                    propertyValuesHolderArr[intValue4] = PropertyValuesHolder.ofFloat("translationY", new float[]{view.getTranslationY(), 0.0f});
                }
                if (!(i == 0 && i2 == 0)) {
                    rect3 = new Rect(0, 0, i7, i8);
                    rect3 = new Rect(0, 0, i9, i10);
                }
                ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr);
                if (view.getParent() instanceof ViewGroup) {
                    viewGroup2 = (ViewGroup) view.getParent();
                    mo1862a(new C22532(this));
                }
                ofPropertyValuesHolder.addListener(new C22543(this));
                return ofPropertyValuesHolder;
            }
            PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[intValue4];
            if (intValue2 != intValue3) {
                view.setLeft(intValue2);
            }
            if (i != i2) {
                view.setTop(i);
            }
            if (i3 != i4) {
                view.setRight(i3);
            }
            if (i5 != i6) {
                view.setBottom(i5);
            }
            if (intValue2 != intValue3) {
                intValue4 = 1;
                propertyValuesHolderArr2[0] = PropertyValuesHolder.ofInt("left", new int[]{intValue2, intValue3});
            } else {
                intValue4 = 0;
            }
            if (i != i2) {
                intValue = intValue4 + 1;
                propertyValuesHolderArr2[intValue4] = PropertyValuesHolder.ofInt("top", new int[]{i, i2});
            } else {
                intValue = intValue4;
            }
            if (i3 != i4) {
                intValue4 = intValue + 1;
                propertyValuesHolderArr2[intValue] = PropertyValuesHolder.ofInt("right", new int[]{i3, i4});
            } else {
                intValue4 = intValue;
            }
            if (i5 != i6) {
                intValue = intValue4 + 1;
                propertyValuesHolderArr2[intValue4] = PropertyValuesHolder.ofInt("bottom", new int[]{i5, i6});
            }
            ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr2);
            if (view.getParent() instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) view.getParent();
                mo1862a(new C22521(this));
            }
            return ofPropertyValuesHolder;
        }
        return null;
    }
}
