package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminHome {
    private static JFrame frame;
    private static String jwt;

    public AdminHome(String jwt) {
        this.jwt = jwt;
        frame = new JFrame("Admin Panel - Home");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel welcomeLabel = new JLabel("Bine ai venit! Sunteți logat ca și administrator.");
        welcomeLabel.setBounds(10, 20, 300, 25);
        panel.add(welcomeLabel);

        JLabel instructionsLabel = new JLabel("Utilizează meniul de navigare pentru a gestiona profesorii, elevii, grupele și orarul.");
        instructionsLabel.setBounds(10, 50, 600, 25);
        panel.add(instructionsLabel);

        JButton manageTeachersButton = new JButton("Gestionează Profesori");
        manageTeachersButton.setBounds(10, 80, 300, 25);
        panel.add(manageTeachersButton);
        manageTeachersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ManageTeachers(jwt).setVisible(true);
            }
        });

        JButton manageStudentsButton = new JButton("Gestionează Studenți");
        manageStudentsButton.setBounds(10, 110, 300, 25);
        panel.add(manageStudentsButton);
        manageStudentsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ManageStudents(jwt).setVisible(true);
            }

        });

        JButton manageClassesButton = new JButton("Gestionează Grupe");
        manageClassesButton.setBounds(10, 140, 300, 25);
        panel.add(manageClassesButton);
        manageClassesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ManageClasses(jwt).setVisible(true);
            }
        });

        JButton manageScheduleButton = new JButton("Gestionează Orarul");
        manageScheduleButton.setBounds(10, 170, 300, 25);
        panel.add(manageScheduleButton);
        manageScheduleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
new ManageSchedule(jwt).setVisible(true);            }
        });

        JButton manageAnnouncementsButton = new JButton("Gestionează Anunțurile");
        manageAnnouncementsButton.setBounds(10, 200, 300, 25);
        panel.add(manageAnnouncementsButton);
        manageAnnouncementsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ManageAnnouncements(jwt).setVisible(true);
            }
        });

        JButton manageCoursesButton = new JButton("Gestionează Cursurile");
        manageCoursesButton.setBounds(10, 230, 300, 25);
        panel.add(manageCoursesButton);
        manageCoursesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ManageCourses(jwt).setVisible(true);
            }
        });

        JButton logoutButton = new JButton("Deloghează-te și închide aplicația!");
        logoutButton.setBounds(10, 510, 300, 25);
        panel.add(logoutButton);
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logica pentru logout
                frame.dispose();
            }
        });
    }
}
