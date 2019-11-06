public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Body(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body ob) {
        double rSquared = Math.pow(xxPos - ob.xxPos, 2) + Math.pow(yyPos - ob.yyPos, 2);
        return Math.sqrt(rSquared);
    }

    public double calcForceExertedBy(Body ob) {
        double G = 6.67e-11;
        return G * mass * ob.mass / Math.pow(calcDistance(ob), 2);
    }

    public double calcForceExertedByX(Body ob) {
        double fEx = calcForceExertedBy(ob) * (xxPos - ob.xxPos);
        if (fEx < 0) fEx = fEx * -1;
        return fEx / calcDistance(ob);

    }

    public double calcForceExertedByY(Body ob) {
        double fEx = calcForceExertedBy(ob) * (yyPos - ob.yyPos);
        if (fEx < 0) fEx = fEx * -1;
        return fEx / calcDistance(ob);
    }

    public double calcNetForceExertedByX(Body[] bodies) {
        double netForce = 0;
        for (Body body : bodies) {
            if (! body.equals(this)) {
                netForce += calcForceExertedByX(body);
            }
        }
        return netForce;
    }

    public double calcNetForceExertedByY(Body[] bodies) {
        double netForce = 0;
        for (Body body : bodies) {
            if (! body.equals(this)) {
                netForce += calcForceExertedByY(body);
            }
        }
        return netForce;
    }
}
