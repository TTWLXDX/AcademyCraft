/**
 * Copyright (c) Lambda Innovation, 2013-2015
 * 本作品版权由Lambda Innovation所有。
 * http://www.li-dev.cn/
 *
 * This project is open-source, and it is distributed under  
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * 本项目是一个开源项目，且遵循GNU通用公共授权协议。
 * 在遵照该协议的情况下，您可以自由传播和修改。
 * http://www.gnu.org/licenses/gpl.html
 */
package cn.academy.energy.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

/**
 * @author WeAthFolD
 *
 */
public class ContainerMatrix extends Container {
	
	public final TileMatrix tile;
	
	public final EntityPlayer player;
	
	public ContainerMatrix(TileMatrix _tile, EntityPlayer _player) {
		tile = _tile;
		player = _player;
		
		initInventory(player.inventory);
	}
	
    private void initInventory(InventoryPlayer inv) {
        this.addSlotToContainer(new Slot(tile, 0, 12, 5));
        this.addSlotToContainer(new Slot(tile, 1, 76, 5));
        this.addSlotToContainer(new Slot(tile, 2, 44, 64));
        this.addSlotToContainer(new Slot(tile, 2, 44, 28));
        
        int STEP = 18;
        
        for(int i = 0; i < 9; ++i) {
            addSlotToContainer(new Slot(inv, i, 8 + i * STEP, 153));
        }
        
        for(int i = 1; i < 4; ++i) {
            for(int j = 0; j < 9; ++j) {
                int slot = (4 - i) * 9 + j;
                addSlotToContainer(new Slot(inv, slot, 8 + j * STEP, 149 - i * STEP));
            }
        }
    }

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return player.getDistanceSq(tile.xCoord + .5, tile.yCoord + .5, tile.zCoord + .5) < 64;
	}

}
