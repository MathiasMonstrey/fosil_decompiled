package com.fossil;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import android.util.Log;

final class ff implements Parcelable {
    public static final Creator<ff> CREATOR = new C35641();
    final String JY;
    Fragment JZ;
    final Bundle mArguments;
    final int mContainerId;
    final boolean mDetached;
    final int mFragmentId;
    final boolean mFromLayout;
    final boolean mHidden;
    final int mIndex;
    final boolean mRetainInstance;
    Bundle mSavedFragmentState;
    final String mTag;

    static class C35641 implements Creator<ff> {
        C35641() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m11349h(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return aL(i);
        }

        public ff m11349h(Parcel parcel) {
            return new ff(parcel);
        }

        public ff[] aL(int i) {
            return new ff[i];
        }
    }

    public ff(Fragment fragment) {
        this.JY = fragment.getClass().getName();
        this.mIndex = fragment.mIndex;
        this.mFromLayout = fragment.mFromLayout;
        this.mFragmentId = fragment.mFragmentId;
        this.mContainerId = fragment.mContainerId;
        this.mTag = fragment.mTag;
        this.mRetainInstance = fragment.mRetainInstance;
        this.mDetached = fragment.mDetached;
        this.mArguments = fragment.mArguments;
        this.mHidden = fragment.mHidden;
    }

    public ff(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.JY = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mFromLayout = parcel.readInt() != 0;
        this.mFragmentId = parcel.readInt();
        this.mContainerId = parcel.readInt();
        this.mTag = parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.mRetainInstance = z;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.mDetached = z;
        this.mArguments = parcel.readBundle();
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.mHidden = z2;
        this.mSavedFragmentState = parcel.readBundle();
    }

    public Fragment m11350a(ez ezVar, Fragment fragment, fc fcVar) {
        if (this.JZ == null) {
            Context context = ezVar.getContext();
            if (this.mArguments != null) {
                this.mArguments.setClassLoader(context.getClassLoader());
            }
            this.JZ = Fragment.instantiate(context, this.JY, this.mArguments);
            if (this.mSavedFragmentState != null) {
                this.mSavedFragmentState.setClassLoader(context.getClassLoader());
                this.JZ.mSavedFragmentState = this.mSavedFragmentState;
            }
            this.JZ.setIndex(this.mIndex, fragment);
            this.JZ.mFromLayout = this.mFromLayout;
            this.JZ.mRestored = true;
            this.JZ.mFragmentId = this.mFragmentId;
            this.JZ.mContainerId = this.mContainerId;
            this.JZ.mTag = this.mTag;
            this.JZ.mRetainInstance = this.mRetainInstance;
            this.JZ.mDetached = this.mDetached;
            this.JZ.mHidden = this.mHidden;
            this.JZ.mFragmentManager = ezVar.mFragmentManager;
            if (fb.DEBUG) {
                Log.v("FragmentManager", "Instantiated fragment " + this.JZ);
            }
        }
        this.JZ.mChildNonConfig = fcVar;
        return this.JZ;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.JY);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mFromLayout ? 1 : 0);
        parcel.writeInt(this.mFragmentId);
        parcel.writeInt(this.mContainerId);
        parcel.writeString(this.mTag);
        if (this.mRetainInstance) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.mDetached) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.mArguments);
        if (!this.mHidden) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeBundle(this.mSavedFragmentState);
    }
}
