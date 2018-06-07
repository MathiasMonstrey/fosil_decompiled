package com.fossil;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Contacts;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class uy extends uw<InputStream> {
    private static final UriMatcher aBl = new UriMatcher(-1);

    protected /* synthetic */ Object mo4191b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        return m13857c(uri, contentResolver);
    }

    protected /* synthetic */ void bd(Object obj) throws IOException {
        m13858c((InputStream) obj);
    }

    static {
        aBl.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        aBl.addURI("com.android.contacts", "contacts/lookup/*", 1);
        aBl.addURI("com.android.contacts", "contacts/#/photo", 2);
        aBl.addURI("com.android.contacts", "contacts/#", 3);
        aBl.addURI("com.android.contacts", "contacts/#/display_photo", 4);
    }

    public uy(Context context, Uri uri) {
        super(context, uri);
    }

    protected InputStream m13857c(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        return m13855a(uri, contentResolver, aBl.match(uri));
    }

    protected void m13858c(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    private InputStream m13855a(Uri uri, ContentResolver contentResolver, int i) throws FileNotFoundException {
        switch (i) {
            case 1:
            case 3:
                if (i == 1) {
                    uri = Contacts.lookupContact(contentResolver, uri);
                    if (uri == null) {
                        throw new FileNotFoundException("Contact cannot be found");
                    }
                }
                return openContactPhotoInputStream(contentResolver, uri);
            default:
                return contentResolver.openInputStream(uri);
        }
    }

    @TargetApi(14)
    private InputStream openContactPhotoInputStream(ContentResolver contentResolver, Uri uri) {
        if (VERSION.SDK_INT < 14) {
            return Contacts.openContactPhotoInputStream(contentResolver, uri);
        }
        return Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }
}
