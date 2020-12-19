package ru.sberbank.itgod.mechanics;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Vector3 {
    @SerializedName("x")
    private double x;
    @SerializedName("y")
    private double y;
    @SerializedName("z")
    private double z;

    public Vector3() {
    }

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Double distance(Vector3 first, Vector3 second) {
        double squareDistance = (Math.pow(first.x - second.x, 2) + Math.pow(first.y - second.y, 2) +
                Math.pow(first.z - second.z, 2));
        return Math.sqrt(squareDistance);
    }

    private static Vector3 vectorAddition(Vector3 a, Vector3 b) {
        return new Vector3(a.x + b.x, a.y + b.y, a.z + b.z);
    }

    private static Vector3 vectorSubstraction(Vector3 a, Vector3 b) {
        return new Vector3(a.x - b.x, a.y - b.y, a.z - b.z);
    }

    private static Vector3 minusVector(Vector3 a) {
        return new Vector3(-a.x, -a.y, -a.z);
    }

    private static Vector3 vectorMultiplication(Vector3 a, double b) {
        return new Vector3(a.x * b, a.y * b, a.z * b);
    }

    private static Vector3 vectorDivision(Vector3 a, double b) {
        return new Vector3(a.x / b, a.y / b, a.z / b);
    }

    public static Vector3 lerp(Vector3 a, Vector3 b, double t) {
        return vectorAddition(a, vectorMultiplication(vectorSubstraction(b, a), t));
    }

    public static Vector3 normalize(Vector3 a) {
        return vectorDivision(a, distance(a, new Vector3(0, 0, 0)));
    }

}
