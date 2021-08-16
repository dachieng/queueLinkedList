import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomersEntering extends JPanel {
    private static LinkedListDeque deque;
    private static JFrame frame;

    public CustomersEntering() {
        deque = new LinkedListDeque();
    }

    public static void main(String[] args) {
        frame = new JFrame("Queue UI For Customers In a Restaurant");
        frame.setSize(700, 400);
        JPanel panel = new CustomersEntering();
        panel.setSize(700, 400);
        JLabel message = new JLabel();
        message.setBounds(140, 120, 300, 30);
        // The button add an item first in the queue
        JButton addFirst = new JButton("addFirst");
        addFirst.setBounds(300, 20, 130, 30);
        addFirst.setBackground(Color.GREEN);
        addFirst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = (String) JOptionPane.showInputDialog(frame, "Enter the customer name");
                deque.addFirst(data);
                frame.repaint();
            }
        });
        frame.add(addFirst);
        // The button add an item first in the queue
        JButton addLast = new JButton("addLast");
        addLast.setBounds(300, 60, 130, 30);
        addLast.setBackground(Color.GREEN);
        addLast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = (String) JOptionPane.showInputDialog(frame, "Enter the customer name");
                deque.addLast(data);
                frame.repaint();
            }
        });
        frame.add(addLast);
        // The button to remove the first in the queue
        JButton removeFirst = new JButton("RemoveFirst");
        removeFirst.setBounds(300, 100, 130, 30);
        removeFirst.setBackground(Color.GREEN);
        removeFirst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (deque.isEmpty()) {
                    message.setText("Empty");
                } else {
                    message.setText("");
                    deque.removeFirst();
                }

                frame.repaint();
            }
        });
        frame.add(removeFirst);

        // The button to remove the last in the queue
        JButton removeLast = new JButton("RemoveLast");
        removeLast.setBounds(300, 140, 130, 30);
        removeLast.setBackground(Color.GREEN);
        removeLast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (deque.isEmpty()) {
                    message.setText("Empty");
                } else {
                    message.setText("");
                    deque.removeLast();
                }
                frame.repaint();
            }
        });
        frame.add(removeLast);
        // The button to show the first element
        JButton first = new JButton("First");
        first.setBounds(300, 180, 130, 30);
        first.setBackground(Color.GREEN);
        first.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (deque.isEmpty()) {
                    message.setText("Empty");
                } else {
                    message.setText(deque.first().data);
                }

                frame.repaint();
            }
        });
        frame.add(first);
        // The button to show the last element
        JButton last = new JButton("Last");
        last.setBounds(300, 220, 130, 30);
        last.setBackground(Color.GREEN);
        last.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (deque.isEmpty()) {
                    message.setText("Empty");
                } else {
                    message.setText(deque.last().data);
                }
                frame.repaint();
            }
        });
        frame.add(last);
        // The button to show if size of queue
        JButton size = new JButton("Size");
        size.setBounds(300, 260, 130, 30);
        size.setBackground(Color.GREEN);
        size.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (deque.isEmpty()) {
                    message.setText("Empty");
                } else {
                    message.setText("Size: " + deque.size());
                }
                frame.repaint();
            }
        });
        frame.add(size);
        // The button to show if the queue is empty
        JButton isEmpty = new JButton("Is Empty");
        isEmpty.setBounds(300, 300, 130, 30);
        isEmpty.setBackground(Color.GREEN);
        isEmpty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (deque.isEmpty()) {
                    message.setText("True");
                } else {
                    message.setText("False");
                }
                frame.repaint();
            }
        });
        frame.add(isEmpty);
        frame.add(message);
        frame.add(panel);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        if (!deque.isEmpty()) {
            int x = 15;
            int y = 15;
            LinkedListDeque.Node temp = deque.first();
            while (temp != null) {
                g.setColor(Color.BLACK);
                g.fillRect(x, y, 40, 60);
                g.drawString(temp.data, x, 90);
                x += 50;
                temp = temp.next;
            }
        }
    }

}
