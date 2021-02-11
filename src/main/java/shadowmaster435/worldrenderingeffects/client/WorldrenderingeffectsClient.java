package shadowmaster435.worldrenderingeffects.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.minecraft.client.options.KeyBinding;
import org.lwjgl.glfw.GLFW;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.LiteralText;

@Environment(EnvType.CLIENT)
public class WorldrenderingeffectsClient implements ClientModInitializer {
    public static int mode = 0;
    @Override
    public void onInitializeClient() {

        KeyBinding binding1 = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.fabric-key-binding-api-v1-testmod.test_keybinding_1", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_0, "key.category.first.test"));
        ClientTickCallback.EVENT.register(client -> {
            while (binding1.wasPressed()) {
                assert client.player != null;
                if (mode == 0) {
                    client.player.sendMessage(new LiteralText("Current Mode: Vertical Squish"), false);
                    mode = 1;
                } else if (mode == 1) {
                    client.player.sendMessage(new LiteralText("Current Mode: Odd Squish"), false);
                    mode = 2;
                } else if (mode == 2) {
                    client.player.sendMessage(new LiteralText("Current Mode: Big Steps"), false);
                    mode = 3;
                } else if (mode == 3) {
                    client.player.sendMessage(new LiteralText("Current Mode: Spinning World"), false);
                    mode = 4;
                } else if (mode == 4) {
                    client.player.sendMessage(new LiteralText("Current Mode: Strech And Squish"), false);
                    mode = 5;
                } else if (mode == 5) {
                    client.player.sendMessage(new LiteralText("Current Mode: Negative Size World"), false);
                    mode = 6;
                } else if (mode == 6) {
                    client.player.sendMessage(new LiteralText("Current Mode: Unbalanced World"), false);
                    mode = 7;
                } else if (mode == 7) {
                    client.player.sendMessage(new LiteralText("Current Mode: X, Y, and Z Rotation"), false);
                    mode = 8;
                }
                else if (mode == 8) {
                    client.player.sendMessage(new LiteralText("Current Mode: None"), false);
                    mode = 0;
                }
            }
        });
    }
}
