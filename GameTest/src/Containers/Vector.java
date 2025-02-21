package Containers;

public class Vector {
    private float x;
    private float y;

     public Vector(float x, float y) {
        this.x = x;
        this.y = y;
     }

    public float getNormalisedX(Vector vector) {
        float xDiff = this.x - vector.x;
        float absoluteDistance = absoluteDistance(vector);
        return xDiff / absoluteDistance;
    }

    public float getNormalisedY(Vector vector) {
        float yDiff = this.y - vector.y;
        float absoluteDistance = absoluteDistance(vector);
        return yDiff / absoluteDistance;
    }

     public float absoluteDistance(Vector vector) {
         float xDiff = Math.abs(this.x - vector.x);
         float yDiff = Math.abs(this.y - vector.y);
         float aSquared = xDiff * xDiff;
         float bSquared = yDiff * yDiff;

         // C Squared = Sqrt of A squared + B squared.
         return ((float) Math.sqrt(aSquared + bSquared));
     }

     public float getX() {
         return this.x;
     }

    public float getY() {
        return this.y;
    }

    public void setX(float newX) {
         this.x = newX;
    }

    public void setY(float newY) {
        this.y = newY;
    }
}
