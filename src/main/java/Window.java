
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sound.sampled.*;

public class Window extends JFrame implements ActionListener {

    public static Mixer.Info selectedInput = AudioSystem.getMixerInfo()[8];
    private static HashMap<String,Mixer.Info> micsMap;

    private static JComboBox select;

    Update updateVar;
    
    public Window(Update updateVar){

        this.updateVar = updateVar;

        this.setTitle("Audio Listener");
        this.setSize(500,500);
        this.setLayout(new FlowLayout());
        this.getContentPane().setBackground(new Color(53, 55, 92));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        micsMap = new HashMap<String,Mixer.Info>();
        ArrayList<String> mics = new ArrayList<String>();

        for(Mixer.Info m : AudioSystem.getMixerInfo()){
            if(AudioSystem.getMixer(m).isLineSupported(Port.Info.LINE_IN)){
                mics.add(m.getName());
                micsMap.put(m.getName(),m);
            }
        }

        select = new JComboBox(mics.toArray());
        select.addActionListener(this);


        this.add(select);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == select){
            selectedInput = micsMap.get(select.getSelectedItem());

            updateVar.update(AudioSystem.getMixer(selectedInput));
        }
    }



}
