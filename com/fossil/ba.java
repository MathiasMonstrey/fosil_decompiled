package com.fossil;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.support.design.widget.VisibilityAwareImageButton;
import com.fossil.bb.C1097a;
import com.fossil.bj.C1929d;

@TargetApi(14)
public class ba extends az {
    private float wI = this.zI.getRotation();

    public ba(VisibilityAwareImageButton visibilityAwareImageButton, bf bfVar, C1929d c1929d) {
        super(visibilityAwareImageButton, bfVar, c1929d);
    }

    boolean gp() {
        return true;
    }

    void gq() {
        float rotation = this.zI.getRotation();
        if (this.wI != rotation) {
            this.wI = rotation;
            gs();
        }
    }

    void mo1225a(final C1097a c1097a, final boolean z) {
        if (!gy()) {
            this.zI.animate().cancel();
            if (gr()) {
                this.zA = 1;
                this.zI.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(aq.vd).setListener(new AnimatorListenerAdapter(this) {
                    private boolean zx;
                    final /* synthetic */ ba zy;

                    public void onAnimationStart(Animator animator) {
                        this.zy.zI.m1863a(0, z);
                        this.zx = false;
                    }

                    public void onAnimationCancel(Animator animator) {
                        this.zx = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        this.zy.zA = 0;
                        if (!this.zx) {
                            this.zy.zI.m1863a(z ? 8 : 4, z);
                            if (c1097a != null) {
                                c1097a.gk();
                            }
                        }
                    }
                });
                return;
            }
            this.zI.m1863a(z ? 8 : 4, z);
            if (c1097a != null) {
                c1097a.gk();
            }
        }
    }

    void mo1228b(final C1097a c1097a, final boolean z) {
        if (!gx()) {
            this.zI.animate().cancel();
            if (gr()) {
                this.zA = 2;
                if (this.zI.getVisibility() != 0) {
                    this.zI.setAlpha(0.0f);
                    this.zI.setScaleY(0.0f);
                    this.zI.setScaleX(0.0f);
                }
                this.zI.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(aq.ve).setListener(new AnimatorListenerAdapter(this) {
                    final /* synthetic */ ba zy;

                    public void onAnimationStart(Animator animator) {
                        this.zy.zI.m1863a(0, z);
                    }

                    public void onAnimationEnd(Animator animator) {
                        this.zy.zA = 0;
                        if (c1097a != null) {
                            c1097a.gj();
                        }
                    }
                });
                return;
            }
            this.zI.m1863a(0, z);
            this.zI.setAlpha(1.0f);
            this.zI.setScaleY(1.0f);
            this.zI.setScaleX(1.0f);
            if (c1097a != null) {
                c1097a.gj();
            }
        }
    }

    private boolean gr() {
        return li.as(this.zI) && !this.zI.isInEditMode();
    }

    private void gs() {
        if (VERSION.SDK_INT == 19) {
            if (this.wI % 90.0f != 0.0f) {
                if (this.zI.getLayerType() != 1) {
                    this.zI.setLayerType(1, null);
                }
            } else if (this.zI.getLayerType() != 0) {
                this.zI.setLayerType(0, null);
            }
        }
        if (this.zq != null) {
            this.zq.setRotation(-this.wI);
        }
        if (this.zD != null) {
            this.zD.setRotation(-this.wI);
        }
    }
}
