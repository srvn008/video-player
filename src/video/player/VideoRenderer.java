package video.player;

import java.awt.BorderLayout;

import java.awt.Color;

import java.awt.Component;

import java.awt.Dimension;

import java.awt.Graphics;

import java.awt.Image;

import javax.swing.ImageIcon;

import javax.swing.JLabel;

import javax.swing.JList;

import javax.swing.JPanel;

import javax.swing.ListCellRenderer;

public class VideoRenderer extends JPanel
        implements ListCellRenderer<VideoItem> {

    private static final int COVER_WIDTH = 140;

    private static final int COVER_HEIGHT = 80;

    private final CoverLabel labelImagen = new CoverLabel();

    private final JLabel labelTexto = new JLabel();

    public VideoRenderer() {

        setLayout(new BorderLayout(10, 10));

        labelImagen.setPreferredSize(
                new Dimension(COVER_WIDTH, COVER_HEIGHT)
        );

        labelTexto.setForeground(Color.WHITE);

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

        labelImagen.setImageIcon(value.getMiniatura());

        if (isSelected) {

            setBackground(Color.GRAY);

        } else {

            setBackground(Color.DARK_GRAY);

        }

        labelTexto.setOpaque(false);

        labelImagen.setOpaque(false);

        return this;

    }

    private static class CoverLabel extends JLabel {

        private ImageIcon imageIcon;

        public void setImageIcon(ImageIcon imageIcon) {

            this.imageIcon = imageIcon;

            repaint();

        }

        @Override

        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            if (imageIcon == null) {

                return;

            }

            Image image = imageIcon.getImage();

            int panelWidth = getWidth();

            int panelHeight = getHeight();

            int imageWidth = image.getWidth(null);

            int imageHeight = image.getHeight(null);

            if (imageWidth <= 0 || imageHeight <= 0) {

                return;

            }

            double scale = Math.max(
                    (double) panelWidth / imageWidth,
                    (double) panelHeight / imageHeight
            );

            int scaledWidth = (int) (imageWidth * scale);

            int scaledHeight = (int) (imageHeight * scale);

            int x = (panelWidth - scaledWidth) / 2;

            int y = (panelHeight - scaledHeight) / 2;

            g.drawImage(
                    image,
                    x,
                    y,
                    scaledWidth,
                    scaledHeight,
                    this
            );

        }

    }

}
