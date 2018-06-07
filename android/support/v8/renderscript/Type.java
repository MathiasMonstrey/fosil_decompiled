package android.support.v8.renderscript;

public class Type extends BaseObj {
    boolean mDimFaces;
    boolean mDimMipmaps;
    int mDimX;
    int mDimY;
    int mDimYuv;
    int mDimZ;
    Element mElement;
    int mElementCount;

    public static class Builder {
        boolean mDimFaces;
        boolean mDimMipmaps;
        int mDimX = 1;
        int mDimY;
        int mDimZ;
        Element mElement;
        RenderScript mRS;
        int mYuv;

        public Builder(RenderScript renderScript, Element element) {
            element.checkValid();
            this.mRS = renderScript;
            this.mElement = element;
        }

        public Builder setX(int i) {
            if (i < 1) {
                throw new RSIllegalArgumentException("Values of less than 1 for Dimension X are not valid.");
            }
            this.mDimX = i;
            return this;
        }

        public Builder setY(int i) {
            if (i < 1) {
                throw new RSIllegalArgumentException("Values of less than 1 for Dimension Y are not valid.");
            }
            this.mDimY = i;
            return this;
        }

        public Builder setZ(int i) {
            if (i < 1) {
                throw new RSIllegalArgumentException("Values of less than 1 for Dimension Z are not valid.");
            }
            this.mDimZ = i;
            return this;
        }

        public Builder setMipmaps(boolean z) {
            this.mDimMipmaps = z;
            return this;
        }

        public Builder setFaces(boolean z) {
            this.mDimFaces = z;
            return this;
        }

        public Builder setYuvFormat(int i) {
            switch (i) {
                case 17:
                case 842094169:
                    this.mYuv = i;
                    return this;
                default:
                    throw new RSIllegalArgumentException("Only NV21 and YV12 are supported..");
            }
        }

        public Type create() {
            if (this.mDimZ > 0) {
                if (this.mDimX < 1 || this.mDimY < 1) {
                    throw new RSInvalidStateException("Both X and Y dimension required when Z is present.");
                } else if (this.mDimFaces) {
                    throw new RSInvalidStateException("Cube maps not supported with 3D types.");
                }
            }
            if (this.mDimY > 0 && this.mDimX < 1) {
                throw new RSInvalidStateException("X dimension required when Y is present.");
            } else if (this.mDimFaces && this.mDimY < 1) {
                throw new RSInvalidStateException("Cube maps require 2D Types.");
            } else if (this.mYuv == 0 || !(this.mDimZ != 0 || this.mDimFaces || this.mDimMipmaps)) {
                Type type = new Type(this.mRS.nTypeCreate(this.mElement.getID(this.mRS), this.mDimX, this.mDimY, this.mDimZ, this.mDimMipmaps, this.mDimFaces, this.mYuv), this.mRS);
                type.mElement = this.mElement;
                type.mDimX = this.mDimX;
                type.mDimY = this.mDimY;
                type.mDimZ = this.mDimZ;
                type.mDimMipmaps = this.mDimMipmaps;
                type.mDimFaces = this.mDimFaces;
                type.mDimYuv = this.mYuv;
                type.calcElementCount();
                return type;
            } else {
                throw new RSInvalidStateException("YUV only supports basic 2D.");
            }
        }
    }

    public enum CubemapFace {
        POSITIVE_X(0),
        NEGATIVE_X(1),
        POSITIVE_Y(2),
        NEGATIVE_Y(3),
        POSITIVE_Z(4),
        NEGATIVE_Z(5);
        
        int mID;

        private CubemapFace(int i) {
            this.mID = i;
        }
    }

    public Element getElement() {
        return this.mElement;
    }

    public int getX() {
        return this.mDimX;
    }

    public int getY() {
        return this.mDimY;
    }

    public int getZ() {
        return this.mDimZ;
    }

    public int getYuv() {
        return this.mDimYuv;
    }

    public boolean hasMipmaps() {
        return this.mDimMipmaps;
    }

    public boolean hasFaces() {
        return this.mDimFaces;
    }

    public int getCount() {
        return this.mElementCount;
    }

    void calcElementCount() {
        int i;
        boolean hasMipmaps = hasMipmaps();
        int x = getX();
        int y = getY();
        int z = getZ();
        if (hasFaces()) {
            i = 6;
        } else {
            i = 1;
        }
        if (x == 0) {
            x = 1;
        }
        if (y == 0) {
            y = 1;
        }
        if (z == 0) {
            z = 1;
        }
        int i2 = ((x * y) * z) * i;
        int i3 = y;
        y = x;
        x = i2;
        while (hasMipmaps && (y > 1 || i3 > 1 || z > 1)) {
            if (y > 1) {
                y >>= 1;
            }
            if (i3 > 1) {
                i3 >>= 1;
            }
            if (z > 1) {
                z >>= 1;
            }
            x += ((y * i3) * z) * i;
        }
        this.mElementCount = x;
    }

    Type(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    public long getDummyType(RenderScript renderScript, long j) {
        return renderScript.nIncTypeCreate(j, this.mDimX, this.mDimY, this.mDimZ, this.mDimMipmaps, this.mDimFaces, this.mDimYuv);
    }

    public static Type createX(RenderScript renderScript, Element element, int i) {
        if (i < 1) {
            throw new RSInvalidStateException("Dimension must be >= 1.");
        }
        Type type = new Type(renderScript.nTypeCreate(element.getID(renderScript), i, 0, 0, false, false, 0), renderScript);
        type.mElement = element;
        type.mDimX = i;
        type.calcElementCount();
        return type;
    }

    public static Type createXY(RenderScript renderScript, Element element, int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new RSInvalidStateException("Dimension must be >= 1.");
        }
        Type type = new Type(renderScript.nTypeCreate(element.getID(renderScript), i, i2, 0, false, false, 0), renderScript);
        type.mElement = element;
        type.mDimX = i;
        type.mDimY = i2;
        type.calcElementCount();
        return type;
    }

    public static Type createXYZ(RenderScript renderScript, Element element, int i, int i2, int i3) {
        if (i < 1 || i2 < 1 || i3 < 1) {
            throw new RSInvalidStateException("Dimension must be >= 1.");
        }
        Type type = new Type(renderScript.nTypeCreate(element.getID(renderScript), i, i2, i3, false, false, 0), renderScript);
        type.mElement = element;
        type.mDimX = i;
        type.mDimY = i2;
        type.mDimZ = i3;
        type.calcElementCount();
        return type;
    }
}
