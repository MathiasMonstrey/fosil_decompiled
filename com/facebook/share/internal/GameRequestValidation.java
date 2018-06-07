package com.facebook.share.internal;

import com.facebook.internal.Validate;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.GameRequestContent.ActionType;

public class GameRequestValidation {
    public static void validate(GameRequestContent gameRequestContent) {
        int i;
        int i2 = 0;
        Validate.notNull(gameRequestContent.getMessage(), "message");
        if (gameRequestContent.getObjectId() != null) {
            i = 1;
        } else {
            i = 0;
        }
        int i3 = (gameRequestContent.getActionType() == ActionType.ASKFOR || gameRequestContent.getActionType() == ActionType.SEND) ? 1 : 0;
        if ((i ^ i3) != 0) {
            throw new IllegalArgumentException("Object id should be provided if and only if action type is send or askfor");
        }
        if (gameRequestContent.getRecipients() != null) {
            i2 = 1;
        }
        if (gameRequestContent.getSuggestions() != null) {
            i2++;
        }
        if (gameRequestContent.getFilters() != null) {
            i2++;
        }
        if (i2 > 1) {
            throw new IllegalArgumentException("Parameters to, filters and suggestions are mutually exclusive");
        }
    }
}
