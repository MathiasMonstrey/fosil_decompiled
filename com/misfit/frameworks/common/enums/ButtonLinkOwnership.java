package com.misfit.frameworks.common.enums;

public enum ButtonLinkOwnership {
    ButtonLinkOwnershipUnknown(-1),
    ButtonLinkOwnershipNoLinking(0),
    ButtonLinkOwnershipLinkingOnlyOwnerAccount(1),
    ButtonLinkOwnershipLinkingManyAccount(2);
    
    private int value;

    public int getValue() {
        return this.value;
    }

    public static ButtonLinkOwnership fromInt(int i) {
        for (ButtonLinkOwnership buttonLinkOwnership : values()) {
            if (buttonLinkOwnership.getValue() == i) {
                return buttonLinkOwnership;
            }
        }
        return null;
    }

    private ButtonLinkOwnership(int i) {
        this.value = i;
    }
}
