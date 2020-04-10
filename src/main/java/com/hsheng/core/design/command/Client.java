package com.hsheng.core.design.command;

import javax.swing.*;
import java.awt.event.*;

/**
 * @description 命令模式
 * @author hesheng
 * @date 2020/4/10 8:27
 * @since TODO
 */
public class Client extends JFrame implements ActionListener {

    private MacroCommand history = new MacroCommand();

    private DrawCanvas canvas = new DrawCanvas(400, 400, history);

    private JButton clearButton = new JButton(" clear");

    public Client(String title) {
        super(title);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //使用适配器匿名内部类->编译后的class文件"主类名$编号.class"(Client$1.class)
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Command command = new DrawCommand(canvas, e.getPoint());
                history.append(command);
                command.execute();
            }
        });
        clearButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        show();
    }

    public static void main(String[] args) {
        new Client("Command Sample");
    }

    //ActionListener接口中的方法
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            history.clear();
            canvas.repaint();
        }
    }
}
