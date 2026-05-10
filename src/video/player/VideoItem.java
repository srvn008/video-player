/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package video.player;

import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author santi
 */
public class VideoItem {

    private final File archivo;
    private final ImageIcon miniatura;

    public VideoItem(File archivo, ImageIcon miniatura) {

        this.archivo = archivo;
        this.miniatura = miniatura;

    }

    public File getArchivo() {
        return archivo;
    }

    public ImageIcon getMiniatura() {
        return miniatura;
    }

    public String getNombre() {
        return archivo.getName();
    }

    @Override
    public String toString() {
        return getNombre();
    }

}