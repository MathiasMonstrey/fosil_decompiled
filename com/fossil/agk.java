package com.fossil;

public abstract class agk {
    public abstract agk containedType(int i);

    public abstract int containedTypeCount();

    public abstract String containedTypeName(int i);

    public abstract agk getContentType();

    public abstract agk getKeyType();

    public abstract Class<?> getRawClass();

    public abstract agk getReferencedType();

    public abstract boolean hasGenericTypes();

    public abstract boolean hasRawClass(Class<?> cls);

    public abstract boolean isAbstract();

    public abstract boolean isArrayType();

    public abstract boolean isCollectionLikeType();

    public abstract boolean isConcrete();

    public abstract boolean isContainerType();

    public abstract boolean isEnumType();

    public abstract boolean isFinal();

    public abstract boolean isInterface();

    public abstract boolean isMapLikeType();

    public abstract boolean isPrimitive();

    public abstract boolean isThrowable();

    public abstract String toCanonical();

    public boolean isReferenceType() {
        return getReferencedType() != null;
    }

    public Class<?> getParameterSource() {
        return null;
    }
}
