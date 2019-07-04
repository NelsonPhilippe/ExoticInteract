package me.xilidev.exoticinteract.utils;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class WorldUtils {

    private Material idBlock;
    private boolean autorisation;
    private Player pseudo;

    public WorldUtils(){

        autorisation = false;
        idBlock = null;
        pseudo = null;

    }

    public void setPseudo(Player pseudo){

        this.pseudo = pseudo;
    }

    public Player getPseudo(){
        return pseudo;
    }

    public void setAutorisation(boolean autorisation) {
        this.autorisation = autorisation;
    }

    public boolean getAutorisation(){
        return autorisation;
    }

    public void setIdBlock(Material idBlock){
        this.idBlock = idBlock;
    }

    public Material getIdBlock(){
        return idBlock;
    }

    public static Location getAllowRegion(Location location){


        return location;
    }

}
