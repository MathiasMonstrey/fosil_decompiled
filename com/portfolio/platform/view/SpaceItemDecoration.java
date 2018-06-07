package com.portfolio.platform.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.s;
import android.util.AttributeSet;
import android.view.View;

public class SpaceItemDecoration extends g {
    private final int dng;
    private boolean dnh;
    private boolean dni;
    int mOrientation;

    public SpaceItemDecoration(Context context, AttributeSet attributeSet) {
        this.dnh = false;
        this.dni = false;
        this.mOrientation = -1;
        this.dng = 0;
    }

    public SpaceItemDecoration(Context context, int i) {
        this.dnh = false;
        this.dni = false;
        this.mOrientation = -1;
        this.dng = context.getResources().getDimensionPixelSize(i);
    }

    public SpaceItemDecoration(Context context, int i, boolean z, boolean z2) {
        this(context, i);
        this.dnh = z;
        this.dni = z2;
    }

    public void m16003a(Rect rect, View view, RecyclerView recyclerView, s sVar) {
        if (this.dng != 0) {
            if (this.mOrientation == -1) {
                m16002q(recyclerView);
            }
            int bV = recyclerView.bV(view);
            if (bV == -1) {
                return;
            }
            if (bV == 0 && !this.dnh) {
                return;
            }
            if (this.mOrientation == 1) {
                rect.top = this.dng;
                if (this.dni && bV == sVar.getItemCount() - 1) {
                    rect.bottom = rect.top;
                }
            } else if (this.mOrientation == 0) {
                rect.left = this.dng;
                if (this.dni && bV == sVar.getItemCount() - 1) {
                    rect.right = rect.left;
                }
            } else {
                rect.top = this.dng;
                if (this.dni && bV == sVar.getItemCount() - 1) {
                    rect.bottom = rect.top;
                }
                rect.left = this.dng;
                if (this.dni && bV == sVar.getItemCount() - 1) {
                    rect.right = rect.left;
                }
            }
        }
    }

    private int m16002q(RecyclerView recyclerView) {
        if (this.mOrientation == -1) {
            if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                this.mOrientation = 3;
            } else if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                this.mOrientation = ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation();
            } else {
                throw new IllegalStateException("DividerItemDecoration can only be used with a LinearLayoutManager.");
            }
        }
        return this.mOrientation;
    }
}
