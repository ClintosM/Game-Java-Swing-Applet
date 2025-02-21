package Containers;

public class Vector {
    private float x;
    private float y;

     public Vector(float x, float y) {
        this.x = x;
        this.y = y;
     }

    public float getNormalisedX(Vector vector) {
        float xDiff = vector.x - this.x;
        return xDiff /  signedDistance(vector);
    }

    public float getNormalisedY(Vector vector) {
        float yDiff = vector.y - this.y;
        return yDiff / signedDistance(vector);
    }

     public float absoluteDistance(Vector vector) {
         float xDiff = Math.abs(this.x - vector.x);
         float yDiff = Math.abs(this.y - vector.y);
         float aSquared = xDiff * xDiff;
         float bSquared = yDiff * yDiff;

         // C Squared = Sqrt of A squared + B squared.
         return ((float) Math.sqrt(aSquared + bSquared));
     }

    public float signedDistance(Vector vector) {
        float xDiff = this.x - vector.x;
        float yDiff = this.y - vector.y;
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
