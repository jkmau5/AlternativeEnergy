package jkmau5.alternativeenergy.world.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import jkmau5.alternativeenergy.AlternativeEnergy;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import java.util.List;

/**
 * Author: Lordmau5
 * Date: 26.10.13
 * Time: 12:32
 * You are allowed to change this code,
 * however, not to publish it without my permission.
 */
public class ItemUpgrade extends Item {

    @SideOnly(Side.CLIENT)
    private Icon[] icons;

    public ItemUpgrade(int par1) {
        super(par1);
        setUnlocalizedName("altEng.upgrade");
        setCreativeTab(AlternativeEnergy.tabPowerBox);
        setMaxStackSize(16);
        setHasSubtypes(true);
    }

    private String[] upgradeNames = {"capacity", "outputSpeed"};

    @Override
    public String getUnlocalizedName(ItemStack itemStack){
        return "item.altEng.upgrade." + upgradeNames[itemStack.getItemDamage()];
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister iR)
    {
        icons = new Icon[2];
        for(int i = 0; i < icons.length; i++)
        {
            icons[i] = iR.registerIcon(AlternativeEnergy.modid + ":" + this.getUnlocalizedName().substring(5) + "_" + upgradeNames[i]);
        }
    }

    public Icon getIconFromDamage(int par1)
    {
        return icons[par1];
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int x = 0; x < icons.length; x++)
        {
            par3List.add(new ItemStack(this, 1, x));
        }
    }
}