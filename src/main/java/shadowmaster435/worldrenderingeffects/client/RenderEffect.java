package shadowmaster435.worldrenderingeffects.client;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.client.world.ClientWorld;

public class RenderEffect {
    public static int effectTime;
    public static int offsetx;
    public static int offsety;
    public static int offsetz;
    public static int scalex;
    public static int scaley;
    public static int scalez;
    public static int rotx;
    public static int roty;
    public static int rotz;
    public static int oscillationspeed = 0;
    private static ClientWorld world;
    public static float Sinefunc() {
        if (oscillationspeed == 0) {
            return 0;
        } else {
            return (float) (Math.sin((world.getTime()) / 8.0) / oscillationspeed);
        }
    }

    public static boolean HasActiveEffect() {
        return effectTime <= 0;
    }
    public static void scale(MatrixStack matrices) {
        matrices.scale(scalex + Sinefunc(), scaley + Sinefunc(), scalez + Sinefunc());
    }
    public static void translate(MatrixStack matrices) {
        matrices.translate(offsetx + Sinefunc(), offsety + Sinefunc(), offsetz + Sinefunc());
    }
    public static void rotate(MatrixStack matrices) {
        matrices.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(((world.getTime()) * (rotx + Sinefunc()))));
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(((world.getTime()) * (roty + Sinefunc()))));
        matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(((world.getTime()) * (rotz + Sinefunc()))));
    }
    public static void reset(MatrixStack matrices) {
        matrices.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(0));
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(0));
        matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(0));
        matrices.translate(0, 0, 0);
        matrices.scale(0, 0, 0);
    }
}
