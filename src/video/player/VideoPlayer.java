/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package video.player;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import uk.co.caprica.vlcj.media.callback.CallbackMedia;
import uk.co.caprica.vlcj.media.callback.nonseekable.FileInputStreamMedia;

/**
 *
 * @author santi
 */
public class VideoPlayer {


    private final JFrame frame;

    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;
    
    
    private final JButton pauseButton;

    private final JButton rewindButton;

    private final JButton skipButton;

    public VideoPlayer(String[] args) {

        frame = new JFrame("My First Media Player");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mediaPlayerComponent.release();
                System.exit(0);
            }
        });

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        contentPane.add(mediaPlayerComponent, BorderLayout.CENTER);

        JPanel controlsPane = new JPanel();

        pauseButton = new JButton("Pause");
        controlsPane.add(pauseButton);

        rewindButton = new JButton("Rewind");
        controlsPane.add(rewindButton);

        skipButton = new JButton("Skip");
        controlsPane.add(skipButton);

        contentPane.add(controlsPane, BorderLayout.SOUTH);

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.mediaPlayer().controls().pause();
            }
        });

        rewindButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.mediaPlayer().controls().skipPosition(-10000);
            }
        });

        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.mediaPlayer().controls().skipPosition(10000);
            }
        });

        frame.setContentPane(contentPane);
        
        frame.setVisible(true);
        
        CallbackMedia media = new FileInputStreamMedia(new File("C:\\Users\\santi\\Downloads\\file_example_MP4_480_1_5MG.mp4"));

        mediaPlayerComponent.mediaPlayer().media().play(media);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Iniciando prueba VLCJ...");

        new VideoPlayer(args);
    }

}
