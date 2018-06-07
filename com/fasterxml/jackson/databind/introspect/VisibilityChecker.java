package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public interface VisibilityChecker<T extends VisibilityChecker<T>> {

    @JsonAutoDetect(yN = Visibility.PUBLIC_ONLY, yO = Visibility.PUBLIC_ONLY, yP = Visibility.ANY, yQ = Visibility.ANY, yR = Visibility.PUBLIC_ONLY)
    public static class Std implements VisibilityChecker<Std>, Serializable {
        protected static final Std DEFAULT = new Std((JsonAutoDetect) Std.class.getAnnotation(JsonAutoDetect.class));
        private static final long serialVersionUID = 1;
        protected final Visibility _creatorMinLevel;
        protected final Visibility _fieldMinLevel;
        protected final Visibility _getterMinLevel;
        protected final Visibility _isGetterMinLevel;
        protected final Visibility _setterMinLevel;

        public static Std defaultInstance() {
            return DEFAULT;
        }

        public Std(JsonAutoDetect jsonAutoDetect) {
            this._getterMinLevel = jsonAutoDetect.yN();
            this._isGetterMinLevel = jsonAutoDetect.yO();
            this._setterMinLevel = jsonAutoDetect.yP();
            this._creatorMinLevel = jsonAutoDetect.yQ();
            this._fieldMinLevel = jsonAutoDetect.yR();
        }

        public Std(Visibility visibility, Visibility visibility2, Visibility visibility3, Visibility visibility4, Visibility visibility5) {
            this._getterMinLevel = visibility;
            this._isGetterMinLevel = visibility2;
            this._setterMinLevel = visibility3;
            this._creatorMinLevel = visibility4;
            this._fieldMinLevel = visibility5;
        }

        public Std(Visibility visibility) {
            if (visibility == Visibility.DEFAULT) {
                this._getterMinLevel = DEFAULT._getterMinLevel;
                this._isGetterMinLevel = DEFAULT._isGetterMinLevel;
                this._setterMinLevel = DEFAULT._setterMinLevel;
                this._creatorMinLevel = DEFAULT._creatorMinLevel;
                this._fieldMinLevel = DEFAULT._fieldMinLevel;
                return;
            }
            this._getterMinLevel = visibility;
            this._isGetterMinLevel = visibility;
            this._setterMinLevel = visibility;
            this._creatorMinLevel = visibility;
            this._fieldMinLevel = visibility;
        }

        public Std with(JsonAutoDetect jsonAutoDetect) {
            if (jsonAutoDetect != null) {
                return withGetterVisibility(jsonAutoDetect.yN()).withIsGetterVisibility(jsonAutoDetect.yO()).withSetterVisibility(jsonAutoDetect.yP()).withCreatorVisibility(jsonAutoDetect.yQ()).withFieldVisibility(jsonAutoDetect.yR());
            }
            return this;
        }

        public Std with(Visibility visibility) {
            if (visibility == Visibility.DEFAULT) {
                return DEFAULT;
            }
            return new Std(visibility);
        }

        public Std withVisibility(PropertyAccessor propertyAccessor, Visibility visibility) {
            switch (propertyAccessor) {
                case GETTER:
                    return withGetterVisibility(visibility);
                case SETTER:
                    return withSetterVisibility(visibility);
                case CREATOR:
                    return withCreatorVisibility(visibility);
                case FIELD:
                    return withFieldVisibility(visibility);
                case IS_GETTER:
                    return withIsGetterVisibility(visibility);
                case ALL:
                    return with(visibility);
                default:
                    return this;
            }
        }

        public Std withGetterVisibility(Visibility visibility) {
            Visibility visibility2;
            if (visibility == Visibility.DEFAULT) {
                visibility2 = DEFAULT._getterMinLevel;
            } else {
                visibility2 = visibility;
            }
            return this._getterMinLevel == visibility2 ? this : new Std(visibility2, this._isGetterMinLevel, this._setterMinLevel, this._creatorMinLevel, this._fieldMinLevel);
        }

        public Std withIsGetterVisibility(Visibility visibility) {
            Visibility visibility2;
            if (visibility == Visibility.DEFAULT) {
                visibility2 = DEFAULT._isGetterMinLevel;
            } else {
                visibility2 = visibility;
            }
            return this._isGetterMinLevel == visibility2 ? this : new Std(this._getterMinLevel, visibility2, this._setterMinLevel, this._creatorMinLevel, this._fieldMinLevel);
        }

        public Std withSetterVisibility(Visibility visibility) {
            Visibility visibility2;
            if (visibility == Visibility.DEFAULT) {
                visibility2 = DEFAULT._setterMinLevel;
            } else {
                visibility2 = visibility;
            }
            return this._setterMinLevel == visibility2 ? this : new Std(this._getterMinLevel, this._isGetterMinLevel, visibility2, this._creatorMinLevel, this._fieldMinLevel);
        }

        public Std withCreatorVisibility(Visibility visibility) {
            Visibility visibility2;
            if (visibility == Visibility.DEFAULT) {
                visibility2 = DEFAULT._creatorMinLevel;
            } else {
                visibility2 = visibility;
            }
            return this._creatorMinLevel == visibility2 ? this : new Std(this._getterMinLevel, this._isGetterMinLevel, this._setterMinLevel, visibility2, this._fieldMinLevel);
        }

        public Std withFieldVisibility(Visibility visibility) {
            Visibility visibility2;
            if (visibility == Visibility.DEFAULT) {
                visibility2 = DEFAULT._fieldMinLevel;
            } else {
                visibility2 = visibility;
            }
            return this._fieldMinLevel == visibility2 ? this : new Std(this._getterMinLevel, this._isGetterMinLevel, this._setterMinLevel, this._creatorMinLevel, visibility2);
        }

        public boolean isCreatorVisible(Member member) {
            return this._creatorMinLevel.isVisible(member);
        }

        public boolean isCreatorVisible(AnnotatedMember annotatedMember) {
            return isCreatorVisible(annotatedMember.getMember());
        }

        public boolean isFieldVisible(Field field) {
            return this._fieldMinLevel.isVisible(field);
        }

        public boolean isFieldVisible(AnnotatedField annotatedField) {
            return isFieldVisible(annotatedField.getAnnotated());
        }

        public boolean isGetterVisible(Method method) {
            return this._getterMinLevel.isVisible(method);
        }

        public boolean isGetterVisible(AnnotatedMethod annotatedMethod) {
            return isGetterVisible(annotatedMethod.getAnnotated());
        }

        public boolean isIsGetterVisible(Method method) {
            return this._isGetterMinLevel.isVisible(method);
        }

        public boolean isIsGetterVisible(AnnotatedMethod annotatedMethod) {
            return isIsGetterVisible(annotatedMethod.getAnnotated());
        }

        public boolean isSetterVisible(Method method) {
            return this._setterMinLevel.isVisible(method);
        }

        public boolean isSetterVisible(AnnotatedMethod annotatedMethod) {
            return isSetterVisible(annotatedMethod.getAnnotated());
        }

        public String toString() {
            return "[Visibility:" + " getter: " + this._getterMinLevel + ", isGetter: " + this._isGetterMinLevel + ", setter: " + this._setterMinLevel + ", creator: " + this._creatorMinLevel + ", field: " + this._fieldMinLevel + "]";
        }
    }

    boolean isCreatorVisible(AnnotatedMember annotatedMember);

    boolean isFieldVisible(AnnotatedField annotatedField);

    boolean isGetterVisible(AnnotatedMethod annotatedMethod);

    boolean isIsGetterVisible(AnnotatedMethod annotatedMethod);

    boolean isSetterVisible(AnnotatedMethod annotatedMethod);

    T with(JsonAutoDetect jsonAutoDetect);

    T withCreatorVisibility(Visibility visibility);

    T withFieldVisibility(Visibility visibility);

    T withGetterVisibility(Visibility visibility);

    T withIsGetterVisibility(Visibility visibility);

    T withSetterVisibility(Visibility visibility);

    T withVisibility(PropertyAccessor propertyAccessor, Visibility visibility);
}
