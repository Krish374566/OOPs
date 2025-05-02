abstract class S {
    abstract double calculateVolume();
}

class C extends S { // Cuboid
    double length, width, height;

    C(double l, double w, double h) {
        this.length = l;
        this.width = w;
        this.height = h;
    }

    double calculateVolume() {
        return length * width * height;
    }
}

class Sp extends S { // Sphere
    double radius;

    Sp(double r) {
        this.radius = r;
    }

    double calculateVolume() {
        return (4.0 / 3) * Math.PI * Math.pow(radius, 3);
    }
}

public class SolidTest {
    public static void main(String[] args) {
        S cuboid = new C(5, 3, 2);
        S sphere = new Sp(4);

        System.out.println("Cuboid Volume: " + cuboid.calculateVolume());
        System.out.println("Sphere Volume: " + sphere.calculateVolume());
    }
}
