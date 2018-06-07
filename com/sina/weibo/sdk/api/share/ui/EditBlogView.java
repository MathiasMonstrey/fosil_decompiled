package com.sina.weibo.sdk.api.share.ui;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

public class EditBlogView extends EditText {
    private Context dqc;
    private List<C5050b> dqd;
    private C5049a dqe;
    private boolean dqf = true;

    public interface C5049a {
        void awx();
    }

    public interface C5050b {
        void onSelectionChanged(int i, int i2);
    }

    public EditBlogView(Context context) {
        super(context);
        init();
    }

    public EditBlogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public EditBlogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.dqc = getContext();
        this.dqd = new ArrayList();
    }

    public void setOnSelectionListener(C5050b c5050b) {
        this.dqd.add(c5050b);
    }

    protected void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        if (this.dqf && this.dqd != null && !this.dqd.isEmpty()) {
            for (C5050b onSelectionChanged : this.dqd) {
                onSelectionChanged.onSelectionChanged(i, i2);
            }
        }
    }

    public void setOnEnterListener(C5049a c5049a) {
        this.dqe = c5049a;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 66 && this.dqe != null) {
            this.dqe.awx();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public int mt(int i) {
        if (i == -1) {
            return i;
        }
        Editable text = getText();
        if (i >= text.length()) {
            return i;
        }
        Object[] spans = text.getSpans(i, i, ImageSpan.class);
        if (spans == null || spans.length == 0 || i == text.getSpanStart(spans[0])) {
            return i;
        }
        return text.getSpanEnd(spans[0]);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new InputConnectionWrapper(this, super.onCreateInputConnection(editorInfo), false) {
            final /* synthetic */ EditBlogView dqg;

            public boolean commitText(CharSequence charSequence, int i) {
                Object editableText = this.dqg.getEditableText();
                String str = new String(editableText.toString());
                int selectionStart = Selection.getSelectionStart(editableText);
                int selectionEnd = Selection.getSelectionEnd(editableText);
                if (!(selectionStart == -1 || selectionEnd == -1)) {
                    int mt = this.dqg.mt(selectionStart);
                    int mt2 = this.dqg.mt(selectionEnd);
                    if (mt <= mt2) {
                        int i2 = mt2;
                        mt2 = mt;
                        mt = i2;
                    }
                    if (!(mt2 == selectionStart && mt == selectionEnd)) {
                        Selection.setSelection(editableText, mt2, mt);
                    }
                    if (mt2 != mt) {
                        this.dqg.getText().delete(mt2, mt);
                    }
                }
                return super.commitText(charSequence, i);
            }

            public boolean setComposingText(CharSequence charSequence, int i) {
                Object editableText = this.dqg.getEditableText();
                String str = new String(editableText.toString());
                int selectionStart = Selection.getSelectionStart(editableText);
                int selectionEnd = Selection.getSelectionEnd(editableText);
                if (!(selectionStart == -1 || selectionEnd == -1)) {
                    int mt = this.dqg.mt(selectionStart);
                    int mt2 = this.dqg.mt(selectionEnd);
                    if (mt <= mt2) {
                        int i2 = mt2;
                        mt2 = mt;
                        mt = i2;
                    }
                    if (!(mt2 == selectionStart && mt == selectionEnd)) {
                        Selection.setSelection(editableText, mt2, mt);
                    }
                    if (mt2 != mt) {
                        this.dqg.getText().delete(mt2, mt);
                    }
                }
                return super.setComposingText(charSequence, i);
            }
        };
    }
}
