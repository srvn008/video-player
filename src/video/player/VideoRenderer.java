/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package video.player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/**
 *
 * @author santi
 */
public class VideoRenderer extends JPanel
        implements ListCellRenderer<VideoItem> {

    private final JLabel labelImagen =
            new JLabel();

    private final JLabel labelTexto =
            new JLabel();

    public VideoRenderer() {

        setLayout(new BorderLayout(10, 10));

        add(labelImagen, BorderLayout.WEST);
        add(labelTexto, BorderLayout.CENTER);

    }

    @Override
    public Component getListCellRendererComponent(
            JList<? extends VideoItem> list,
            VideoItem value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {

        labelTexto.setText(value.getNombre());

        labelImagen.setIcon(value.getMiniatura());

        if (isSelected) {

            setBackground(Color.GRAY);

        } else {

            setBackground(Color.DARK_GRAY);

        }

        return this;
    }

}