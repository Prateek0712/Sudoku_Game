/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.sudoku_solver;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import  java.awt.event.*;

/**
 *
 * @author admin
 */
public class SUDOKU_GAME extends javax.swing.JFrame {

    /**
     * Creates new form SUDOKU_GAME
     */
    private String turn="1";
    private boolean solFlag= true;
    private boolean checkMFlag= true;
    private boolean Tflag=true;
    private String[][] ansBoard={
        {"2","9","8","5","1","6","7","3","4"},
        {"4","1","3","2","7","8","5","6","9"},
        {"7","5","6","3","4","9","1","2","8"},
        {"8","2","1","4","3","5","6","9","7"},
        {"5","3","4","6","9","7","2","8","1"},
        {"9","6","7","1","8","2","3","7","6"},
        {"1","4","2","8","5","3","9","7","6"},
        {"3","7","5","9","6","4","8","1","2"},
        {"6","8","9","7","2","1","4","5","3"}
    };
    public void assignClr(JButton btn)
    {
        s1.setBackground(Color.white);
        s2.setBackground(Color.white);
        s3.setBackground(Color.white);
        s4.setBackground(Color.white);
        s5.setBackground(Color.white);
        s6.setBackground(Color.white);
        s7.setBackground(Color.white);
        s8.setBackground(Color.white);
        s9.setBackground(Color.white);
        btn.setBackground(Color.pink);
    }
    public void resetGame()
    {
        JButton pre[]={r0c3,r0c6,r0c7,r0c8,r1c0,r1c4,r1c5,r1c6,r1c8,r2c0,
        r2c2,r2c4,r2c7,r3c4,r3c5,r3c7,r4c1,r4c2,r4c6,r4c7,r5c1,r5c4,r6c1,
        r6c4,r6c6,r6c8,r7c0,r7c3,r7c4,r7c8,r8c0,r8c1,r8c2,r8c5};
        JButton btnArr[][]={
            {r0c0,r0c1,r0c2,r0c3,r0c4,r0c5,r0c6,r0c7,r0c8},
            {r1c0,r1c1,r1c2,r1c3,r1c4,r1c5,r1c6,r1c7,r1c8},
            {r2c0,r2c1,r2c2,r2c3,r2c4,r2c5,r2c6,r2c7,r2c8},
            {r3c0,r3c1,r3c2,r3c3,r3c4,r3c5,r3c6,r3c7,r3c8},
            {r4c0,r4c1,r4c2,r4c3,r4c4,r4c5,r4c6,r4c7,r4c8},
            {r5c0,r5c1,r5c2,r5c3,r5c4,r5c5,r5c6,r5c7,r5c8},
            {r6c0,r6c1,r6c2,r6c3,r6c4,r6c5,r6c6,r6c7,r6c8},
            {r7c0,r7c1,r7c2,r7c3,r7c4,r7c5,r7c6,r7c7,r7c8},
            {r8c0,r8c1,r8c2,r8c3,r8c4,r8c5,r8c6,r8c7,r8c8},
        };
        for(int i=0;i<9;i++)
        {
          for(int j=0;j<9;j++)
          {
              boolean flag=false;
              for(int k=0;k<pre.length;k++)
              {
                  if(pre[k]==btnArr[i][j])
                  {
                      flag=true;
                      break;
                  }
              }
              if(!flag)
              {
                  btnArr[i][j].setText("");
                  btnArr[i][j].setBackground(Color.LIGHT_GRAY);
              }
          }
        }
        jLabel3.setText("");
        time=301;
        Tflag=true;
    }
    public void seeSolution()
    {
        JButton pre[]={r0c3,r0c6,r0c7,r0c8,r1c0,r1c4,r1c5,r1c6,r1c8,r2c0,
        r2c2,r2c4,r2c7,r3c4,r3c5,r3c7,r4c1,r4c2,r4c6,r4c7,r5c1,r5c4,r6c1,
        r6c4,r6c6,r6c8,r7c0,r7c3,r7c4,r7c8,r8c0,r8c1,r8c2,r8c5};
        JButton btnArr[][]={
            {r0c0,r0c1,r0c2,r0c3,r0c4,r0c5,r0c6,r0c7,r0c8},
            {r1c0,r1c1,r1c2,r1c3,r1c4,r1c5,r1c6,r1c7,r1c8},
            {r2c0,r2c1,r2c2,r2c3,r2c4,r2c5,r2c6,r2c7,r2c8},
            {r3c0,r3c1,r3c2,r3c3,r3c4,r3c5,r3c6,r3c7,r3c8},
            {r4c0,r4c1,r4c2,r4c3,r4c4,r4c5,r4c6,r4c7,r4c8},
            {r5c0,r5c1,r5c2,r5c3,r5c4,r5c5,r5c6,r5c7,r5c8},
            {r6c0,r6c1,r6c2,r6c3,r6c4,r6c5,r6c6,r6c7,r6c8},
            {r7c0,r7c1,r7c2,r7c3,r7c4,r7c5,r7c6,r7c7,r7c8},
            {r8c0,r8c1,r8c2,r8c3,r8c4,r8c5,r8c6,r8c7,r8c8},
        };
        if(solFlag)
        {
            solFlag=false;
            SOLUTION_BTN.setText("HIDE");
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    boolean f=true;
                    for(int k=0;k<pre.length;k++)
                    {
                        if(btnArr[i][j]==pre[k])    
                        {
                            f=false;
                            break;
                        }
                    }
                    if(f)
                    {
                       btnArr[i][j].setText(ansBoard[i][j]);
                       btnArr[i][j].setBackground(Color.YELLOW);
                    }
                }
            }
        }
        else
        {
            solFlag=true;
            SOLUTION_BTN.setText("SOLUTION");
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    boolean f=true;
                    for(int k=0;k<pre.length;k++)
                    {
                        if(btnArr[i][j]==pre[k])
                        {
                            f=false;
                            break;
                        }
                    }
                    if(f)
                    {
                       btnArr[i][j].setText("");
                       btnArr[i][j].setBackground(Color.LIGHT_GRAY);
                    }
                }
            }
        }
    }
    public void checkM()
    {
        JButton btnArr[][]={
            {r0c0,r0c1,r0c2,r0c3,r0c4,r0c5,r0c6,r0c7,r0c8},
            {r1c0,r1c1,r1c2,r1c3,r1c4,r1c5,r1c6,r1c7,r1c8},
            {r2c0,r2c1,r2c2,r2c3,r2c4,r2c5,r2c6,r2c7,r2c8},
            {r3c0,r3c1,r3c2,r3c3,r3c4,r3c5,r3c6,r3c7,r3c8},
            {r4c0,r4c1,r4c2,r4c3,r4c4,r4c5,r4c6,r4c7,r4c8},
            {r5c0,r5c1,r5c2,r5c3,r5c4,r5c5,r5c6,r5c7,r5c8},
            {r6c0,r6c1,r6c2,r6c3,r6c4,r6c5,r6c6,r6c7,r6c8},
            {r7c0,r7c1,r7c2,r7c3,r7c4,r7c5,r7c6,r7c7,r7c8},
            {r8c0,r8c1,r8c2,r8c3,r8c4,r8c5,r8c6,r8c7,r8c8},
        };
        if(checkMFlag)
        {
            checkMFlag=false;
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    if(btnArr[i][j].getText().equals("")==false && btnArr[i][j].getText().equals(ansBoard[i][j])==false)
                    {
                        btnArr[i][j].setBackground(Color.DARK_GRAY);
                    }
                }
            }
        }
        else
        {
            checkMFlag=true;
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    if(btnArr[i][j].getText().equals("")==false && btnArr[i][j].getText().equals(ansBoard[i][j])==false)
                    {
                        btnArr[i][j].setBackground(Color.PINK);
                    }
                }
            }
        }
    }
    public boolean checkResult()
    {
        JButton btnArr[][]={
            {r0c0,r0c1,r0c2,r0c3,r0c4,r0c5,r0c6,r0c7,r0c8},
            {r1c0,r1c1,r1c2,r1c3,r1c4,r1c5,r1c6,r1c7,r1c8},
            {r2c0,r2c1,r2c2,r2c3,r2c4,r2c5,r2c6,r2c7,r2c8},
            {r3c0,r3c1,r3c2,r3c3,r3c4,r3c5,r3c6,r3c7,r3c8},
            {r4c0,r4c1,r4c2,r4c3,r4c4,r4c5,r4c6,r4c7,r4c8},
            {r5c0,r5c1,r5c2,r5c3,r5c4,r5c5,r5c6,r5c7,r5c8},
            {r6c0,r6c1,r6c2,r6c3,r6c4,r6c5,r6c6,r6c7,r6c8},
            {r7c0,r7c1,r7c2,r7c3,r7c4,r7c5,r7c6,r7c7,r7c8},
            {r8c0,r8c1,r8c2,r8c3,r8c4,r8c5,r8c6,r8c7,r8c8},
        };
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
               if(btnArr[i][j].getText().equals(ansBoard[i][j])==false)
               {
                   return false;
               }
            }
        }
        return true;
    }
    int time=301;
    Timer T=new Timer(1000,new ActionListener()
    { public void actionPerformed(ActionEvent e)
    {
        time--;
        if(time>=0 && Tflag)
        {
            jLabel2.setText(""+time);
        }
        else if(time==0 && Tflag)
        {
            if(checkResult())
            {
                jLabel3.setText("CONGRATULATION YOU WON..!");
                jLabel3.setForeground(Color.BLUE);
            }
            else
            {
                jLabel3.setText("BETTER LUCK NEXT TIME..!");
                jLabel3.setForeground(Color.RED);
            }
        }
    }
    });
    public SUDOKU_GAME() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        r0c0 = new javax.swing.JButton();
        r0c1 = new javax.swing.JButton();
        r0c2 = new javax.swing.JButton();
        r1c0 = new javax.swing.JButton();
        r1c1 = new javax.swing.JButton();
        r1c2 = new javax.swing.JButton();
        r2c0 = new javax.swing.JButton();
        r2c1 = new javax.swing.JButton();
        r2c2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        r1c3 = new javax.swing.JButton();
        r1c4 = new javax.swing.JButton();
        r0c5 = new javax.swing.JButton();
        r0c4 = new javax.swing.JButton();
        r0c3 = new javax.swing.JButton();
        r1c5 = new javax.swing.JButton();
        r2c3 = new javax.swing.JButton();
        r2c4 = new javax.swing.JButton();
        r2c5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        r0c6 = new javax.swing.JButton();
        r0c7 = new javax.swing.JButton();
        r0c8 = new javax.swing.JButton();
        r1c6 = new javax.swing.JButton();
        r1c7 = new javax.swing.JButton();
        r1c8 = new javax.swing.JButton();
        r2c6 = new javax.swing.JButton();
        r2c7 = new javax.swing.JButton();
        r2c8 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        r3c0 = new javax.swing.JButton();
        r3c2 = new javax.swing.JButton();
        r4c2 = new javax.swing.JButton();
        r3c1 = new javax.swing.JButton();
        r4c0 = new javax.swing.JButton();
        r4c1 = new javax.swing.JButton();
        r5c0 = new javax.swing.JButton();
        r5c1 = new javax.swing.JButton();
        r5c2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        r3c3 = new javax.swing.JButton();
        r4c4 = new javax.swing.JButton();
        r5c4 = new javax.swing.JButton();
        r4c5 = new javax.swing.JButton();
        r3c4 = new javax.swing.JButton();
        r3c5 = new javax.swing.JButton();
        r4c3 = new javax.swing.JButton();
        r5c3 = new javax.swing.JButton();
        r5c5 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        r3c6 = new javax.swing.JButton();
        r3c7 = new javax.swing.JButton();
        r4c6 = new javax.swing.JButton();
        r4c7 = new javax.swing.JButton();
        r5c8 = new javax.swing.JButton();
        r4c8 = new javax.swing.JButton();
        r5c6 = new javax.swing.JButton();
        r3c8 = new javax.swing.JButton();
        r5c7 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        r6c0 = new javax.swing.JButton();
        r8c2 = new javax.swing.JButton();
        r7c1 = new javax.swing.JButton();
        r7c2 = new javax.swing.JButton();
        r8c1 = new javax.swing.JButton();
        r8c0 = new javax.swing.JButton();
        r7c0 = new javax.swing.JButton();
        r6c2 = new javax.swing.JButton();
        r6c1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        r6c3 = new javax.swing.JButton();
        r7c5 = new javax.swing.JButton();
        r8c5 = new javax.swing.JButton();
        r6c5 = new javax.swing.JButton();
        r8c4 = new javax.swing.JButton();
        r6c4 = new javax.swing.JButton();
        r8c3 = new javax.swing.JButton();
        r7c3 = new javax.swing.JButton();
        r7c4 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        r6c6 = new javax.swing.JButton();
        r7c7 = new javax.swing.JButton();
        r7c8 = new javax.swing.JButton();
        r8c8 = new javax.swing.JButton();
        r6c8 = new javax.swing.JButton();
        r8c7 = new javax.swing.JButton();
        r6c7 = new javax.swing.JButton();
        r8c6 = new javax.swing.JButton();
        r7c6 = new javax.swing.JButton();
        RESET_BTN = new javax.swing.JButton();
        SOLUTION_BTN = new javax.swing.JButton();
        CHECK_MOVE_BTN = new javax.swing.JButton();
        s1 = new javax.swing.JButton();
        s2 = new javax.swing.JButton();
        s3 = new javax.swing.JButton();
        s4 = new javax.swing.JButton();
        s5 = new javax.swing.JButton();
        s6 = new javax.swing.JButton();
        s7 = new javax.swing.JButton();
        s8 = new javax.swing.JButton();
        s9 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SUDOKU GAME");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(246, 120, 120));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        r0c0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r0c0ActionPerformed(evt);
            }
        });

        r0c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r0c1ActionPerformed(evt);
            }
        });

        r0c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r0c2ActionPerformed(evt);
            }
        });

        r1c0.setBackground(new java.awt.Color(255, 0, 0));
        r1c0.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r1c0.setText("4");
        r1c0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c0ActionPerformed(evt);
            }
        });

        r1c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c1ActionPerformed(evt);
            }
        });

        r1c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c2ActionPerformed(evt);
            }
        });

        r2c0.setBackground(new java.awt.Color(255, 0, 0));
        r2c0.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r2c0.setText("7");
        r2c0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c0ActionPerformed(evt);
            }
        });

        r2c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c1ActionPerformed(evt);
            }
        });

        r2c2.setBackground(new java.awt.Color(255, 0, 0));
        r2c2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r2c2.setText("6");
        r2c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(r0c0, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r0c1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r0c2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(r1c0, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r1c1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r1c2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(r2c0, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r2c1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r2c2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r0c0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r0c1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r0c2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r1c0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r2c0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        r1c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c3ActionPerformed(evt);
            }
        });

        r1c4.setBackground(new java.awt.Color(255, 0, 0));
        r1c4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r1c4.setText("7");
        r1c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c4ActionPerformed(evt);
            }
        });

        r0c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r0c5ActionPerformed(evt);
            }
        });

        r0c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r0c4ActionPerformed(evt);
            }
        });

        r0c3.setBackground(new java.awt.Color(255, 0, 0));
        r0c3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r0c3.setText("5");
        r0c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r0c3ActionPerformed(evt);
            }
        });

        r1c5.setBackground(new java.awt.Color(255, 0, 0));
        r1c5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r1c5.setText("8");
        r1c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c5ActionPerformed(evt);
            }
        });

        r2c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c3ActionPerformed(evt);
            }
        });

        r2c4.setBackground(new java.awt.Color(255, 0, 0));
        r2c4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r2c4.setText("4");
        r2c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c4ActionPerformed(evt);
            }
        });

        r2c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(r0c3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r0c4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r0c5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(r1c3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r1c4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r1c5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(r2c3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r2c4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r2c5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r0c3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r0c4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r0c5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r1c4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r2c5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        r0c6.setBackground(new java.awt.Color(255, 0, 0));
        r0c6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r0c6.setText("7");
        r0c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r0c6ActionPerformed(evt);
            }
        });

        r0c7.setBackground(new java.awt.Color(255, 0, 0));
        r0c7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r0c7.setText("3");
        r0c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r0c7ActionPerformed(evt);
            }
        });

        r0c8.setBackground(new java.awt.Color(255, 0, 0));
        r0c8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r0c8.setText("4");
        r0c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r0c8ActionPerformed(evt);
            }
        });

        r1c6.setBackground(new java.awt.Color(255, 0, 0));
        r1c6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r1c6.setText("5");
        r1c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c6ActionPerformed(evt);
            }
        });

        r1c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c7ActionPerformed(evt);
            }
        });

        r1c8.setBackground(new java.awt.Color(255, 0, 0));
        r1c8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r1c8.setText("9");
        r1c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c8ActionPerformed(evt);
            }
        });

        r2c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c6ActionPerformed(evt);
            }
        });

        r2c7.setBackground(new java.awt.Color(255, 0, 0));
        r2c7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r2c7.setText("2");
        r2c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c7ActionPerformed(evt);
            }
        });

        r2c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(r0c6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r0c7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r0c8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(r1c6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r1c7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r1c8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(r2c6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r2c7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r2c8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r0c6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r0c7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r0c8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r1c6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r2c6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        r3c0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c0ActionPerformed(evt);
            }
        });

        r3c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c2ActionPerformed(evt);
            }
        });

        r4c2.setBackground(new java.awt.Color(255, 0, 0));
        r4c2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r4c2.setText("4");
        r4c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c2ActionPerformed(evt);
            }
        });

        r3c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c1ActionPerformed(evt);
            }
        });

        r4c0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c0ActionPerformed(evt);
            }
        });

        r4c1.setBackground(new java.awt.Color(255, 0, 0));
        r4c1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r4c1.setText("3");
        r4c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c1ActionPerformed(evt);
            }
        });

        r5c0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c0ActionPerformed(evt);
            }
        });

        r5c1.setBackground(new java.awt.Color(255, 0, 0));
        r5c1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r5c1.setText("6");
        r5c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c1ActionPerformed(evt);
            }
        });

        r5c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(r3c0, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r3c1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r3c2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(r4c0, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r4c1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r4c2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(r5c0, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r5c1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r5c2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r3c0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r4c0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r5c0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        r3c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c3ActionPerformed(evt);
            }
        });

        r4c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c4ActionPerformed(evt);
            }
        });

        r5c4.setBackground(new java.awt.Color(255, 0, 0));
        r5c4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r5c4.setText("8");
        r5c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c4ActionPerformed(evt);
            }
        });

        r4c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c5ActionPerformed(evt);
            }
        });

        r3c4.setBackground(new java.awt.Color(255, 0, 0));
        r3c4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r3c4.setText("3");
        r3c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c4ActionPerformed(evt);
            }
        });

        r3c5.setBackground(new java.awt.Color(255, 0, 0));
        r3c5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r3c5.setText("5");
        r3c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c5ActionPerformed(evt);
            }
        });

        r4c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c3ActionPerformed(evt);
            }
        });

        r5c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c3ActionPerformed(evt);
            }
        });

        r5c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(r5c3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r5c4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r5c5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(r4c3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r4c4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r4c5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(r3c3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r3c4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r3c5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r3c3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r4c3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r5c3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        r3c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c6ActionPerformed(evt);
            }
        });

        r3c7.setBackground(new java.awt.Color(255, 0, 0));
        r3c7.setText("9");
        r3c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c7ActionPerformed(evt);
            }
        });

        r4c6.setBackground(new java.awt.Color(255, 0, 0));
        r4c6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r4c6.setText("2");
        r4c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c6ActionPerformed(evt);
            }
        });

        r4c7.setBackground(new java.awt.Color(255, 0, 0));
        r4c7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r4c7.setText("8");
        r4c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c7ActionPerformed(evt);
            }
        });

        r5c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c8ActionPerformed(evt);
            }
        });

        r4c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c8ActionPerformed(evt);
            }
        });

        r5c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c6ActionPerformed(evt);
            }
        });

        r3c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c8ActionPerformed(evt);
            }
        });

        r5c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(r4c6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r4c7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r4c8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(r5c6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r5c7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r5c8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(r3c6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r3c7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r3c8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r3c6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r4c6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r5c6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        r6c0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c0ActionPerformed(evt);
            }
        });

        r8c2.setBackground(new java.awt.Color(255, 0, 0));
        r8c2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r8c2.setText("9");
        r8c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c2ActionPerformed(evt);
            }
        });

        r7c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c1ActionPerformed(evt);
            }
        });

        r7c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c2ActionPerformed(evt);
            }
        });

        r8c1.setBackground(new java.awt.Color(255, 0, 0));
        r8c1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r8c1.setText("8");
        r8c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c1ActionPerformed(evt);
            }
        });

        r8c0.setBackground(new java.awt.Color(255, 0, 0));
        r8c0.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r8c0.setText("6");
        r8c0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c0ActionPerformed(evt);
            }
        });

        r7c0.setBackground(new java.awt.Color(255, 0, 0));
        r7c0.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r7c0.setText("3");
        r7c0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c0ActionPerformed(evt);
            }
        });

        r6c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c2ActionPerformed(evt);
            }
        });

        r6c1.setBackground(new java.awt.Color(255, 0, 0));
        r6c1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r6c1.setText("4");
        r6c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(r6c0, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r6c1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r6c2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(r8c0, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r8c1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r8c2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(r7c0, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r7c1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r7c2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r6c0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r7c0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r8c1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        r6c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c3ActionPerformed(evt);
            }
        });

        r7c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c5ActionPerformed(evt);
            }
        });

        r8c5.setBackground(new java.awt.Color(255, 0, 0));
        r8c5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r8c5.setText("1");
        r8c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c5ActionPerformed(evt);
            }
        });

        r6c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c5ActionPerformed(evt);
            }
        });

        r8c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c4ActionPerformed(evt);
            }
        });

        r6c4.setBackground(new java.awt.Color(255, 0, 0));
        r6c4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r6c4.setText("5");
        r6c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c4ActionPerformed(evt);
            }
        });

        r8c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c3ActionPerformed(evt);
            }
        });

        r7c3.setBackground(new java.awt.Color(255, 0, 0));
        r7c3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r7c3.setText("9");
        r7c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c3ActionPerformed(evt);
            }
        });

        r7c4.setBackground(new java.awt.Color(255, 0, 0));
        r7c4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r7c4.setText("6");
        r7c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(r6c3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r6c4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r6c5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(r8c3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r8c4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r8c5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(r7c3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r7c4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r7c5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r6c3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r7c3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r8c3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        r6c6.setBackground(new java.awt.Color(255, 0, 0));
        r6c6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r6c6.setText("9");
        r6c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c6ActionPerformed(evt);
            }
        });

        r7c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c7ActionPerformed(evt);
            }
        });

        r7c8.setBackground(new java.awt.Color(255, 0, 0));
        r7c8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r7c8.setText("2");
        r7c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c8ActionPerformed(evt);
            }
        });

        r8c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c8ActionPerformed(evt);
            }
        });

        r6c8.setBackground(new java.awt.Color(255, 0, 0));
        r6c8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        r6c8.setText("6");
        r6c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c8ActionPerformed(evt);
            }
        });

        r8c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c7ActionPerformed(evt);
            }
        });

        r6c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c7ActionPerformed(evt);
            }
        });

        r8c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c6ActionPerformed(evt);
            }
        });

        r7c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(r6c6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r6c7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r6c8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(r7c6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r7c7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r7c8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(r8c6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r8c7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r8c8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r6c6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r7c6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r8c6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        RESET_BTN.setText("RESET");
        RESET_BTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RESET_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RESET_BTNActionPerformed(evt);
            }
        });

        SOLUTION_BTN.setText("SOLUTION");
        SOLUTION_BTN.setToolTipText("");
        SOLUTION_BTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SOLUTION_BTN.setFocusTraversalPolicyProvider(true);
        SOLUTION_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SOLUTION_BTNActionPerformed(evt);
            }
        });

        CHECK_MOVE_BTN.setText("CHECK MOVE");
        CHECK_MOVE_BTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CHECK_MOVE_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHECK_MOVE_BTNActionPerformed(evt);
            }
        });

        s1.setText("1");
        s1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1ActionPerformed(evt);
            }
        });

        s2.setText("2");
        s2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s2ActionPerformed(evt);
            }
        });

        s3.setText("3");
        s3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s3ActionPerformed(evt);
            }
        });

        s4.setText("4");
        s4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s4ActionPerformed(evt);
            }
        });

        s5.setText("5");
        s5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s5ActionPerformed(evt);
            }
        });

        s6.setText("6");
        s6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s6ActionPerformed(evt);
            }
        });

        s7.setText("7");
        s7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s7ActionPerformed(evt);
            }
        });

        s8.setText("8");
        s8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s8ActionPerformed(evt);
            }
        });

        s9.setText("9");
        s9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s9ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("  Timer");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton1.setText("SUBMIT");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RESET_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(s1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(s2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(s3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(56, 56, 56)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(s4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(s5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(s6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(s7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(s8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(s9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(SOLUTION_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(CHECK_MOVE_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(s7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(s1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(s2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(s3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(s4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(s5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(s6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(s9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(s8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SOLUTION_BTN)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RESET_BTN)
                            .addComponent(CHECK_MOVE_BTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SOLUTION_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SOLUTION_BTNActionPerformed
        // TODO add your handling code here:
        seeSolution();
        jLabel3.setText("YOU SEEN THE SOLUTION");
        jLabel3.setForeground(Color.YELLOW);
        Tflag=false;
    }//GEN-LAST:event_SOLUTION_BTNActionPerformed

    private void r0c5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r0c5ActionPerformed
        //TODO add your handling code here:
        r0c5.setText(turn);
        r0c5.setBackground(Color.PINK);
    }//GEN-LAST:event_r0c5ActionPerformed

    private void r1c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1c4ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r1c4ActionPerformed

    private void r0c6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r0c6ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r0c6ActionPerformed

    private void r0c7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r0c7ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r0c7ActionPerformed

    private void r0c8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r0c8ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r0c8ActionPerformed

    private void r1c6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1c6ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r1c6ActionPerformed

    private void r1c7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1c7ActionPerformed
        // TODO add your handling code here:
        r1c7.setText(turn);
        r1c7.setBackground(Color.pink);

    }//GEN-LAST:event_r1c7ActionPerformed

    private void r1c8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1c8ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r1c8ActionPerformed

    private void r2c6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2c6ActionPerformed
        // TODO add your handling code here:
        r2c6.setText(turn);
        r2c6.setBackground(Color.pink);
        
    }//GEN-LAST:event_r2c6ActionPerformed

    private void r2c7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2c7ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r2c7ActionPerformed

    private void r2c8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2c8ActionPerformed
        // TODO add your handling code here:
        r2c8.setText(turn);
        r2c8.setBackground(Color.pink);
    }//GEN-LAST:event_r2c8ActionPerformed

    private void r3c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3c1ActionPerformed
        // TODO add your handling code here:
        r3c1.setText(turn);
        r3c1.setBackground(Color.pink);
    }//GEN-LAST:event_r3c1ActionPerformed

    private void r4c0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4c0ActionPerformed
        // TODO add your handling code here:
        r4c0.setText(turn);
        r4c0.setBackground(Color.pink);
    }//GEN-LAST:event_r4c0ActionPerformed

    private void r5c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r5c2ActionPerformed
        // TODO add your handling code here:
        r5c2.setText(turn);
        r5c2.setBackground(Color.pink);
    }//GEN-LAST:event_r5c2ActionPerformed

    private void r3c5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3c5ActionPerformed
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
// TODO add your handling code here:JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE)
    }//GEN-LAST:event_r3c5ActionPerformed

    private void r4c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4c3ActionPerformed
        // TODO add your handling code here:
        r4c3.setText(turn);
        r4c3.setBackground(Color.pink);
    }//GEN-LAST:event_r4c3ActionPerformed

    private void r5c6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r5c6ActionPerformed
        // TODO add your handling code here:
        r5c6.setText(turn);
        r5c6.setBackground(Color.pink);
    }//GEN-LAST:event_r5c6ActionPerformed

    private void r3c8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3c8ActionPerformed
        // TODO add your handling code here:
        r3c8.setText(turn);
        r3c8.setBackground(Color.pink);
    }//GEN-LAST:event_r3c8ActionPerformed

    private void r6c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r6c1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r6c1ActionPerformed

    private void r7c0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r7c0ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r7c0ActionPerformed

    private void r8c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r8c1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r8c1ActionPerformed

    private void r8c0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r8c0ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r8c0ActionPerformed

    private void r6c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r6c2ActionPerformed
        // TODO add your handling code here:
        r6c2.setText(turn);
        r6c2.setBackground(Color.pink);
    }//GEN-LAST:event_r6c2ActionPerformed

    private void r6c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r6c3ActionPerformed
        // TODO add your handling code here:
        r6c3.setText(turn);
        r6c3.setBackground(Color.pink);
    }//GEN-LAST:event_r6c3ActionPerformed

    private void r7c5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r7c5ActionPerformed
        // TODO add your handling code here:
        r7c5.setText(turn);
        r7c5.setBackground(Color.pink);
    }//GEN-LAST:event_r7c5ActionPerformed

    private void r8c5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r8c5ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r8c5ActionPerformed

    private void r6c5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r6c5ActionPerformed
        // TODO add your handling code here:
        r6c5.setText(turn);
        r6c5.setBackground(Color.pink);
    }//GEN-LAST:event_r6c5ActionPerformed

    private void r8c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r8c4ActionPerformed
        // TODO add your handling code here:
        r8c4.setText(turn);
        r8c4.setBackground(Color.pink);
    }//GEN-LAST:event_r8c4ActionPerformed

    private void r6c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r6c4ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r6c4ActionPerformed

    private void r8c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r8c3ActionPerformed
        // TODO add your handling code here:
        r8c3.setText(turn);
        r8c3.setBackground(Color.pink);
    }//GEN-LAST:event_r8c3ActionPerformed

    private void r7c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r7c3ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r7c3ActionPerformed

    private void r7c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r7c4ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r7c4ActionPerformed

    private void r6c6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r6c6ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r6c6ActionPerformed

    private void r7c7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r7c7ActionPerformed
        // TODO add your handling code here:
        r7c7.setText(turn);
        r7c7.setBackground(Color.pink);
    }//GEN-LAST:event_r7c7ActionPerformed

    private void r7c8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r7c8ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r7c8ActionPerformed

    private void r8c8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r8c8ActionPerformed
        // TODO add your handling code here:
        r8c8.setText(turn);
        r8c8.setBackground(Color.pink);
    }//GEN-LAST:event_r8c8ActionPerformed

    private void r6c8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r6c8ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r6c8ActionPerformed

    private void r8c7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r8c7ActionPerformed
        // TODO add your handling code here:
        r8c7.setText(turn);
        r8c7.setBackground(Color.pink);
    }//GEN-LAST:event_r8c7ActionPerformed

    private void r6c7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r6c7ActionPerformed
        // TODO add your handling code here:
        r6c7.setText(turn);
        r6c7.setBackground(Color.pink);
    }//GEN-LAST:event_r6c7ActionPerformed

    private void r8c6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r8c6ActionPerformed
        // TODO add your handling code here:
        r8c6.setText(turn);
        r8c6.setBackground(Color.pink);
    }//GEN-LAST:event_r8c6ActionPerformed

    private void r7c6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r7c6ActionPerformed
        // TODO add your handling code here:
        r7c6.setText(turn);
        r7c6.setBackground(Color.pink);
    }//GEN-LAST:event_r7c6ActionPerformed

    private void s1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1ActionPerformed
        // TODO add your handling code here:
        assignClr(s1);
        turn="1";
    }//GEN-LAST:event_s1ActionPerformed

    private void s2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s2ActionPerformed
        // TODO add your handling code here:
        assignClr(s2);
        turn="2";
    }//GEN-LAST:event_s2ActionPerformed

    private void s3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s3ActionPerformed
        // TODO add your handling code here:
        assignClr(s3);
        turn="3";
    }//GEN-LAST:event_s3ActionPerformed

    private void s4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s4ActionPerformed
        // TODO add your handling code here:
        assignClr(s4);
        turn="4";
    }//GEN-LAST:event_s4ActionPerformed

    private void s5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s5ActionPerformed
        // TODO add your handling code here:
        assignClr(s5);
        turn="5";
    }//GEN-LAST:event_s5ActionPerformed

    private void s6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s6ActionPerformed
        // TODO add your handling code here:
        assignClr(s6);
        turn="6";
    }//GEN-LAST:event_s6ActionPerformed

    private void s7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s7ActionPerformed
        // TODO add your handling code here:
        assignClr(s7);
        turn="7";
    }//GEN-LAST:event_s7ActionPerformed

    private void s8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s8ActionPerformed
        // TODO add your handling code here:
        assignClr(s8);
        turn="8";
    }//GEN-LAST:event_s8ActionPerformed

    private void s9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s9ActionPerformed
        // TODO add your handling code here:
        assignClr(s9);
        turn="9";
    }//GEN-LAST:event_s9ActionPerformed

    private void CHECK_MOVE_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHECK_MOVE_BTNActionPerformed
        // TODO add your handling code here:
        checkM();
    }//GEN-LAST:event_CHECK_MOVE_BTNActionPerformed

    private void r1c0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1c0ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r1c0ActionPerformed

    private void r4c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4c2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r4c2ActionPerformed

    private void r2c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2c2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r2c2ActionPerformed

    private void r0c0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r0c0ActionPerformed
        // TODO add your handling code here:
        r0c0.setText(turn);
        r0c0.setBackground(Color.pink);
    }//GEN-LAST:event_r0c0ActionPerformed

    private void r0c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r0c1ActionPerformed
        // TODO add your handling code here:
        r0c1.setText(turn);
        r0c1.setBackground(Color.pink);
    }//GEN-LAST:event_r0c1ActionPerformed

    private void r0c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r0c2ActionPerformed
        // TODO add your handling code here:
        r0c2.setText(turn);
        r0c2.setBackground(Color.pink);
    }//GEN-LAST:event_r0c2ActionPerformed

    private void r0c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r0c3ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r0c3ActionPerformed

    private void r0c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r0c4ActionPerformed
        // TODO add your handling code here:
        r0c4.setText(turn);
        r0c4.setBackground(Color.pink);
    }//GEN-LAST:event_r0c4ActionPerformed

    private void r2c0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2c0ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r2c0ActionPerformed

    private void r1c5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1c5ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r1c5ActionPerformed

    private void r2c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2c4ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r2c4ActionPerformed

    private void r3c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3c4ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r3c4ActionPerformed

    private void r4c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4c1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r4c1ActionPerformed

    private void r4c6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4c6ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r4c6ActionPerformed

    private void r4c7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4c7ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r4c7ActionPerformed

    private void r5c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r5c1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r5c1ActionPerformed

    private void r5c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r5c4ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r5c4ActionPerformed

    private void r8c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r8c2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r8c2ActionPerformed

    private void r1c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1c1ActionPerformed
        // TODO add your handling code here:
        r1c1.setText(turn);
        r1c1.setBackground(Color.pink);
    }//GEN-LAST:event_r1c1ActionPerformed

    private void r1c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1c2ActionPerformed
        // TODO add your handling code here:
        r1c2.setText(turn);
        r1c2.setBackground(Color.pink);

    }//GEN-LAST:event_r1c2ActionPerformed

    private void r1c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1c3ActionPerformed
        // TODO add your handling code here:
        r1c3.setText(turn);
        r1c3.setBackground(Color.pink);

    }//GEN-LAST:event_r1c3ActionPerformed

    private void r2c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2c1ActionPerformed
        // TODO add your handling code here:
        r2c1.setText(turn);
        r2c1.setBackground(Color.pink);

    }//GEN-LAST:event_r2c1ActionPerformed

    private void r2c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2c3ActionPerformed
        // TODO add your handling code here:
        r2c3.setText(turn);
        r2c3.setBackground(Color.pink);
    }//GEN-LAST:event_r2c3ActionPerformed

    private void r2c5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2c5ActionPerformed
        // TODO add your handling code here:
        r2c5.setText(turn);
        r2c5.setBackground(Color.pink);

    }//GEN-LAST:event_r2c5ActionPerformed

    private void r3c0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3c0ActionPerformed
        // TODO add your handling code here:
        r3c0.setText(turn);
        r3c0.setBackground(Color.pink);
    }//GEN-LAST:event_r3c0ActionPerformed

    private void r3c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3c2ActionPerformed
        // TODO add your handling code here:
        r3c2.setText(turn);
        r3c2.setBackground(Color.pink);
    }//GEN-LAST:event_r3c2ActionPerformed

    private void r3c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3c3ActionPerformed
        // TODO add your handling code here:
        r3c3.setText(turn);
        r3c3.setBackground(Color.pink);
    }//GEN-LAST:event_r3c3ActionPerformed

    private void r3c6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3c6ActionPerformed
        // TODO add your handling code here:
        r3c6.setText(turn);
        r3c6.setBackground(Color.pink);
    }//GEN-LAST:event_r3c6ActionPerformed

    private void r4c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4c4ActionPerformed
        // TODO add your handling code here:
        r4c4.setText(turn);
        r4c4.setBackground(Color.pink);
    }//GEN-LAST:event_r4c4ActionPerformed

    private void r4c5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4c5ActionPerformed
        // TODO add your handling code here:
        r4c5.setText(turn);
        r4c5.setBackground(Color.pink);
    }//GEN-LAST:event_r4c5ActionPerformed

    private void r4c8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4c8ActionPerformed
        // TODO add your handling code here:
        r4c8.setText(turn);
        r4c8.setBackground(Color.pink);
    }//GEN-LAST:event_r4c8ActionPerformed

    private void r5c0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r5c0ActionPerformed
        // TODO add your handling code here:
        r5c0.setText(turn);
        r5c0.setBackground(Color.pink);
    }//GEN-LAST:event_r5c0ActionPerformed

    private void r5c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r5c3ActionPerformed
        // TODO add your handling code here:
        r5c3.setText(turn);
        r5c3.setBackground(Color.pink);
    }//GEN-LAST:event_r5c3ActionPerformed

    private void r5c5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r5c5ActionPerformed
        // TODO add your handling code here:
        r5c5.setText(turn);
        r5c5.setBackground(Color.pink);
    }//GEN-LAST:event_r5c5ActionPerformed

    private void r5c7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r5c7ActionPerformed
        // TODO add your handling code here:
        r5c7.setText(turn);
        r5c7.setBackground(Color.pink);
    }//GEN-LAST:event_r5c7ActionPerformed

    private void r5c8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r5c8ActionPerformed
        // TODO add your handling code here:
        r5c8.setText(turn);
        r5c8.setBackground(Color.pink);
    }//GEN-LAST:event_r5c8ActionPerformed

    private void r6c0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r6c0ActionPerformed
        // TODO add your handling code here:
        r6c0.setText(turn);
        r6c0.setBackground(Color.pink);
    }//GEN-LAST:event_r6c0ActionPerformed

    private void r7c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r7c1ActionPerformed
        // TODO add your handling code here:r6c0.setText(turn);
        r7c1.setText(turn);
        r7c1.setBackground(Color.pink);
    }//GEN-LAST:event_r7c1ActionPerformed

    private void r7c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r7c2ActionPerformed
        // TODO add your handling code here:
        r7c2.setText(turn);
        r7c2.setBackground(Color.pink);
    }//GEN-LAST:event_r7c2ActionPerformed

    private void r3c7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3c7ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "THIS BOX IS ALLOTED", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_r3c7ActionPerformed

    private void RESET_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RESET_BTNActionPerformed
        // TODO add your handling code here:
        JFrame frame=new JFrame();
        if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to reset game",
                "Sudoku_Game", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
        {
            resetGame();
        }
    }//GEN-LAST:event_RESET_BTNActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        T.start();
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(Tflag)
        {
            if(checkResult())
            {
                jLabel3.setText("CONGRATULATION YOU WON..!");
                jLabel3.setForeground(Color.BLUE);
            }
            else
            {
                jLabel3.setText("BETTER LUCK NEXT TIME..!");
                jLabel3.setForeground(Color.RED);
            }
        }
        else
        {
            jLabel3.setText("SOLUTION ALREADY CHECK..!");
            jLabel3.setForeground(Color.BLUE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SUDOKU_GAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SUDOKU_GAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SUDOKU_GAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SUDOKU_GAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SUDOKU_GAME().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CHECK_MOVE_BTN;
    private javax.swing.JButton RESET_BTN;
    private javax.swing.JButton SOLUTION_BTN;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton r0c0;
    private javax.swing.JButton r0c1;
    private javax.swing.JButton r0c2;
    private javax.swing.JButton r0c3;
    private javax.swing.JButton r0c4;
    private javax.swing.JButton r0c5;
    private javax.swing.JButton r0c6;
    private javax.swing.JButton r0c7;
    private javax.swing.JButton r0c8;
    private javax.swing.JButton r1c0;
    private javax.swing.JButton r1c1;
    private javax.swing.JButton r1c2;
    private javax.swing.JButton r1c3;
    private javax.swing.JButton r1c4;
    private javax.swing.JButton r1c5;
    private javax.swing.JButton r1c6;
    private javax.swing.JButton r1c7;
    private javax.swing.JButton r1c8;
    private javax.swing.JButton r2c0;
    private javax.swing.JButton r2c1;
    private javax.swing.JButton r2c2;
    private javax.swing.JButton r2c3;
    private javax.swing.JButton r2c4;
    private javax.swing.JButton r2c5;
    private javax.swing.JButton r2c6;
    private javax.swing.JButton r2c7;
    private javax.swing.JButton r2c8;
    private javax.swing.JButton r3c0;
    private javax.swing.JButton r3c1;
    private javax.swing.JButton r3c2;
    private javax.swing.JButton r3c3;
    private javax.swing.JButton r3c4;
    private javax.swing.JButton r3c5;
    private javax.swing.JButton r3c6;
    private javax.swing.JButton r3c7;
    private javax.swing.JButton r3c8;
    private javax.swing.JButton r4c0;
    private javax.swing.JButton r4c1;
    private javax.swing.JButton r4c2;
    private javax.swing.JButton r4c3;
    private javax.swing.JButton r4c4;
    private javax.swing.JButton r4c5;
    private javax.swing.JButton r4c6;
    private javax.swing.JButton r4c7;
    private javax.swing.JButton r4c8;
    private javax.swing.JButton r5c0;
    private javax.swing.JButton r5c1;
    private javax.swing.JButton r5c2;
    private javax.swing.JButton r5c3;
    private javax.swing.JButton r5c4;
    private javax.swing.JButton r5c5;
    private javax.swing.JButton r5c6;
    private javax.swing.JButton r5c7;
    private javax.swing.JButton r5c8;
    private javax.swing.JButton r6c0;
    private javax.swing.JButton r6c1;
    private javax.swing.JButton r6c2;
    private javax.swing.JButton r6c3;
    private javax.swing.JButton r6c4;
    private javax.swing.JButton r6c5;
    private javax.swing.JButton r6c6;
    private javax.swing.JButton r6c7;
    private javax.swing.JButton r6c8;
    private javax.swing.JButton r7c0;
    private javax.swing.JButton r7c1;
    private javax.swing.JButton r7c2;
    private javax.swing.JButton r7c3;
    private javax.swing.JButton r7c4;
    private javax.swing.JButton r7c5;
    private javax.swing.JButton r7c6;
    private javax.swing.JButton r7c7;
    private javax.swing.JButton r7c8;
    private javax.swing.JButton r8c0;
    private javax.swing.JButton r8c1;
    private javax.swing.JButton r8c2;
    private javax.swing.JButton r8c3;
    private javax.swing.JButton r8c4;
    private javax.swing.JButton r8c5;
    private javax.swing.JButton r8c6;
    private javax.swing.JButton r8c7;
    private javax.swing.JButton r8c8;
    private javax.swing.JButton s1;
    private javax.swing.JButton s2;
    private javax.swing.JButton s3;
    private javax.swing.JButton s4;
    private javax.swing.JButton s5;
    private javax.swing.JButton s6;
    private javax.swing.JButton s7;
    private javax.swing.JButton s8;
    private javax.swing.JButton s9;
    // End of variables declaration//GEN-END:variables
}
