/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entidades.Autor;
import entidades.Editora;
import entidades.Livro;
import persistencia.PAutor;
import persistencia.PEditora;
import persistencia.PLivro;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.IDGenerator;
import util.RenderizaLabel;

/**
 *
 * @author repez
 */
public class TelaLivro extends javax.swing.JFrame {
    
    String livro_db = "./src/arquivos/Livros.csv";
    String autor_db = "./src/arquivos/Autores.csv";
    String editora_db = "./src/arquivos/Editoras.csv";
    
    /**
     * Creates new form TelaLivro
     */
    public TelaLivro() {
        
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jLabelLivroID.setVisible(false);
        jButtonCancelarEdicao.setVisible(false);
        jButtonEditarLivro.setVisible(false);
        
        try {

            PAutor ad = new PAutor(autor_db);
            PEditora ed = new PEditora(editora_db);
            
            ArrayList<Autor> listaAutores = ad.listar();
            ArrayList<Editora> listaEditoras = ed.listar();
            
            String[] autores = new String[listaAutores.size()];
            String[] editoras = new String[listaEditoras.size()];
            
            for (int i = 0; i < listaAutores.size(); i++) {
                Autor a = listaAutores.get(i);
                autores[i] = a.getNome();
            }
            
            for (int i = 0; i < listaEditoras.size(); i++) {
                Editora e = listaEditoras.get(i);
                editoras[i] = e.getNome();
            }
            
            Arrays.sort(autores);
            Arrays.sort(editoras);
            
            DefaultComboBoxModel m_autores = new DefaultComboBoxModel(autores);
            jComboBoxLivroAutor.setModel(m_autores);
            
            DefaultComboBoxModel m_editoras = new DefaultComboBoxModel(editoras);
            jComboBoLivroEditora.setModel(m_editoras);
  
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro.getMessage());
            erro.printStackTrace();
        }
        
    }
    
    //Método para buscar os autores e preencher a jTable inicialmente
    public void showLivros(ArrayList<Livro> listaLivros) {
        try {

            DefaultTableModel modelo = (DefaultTableModel) jTableLivros.getModel();
            
            //setando o modo de renderizacão da coluna Capa da tabela
            jTableLivros.getColumn("Capa").setCellRenderer(new RenderizaLabel());
            
            modelo.setNumRows(listaLivros.size());
            
            PAutor ad = new PAutor(autor_db);
            PEditora ed = new PEditora(editora_db);
            
            for (int i = 0; i < listaLivros.size(); i++) {
                Livro liv = listaLivros.get(i);
                modelo.setValueAt(liv.getId(), i, 0);
                modelo.setValueAt(liv.getIsbn(), i, 1);
                modelo.setValueAt(liv.getTitulo(), i, 2);   
                
                Autor a = ad.getAutorByID(liv.getAutorID());
                modelo.setValueAt(a.getNome(), i, 3);
                
                Editora e = ed.getEditoraByID(liv.getEditoraID());            
                modelo.setValueAt(e.getNome(), i, 4);
                   
                ImageIcon foto = new ImageIcon(liv.getFotoDaCapa());
                Image imagem = foto.getImage();
                Image novaImagem = imagem.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                ImageIcon fotoRedimensionada = new ImageIcon(novaImagem);
                    
                JLabel img = new JLabel();
                img.setIcon(fotoRedimensionada);
                
                modelo.setValueAt(img, i, 5);
            }
            
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, erro.getMessage());
        }
    }
    
    public void limparCampos() {
        jTextFieldLivroTitulo.setText("");
        jTextFieldLivroISBN.setText("");
        jTextFieldLivroCapa.setText("");
        jComboBoxLivroAutor.setSelectedIndex(0);
        jComboBoLivroEditora.setSelectedIndex(0);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldLivroISBN = new javax.swing.JTextField();
        jTextFieldLivroTitulo = new javax.swing.JTextField();
        jTextFieldLivroCapa = new javax.swing.JTextField();
        jButtonCarregaCapa = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonCadastrarLivro = new javax.swing.JButton();
        jComboBoxLivroAutor = new javax.swing.JComboBox<>();
        jComboBoLivroEditora = new javax.swing.JComboBox<>();
        jButtonEditarLivro = new javax.swing.JButton();
        jButtonCancelarEdicao = new javax.swing.JButton();
        jLabelLivroID = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLivros = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldBuscaLivros = new javax.swing.JTextField();
        jButtonBuscarLivro = new javax.swing.JButton();
        jButtonListarLivros = new javax.swing.JButton();
        jComboBoxTipoBuscaLivro = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Livros");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Livros", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Novo Livro"));

        jLabel2.setText("ISBN:");

        jLabel3.setText("Título:");

        jLabel4.setText("Capa:");

        jButtonCarregaCapa.setText("Carregar");
        jButtonCarregaCapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCarregaCapaActionPerformed(evt);
            }
        });

        jLabel5.setText("Autor:");

        jLabel6.setText("Editora:");

        jButtonCadastrarLivro.setText("Cadastrar");
        jButtonCadastrarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarLivroActionPerformed(evt);
            }
        });

        jComboBoxLivroAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoLivroEditora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonEditarLivro.setText("Editar");
        jButtonEditarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarLivroActionPerformed(evt);
            }
        });

        jButtonCancelarEdicao.setText("Cancelar Edição");
        jButtonCancelarEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarEdicaoActionPerformed(evt);
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
                        .addComponent(jLabel2)
                        .addGap(36, 36, 36)
                        .addComponent(jTextFieldLivroISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelLivroID))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonCadastrarLivro)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEditarLivro)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancelarEdicao))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldLivroTitulo)
                            .addComponent(jTextFieldLivroCapa)
                            .addComponent(jComboBoxLivroAutor, 0, 300, Short.MAX_VALUE)
                            .addComponent(jComboBoLivroEditora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCarregaCapa)))
                .addContainerGap(326, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldLivroISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLivroID))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldLivroTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldLivroCapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCarregaCapa))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxLivroAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoLivroEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCadastrarLivro)
                    .addComponent(jButtonEditarLivro)
                    .addComponent(jButtonCancelarEdicao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Livros Cadastrados"));

        jTableLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ISBN", "Título", "Autor", "Editora", "Capa"
            }
        ));
        jTableLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLivrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableLivros);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Busca de Livros"));

        jLabel1.setText("Buscar por:");

        jButtonBuscarLivro.setText("Buscar");
        jButtonBuscarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarLivroActionPerformed(evt);
            }
        });

        jButtonListarLivros.setText("Listar Livros");
        jButtonListarLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarLivrosActionPerformed(evt);
            }
        });

        jComboBoxTipoBuscaLivro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Autor", "Editora", "Título" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxTipoBuscaLivro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBuscaLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBuscarLivro)
                .addGap(187, 187, 187)
                .addComponent(jButtonListarLivros)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldBuscaLivros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarLivro)
                    .addComponent(jButtonListarLivros)
                    .addComponent(jComboBoxTipoBuscaLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCarregaCapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCarregaCapaActionPerformed
        // TODO add your handling code here:
        JFileChooser jf = new JFileChooser();
     
        jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        jf.showOpenDialog(this);
        
        File f = jf.getSelectedFile();
        jTextFieldLivroCapa.setText(f.getPath());
    }//GEN-LAST:event_jButtonCarregaCapaActionPerformed

    private void jButtonCadastrarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarLivroActionPerformed
        // TODO add your handling code here:
        try {
            
            IDGenerator novoID = new IDGenerator();
            int id = novoID.getNovoID();
            int isbn = Integer.parseInt(jTextFieldLivroISBN.getText());
            String titulo = jTextFieldLivroTitulo.getText();
            String capa = jTextFieldLivroCapa.getText();

            if(!jTextFieldLivroISBN.getText().isEmpty() && !jTextFieldLivroCapa.getText().isEmpty() && !jTextFieldLivroTitulo.getText().isEmpty()) {

                Autor autorEncontrado = null;
                if(jComboBoxLivroAutor.getSelectedItem() != null) {
                    PAutor ad =  new PAutor(autor_db);
                    autorEncontrado = ad.getAutorByNome(jComboBoxLivroAutor.getSelectedItem().toString());
                }
                
                Editora editoraEncontrada = null;
                if(jComboBoLivroEditora.getSelectedItem() != null) {
                    PEditora ed =  new PEditora(editora_db);
                    editoraEncontrada = ed.getEditoraByNome(jComboBoLivroEditora.getSelectedItem().toString());
                }
                
                if(editoraEncontrada != null && autorEncontrado != null) {
                    Livro novoLivro = new Livro(id, isbn, titulo, capa, autorEncontrado.getId(), editoraEncontrada.getId());
                    
                    PLivro ldao = new PLivro(livro_db);
 
                    BufferedImage imagem = ImageIO.read(new File(novoLivro.getFotoDaCapa()));
                    String caminhoFinal = "./src/img/" + novoLivro.getTitulo() + ".jpg";
                    ImageIO.write(imagem, "jpg", new File(caminhoFinal));
                    
                    novoLivro.setFotoDaCapa(caminhoFinal);
                    ldao.incluir(novoLivro);
                    
                    novoID.gravaID(id);
                    JOptionPane.showMessageDialog(rootPane, "Livro " + titulo + " cadastrado com sucesso!");
                    limparCampos();
                    
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao incluir livro.");
                }                           
            } else {
                JOptionPane.showMessageDialog(rootPane, "Preencha os campos antes de tentar inserir um Livro.");
            } 

        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, erro.getMessage());
        }
        
    }//GEN-LAST:event_jButtonCadastrarLivroActionPerformed

    private void jButtonListarLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarLivrosActionPerformed
        // TODO add your handling code here:
        try {
            PLivro ldao = new PLivro(livro_db);
            ArrayList<Livro> listaLivros = ldao.listar();
            if(listaLivros.size() > 0) {
                showLivros(listaLivros);
            } else {
                DefaultTableModel modelo = (DefaultTableModel) jTableLivros.getModel();
                modelo.setRowCount(0);
                JOptionPane.showMessageDialog(rootPane, "Nenhum livro cadastrada."); 
            }   
        } catch (Exception erro) {
            erro.printStackTrace();
        }
    }//GEN-LAST:event_jButtonListarLivrosActionPerformed

    private void jButtonBuscarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarLivroActionPerformed
        // TODO add your handling code here:
        try {
            String tipoBusca = jComboBoxTipoBuscaLivro.getSelectedItem().toString();
            String busca = jTextFieldBuscaLivros.getText();
            if(!busca.isEmpty() && !tipoBusca.isEmpty()) {
                PLivro ldao = new PLivro(livro_db);
                ArrayList<Livro> livrosEncontrados = null;
                if(tipoBusca.equals("Autor")) {
                    livrosEncontrados = ldao.getLivrosByAutor(busca.toUpperCase());
                } else if(tipoBusca.equals("Editora")) {
                    livrosEncontrados = ldao.getLivrosByEditora(busca.toUpperCase());
                } else {
                    livrosEncontrados = ldao.getLivrosByTitulo(busca.toUpperCase());
                }
                if(livrosEncontrados != null) {
                    showLivros(livrosEncontrados);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Nenhum livro encontrado.");
                }
                
            } else {
                JOptionPane.showMessageDialog(rootPane, "Preencha os campos de busca corretamente!");
            }
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonBuscarLivroActionPerformed

    private void jTableLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLivrosMouseClicked
        // TODO add your handling code here:
        try {
            int linhaSelecionada = jTableLivros.getSelectedRow();
            jLabelLivroID.setText(jTableLivros.getModel().getValueAt(linhaSelecionada, 0).toString());
            int livroID = Integer.parseInt(jLabelLivroID.getText());
            
            jButtonEditarLivro.setVisible(true);
            jButtonCancelarEdicao.setVisible(true);
            jButtonCadastrarLivro.setVisible(false);
            
            if(!jLabelLivroID.getText().isEmpty()) {
                PLivro ldao = new PLivro(livro_db);
                Livro livro = ldao.getLivroByID(livroID);
                
                jTextFieldLivroCapa.setText(livro.getFotoDaCapa());
                jTextFieldLivroISBN.setText(String.valueOf(livro.getIsbn()));
                jTextFieldLivroTitulo.setText(livro.getTitulo());
                
                PEditora edao = new PEditora(editora_db);
                Editora editora = edao.getEditoraByID(livro.getEditoraID());
                jComboBoLivroEditora.setSelectedItem(editora.getNome());
                
                PAutor adao = new PAutor(autor_db);
                Autor autor = adao.getAutorByID(livro.getAutorID());
                jComboBoxLivroAutor.setSelectedItem(autor.getNome());
            }
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro.getMessage());
        }
        
        
        
    }//GEN-LAST:event_jTableLivrosMouseClicked

    private void jButtonEditarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarLivroActionPerformed
        // TODO add your handling code here:
        try {
            int livroID = Integer.parseInt(String.valueOf(jLabelLivroID.getText()));
            if(!jLabelLivroID.getText().isEmpty()) {
                PLivro ldao = new PLivro(livro_db);
                Livro livro = ldao.getLivroByID(livroID);
                
                livro.setFotoDaCapa(jTextFieldLivroCapa.getText());
                livro.setTitulo(jTextFieldLivroTitulo.getText());
                livro.setIsbn(Integer.parseInt(jTextFieldLivroISBN.getText()));
                
                PAutor adao = new PAutor(autor_db);
                Autor autor = adao.getAutorByNome(jComboBoxLivroAutor.getSelectedItem().toString());
                
                PEditora edao = new PEditora(editora_db);
                Editora editora = edao.getEditoraByNome(jComboBoLivroEditora.getSelectedItem().toString());
                
                livro.setAutorID(autor.getId());
                livro.setEditoraID(editora.getId());
                
                ldao.alterar(livro);
                JOptionPane.showMessageDialog(rootPane, "Livro alterado com sucesso!");
                limparCampos();
                showLivros(ldao.listar());
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonEditarLivroActionPerformed

    private void jButtonCancelarEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarEdicaoActionPerformed
        // TODO add your handling code here:
        jLabelLivroID.setText("");
        jButtonCadastrarLivro.setVisible(true);
        jButtonCancelarEdicao.setVisible(false);
        jButtonEditarLivro.setVisible(false);
        limparCampos();
    }//GEN-LAST:event_jButtonCancelarEdicaoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLivro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarLivro;
    private javax.swing.JButton jButtonCadastrarLivro;
    private javax.swing.JButton jButtonCancelarEdicao;
    private javax.swing.JButton jButtonCarregaCapa;
    private javax.swing.JButton jButtonEditarLivro;
    private javax.swing.JButton jButtonListarLivros;
    private javax.swing.JComboBox<String> jComboBoLivroEditora;
    private javax.swing.JComboBox<String> jComboBoxLivroAutor;
    private javax.swing.JComboBox<String> jComboBoxTipoBuscaLivro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelLivroID;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLivros;
    private javax.swing.JTextField jTextFieldBuscaLivros;
    private javax.swing.JTextField jTextFieldLivroCapa;
    private javax.swing.JTextField jTextFieldLivroISBN;
    private javax.swing.JTextField jTextFieldLivroTitulo;
    // End of variables declaration//GEN-END:variables
}
