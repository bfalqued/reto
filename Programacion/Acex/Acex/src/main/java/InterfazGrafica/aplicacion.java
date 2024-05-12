package InterfazGrafica;

import Clases.Actividad_Solicitada;
import Clases.Actividad_SolicitadaDAOImp;
import Clases.CargarDatos;
import Clases.Curso;
import Clases.CursoDAOImp;
import Clases.Departamento;
import Clases.DepartamentoDAOImp;
import Clases.EstadoActividad;
import Clases.Grupo;
import Clases.GrupoDAOImp;
import Clases.Profesor;
import Clases.ProfesorDAOImp;
import Clases.TipoActividad;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.UIManager;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.List;
import javax.swing.ListSelectionModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Borja
 */
public class aplicacion extends javax.swing.JFrame {

    private Map<String, Integer> Mapacursosselecionados;
    private Map<String, Integer> Mapagruposselecionados;
    private List <String> listaprofesoresresponsablesselecionados;
    private List <String> listaprofesoresparticipantesselecionados;
    private String contenidocomentarioadicional;
    private String contenidocomentariotransporte;
    private String contenidocomentarioalojamiento;
    private Profesor profesorLogin;

    public aplicacion() {
        initComponents();

        menu.setOpaque(true);
        Color negrotransparente = new Color(0, 0, 0, 128);
        Color negrotransparente1 = new Color(0,0,0,220);
        menu.setBackground(negrotransparente);
        solicitud.setBackground(negrotransparente);
        Color gristransparente = new Color(60, 63, 65, 128);
        Color gristransparente1 = new Color (60,63,65,240);
        fondosolicitud.setBackground(gristransparente);
        solicitud.setVisible(false);
        importar.setVisible(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV files", "csv");
        cuadroimportar.setFileFilter(filter);
        profesoresresponsables.setVisible(false);
        // Supongamos que tienes una clase ProfesorDAO que se encarga de interactuar con la base de datos
        profesoresparticipantes.setVisible(false);
        gruposparticipantes.setVisible(false);
        cursosparticipantes.setVisible(false);
        this.setVisible(true);
        Mapacursosselecionados = new HashMap<>();
        Mapagruposselecionados = new HashMap<>();
        listaprofesoresresponsablesselecionados=new ArrayList();
        listaprofesoresparticipantesselecionados= new ArrayList();
        panelcomentarios.setVisible(false);
        setDocumentfilter(cuadrotitulosolicitud, 150);
        setDocumentfilterTextarea(comentarioalojamiento,300);
        setDocumentfilterTextarea(comentariotransporte,300);
        setDocumentfilterTextarea(comentarioadicional,300);
        gestionarsolicitudes.setVisible(false);
        solicitudesaprobadas.setVisible(false);
        solicitudespendientes.setVisible(false);
        solicitudesdenegadas.setVisible(false);
        gestionarsolicitudes.setBackground(negrotransparente);
        solicitudesaprobadas.setBackground(negrotransparente);
        solicitudespendientes.setBackground(negrotransparente);
        solicitudesdenegadas.setBackground(negrotransparente);
        fondosolicitudesdenegadas.setBackground(gristransparente);
        fondosolicitudespendientes.setBackground(gristransparente);
        fondosolicitudesaprobadas.setBackground(gristransparente);
        fondogestionarsolicitudes.setBackground(gristransparente);
        cursosparticipantes.setBackground(negrotransparente1);
        gruposparticipantes.setBackground(negrotransparente1);
        fondocursosparticipantes.setBackground(gristransparente1);
        fondogruposparticipantes.setBackground(gristransparente1);
        profesoresresponsables.setBackground(negrotransparente1);
        profesoresparticipantes.setBackground(negrotransparente1);
        fondoprofesoresresponsables.setBackground(gristransparente1);
        fondoprofesoresparticipantes.setBackground(gristransparente1);
        actividadesrealizadas.setBackground(negrotransparente);
        fondoactividadesrealizadas.setBackground(gristransparente);
        panelcomentarios.setBackground(negrotransparente1);
        fondopanelcomentarios.setBackground(gristransparente1);
        actividadesrealizadas.setVisible(false);

    }
    public void setProfesor(Profesor profesor){
        this.profesorLogin=profesor;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        importar = new javax.swing.JPanel();
        cuadroimportar = new javax.swing.JFileChooser();
        gruposparticipantes = new javax.swing.JPanel();
        titulogruposparticipantes = new javax.swing.JLabel();
        cerrargruposparticipantes = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        listagruposparticipantes = new javax.swing.JList<>();
        guardargruposparticipantes = new javax.swing.JButton();
        fondogruposparticipantes = new javax.swing.JLabel();
        cursosparticipantes = new javax.swing.JPanel();
        titulocursosparticipantes = new javax.swing.JLabel();
        cerrarcursosparticipantes = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        listacursosparticipantes = new javax.swing.JList<>();
        guardarcursosparticipantes = new javax.swing.JButton();
        fondocursosparticipantes = new javax.swing.JLabel();
        profesoresresponsables = new javax.swing.JPanel();
        tituloprofesoresresponsables = new javax.swing.JLabel();
        cerrarprofesoresresponsables = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaprofesoresresponsables = new javax.swing.JList<>();
        botonguardarprofesoresresponsables = new javax.swing.JButton();
        fondoprofesoresresponsables = new javax.swing.JLabel();
        profesoresparticipantes = new javax.swing.JPanel();
        tituloprofesoresparticipantes = new javax.swing.JLabel();
        cerrarprofesoresparticipantes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaprofesoresparticipantes = new javax.swing.JList<>();
        guardarprofesoresparticipantes = new javax.swing.JButton();
        fondoprofesoresparticipantes = new javax.swing.JLabel();
        panelcomentarios = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        comentarioadicional = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        comentarioalojamiento = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        comentariotransporte = new javax.swing.JTextArea();
        titulocomentarioadicional = new javax.swing.JLabel();
        titulocomentarioalojamiento = new javax.swing.JLabel();
        titulocomentariotransporte = new javax.swing.JLabel();
        guardarcomentarios = new javax.swing.JButton();
        cerrarcomentarios = new javax.swing.JLabel();
        fondopanelcomentarios = new javax.swing.JLabel();
        solicitud = new javax.swing.JPanel();
        encabezado = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        cuadrotitulosolicitud = new javax.swing.JTextField();
        departamento = new javax.swing.JLabel();
        elegirdepartamento = new javax.swing.JComboBox<>();
        Tipo = new javax.swing.JLabel();
        cajatipo = new javax.swing.JComboBox<>();
        actividadprevista = new javax.swing.JLabel();
        cajaprevista = new javax.swing.JComboBox<>();
        horario = new javax.swing.JLabel();
        horaini = new javax.swing.JLabel();
        hini = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));
        horafin = new javax.swing.JLabel();
        hfin = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));
        horario1 = new javax.swing.JLabel();
        fechaini = new javax.swing.JLabel();
        fini = new JSpinner(new SpinnerDateModel());
        fechafin = new javax.swing.JLabel();
        ffin = new JSpinner(new SpinnerDateModel());
        transporte = new javax.swing.JLabel();
        cajatransporte = new javax.swing.JComboBox<>();
        botonprofesoresresponsables = new javax.swing.JButton();
        botonprofesoresparticipantes = new javax.swing.JButton();
        elegircursogrupo = new javax.swing.JComboBox<>();
        alumnosselecionar = new javax.swing.JButton();
        alumnos = new javax.swing.JLabel();
        profesores = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cajaalojamiento = new javax.swing.JComboBox<>();
        comentarios = new javax.swing.JLabel();
        botoncomentar = new javax.swing.JButton();
        botonenviarsolicitud = new javax.swing.JButton();
        fondosolicitud = new javax.swing.JLabel();
        cerrarsoli = new javax.swing.JLabel();
        botonesminmaxcerrar = new javax.swing.JPanel();
        gestionarsolicitudes = new javax.swing.JPanel();
        titulogestionarsolicitudes = new javax.swing.JLabel();
        cerrargestionarsolicitudes = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        fondogestionarsolicitudes = new javax.swing.JLabel();
        solicitudesaprobadas = new javax.swing.JPanel();
        titulosolicitudesaprobadas = new javax.swing.JLabel();
        cerrarsolicitudesaprobadas = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        fondosolicitudesaprobadas = new javax.swing.JLabel();
        solicitudespendientes = new javax.swing.JPanel();
        titulosolicitudespendientes = new javax.swing.JLabel();
        cerrarsolicitudespendientes = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        fondosolicitudespendientes = new javax.swing.JLabel();
        solicitudesdenegadas = new javax.swing.JPanel();
        titulosolicitudesdenegadas = new javax.swing.JLabel();
        cerrarsolicitudesdenegadas = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        fondosolicitudesdenegadas = new javax.swing.JLabel();
        actividadesrealizadas = new javax.swing.JPanel();
        tituloactividadesrealizadas = new javax.swing.JLabel();
        cerraractividadesrealizadas = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        fondoactividadesrealizadas = new javax.swing.JLabel();
        botoncerrar = new javax.swing.JPanel();
        cerrar = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        iconoimportardatos = new javax.swing.JLabel();
        crearsolicitud = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        botongestionarsolicitudes = new javax.swing.JLabel();
        botonsolicitudaprobada = new javax.swing.JLabel();
        botonactividadpendiente = new javax.swing.JLabel();
        botonsolicituddenegada = new javax.swing.JLabel();
        botonactividadesrealizadas = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("pantalla"); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        importar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cuadroimportar.setOpaque(true);
        cuadroimportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuadroimportarActionPerformed(evt);
            }
        });
        importar.add(cuadroimportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 430));

        getContentPane().add(importar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 580, 440));

        gruposparticipantes.setBackground(new java.awt.Color(0, 0, 0));
        gruposparticipantes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulogruposparticipantes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titulogruposparticipantes.setForeground(new java.awt.Color(255, 255, 255));
        titulogruposparticipantes.setText("Grupos participantes");
        gruposparticipantes.add(titulogruposparticipantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 180, 40));

        cerrargruposparticipantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconocerrar30x30.png"))); // NOI18N
        cerrargruposparticipantes.setText("jLabel2");
        cerrargruposparticipantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrargruposparticipantesMouseClicked(evt);
            }
        });
        gruposparticipantes.add(cerrargruposparticipantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 30, 30));

        jScrollPane6.setViewportView(listagruposparticipantes);

        gruposparticipantes.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 480, 280));

        guardargruposparticipantes.setForeground(new java.awt.Color(0, 0, 0));
        guardargruposparticipantes.setText("Guardar");
        guardargruposparticipantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardargruposparticipantesMouseClicked(evt);
            }
        });
        guardargruposparticipantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardargruposparticipantesActionPerformed(evt);
            }
        });
        gruposparticipantes.add(guardargruposparticipantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 130, 30));

        fondogruposparticipantes.setOpaque(true);
        gruposparticipantes.add(fondogruposparticipantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 520, 390));

        getContentPane().add(gruposparticipantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 570, 440));

        cursosparticipantes.setBackground(new java.awt.Color(0, 0, 0));
        cursosparticipantes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulocursosparticipantes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titulocursosparticipantes.setForeground(new java.awt.Color(255, 255, 255));
        titulocursosparticipantes.setText("Cursos participantes");
        cursosparticipantes.add(titulocursosparticipantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 180, 40));

        cerrarcursosparticipantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconocerrar30x30.png"))); // NOI18N
        cerrarcursosparticipantes.setText("jLabel2");
        cerrarcursosparticipantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarcursosparticipantesMouseClicked(evt);
            }
        });
        cursosparticipantes.add(cerrarcursosparticipantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 30, 30));

        jScrollPane7.setViewportView(listacursosparticipantes);

        cursosparticipantes.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 480, 280));

        guardarcursosparticipantes.setForeground(new java.awt.Color(0, 0, 0));
        guardarcursosparticipantes.setText("Guardar");
        guardarcursosparticipantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarcursosparticipantesMouseClicked(evt);
            }
        });
        guardarcursosparticipantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarcursosparticipantesActionPerformed(evt);
            }
        });
        cursosparticipantes.add(guardarcursosparticipantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 130, 30));

        fondocursosparticipantes.setOpaque(true);
        cursosparticipantes.add(fondocursosparticipantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 520, 390));

        getContentPane().add(cursosparticipantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 570, 440));

        profesoresresponsables.setBackground(new java.awt.Color(0, 0, 0));
        profesoresresponsables.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloprofesoresresponsables.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tituloprofesoresresponsables.setForeground(new java.awt.Color(255, 255, 255));
        tituloprofesoresresponsables.setText("Profesores responsables");
        profesoresresponsables.add(tituloprofesoresresponsables, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 360, 40));

        cerrarprofesoresresponsables.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconocerrar30x30.png"))); // NOI18N
        cerrarprofesoresresponsables.setText("jLabel2");
        cerrarprofesoresresponsables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarprofesoresresponsablesMouseClicked(evt);
            }
        });
        profesoresresponsables.add(cerrarprofesoresresponsables, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 30, 30));

        jScrollPane2.setViewportView(listaprofesoresresponsables);

        profesoresresponsables.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 520, 280));

        botonguardarprofesoresresponsables.setForeground(new java.awt.Color(0, 0, 0));
        botonguardarprofesoresresponsables.setText("Guardar");
        botonguardarprofesoresresponsables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonguardarprofesoresresponsablesMouseClicked(evt);
            }
        });
        botonguardarprofesoresresponsables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonguardarprofesoresresponsablesActionPerformed(evt);
            }
        });
        profesoresresponsables.add(botonguardarprofesoresresponsables, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 130, 30));

        fondoprofesoresresponsables.setOpaque(true);
        profesoresresponsables.add(fondoprofesoresresponsables, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 560, 400));

        getContentPane().add(profesoresresponsables, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 610, 460));

        profesoresparticipantes.setBackground(new java.awt.Color(0, 0, 0));
        profesoresparticipantes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloprofesoresparticipantes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tituloprofesoresparticipantes.setForeground(new java.awt.Color(255, 255, 255));
        tituloprofesoresparticipantes.setText("Profesores participantes");
        profesoresparticipantes.add(tituloprofesoresparticipantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 360, 30));

        cerrarprofesoresparticipantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconocerrar30x30.png"))); // NOI18N
        cerrarprofesoresparticipantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarprofesoresparticipantesMouseClicked(evt);
            }
        });
        profesoresparticipantes.add(cerrarprofesoresparticipantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 30, 30));

        jScrollPane1.setViewportView(listaprofesoresparticipantes);

        profesoresparticipantes.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 520, 280));

        guardarprofesoresparticipantes.setText("Guardar");
        guardarprofesoresparticipantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarprofesoresparticipantesMouseClicked(evt);
            }
        });
        profesoresparticipantes.add(guardarprofesoresparticipantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 130, 40));

        fondoprofesoresparticipantes.setOpaque(true);
        profesoresparticipantes.add(fondoprofesoresparticipantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 560, 400));

        getContentPane().add(profesoresparticipantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 610, 460));

        panelcomentarios.setBackground(new java.awt.Color(0, 0, 0));
        panelcomentarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comentarioadicional.setColumns(20);
        comentarioadicional.setRows(5);
        jScrollPane8.setViewportView(comentarioadicional);

        panelcomentarios.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 740, 120));

        comentarioalojamiento.setColumns(20);
        comentarioalojamiento.setRows(5);
        jScrollPane9.setViewportView(comentarioalojamiento);

        panelcomentarios.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 740, 120));

        comentariotransporte.setColumns(20);
        comentariotransporte.setRows(5);
        jScrollPane10.setViewportView(comentariotransporte);

        panelcomentarios.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 740, 120));

        titulocomentarioadicional.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titulocomentarioadicional.setForeground(new java.awt.Color(255, 255, 255));
        titulocomentarioadicional.setText("Comentario adicional:");
        panelcomentarios.add(titulocomentarioadicional, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 350, 50));

        titulocomentarioalojamiento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titulocomentarioalojamiento.setForeground(new java.awt.Color(255, 255, 255));
        titulocomentarioalojamiento.setText("Comentario alojamiento:");
        panelcomentarios.add(titulocomentarioalojamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 200, 50));

        titulocomentariotransporte.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titulocomentariotransporte.setForeground(new java.awt.Color(255, 255, 255));
        titulocomentariotransporte.setText("Comentario transporte:");
        panelcomentarios.add(titulocomentariotransporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 350, 50));

        guardarcomentarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        guardarcomentarios.setForeground(new java.awt.Color(0, 0, 0));
        guardarcomentarios.setText("Guardar");
        guardarcomentarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarcomentariosMouseClicked(evt);
            }
        });
        panelcomentarios.add(guardarcomentarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 590, 210, 50));

        cerrarcomentarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconocerrar30x30.png"))); // NOI18N
        cerrarcomentarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarcomentariosMouseClicked(evt);
            }
        });
        panelcomentarios.add(cerrarcomentarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 30, 30));

        fondopanelcomentarios.setOpaque(true);
        panelcomentarios.add(fondopanelcomentarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 770, 640));

        getContentPane().add(panelcomentarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 820, 690));

        solicitud.setBackground(new java.awt.Color(0, 0, 0));
        solicitud.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        encabezado.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        encabezado.setForeground(new java.awt.Color(255, 255, 255));
        encabezado.setText("Nueva solicitud");
        solicitud.add(encabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 193, 51));

        titulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Titulo:");
        solicitud.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 70, 50));

        cuadrotitulosolicitud.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cuadrotitulosolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuadrotitulosolicitudActionPerformed(evt);
            }
        });
        solicitud.add(cuadrotitulosolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 400, 30));

        departamento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        departamento.setForeground(new java.awt.Color(255, 255, 255));
        departamento.setText("Departamento:");
        solicitud.add(departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 130, 40));

        elegirdepartamento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        elegirdepartamento.setForeground(new java.awt.Color(0, 0, 0));
        elegirdepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                elegirdepartamentoMouseClicked(evt);
            }
        });
        elegirdepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elegirdepartamentoActionPerformed(evt);
            }
        });
        solicitud.add(elegirdepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 400, 30));

        Tipo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Tipo.setForeground(new java.awt.Color(255, 255, 255));
        Tipo.setText("Tipo:");
        solicitud.add(Tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        cajatipo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cajatipo.setForeground(new java.awt.Color(0, 0, 0));
        cajatipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Extraescolar", "Complementaria" }));
        solicitud.add(cajatipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 200, 30));

        actividadprevista.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        actividadprevista.setForeground(new java.awt.Color(255, 255, 255));
        actividadprevista.setText("Actividad prevista:");
        solicitud.add(actividadprevista, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 160, 40));

        cajaprevista.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cajaprevista.setForeground(new java.awt.Color(0, 0, 0));
        cajaprevista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        solicitud.add(cajaprevista, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, -1, -1));

        horario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        horario.setForeground(new java.awt.Color(255, 255, 255));
        horario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        horario.setText("Horario:");
        horario.setToolTipText("");
        solicitud.add(horario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 80, 30));

        horaini.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        horaini.setForeground(new java.awt.Color(255, 255, 255));
        horaini.setText("Inicio:");
        horaini.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        solicitud.add(horaini, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 50, 50));

        hini.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                hiniAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        solicitud.add(hini, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 120, 30));

        horafin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        horafin.setForeground(new java.awt.Color(255, 255, 255));
        horafin.setText("Fin:");
        horafin.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        solicitud.add(horafin, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 30, 50));

        hfin.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                hfinAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        solicitud.add(hfin, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 120, 30));

        horario1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        horario1.setForeground(new java.awt.Color(255, 255, 255));
        horario1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        horario1.setText("Fecha:");
        horario1.setToolTipText("");
        solicitud.add(horario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 80, 30));

        fechaini.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        fechaini.setForeground(new java.awt.Color(255, 255, 255));
        fechaini.setText("Inicio:");
        fechaini.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        solicitud.add(fechaini, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 50, 50));

        fini.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                finiAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        solicitud.add(fini, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 120, 30));

        fechafin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        fechafin.setForeground(new java.awt.Color(255, 255, 255));
        fechafin.setText("Fin:");
        fechafin.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        solicitud.add(fechafin, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 30, 50));

        ffin.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                ffinAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        solicitud.add(ffin, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 120, 30));

        transporte.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        transporte.setForeground(new java.awt.Color(255, 255, 255));
        transporte.setText("Transporte/s:");
        solicitud.add(transporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 120, 40));

        cajatransporte.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cajatransporte.setForeground(new java.awt.Color(0, 0, 0));
        cajatransporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        solicitud.add(cajatransporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, -1, -1));

        botonprofesoresresponsables.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonprofesoresresponsables.setForeground(new java.awt.Color(0, 0, 0));
        botonprofesoresresponsables.setText("Profesores responsables");
        botonprofesoresresponsables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonprofesoresresponsablesMouseClicked(evt);
            }
        });
        solicitud.add(botonprofesoresresponsables, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, -1, 40));

        botonprofesoresparticipantes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonprofesoresparticipantes.setForeground(new java.awt.Color(0, 0, 0));
        botonprofesoresparticipantes.setText("Profesores participantes");
        botonprofesoresparticipantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonprofesoresparticipantesMouseClicked(evt);
            }
        });
        solicitud.add(botonprofesoresparticipantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, -1, 40));

        elegircursogrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cursos", "Grupos" }));
        solicitud.add(elegircursogrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 500, 180, 40));

        alumnosselecionar.setText("Seleccionar");
        alumnosselecionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alumnosselecionarMouseClicked(evt);
            }
        });
        alumnosselecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumnosselecionarActionPerformed(evt);
            }
        });
        solicitud.add(alumnosselecionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 180, 40));

        alumnos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        alumnos.setForeground(new java.awt.Color(255, 255, 255));
        alumnos.setText("Alumnos:");
        solicitud.add(alumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 130, 40));

        profesores.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        profesores.setForeground(new java.awt.Color(255, 255, 255));
        profesores.setText("Profesores:");
        solicitud.add(profesores, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 110, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Alojamiento:");
        solicitud.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, -1, -1));

        cajaalojamiento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cajaalojamiento.setForeground(new java.awt.Color(0, 0, 0));
        cajaalojamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        solicitud.add(cajaalojamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 560, -1, -1));

        comentarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comentarios.setForeground(new java.awt.Color(255, 255, 255));
        comentarios.setText("Comentarios:");
        solicitud.add(comentarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 610, 120, 40));

        botoncomentar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botoncomentar.setForeground(new java.awt.Color(0, 0, 0));
        botoncomentar.setText("Comentar");
        botoncomentar.setActionCommand("");
        botoncomentar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botoncomentarMouseClicked(evt);
            }
        });
        solicitud.add(botoncomentar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 610, 180, 40));

        botonenviarsolicitud.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonenviarsolicitud.setForeground(new java.awt.Color(0, 0, 0));
        botonenviarsolicitud.setText("Enviar Solicitud");
        botonenviarsolicitud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonenviarsolicitudMouseClicked(evt);
            }
        });
        botonenviarsolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonenviarsolicitudActionPerformed(evt);
            }
        });
        solicitud.add(botonenviarsolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 710, 180, 40));

        fondosolicitud.setOpaque(true);
        solicitud.add(fondosolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 700, 810));

        cerrarsoli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconocerrar30x30.png"))); // NOI18N
        cerrarsoli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarsoliMouseClicked(evt);
            }
        });
        solicitud.add(cerrarsoli, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, -1, -1));

        getContentPane().add(solicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, 870));

        botonesminmaxcerrar.setOpaque(false);
        botonesminmaxcerrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(botonesminmaxcerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 100, 50));

        gestionarsolicitudes.setBackground(new java.awt.Color(0, 0, 0));
        gestionarsolicitudes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulogestionarsolicitudes.setBackground(new java.awt.Color(0, 0, 0));
        titulogestionarsolicitudes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titulogestionarsolicitudes.setForeground(new java.awt.Color(255, 255, 255));
        titulogestionarsolicitudes.setText("Gestionar solicitudes");
        gestionarsolicitudes.add(titulogestionarsolicitudes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 232, 58));

        cerrargestionarsolicitudes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconocerrar30x30.png"))); // NOI18N
        cerrargestionarsolicitudes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrargestionarsolicitudesMouseClicked(evt);
            }
        });
        gestionarsolicitudes.add(cerrargestionarsolicitudes, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 30, 30));

        jTable4.setForeground(new java.awt.Color(153, 153, 153));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id_actividad", "fecha", "titulo", "solicitante"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(jTable4);

        gestionarsolicitudes.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 870, 330));

        fondogestionarsolicitudes.setOpaque(true);
        gestionarsolicitudes.add(fondogestionarsolicitudes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 930, 400));

        getContentPane().add(gestionarsolicitudes, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, 450));

        solicitudesaprobadas.setBackground(new java.awt.Color(0, 0, 0));
        solicitudesaprobadas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulosolicitudesaprobadas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titulosolicitudesaprobadas.setForeground(new java.awt.Color(255, 255, 255));
        titulosolicitudesaprobadas.setText("Solicitudes aprobadas");
        solicitudesaprobadas.add(titulosolicitudesaprobadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 210, 50));

        cerrarsolicitudesaprobadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconocerrar30x30.png"))); // NOI18N
        cerrarsolicitudesaprobadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarsolicitudesaprobadasMouseClicked(evt);
            }
        });
        solicitudesaprobadas.add(cerrarsolicitudesaprobadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, -1, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id_actividad", "fecha", "titulo", "solicitante"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable2);

        solicitudesaprobadas.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 880, 300));

        fondosolicitudesaprobadas.setOpaque(true);
        solicitudesaprobadas.add(fondosolicitudesaprobadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 910, 360));

        getContentPane().add(solicitudesaprobadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 950, 410));

        solicitudespendientes.setBackground(new java.awt.Color(0, 0, 0));
        solicitudespendientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulosolicitudespendientes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titulosolicitudespendientes.setForeground(new java.awt.Color(255, 255, 255));
        titulosolicitudespendientes.setText("Solicitudes pendientes");
        solicitudespendientes.add(titulosolicitudespendientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 210, 50));

        cerrarsolicitudespendientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconocerrar30x30.png"))); // NOI18N
        cerrarsolicitudespendientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarsolicitudespendientesMouseClicked(evt);
            }
        });
        solicitudespendientes.add(cerrarsolicitudespendientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 30, 30));

        jTable1.setForeground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id_actividad", "fecha", "titulo", "solicitante"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);
        jTable1.getAccessibleContext().setAccessibleName("");
        jTable1.getAccessibleContext().setAccessibleDescription("");

        solicitudespendientes.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 900, 300));

        fondosolicitudespendientes.setOpaque(true);
        solicitudespendientes.add(fondosolicitudespendientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 920, 360));

        getContentPane().add(solicitudespendientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, 410));

        solicitudesdenegadas.setBackground(new java.awt.Color(0, 0, 0));
        solicitudesdenegadas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulosolicitudesdenegadas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titulosolicitudesdenegadas.setForeground(new java.awt.Color(255, 255, 255));
        titulosolicitudesdenegadas.setText("Solicitudes denegadas");
        solicitudesdenegadas.add(titulosolicitudesdenegadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 210, 50));

        cerrarsolicitudesdenegadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconocerrar30x30.png"))); // NOI18N
        cerrarsolicitudesdenegadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarsolicitudesdenegadasMouseClicked(evt);
            }
        });
        solicitudesdenegadas.add(cerrarsolicitudesdenegadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 30, 30));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id_actividad", "fecha", "titulo", "solicitante"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable3);

        solicitudesdenegadas.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 910, 300));

        fondosolicitudesdenegadas.setOpaque(true);
        solicitudesdenegadas.add(fondosolicitudesdenegadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 930, 370));

        getContentPane().add(solicitudesdenegadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 970, 420));

        actividadesrealizadas.setBackground(new java.awt.Color(0, 0, 0));
        actividadesrealizadas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloactividadesrealizadas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tituloactividadesrealizadas.setForeground(new java.awt.Color(255, 255, 255));
        tituloactividadesrealizadas.setText("Actividades realizadas");
        actividadesrealizadas.add(tituloactividadesrealizadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 210, 50));

        cerraractividadesrealizadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconocerrar30x30.png"))); // NOI18N
        cerraractividadesrealizadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerraractividadesrealizadasMouseClicked(evt);
            }
        });
        actividadesrealizadas.add(cerraractividadesrealizadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, -1, -1));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id_actividad", "fecha", "titulo", "solicitante"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane12.setViewportView(jTable5);

        actividadesrealizadas.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 880, 300));

        fondoactividadesrealizadas.setOpaque(true);
        actividadesrealizadas.add(fondoactividadesrealizadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 910, 360));

        getContentPane().add(actividadesrealizadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 950, 410));

        botoncerrar.setOpaque(false);
        botoncerrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconocerrar.png"))); // NOI18N
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });
        botoncerrar.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(botoncerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 0, 50, 50));

        menu.setBackground(new java.awt.Color(0, 0, 0));
        menu.setForeground(new java.awt.Color(102, 102, 102));
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconoimportardatos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        iconoimportardatos.setForeground(new java.awt.Color(255, 255, 255));
        iconoimportardatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/subirdatos.png"))); // NOI18N
        iconoimportardatos.setText("Importar datos");
        iconoimportardatos.setPreferredSize(new java.awt.Dimension(30, 30));
        iconoimportardatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconoimportardatosMouseClicked(evt);
            }
        });
        menu.add(iconoimportardatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 250, 134, 50));

        crearsolicitud.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        crearsolicitud.setForeground(new java.awt.Color(255, 255, 255));
        crearsolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/crearsolicitud.png"))); // NOI18N
        crearsolicitud.setText("Crear solicitud");
        crearsolicitud.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        crearsolicitud.setPreferredSize(new java.awt.Dimension(134, 50));
        crearsolicitud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crearsolicitudMouseClicked(evt);
            }
        });
        menu.add(crearsolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 380, -1, 50));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logointerfaz.png"))); // NOI18N
        menu.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 41, -1, 150));

        botongestionarsolicitudes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botongestionarsolicitudes.setForeground(new java.awt.Color(255, 255, 255));
        botongestionarsolicitudes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestionarsolicitudes.png"))); // NOI18N
        botongestionarsolicitudes.setText("Gestionar solicitudes");
        botongestionarsolicitudes.setPreferredSize(new java.awt.Dimension(134, 50));
        botongestionarsolicitudes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botongestionarsolicitudesMouseClicked(evt);
            }
        });
        menu.add(botongestionarsolicitudes, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 430, 176, -1));

        botonsolicitudaprobada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonsolicitudaprobada.setForeground(new java.awt.Color(255, 255, 255));
        botonsolicitudaprobada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aprobada.png"))); // NOI18N
        botonsolicitudaprobada.setText("Solicitudes aprobadas");
        botonsolicitudaprobada.setPreferredSize(new java.awt.Dimension(134, 50));
        botonsolicitudaprobada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonsolicitudaprobadaMouseClicked(evt);
            }
        });
        menu.add(botonsolicitudaprobada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 170, -1));

        botonactividadpendiente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonactividadpendiente.setForeground(new java.awt.Color(255, 255, 255));
        botonactividadpendiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividadpendiente.png"))); // NOI18N
        botonactividadpendiente.setText("Solicitudes pendientes");
        botonactividadpendiente.setPreferredSize(new java.awt.Dimension(134, 50));
        botonactividadpendiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonactividadpendienteMouseClicked(evt);
            }
        });
        menu.add(botonactividadpendiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 530, 170, -1));

        botonsolicituddenegada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonsolicituddenegada.setForeground(new java.awt.Color(255, 255, 255));
        botonsolicituddenegada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/solicituddenegada.png"))); // NOI18N
        botonsolicituddenegada.setText("Solicitudes denegadas");
        botonsolicituddenegada.setPreferredSize(new java.awt.Dimension(134, 50));
        botonsolicituddenegada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonsolicituddenegadaMouseClicked(evt);
            }
        });
        menu.add(botonsolicituddenegada, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 580, 170, -1));

        botonactividadesrealizadas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonactividadesrealizadas.setForeground(new java.awt.Color(255, 255, 255));
        botonactividadesrealizadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actividadesrealizadas.png"))); // NOI18N
        botonactividadesrealizadas.setText("Actividades realizadas");
        botonactividadesrealizadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonactividadesrealizadasMouseClicked(evt);
            }
        });
        menu.add(botonactividadesrealizadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, 180, 50));

        getContentPane().add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 200, 880));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondo 1350x900.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 900));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_cerrarMouseClicked

    private void crearsolicitudMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearsolicitudMouseClicked

        DepartamentoDAOImp departamentoDAO = new DepartamentoDAOImp();
        List<Departamento> listadepartamentos = departamentoDAO.listar();
        List<String> listanombresdepartamentos = departamentoDAO.nombres(listadepartamentos);
        for (String valor : listanombresdepartamentos) {
            elegirdepartamento.addItem(valor);
        }
        elegirdepartamento.setSelectedIndex(-1);
        cajatipo.setSelectedIndex(-1);
        cajaprevista.setSelectedIndex(-1);
        cajatransporte.setSelectedIndex(-1);
        elegircursogrupo.setSelectedIndex(-1);
        cajaalojamiento.setSelectedIndex(-1);
        solicitud.setVisible(true);

    }//GEN-LAST:event_crearsolicitudMouseClicked

    private void iconoimportardatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconoimportardatosMouseClicked

        importar.setVisible(true);
    }//GEN-LAST:event_iconoimportardatosMouseClicked

    private void cuadroimportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuadroimportarActionPerformed
        String command = evt.getActionCommand();
        if (command.equals(JFileChooser.APPROVE_SELECTION)) {
            File selectedFile = cuadroimportar.getSelectedFile();

            CargarDatos cargarDatos = new CargarDatos();
            List<Profesor> aux = cargarDatos.cargarCSVProfesores(selectedFile);
            cargarDatos.insertarProfesores(aux);
            System.out.println("Profesores cargados exitosamente desde: " + selectedFile);

            importar.setVisible(false);
        } else if (command.equals(JFileChooser.CANCEL_SELECTION)) {
            importar.setVisible(false);
        }

    }//GEN-LAST:event_cuadroimportarActionPerformed

    private void cerrarsoliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarsoliMouseClicked
        solicitud.setVisible(false);
        profesoresresponsables.setVisible(false);
    }//GEN-LAST:event_cerrarsoliMouseClicked

    private void ffinAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_ffinAncestorAdded
        JSpinner.DateEditor editor = new JSpinner.DateEditor(ffin, "dd/MM/yyyy");
        ffin.setEditor(editor);
        ffin.setValue(new Date());
    }//GEN-LAST:event_ffinAncestorAdded

    private void finiAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_finiAncestorAdded
        JSpinner.DateEditor editor = new JSpinner.DateEditor(fini, "dd/MM/yyyy");
        fini.setEditor(editor);
        fini.setValue(new Date());
    }//GEN-LAST:event_finiAncestorAdded

    private void hfinAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_hfinAncestorAdded
        JSpinner.DateEditor editor = new JSpinner.DateEditor(hfin, "HH:mm");
        hfin.setEditor(editor);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        hfin.setValue(calendar.getTime());
    }//GEN-LAST:event_hfinAncestorAdded

    private void hiniAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_hiniAncestorAdded
        JSpinner.DateEditor editor = new JSpinner.DateEditor(hini, "HH:mm");
        hini.setEditor(editor);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        hini.setValue(calendar.getTime());
    }//GEN-LAST:event_hiniAncestorAdded

    private void cerrarprofesoresresponsablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarprofesoresresponsablesMouseClicked
        profesoresresponsables.setVisible(false);
    }//GEN-LAST:event_cerrarprofesoresresponsablesMouseClicked

    private void botonprofesoresresponsablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonprofesoresresponsablesMouseClicked

        profesoresresponsables.setVisible(true);

        ProfesorDAOImp profesorDAO = new ProfesorDAOImp();
        // Obtienes la lista de profesores de la base de datos
        List<Profesor> profesores = profesorDAO.listar();
        // Creas un nuevo modelo para la JList
        DefaultListModel<String> model = new DefaultListModel<>();
        // Añades los nombres y apellidos de los profesores al modelo
        for (Profesor profesor : profesores) {
            model.addElement(profesor.getNombre() + " " + profesor.getApellido());
        }
        // Actualizas el modelo de la JList
        listaprofesoresresponsables.setModel(model);
        listaprofesoresresponsables.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.setVisible(true);
    }//GEN-LAST:event_botonprofesoresresponsablesMouseClicked

    private void botonguardarprofesoresresponsablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonguardarprofesoresresponsablesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonguardarprofesoresresponsablesActionPerformed

    private void botonprofesoresparticipantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonprofesoresparticipantesMouseClicked
        profesoresparticipantes.setVisible(true);

        ProfesorDAOImp profesorDAO = new ProfesorDAOImp();
        // Obtienes la lista de profesores de la base de datos
        List<Profesor> profesores = profesorDAO.listar();
        // Creas un nuevo modelo para la JList
        DefaultListModel<String> model = new DefaultListModel<>();
        // Añades los nombres y apellidos de los profesores al modelo
        for (Profesor profesor : profesores) {
            model.addElement(profesor.getNombre() + " " + profesor.getApellido());
        }
        // Actualizas el modelo de la JList
        listaprofesoresparticipantes.setModel(model);
        listaprofesoresparticipantes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.setVisible(true);
    }//GEN-LAST:event_botonprofesoresparticipantesMouseClicked

    private void cerrarprofesoresparticipantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarprofesoresparticipantesMouseClicked
        profesoresparticipantes.setVisible(false);
    }//GEN-LAST:event_cerrarprofesoresparticipantesMouseClicked

    private void cerrarsolicitudespendientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarsolicitudespendientesMouseClicked
        solicitudespendientes.setVisible(false);
    }//GEN-LAST:event_cerrarsolicitudespendientesMouseClicked

    private void cerrarsolicitudesaprobadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarsolicitudesaprobadasMouseClicked
        solicitudesaprobadas.setVisible(false);
    }//GEN-LAST:event_cerrarsolicitudesaprobadasMouseClicked

    private void cerrarsolicitudesdenegadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarsolicitudesdenegadasMouseClicked
        solicitudesdenegadas.setVisible(false);
    }//GEN-LAST:event_cerrarsolicitudesdenegadasMouseClicked

    private void alumnosselecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumnosselecionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alumnosselecionarActionPerformed

    private void cerrargruposparticipantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrargruposparticipantesMouseClicked
        gruposparticipantes.setVisible(false);
    }//GEN-LAST:event_cerrargruposparticipantesMouseClicked

    private void guardargruposparticipantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardargruposparticipantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guardargruposparticipantesActionPerformed

    private void alumnosselecionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alumnosselecionarMouseClicked
        String selectedItem = (String) elegircursogrupo.getSelectedItem();
        Mapacursosselecionados = new HashMap<>();
        Mapagruposselecionados = new HashMap<>();
        if(selectedItem !=null){if (selectedItem.equals("Cursos")) {

            cursosparticipantes.setVisible(true);
            gruposparticipantes.setVisible(false);
            //listacursosparticipantes.setVisible(true);
            CursoDAOImp cursoDAO = new CursoDAOImp();

            List<Curso> cursos = cursoDAO.listar();

            DefaultListModel<String> model = new DefaultListModel<>();

            for (Curso curso : cursos) {
                model.addElement(curso.getCodigo());
            }
            // Actualizas el modelo de la JList
            listacursosparticipantes.setModel(model);
            listacursosparticipantes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            this.setVisible(true);
        } else if(selectedItem.equals("Grupos")){
            gruposparticipantes.setVisible(true);
            cursosparticipantes.setVisible(false);
            //listagruposparticipantes.setVisible(true);
            GrupoDAOImp grupoDAO = new GrupoDAOImp();

            List<Grupo> grupos = grupoDAO.listar();

            DefaultListModel<String> model = new DefaultListModel<>();

            for (Grupo grupo : grupos) {
                model.addElement(grupo.getCodgrupo());
            }
            // Actualizas el modelo de la JList
            listagruposparticipantes.setModel(model);
            listagruposparticipantes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            this.setVisible(true);
        }}
    }//GEN-LAST:event_alumnosselecionarMouseClicked

    private void guardarcursosparticipantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarcursosparticipantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guardarcursosparticipantesActionPerformed

    private void cerrarcursosparticipantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarcursosparticipantesMouseClicked
        cursosparticipantes.setVisible(false);
    }//GEN-LAST:event_cerrarcursosparticipantesMouseClicked

    private void guardarcursosparticipantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarcursosparticipantesMouseClicked
        int[] cursosSeleccionados = listacursosparticipantes.getSelectedIndices();
        for (int index : cursosSeleccionados) {
            String cursoSeleccionado = listacursosparticipantes.getModel().getElementAt(index);
            String inputValue = JOptionPane.showInputDialog("Ingrese el número de alumnos participantes del curso: " + cursoSeleccionado);
            if (inputValue != null && !inputValue.isEmpty()) {
                try {
                    int number = Integer.parseInt(inputValue);
                    Mapacursosselecionados.put(cursoSeleccionado, number);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido para " + cursoSeleccionado);
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Selecciones guardadas con éxito:\n" + Mapacursosselecionados);
        cursosparticipantes.setVisible(false);
    }//GEN-LAST:event_guardarcursosparticipantesMouseClicked

    private void guardargruposparticipantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardargruposparticipantesMouseClicked
        int[] gruposSeleccionados = listagruposparticipantes.getSelectedIndices();
        for (int index : gruposSeleccionados) {
            String grupoSeleccionado = listagruposparticipantes.getModel().getElementAt(index);
            String inputValue = JOptionPane.showInputDialog("Ingrese el número de alumnos participantes del grupo: " + grupoSeleccionado);
            if (inputValue != null && !inputValue.isEmpty()) {
                try {
                    int number = Integer.parseInt(inputValue);
                    Mapacursosselecionados.put(grupoSeleccionado, number);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido para " + grupoSeleccionado);
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Selecciones guardadas con éxito:\n" + Mapacursosselecionados);
        gruposparticipantes.setVisible(false);
    }//GEN-LAST:event_guardargruposparticipantesMouseClicked

    private void cerrarcomentariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarcomentariosMouseClicked
        panelcomentarios.setVisible(false);
    }//GEN-LAST:event_cerrarcomentariosMouseClicked

    private void botoncomentarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botoncomentarMouseClicked
        panelcomentarios.setVisible(true);
    }//GEN-LAST:event_botoncomentarMouseClicked

    private void elegirdepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elegirdepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_elegirdepartamentoActionPerformed

    private void elegirdepartamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_elegirdepartamentoMouseClicked

    }//GEN-LAST:event_elegirdepartamentoMouseClicked

    private void botonenviarsolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonenviarsolicitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonenviarsolicitudActionPerformed

    private void botonenviarsolicitudMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonenviarsolicitudMouseClicked
        if (validadatos()) {
            
            
            //Obtener id_solicitante
            int solicitante = this.profesorLogin.getId_profesor();
            //obtener titulo
            String titulo = cuadrotitulosolicitud.getText();
            //Obtener id  del departamento
            DepartamentoDAOImp departamentodao=new DepartamentoDAOImp();
            Object selectedValueDep = elegirdepartamento.getSelectedItem();
            String nombredepartamentoSeleccionado = selectedValueDep.toString();
            Departamento departamentoSeleccionado=departamentodao.porNombre(nombredepartamentoSeleccionado);
            int iddepartamentoSeleccionado=departamentoSeleccionado.getId_departamento();
            //obtener si es prevista
            boolean prevista=false;
            Object selectedValuePre = cajaprevista.getSelectedItem();
            String previstaSiONo =selectedValuePre.toString();
            if(previstaSiONo.equals("Si")){
                prevista=true;
            }
            //obtener si es necesario transporte
            boolean transporte=false;
            Object selectedValueTra = cajatransporte.getSelectedItem();
            String transporteSiONo =selectedValueTra.toString();
            if(transporteSiONo.equals("Si")){
                transporte=true;
            }
            //obtener si es necesrio alojamiento
            boolean alojamiento=false;
            Object selectedValueAlo = cajaalojamiento.getSelectedItem();
            String alojamientoSiONo =selectedValueAlo.toString();
            if(alojamientoSiONo.equals("Si")){
                alojamiento=true;
            }
            //obtener tipo
            Object selectedValueTip = cajatipo.getSelectedItem();
            String tipocadena =selectedValueTip.toString();
            TipoActividad tipo=TipoActividad.valueOf(tipocadena);
            //obtener fechas de inicio y de fin
            LocalDateTime fechaHoraInicio = obtenerLocalDateTimeDesdeSpinners(hini, fini);
            LocalDateTime fechaHoraFin = obtenerLocalDateTimeDesdeSpinners(hfin, ffin);
            //obtener estado
            EstadoActividad estado=EstadoActividad.Solicitada;
            //obtener comentario transporte
            String comentarioTransporte=comentariotransporte.getText();
            //obtener comentario alojamiento
            String comentarioAlojamiento=comentarioalojamiento.getText();
            //obtener comentario adicional
            String comentarioAdicional=comentarioadicional.getText();
            //obtener comentario estado
            String comentarioEstado="";
            
            
            //Crear la actividad_solicitada
            Actividad_Solicitada actividadsolicitada = new Actividad_Solicitada(
                    solicitante,
                    titulo, 
                    tipo, 
                    iddepartamentoSeleccionado, 
                    prevista, 
                    fechaHoraInicio,
                    fechaHoraFin, 
                    transporte,
                    comentarioTransporte,
                    alojamiento,
                    comentarioAlojamiento,
                    comentarioAdicional,
                    estado,
                    comentarioEstado);
            
            // Insertar actividad
            Actividad_SolicitadaDAOImp actividadsolicitadadao=new Actividad_SolicitadaDAOImp();
            actividadsolicitadadao.guardar(actividadsolicitada);
            int idActividad = actividadsolicitada.getId_actividad();
            //obtener alumnos participantes
            GrupoDAOImp grupoDao=new GrupoDAOImp();
            CursoDAOImp cursoDao = new CursoDAOImp();
            String participantes="";
            Map<Curso,Integer> cursosparticipan=null;
            Map<Grupo,Integer> gruposparticipan = null;
            if(!Mapagruposselecionados.isEmpty()){
                gruposparticipan=grupoDao.gruposYnumAlumnos(Mapagruposselecionados);
                participantes="grupos";
            }
            else if(!Mapacursosselecionados.isEmpty()){
                cursosparticipan=cursoDao.gruposYnumAlumnos(Mapacursosselecionados);
                participantes="cursos";
            }
            //Insertar alumnos participantes
            if(participantes.equals("grupos")){
                actividadsolicitadadao.insertarGrupoParticipa(gruposparticipan, idActividad);
            }else if(participantes.equals("cursos")){
                actividadsolicitadadao.insertarCursoParticipa(cursosparticipan, idActividad);
            }
            //obtener profesores
            ProfesorDAOImp profesordao=new ProfesorDAOImp();
            //----obtener profesores responsables
            List<String>nombresProfesoresResponsables=this.listaprofesoresresponsablesselecionados;
            List<Profesor> profesoresResponsables=profesordao.obtenerProfesoresDesdeMapadeNombres(nombresProfesoresResponsables);
            
            //----obtener profesores participantes
            List<String>nombresProfesoresParticipantes=this.listaprofesoresparticipantesselecionados;
            List<Profesor> profesoresParticipantes=profesordao.obtenerProfesoresDesdeMapadeNombres(nombresProfesoresParticipantes);
            
            //Insertar profesores
            Actividad_SolicitadaDAOImp actividadprofesoresdao = new Actividad_SolicitadaDAOImp();
            actividadprofesoresdao.insertarProfesorResponsable(profesoresResponsables, idActividad);
            actividadprofesoresdao.insertarProfesorParticipa(profesoresParticipantes, idActividad);
            JOptionPane.showMessageDialog(null, "¡Solicitud enviada correctamente!");
        } 

    }//GEN-LAST:event_botonenviarsolicitudMouseClicked

    private void cuadrotitulosolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuadrotitulosolicitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cuadrotitulosolicitudActionPerformed

    private void botonguardarprofesoresresponsablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonguardarprofesoresresponsablesMouseClicked
        listaprofesoresresponsablesselecionados= listaprofesoresresponsables.getSelectedValuesList();
        profesoresresponsables.setVisible(false);
    }//GEN-LAST:event_botonguardarprofesoresresponsablesMouseClicked

    private void guardarprofesoresparticipantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarprofesoresparticipantesMouseClicked
       listaprofesoresparticipantesselecionados= listaprofesoresparticipantes.getSelectedValuesList();
        profesoresparticipantes.setVisible(false);
    }//GEN-LAST:event_guardarprofesoresparticipantesMouseClicked

    private void guardarcomentariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarcomentariosMouseClicked
        contenidocomentarioadicional = comentarioadicional.getText();
        contenidocomentariotransporte = comentariotransporte.getText();
        contenidocomentarioalojamiento =comentarioalojamiento.getText();
        panelcomentarios.setVisible(false);
        
    }//GEN-LAST:event_guardarcomentariosMouseClicked

    private void botongestionarsolicitudesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botongestionarsolicitudesMouseClicked
        gestionarsolicitudes.setVisible(true);
    }//GEN-LAST:event_botongestionarsolicitudesMouseClicked

    private void cerrargestionarsolicitudesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrargestionarsolicitudesMouseClicked
        gestionarsolicitudes.setVisible(false);
    }//GEN-LAST:event_cerrargestionarsolicitudesMouseClicked

    private void botonsolicitudaprobadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonsolicitudaprobadaMouseClicked
        solicitudesaprobadas.setVisible(true);
    }//GEN-LAST:event_botonsolicitudaprobadaMouseClicked

    private void botonactividadpendienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonactividadpendienteMouseClicked
        solicitudespendientes.setVisible(true);
    }//GEN-LAST:event_botonactividadpendienteMouseClicked

    private void botonsolicituddenegadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonsolicituddenegadaMouseClicked
        solicitudesdenegadas.setVisible(true);
    }//GEN-LAST:event_botonsolicituddenegadaMouseClicked

    private void cerraractividadesrealizadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerraractividadesrealizadasMouseClicked
        actividadesrealizadas.setVisible(false);
    }//GEN-LAST:event_cerraractividadesrealizadasMouseClicked

    private void botonactividadesrealizadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonactividadesrealizadasMouseClicked
        actividadesrealizadas.setVisible(true);
    }//GEN-LAST:event_botonactividadesrealizadasMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new aplicacion().setVisible(true);
            }
        });
    }

    private boolean validadatos() {
        if (!cuadrotitulosolicitud.getText().matches("^([A-Z0-9Ñ][a-záéíóúñºª]*)(\\s[A-Za-z0-9ñÑºªáéíóú]*)*$")) {
            JOptionPane.showMessageDialog(null, "Ingresa un título válido");
            return false;
        } else if (elegirdepartamento.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "Selecciona un departamento");
            return false;
        } else if (cajatipo.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "Selecciona un tipo de actividad");
            return false;
        } else if (cajaprevista.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "Selecciona si está prevista o no");
            return false;
        } else if (obtenerLocalDateTimeDesdeSpinners(hini, fini).isBefore(LocalDateTime.now())) {
            JOptionPane.showMessageDialog(null, "La fecha inicial tiene que ser posterior a la fecha actual");
            return false;
        } else if (obtenerLocalDateTimeDesdeSpinners(hfin, ffin).isBefore(obtenerLocalDateTimeDesdeSpinners(hini, fini))) {
            JOptionPane.showMessageDialog(null, "La fecha final tiene que ser posterior a la fecha inicial");
            return false;
        } else if (cajatransporte.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "Selecciona si se necesita transporte o no");
            return false;            
        } else if (listaprofesoresresponsablesselecionados.isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecciona a los profesores responsables");
            return false;
        } else if(elegircursogrupo.getSelectedIndex()<0){
            JOptionPane.showMessageDialog(null, "Selecciona al menos un curso o grupo");
            return false;
        } else if (Mapacursosselecionados.isEmpty() && Mapagruposselecionados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecciona los cursos o grupos participantes");
            return false;
        }else if (cajaalojamiento.getSelectedIndex()<0){
            JOptionPane.showMessageDialog(null, "Selecciona si la actividad necesita de alojamiento");
            return false;
        }

        return true;
    }

    private LocalDateTime obtenerLocalDateTimeDesdeSpinners(JSpinner horaSpinner, JSpinner fechaSpinner) {
        // Obtener la hora y la fecha seleccionadas de los Spinners como objetos Date
        Date horaSeleccionada = (Date) horaSpinner.getValue();
        Date fechaSeleccionada = (Date) fechaSpinner.getValue();

        // Convertir los objetos Date a objetos LocalTime y LocalDate respectivamente
        LocalTime localTime = horaSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
        LocalDate localDate = fechaSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Combinar la hora y la fecha en un LocalDateTime
        return LocalDateTime.of(localDate, localTime);
    }

    public DocumentFilter limitaCaracteres(int numCaracteres) {
        DocumentFilter filter = new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;

                if (string.length() <= numCaracteres) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        };
        return filter;
    }

    private void setDocumentfilter(JTextField campo, int caracteres) {
        DocumentFilter filter = limitaCaracteres(caracteres);
        ((PlainDocument) campo.getDocument()).setDocumentFilter(filter);
    }
    private void setDocumentfilterTextarea(JTextArea campo, int caracteres){
        DocumentFilter filter = limitaCaracteres(caracteres);
        ((PlainDocument) campo.getDocument()).setDocumentFilter(filter);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Tipo;
    private javax.swing.JPanel actividadesrealizadas;
    private javax.swing.JLabel actividadprevista;
    private javax.swing.JLabel alumnos;
    private javax.swing.JButton alumnosselecionar;
    private javax.swing.JLabel botonactividadesrealizadas;
    private javax.swing.JLabel botonactividadpendiente;
    private javax.swing.JPanel botoncerrar;
    private javax.swing.JButton botoncomentar;
    private javax.swing.JButton botonenviarsolicitud;
    private javax.swing.JPanel botonesminmaxcerrar;
    private javax.swing.JLabel botongestionarsolicitudes;
    private javax.swing.JButton botonguardarprofesoresresponsables;
    private javax.swing.JButton botonprofesoresparticipantes;
    private javax.swing.JButton botonprofesoresresponsables;
    private javax.swing.JLabel botonsolicitudaprobada;
    private javax.swing.JLabel botonsolicituddenegada;
    private javax.swing.JComboBox<String> cajaalojamiento;
    private javax.swing.JComboBox<String> cajaprevista;
    private javax.swing.JComboBox<String> cajatipo;
    private javax.swing.JComboBox<String> cajatransporte;
    private javax.swing.JLabel cerrar;
    private javax.swing.JLabel cerraractividadesrealizadas;
    private javax.swing.JLabel cerrarcomentarios;
    private javax.swing.JLabel cerrarcursosparticipantes;
    private javax.swing.JLabel cerrargestionarsolicitudes;
    private javax.swing.JLabel cerrargruposparticipantes;
    private javax.swing.JLabel cerrarprofesoresparticipantes;
    private javax.swing.JLabel cerrarprofesoresresponsables;
    private javax.swing.JLabel cerrarsoli;
    private javax.swing.JLabel cerrarsolicitudesaprobadas;
    private javax.swing.JLabel cerrarsolicitudesdenegadas;
    private javax.swing.JLabel cerrarsolicitudespendientes;
    private javax.swing.JTextArea comentarioadicional;
    private javax.swing.JTextArea comentarioalojamiento;
    private javax.swing.JLabel comentarios;
    private javax.swing.JTextArea comentariotransporte;
    private javax.swing.JLabel crearsolicitud;
    private javax.swing.JFileChooser cuadroimportar;
    private javax.swing.JTextField cuadrotitulosolicitud;
    private javax.swing.JPanel cursosparticipantes;
    private javax.swing.JLabel departamento;
    private javax.swing.JComboBox<String> elegircursogrupo;
    private javax.swing.JComboBox<String> elegirdepartamento;
    private javax.swing.JLabel encabezado;
    private javax.swing.JLabel fechafin;
    private javax.swing.JLabel fechaini;
    private javax.swing.JSpinner ffin;
    private javax.swing.JSpinner fini;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel fondoactividadesrealizadas;
    private javax.swing.JLabel fondocursosparticipantes;
    private javax.swing.JLabel fondogestionarsolicitudes;
    private javax.swing.JLabel fondogruposparticipantes;
    private javax.swing.JLabel fondopanelcomentarios;
    private javax.swing.JLabel fondoprofesoresparticipantes;
    private javax.swing.JLabel fondoprofesoresresponsables;
    private javax.swing.JLabel fondosolicitud;
    private javax.swing.JLabel fondosolicitudesaprobadas;
    private javax.swing.JLabel fondosolicitudesdenegadas;
    private javax.swing.JLabel fondosolicitudespendientes;
    private javax.swing.JPanel gestionarsolicitudes;
    private javax.swing.JPanel gruposparticipantes;
    private javax.swing.JButton guardarcomentarios;
    private javax.swing.JButton guardarcursosparticipantes;
    private javax.swing.JButton guardargruposparticipantes;
    private javax.swing.JButton guardarprofesoresparticipantes;
    private javax.swing.JSpinner hfin;
    private javax.swing.JSpinner hini;
    private javax.swing.JLabel horafin;
    private javax.swing.JLabel horaini;
    private javax.swing.JLabel horario;
    private javax.swing.JLabel horario1;
    private javax.swing.JLabel iconoimportardatos;
    private javax.swing.JPanel importar;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JList<String> listacursosparticipantes;
    private javax.swing.JList<String> listagruposparticipantes;
    private javax.swing.JList<String> listaprofesoresparticipantes;
    private javax.swing.JList<String> listaprofesoresresponsables;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel panelcomentarios;
    private javax.swing.JLabel profesores;
    private javax.swing.JPanel profesoresparticipantes;
    private javax.swing.JPanel profesoresresponsables;
    private javax.swing.JPanel solicitud;
    private javax.swing.JPanel solicitudesaprobadas;
    private javax.swing.JPanel solicitudesdenegadas;
    private javax.swing.JPanel solicitudespendientes;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel tituloactividadesrealizadas;
    private javax.swing.JLabel titulocomentarioadicional;
    private javax.swing.JLabel titulocomentarioalojamiento;
    private javax.swing.JLabel titulocomentariotransporte;
    private javax.swing.JLabel titulocursosparticipantes;
    private javax.swing.JLabel titulogestionarsolicitudes;
    private javax.swing.JLabel titulogruposparticipantes;
    private javax.swing.JLabel tituloprofesoresparticipantes;
    private javax.swing.JLabel tituloprofesoresresponsables;
    private javax.swing.JLabel titulosolicitudesaprobadas;
    private javax.swing.JLabel titulosolicitudesdenegadas;
    private javax.swing.JLabel titulosolicitudespendientes;
    private javax.swing.JLabel transporte;
    // End of variables declaration//GEN-END:variables
}
