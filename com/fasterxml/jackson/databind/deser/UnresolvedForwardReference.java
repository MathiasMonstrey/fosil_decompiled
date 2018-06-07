package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.aid;
import com.fossil.ail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class UnresolvedForwardReference extends JsonMappingException {
    private static final long serialVersionUID = 1;
    private ail _roid;
    private List<aid> _unresolvedIds;

    public UnresolvedForwardReference(String str, JsonLocation jsonLocation, ail com_fossil_ail) {
        super(str, jsonLocation);
        this._roid = com_fossil_ail;
    }

    public UnresolvedForwardReference(String str) {
        super(str);
        this._unresolvedIds = new ArrayList();
    }

    public ail getRoid() {
        return this._roid;
    }

    public Object getUnresolvedId() {
        return this._roid.EK().key;
    }

    public void addUnresolvedId(Object obj, Class<?> cls, JsonLocation jsonLocation) {
        this._unresolvedIds.add(new aid(obj, cls, jsonLocation));
    }

    public List<aid> getUnresolvedIds() {
        return this._unresolvedIds;
    }

    public String getMessage() {
        String message = super.getMessage();
        if (this._unresolvedIds == null) {
            return message;
        }
        StringBuilder stringBuilder = new StringBuilder(message);
        Iterator it = this._unresolvedIds.iterator();
        while (it.hasNext()) {
            stringBuilder.append(((aid) it.next()).toString());
            if (it.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append('.');
        return stringBuilder.toString();
    }
}
