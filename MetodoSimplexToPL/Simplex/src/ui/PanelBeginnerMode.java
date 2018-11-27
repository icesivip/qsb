/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Clock;
import javax.swing.*;

/**
 *
 * @author Luis
 */
public class PanelBeginnerMode extends JPanel implements ActionListener {

    private LinealProgrammingInterface ui;
    String title;
    private JButton[] butsAdd;
    private JPanel[] panIzq;
    private JComboBox[] combSymbols;
    private PanelVariable[] panVarsObjectiveE;
    private JTextField[] txtEqualities;
    private PanelVariable[][] panConstraints;
    private JFrame enVista;
    private JFrame last;

    //panVars deberían ser las variables originales x1, x2, ...
    //Para las restricciones hacer una matriz o un arreglo de arraylists de panelVariables
    /**
     * Creates new form PanelEquations nCons is the number of Constrains,
     * without counting the objective function
     */
    public PanelBeginnerMode(LinealProgrammingInterface ui, String nVar, String nConstr, String optim, JFrame actual, JFrame last) {
        enVista = actual;
        this.last = last;
        initComponents();
        labOptimization.setText(optim);
        panConstraints = new PanelVariable[Integer.parseInt(nConstr)][Integer.parseInt(nVar) + 1];
        JLabel panelZ = new JLabel("Z");
        panelOF.setLayout(new GridLayout(1, 0));
        panelOF.add(panelZ);
        panelOF.add(new JLabel("="));
        panVarsObjectiveE = new PanelVariable[Integer.parseInt(nVar)];
        for (int i = 0; i < Integer.parseInt(nVar); i++) {
            panVarsObjectiveE[i] = new PanelVariable("X" + (i + 1));
            panelOF.add(panVarsObjectiveE[i]);
        }
        panelCons.setLayout(new GridLayout(Integer.parseInt(nConstr), 1));
        butsAdd = new JButton[Integer.parseInt(nConstr)];
        combSymbols = new JComboBox[Integer.parseInt(nConstr)];
        txtEqualities = new JTextField[Integer.parseInt(nConstr)];
        panIzq = new JPanel[Integer.parseInt(nConstr)];
        for (int i = 0; i < Integer.parseInt(nConstr); i++) {
            JPanel aux = new JPanel();
            aux.setLayout(new BorderLayout());
            butsAdd[i] = new JButton("Add Variable");
            butsAdd[i].addActionListener(this);
            butsAdd[i].setActionCommand(i + "");
            String[] symbols = {"<=", ">=", "="};
            combSymbols[i] = new JComboBox(symbols);
            txtEqualities[i] = new JTextField(2);
            panIzq[i] = new JPanel();
            panIzq[i].setLayout(new GridLayout(1, 0));
            aux.add(panIzq[i], BorderLayout.WEST);
            JPanel auxDer = new JPanel();
            auxDer.add(butsAdd[i]);
            auxDer.add(combSymbols[i]);
            auxDer.add(txtEqualities[i]);
            aux.add(auxDer, BorderLayout.EAST);
            panelCons.add(aux);
        }
        this.ui = ui;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labOF = new javax.swing.JLabel();
        labCons = new javax.swing.JLabel();
        panelOF = new javax.swing.JPanel();
        panelCons = new javax.swing.JPanel();
        butFinalSolution = new javax.swing.JButton();
        butStepByStep = new javax.swing.JButton();
        labOptimization = new javax.swing.JLabel();
        butBack = new javax.swing.JButton();

        labOF.setText("Objective Function:");

        labCons.setText("Constraints:");

        panelOF.setName("panelOF"); // NOI18N

        javax.swing.GroupLayout panelOFLayout = new javax.swing.GroupLayout(panelOF);
        panelOF.setLayout(panelOFLayout);
        panelOFLayout.setHorizontalGroup(
            panelOFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelOFLayout.setVerticalGroup(
            panelOFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        panelCons.setName("PanelCons"); // NOI18N

        javax.swing.GroupLayout panelConsLayout = new javax.swing.GroupLayout(panelCons);
        panelCons.setLayout(panelConsLayout);
        panelConsLayout.setHorizontalGroup(
            panelConsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );
        panelConsLayout.setVerticalGroup(
            panelConsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 139, Short.MAX_VALUE)
        );

        butFinalSolution.setText("Final solution");
        butFinalSolution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butFinalSolutionActionPerformed(evt);
            }
        });

        butStepByStep.setText("Step by step");
        butStepByStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butStepByStepActionPerformed(evt);
            }
        });

        labOptimization.setText("Max/Min");

        butBack.setText("Back");
        butBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labOptimization)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(butBack)
                        .addGap(18, 18, 18)
                        .addComponent(butStepByStep)
                        .addGap(18, 18, 18)
                        .addComponent(butFinalSolution)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labOF)
                            .addComponent(labCons, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(panelOF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelCons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labOF, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelOF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labCons, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelCons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butFinalSolution)
                    .addComponent(butStepByStep)
                    .addComponent(labOptimization)
                    .addComponent(butBack))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void butFinalSolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butFinalSolutionActionPerformed
        String[] equations = new String[txtEqualities.length + 1];
        preStepSolution(equations);
        double[][] finalMatr = ui.FinalSolution(equations, labOptimization.getText());
        JFrame ventana = new JFrame();
        PanelSolution panelS = new PanelSolution(ui, equations, panVarsObjectiveE.length, true, ventana, enVista);
        panelS.fillMatrix(finalMatr);
        posStepSolution(panelS, ventana);
    }//GEN-LAST:event_butFinalSolutionActionPerformed

    private void butStepByStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butStepByStepActionPerformed
       String[] equations = new String[txtEqualities.length + 1];
        preStepSolution(equations);
        ui.InitializeProcess(equations, labOptimization.getText());
        JFrame ventana = new JFrame();
        PanelSolution panelS = new PanelSolution(ui, equations, panVarsObjectiveE.length, false, ventana, enVista);
        posStepSolution(panelS, ventana);
    }//GEN-LAST:event_butStepByStepActionPerformed

    private void butBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butBackActionPerformed
        last.setVisible(true);
        enVista.dispose();
    }//GEN-LAST:event_butBackActionPerformed

private void preStepSolution(String[]equations) {
        //convierte la ecuación objetivo a la forma matricial
        equations[0] = "+1 Z";
        for (int i = 0; i < panVarsObjectiveE.length; i++) {
            String sign;
            if (panVarsObjectiveE[i].getSign().equals("+")) {
                sign = "-";
            } else {
                sign = "+";
            }
            equations[0] += " " + sign + panVarsObjectiveE[i].getC() + " " + panVarsObjectiveE[i].getVar();
        }
        equations[0] += " = " + "0";

        for (int i = 0; i < txtEqualities.length; i++) {
            equations[i + 1] = "+0 Z";
            for (int j = 0; j < panVarsObjectiveE.length; j++) {
                PanelVariable varConst = panConstraints[i][j];
                if (varConst == null) {
                    varConst = new PanelVariable("X" + (j + 1));
                    varConst.put0();
                }
//                String space;
//                if(j == 0)
//                    space = "";
//                else space = " ";
                equations[i + 1] += " " + varConst.getSign() + varConst.getC() + " " + varConst.getVar();
            }
            equations[i + 1] += " " + combSymbols[i].getSelectedItem() +" " + txtEqualities[i].getText();
        }
}

private void posStepSolution (PanelSolution panelS, JFrame ventana) {
        ventana.setVisible(true);
        ventana.setTitle(enVista.getTitle());
        enVista.setVisible(false);
        ventana.add(panelS);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butBack;
    private javax.swing.JButton butFinalSolution;
    private javax.swing.JButton butStepByStep;
    private javax.swing.JLabel labCons;
    private javax.swing.JLabel labOF;
    private javax.swing.JLabel labOptimization;
    private javax.swing.JPanel panelCons;
    private javax.swing.JPanel panelOF;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] vars = new String[panVarsObjectiveE.length];
        for (int i = 0; i < panVarsObjectiveE.length; i++) {
            vars[i] = panVarsObjectiveE[i].getVar();
        }

        for (int i = 0; i < butsAdd.length; i++) {
            if (e.getActionCommand().equals(i + "")) {
                String variable = (String) JOptionPane.showInputDialog(this, "Choose the variable", "Add Variable", JOptionPane.DEFAULT_OPTION, null, vars, null);
//                maximo de 9 restricciones verificar funcionamiento
//                toma el último número de la variable ID
                if(variable != null){
                String col = variable.charAt(variable.length() - 1) + "";
                panConstraints[i][Integer.parseInt(col) - 1] = new PanelVariable(variable);
                panIzq[i].add(panConstraints[i][Integer.parseInt(col) - 1]);
                validate();
                }
            }

        }

    }
}
