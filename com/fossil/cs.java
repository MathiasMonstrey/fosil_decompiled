package com.fossil;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.fossil.dh.C2251c;

@TargetApi(14)
class cs extends dw {
    private static boolean DBG = false;
    private int FR;

    public cs() {
        this(3);
    }

    public cs(int i) {
        this.FR = i;
    }

    private Animator m7474a(View view, float f, float f2, AnimatorListenerAdapter animatorListenerAdapter) {
        Animator animator = null;
        if (f != f2) {
            animator = ObjectAnimator.ofFloat(view, "alpha", new float[]{f, f2});
            if (DBG) {
                Log.d("Fade", "Created animator " + animator);
            }
            if (animatorListenerAdapter != null) {
                animator.addListener(animatorListenerAdapter);
            }
        } else if (animatorListenerAdapter != null) {
            animatorListenerAdapter.onAnimationEnd(null);
        }
        return animator;
    }

    private void m7475c(dn dnVar) {
        int[] iArr = new int[2];
        dnVar.view.getLocationOnScreen(iArr);
        dnVar.values.put("android:fade:screenX", Integer.valueOf(iArr[0]));
        dnVar.values.put("android:fade:screenY", Integer.valueOf(iArr[1]));
    }

    public void mo1864a(dn dnVar) {
        super.mo1864a(dnVar);
        m7475c(dnVar);
    }

    public Animator mo2020a(ViewGroup viewGroup, dn dnVar, int i, dn dnVar2, int i2) {
        if ((this.FR & 1) != 1 || dnVar2 == null) {
            return null;
        }
        final View view = dnVar2.view;
        if (DBG) {
            Log.d("Fade", "Fade.onAppear: startView, startVis, endView, endVis = " + (dnVar != null ? dnVar.view : null) + ", " + i + ", " + view + ", " + i2);
        }
        view.setAlpha(0.0f);
        mo1862a(new C2251c(this) {
            boolean FN = false;
            float FS;
            final /* synthetic */ cs FU;

            public void mo1903a(dh dhVar) {
                if (!this.FN) {
                    view.setAlpha(1.0f);
                }
            }

            public void mo1904b(dh dhVar) {
                this.FS = view.getAlpha();
                view.setAlpha(1.0f);
            }

            public void mo1905c(dh dhVar) {
                view.setAlpha(this.FS);
            }
        });
        return m7474a(view, 0.0f, 1.0f, null);
    }

    public Animator mo2021b(ViewGroup viewGroup, dn dnVar, int i, dn dnVar2, int i2) {
        if ((this.FR & 2) != 2) {
            return null;
        }
        View view;
        View view2;
        View view3;
        int id;
        View view4 = dnVar != null ? dnVar.view : null;
        if (dnVar2 != null) {
            view = dnVar2.view;
        } else {
            view = null;
        }
        if (DBG) {
            Log.d("Fade", "Fade.onDisappear: startView, startVis, endView, endVis = " + view4 + ", " + i + ", " + view + ", " + i2);
        }
        if (view == null || view.getParent() == null) {
            if (view != null) {
                view2 = null;
                view3 = view;
                view4 = view;
            } else {
                if (view4 != null) {
                    if (view4.getParent() == null) {
                        view2 = null;
                        view3 = view4;
                    } else if ((view4.getParent() instanceof View) && view4.getParent().getParent() == null) {
                        id = ((View) view4.getParent()).getId();
                        if (id == -1 || viewGroup.findViewById(id) == null || !this.GA) {
                            Object obj = null;
                            view4 = null;
                        } else {
                            view = view4;
                        }
                        view2 = null;
                        view3 = view;
                    }
                }
                view2 = null;
                view3 = null;
                view4 = null;
            }
        } else if (i2 == 4) {
            view2 = view;
            view3 = null;
            view4 = view;
        } else if (view4 == view) {
            view2 = view;
            view3 = null;
            view4 = view;
        } else {
            view2 = null;
            view3 = view4;
        }
        final int i3;
        final ViewGroup viewGroup2;
        if (view3 != null) {
            int intValue = ((Integer) dnVar.values.get("android:fade:screenX")).intValue();
            id = ((Integer) dnVar.values.get("android:fade:screenY")).intValue();
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            li.m12275q(view3, (intValue - iArr[0]) - view3.getLeft());
            li.m12274p(view3, (id - iArr[1]) - view3.getTop());
            dp.m9315d(viewGroup).add(view3);
            i3 = i2;
            viewGroup2 = viewGroup;
            return m7474a(view4, 1.0f, 0.0f, new AnimatorListenerAdapter(this) {
                final /* synthetic */ cs FU;

                public void onAnimationEnd(Animator animator) {
                    view4.setAlpha(1.0f);
                    if (view2 != null) {
                        view2.setVisibility(i3);
                    }
                    if (view3 != null) {
                        dp.m9315d(viewGroup2).remove(view3);
                    }
                }
            });
        } else if (view2 == null) {
            return null;
        } else {
            view2.setVisibility(0);
            i3 = i2;
            viewGroup2 = viewGroup;
            return m7474a(view4, 1.0f, 0.0f, new AnimatorListenerAdapter(this) {
                boolean FN = false;
                float FS = -1.0f;
                final /* synthetic */ cs FU;

                public void onAnimationCancel(Animator animator) {
                    this.FN = true;
                    if (this.FS >= 0.0f) {
                        view4.setAlpha(this.FS);
                    }
                }

                public void onAnimationEnd(Animator animator) {
                    if (!this.FN) {
                        view4.setAlpha(1.0f);
                    }
                    if (!(view2 == null || this.FN)) {
                        view2.setVisibility(i3);
                    }
                    if (view3 != null) {
                        dp.m9315d(viewGroup2).add(view3);
                    }
                }
            });
        }
    }
}
