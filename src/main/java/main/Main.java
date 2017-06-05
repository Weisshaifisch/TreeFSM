package main;

import treefsm.fsm.FSM;
import treefsm.states.*;
import treefsm.tree.Tree;
import treefsm.tree.TreeStates;

import javax.swing.*;
import java.awt.*;

import static treefsm.states.FSMStates.*;

public class Main {

    private FSM fsm;
    private Tree tree;

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        tree = Tree.getInstance();
        createFSM();

        EventQueue.invokeLater(() ->
                {
                    MainFrame frame = new MainFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setTitle("Tree Finite State Machine");
                    frame.setVisible(true);
                }

        );
    }

    private void createFSM() {
        this.fsm = new FSM();
        fsm.addStates(
                new InitState(INIT),
                new FirstRainyState(FIRST_RAINY),
                new FirstSunnyState(FIRST_SUNNY),
                new RainyGrowState(RAINY_GROW),
                new RainyStasisState(RAINY_STASIS),
                new RainyWitherState(RAINY_WITHER),
                new SunnyGrowState(SUNNY_GROW),
                new SunnyStasisState(SUNNY_STASIS),
                new SunnyWitherState(SUNNY_WITHER)
        );

        fsm.setState(INIT);
    }

    class MainFrame extends JFrame {

        private static final int DEFAULT_WIDTH = 500;
        private static final int DEFAULT_HEIGHT = 200;

        private JPanel windowContent;
        private JLabel dayBeforeYesterdayLabel;
        private JLabel dayBeforeYesterday;
        private JLabel yesterdayLabel;
        private JLabel yesterday;
        private JLabel todayLabel;
        private JLabel today;
        private GridLayout gl;
        private JButton sunnyButton;
        private JButton rainyButton;
        private JLabel treeStatus;
        private ImageIcon imageStasis;
        private ImageIcon imageGrow;
        private ImageIcon imageWither;
        private JLabel imageLabel;
        private JPanel imagePanel;
        private JPanel leftPanel;
        private JPanel rightPanel;

        public MainFrame() throws HeadlessException {
            windowContent = new JPanel();

            leftPanel = new JPanel(new GridLayout(4, 2));
            rightPanel = new JPanel(new BorderLayout());

            windowContent.setLayout(new BorderLayout());

            dayBeforeYesterdayLabel = new JLabel("Day before yesterday: ");
            dayBeforeYesterday = new JLabel("---");
            yesterdayLabel = new JLabel("Yesterday: ");
            yesterday = new JLabel("---");
            todayLabel = new JLabel("Today: ");
            today = new JLabel("---");


            sunnyButton = new JButton("Sunny day");
            sunnyButton.addActionListener(
                    e -> {
                        dayBeforeYesterday.setText(yesterday.getText());
                        yesterday.setText(today.getText());
                        today.setText("Sunny");
                        fsm.processSunnyDay();
                        treeStatus.setText(tree.toString());
                        updateTreeImage(tree.getState());
                    }
            );

            rainyButton = new JButton("Rainy day");
            rainyButton.addActionListener(
                    e -> {
                        dayBeforeYesterday.setText(yesterday.getText());
                        yesterday.setText(today.getText());
                        today.setText("Rainy");
                        fsm.processRainyDay();
                        treeStatus.setText(tree.toString());
                        updateTreeImage(tree.getState());
                    }
            );

            imageStasis = new ImageIcon(getClass().getClassLoader().getResource("image-stasis.png"));
            imageGrow = new ImageIcon(getClass().getClassLoader().getResource("image-grow.png"));
            imageWither = new ImageIcon(getClass().getClassLoader().getResource("image-wither.png"));
            imageLabel = new JLabel();
            updateTreeImage(tree.getState());
            imagePanel = new JPanel(new BorderLayout());
            imagePanel.add(imageLabel, BorderLayout.CENTER);
            treeStatus = new JLabel(tree.toString());


            leftPanel.add(sunnyButton);
            leftPanel.add(rainyButton);
            leftPanel.add(dayBeforeYesterdayLabel);
            leftPanel.add(dayBeforeYesterday);
            leftPanel.add(yesterdayLabel);
            leftPanel.add(yesterday);
            leftPanel.add(todayLabel);
            leftPanel.add(today);

            rightPanel.add(BorderLayout.NORTH, imagePanel);
            rightPanel.add(BorderLayout.SOUTH, treeStatus);

            windowContent.add(BorderLayout.WEST, leftPanel);
            windowContent.add(BorderLayout.EAST, rightPanel);

            setContentPane(windowContent);
            pack();

            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }

        private void updateTreeImage(TreeStates state) {
            switch (state) {
                case GROW:
                    imageLabel.setIcon(imageGrow);
                    break;
                case WITHER:
                    imageLabel.setIcon(imageWither);
                    break;
                default:
                    imageLabel.setIcon(imageStasis);
            }
        }
    }
}


