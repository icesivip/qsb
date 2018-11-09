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
public class PanelEquations extends JPanel implements ActionListener {

    private LinealProgrammingInterface ui;
    private JButton[] butsAdd;
    private JPanel[] panIzq;
    private JComboBox[] combSymbols;
    private PanelVariable[] panVarsObjectiveE;
    private JTextField[] txtEqualities;
    private PanelVariable[][] panConstraints;
    private JFrame enVista;

    //panVars deberían ser las variables originales x1, x2, ...
    //Para las restricciones hacer una matriz o un arreglo de arraylists de panelVariables
    /**
     * Creates new form PanelEquations nCons is the number of Constrains,
     * without counting the objective function
     */
    public PanelEquations(LinealProgrammingInterface ui, String nVar, String nConstr, String optim, JFrame actual) {
        enVista = actual;
        initComponents();
        butOptimize.setText(optim);
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
            String[] symbols = {">=", "<=", "="};
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
        butOptimize = new javax.swing.JButton();

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

        butOptimize.setText("Max/Min");
        butOptimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butOptimizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labOF)
                            .addComponent(labCons, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(panelOF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelCons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(butOptimize)
                .addContainerGap())
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
                .addComponent(butOptimize)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void butOptimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butOptimizeActionPerformed
        String[] equations = new String[txtEqualities.length + 1];
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
        PanelSolution panelS = new PanelSolution(ui, equations, panVarsObjectiveE.length);
        ui.InitializeProcess(equations, butOptimize.getText());
        JFrame ventana = new JFrame();
        ventana.setVisible(true);
        enVista.setVisible(false);
        ventana.add(panelS);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
    }//GEN-LAST:event_butOptimizeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butOptimize;
    private javax.swing.JLabel labCons;
    private javax.swing.JLabel labOF;
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
                String col = variable.charAt(variable.length() - 1) + "";
                panConstraints[i][Integer.parseInt(col) - 1] = new PanelVariable(variable);
                panIzq[i].add(panConstraints[i][Integer.parseInt(col) - 1]);
                validate();
            }

        }

    }
}
