
package br.com.mcdonalds.telas;

import java.sql.*;
import com.br.mcdonalds.dal.ModuloConexao;
import javax.swing.JOptionPane;

public class TelaUsuario extends javax.swing.JFrame {

   //UTILIZANDO FRAMEWORKS DO PACOTE MODULO DE CONEXÃO
Connection conexao = null;
PreparedStatement pst = null;
ResultSet rs = null; //exibe o resultado da conexão
    
    public TelaUsuario() {
        initComponents();
        
        conexao = ModuloConexao.conector(); //CHAMANDO O MÉTODO CONECTOR
    }
    
    //CRIANDO MÉTODO DE CONSULTA
private void consultar(){
String sql ="select * from tbusuarios where iduser=?";
try {
pst=conexao.prepareStatement(sql);
pst.setString(1,txtUsuId.getText());
rs=pst.executeQuery();
if (rs.next()) {
txtUsuNome.setText(rs.getString(2));
txtUsuEmail.setText(rs.getString(3));
txtUsuLogin.setText(rs.getString(4));
txtUsuSenha.setText(rs.getString(5));
} else {
JOptionPane.showMessageDialog(null,"Usuário não cadastrado");
txtUsuNome.setText(null);
txtUsuEmail.setText(null);
txtUsuLogin.setText(null);
txtUsuSenha.setText(null);
}
} catch (Exception e) {
JOptionPane.showMessageDialog(null,e);
}
}

    //MÉTODO ADICIONAR USUÁRIO
private void adicionar(){
String sql ="insert into tbusuarios(iduser, usuario,email,login,senha) values(?,?,?,?,?)";
try {
pst=conexao.prepareStatement(sql);
pst.setString(1,txtUsuId.getText());
pst.setString(2,txtUsuNome.getText());
pst.setString(3,txtUsuEmail.getText());
pst.setString(4,txtUsuLogin.getText());
pst.setString(5,txtUsuSenha.getText());
int adicionado = pst.executeUpdate();
if(adicionado >0){
JOptionPane.showMessageDialog(null,"Usuário cadastrado com sucesso");
txtUsuId.setText(null);
txtUsuNome.setText(null);
txtUsuEmail.setText(null);
txtUsuLogin.setText(null);
txtUsuSenha.setText(null);
}
} catch (Exception e) {
JOptionPane.showMessageDialog(null, e);
}
}

    // MÉTODO DELETE (REMOÇÃO DE USUÁRIOS)
private void remover(){
int confirma=JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este usuário?","Atenção", JOptionPane.YES_NO_OPTION);
if(confirma==JOptionPane.YES_OPTION){
String sql="delete from tbusuarios where iduser=?";
try {
pst=conexao.prepareStatement(sql);
pst.setString(1,txtUsuId.getText());
int apagado = pst.executeUpdate();
if (apagado>0) {
JOptionPane.showMessageDialog(null,"Usuário removido com sucesso");
}
} catch (Exception e) {
JOptionPane.showMessageDialog(null, e);
}
}
}

    //MÉTODO ALTERAR DADOS DE USUÁRIO
private void alterar(){
String sql ="update tbusuarios set usuario=?, email=?, login=?, senha=? where iduser=?";
try {
pst=conexao.prepareStatement(sql);
pst.setString(1,txtUsuNome.getText());
pst.setString(2,txtUsuEmail.getText());
pst.setString(3,txtUsuLogin.getText());
pst.setString(4,txtUsuSenha.getText());
pst.setString(5,txtUsuId.getText());
int adicionado = pst.executeUpdate();
if(adicionado >0){
JOptionPane.showMessageDialog(null,"Usuário alterado com sucesso");
txtUsuId.setText(null);
txtUsuNome.setText(null);
txtUsuEmail.setText(null);
txtUsuLogin.setText(null);
txtUsuSenha.setText(null);
}
} catch (Exception e) {
JOptionPane.showMessageDialog(null, e);
}
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUsuEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtUsuNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtUsuLogin = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtUsuSenha = new javax.swing.JTextField();
        btnUsuAdicionar = new javax.swing.JButton();
        btnUsuPesquisar = new javax.swing.JButton();
        btnUsuAtualizar = new javax.swing.JButton();
        btnUsuDelete = new javax.swing.JButton();

        jButton4.setText("jButton4");

        setTitle("Usuário");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mcdonalds/icones/mcdonaldslogo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ID");

        txtUsuId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Email");

        txtUsuEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nome");

        txtUsuNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Login");

        txtUsuLogin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Senha");

        txtUsuSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnUsuAdicionar.setBackground(new java.awt.Color(255, 255, 0));
        btnUsuAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mcdonalds/icones/adicionarusuario.png"))); // NOI18N
        btnUsuAdicionar.setToolTipText("Adicionar Usuário");
        btnUsuAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuAdicionarActionPerformed(evt);
            }
        });

        btnUsuPesquisar.setBackground(new java.awt.Color(255, 255, 0));
        btnUsuPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mcdonalds/icones/pesquisarusuario.png"))); // NOI18N
        btnUsuPesquisar.setToolTipText("Pesquisar  Usuário");
        btnUsuPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuPesquisarActionPerformed(evt);
            }
        });

        btnUsuAtualizar.setBackground(new java.awt.Color(255, 255, 0));
        btnUsuAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mcdonalds/icones/atualizarusuario.png"))); // NOI18N
        btnUsuAtualizar.setToolTipText("Atualizar Usuário");
        btnUsuAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuAtualizarActionPerformed(evt);
            }
        });

        btnUsuDelete.setBackground(new java.awt.Color(255, 255, 0));
        btnUsuDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mcdonalds/icones/excluirusuario.png"))); // NOI18N
        btnUsuDelete.setToolTipText("Excluir Usuário");
        btnUsuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnUsuAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txtUsuId, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtUsuLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnUsuPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnUsuAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(63, 63, 63)
                                        .addComponent(btnUsuDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(30, 30, 30)
                                                .addComponent(txtUsuEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(28, 28, 28)
                                                .addComponent(txtUsuSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(24, 24, 24))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtUsuNome)
                                .addGap(24, 24, 24))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnUsuDelete)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtUsuId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtUsuEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtUsuNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtUsuLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtUsuSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnUsuAdicionar)
                            .addComponent(btnUsuPesquisar)
                            .addComponent(btnUsuAtualizar))))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 400));

        setSize(new java.awt.Dimension(618, 437));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuPesquisarActionPerformed
        //CHAMANDO O MÉTODO PESQUISAR
consultar();
    }//GEN-LAST:event_btnUsuPesquisarActionPerformed

    private void btnUsuAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuAdicionarActionPerformed
        //CHAMANDO MÉTODO ADICIONAR
adicionar();
    }//GEN-LAST:event_btnUsuAdicionarActionPerformed

    private void btnUsuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuDeleteActionPerformed
        //MÉTODO DELETE
remover();
    }//GEN-LAST:event_btnUsuDeleteActionPerformed

    private void btnUsuAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuAtualizarActionPerformed
        //MÉTODO ALTERAR
alterar();
    }//GEN-LAST:event_btnUsuAtualizarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUsuAdicionar;
    private javax.swing.JButton btnUsuAtualizar;
    private javax.swing.JButton btnUsuDelete;
    private javax.swing.JButton btnUsuPesquisar;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtUsuEmail;
    private javax.swing.JTextField txtUsuId;
    private javax.swing.JTextField txtUsuLogin;
    private javax.swing.JTextField txtUsuNome;
    private javax.swing.JTextField txtUsuSenha;
    // End of variables declaration//GEN-END:variables
}
