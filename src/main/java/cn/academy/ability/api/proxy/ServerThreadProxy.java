package cn.academy.ability.api.proxy;

import net.minecraft.entity.player.EntityPlayer;

public class ServerThreadProxy extends CommonThreadProxy {

    ServerThreadProxy() {
        super("S");
    }

    @Override
    public EntityPlayer getThePlayer() {
        return null;
    }

}
