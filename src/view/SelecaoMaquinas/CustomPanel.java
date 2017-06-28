/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.SelecaoMaquinas;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author Thulio
 */
public class CustomPanel extends JPanel{
    
    int progress = 0;
    
    public void UpdateProgress(int progress_value){
        progress = progress_value;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        //Cria o objeto para desenhar
        Graphics2D g2 = (Graphics2D)g;
        
        //Aplicar Antialiasing para refinar o serrilhado
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        //Centraliza o desenho na tela 
        g2.translate(this.getWidth()/2, this.getHeight()/2);
        
        //Roda o objeto para poder ser desenhado no sentido horário
        g2.rotate(Math.toRadians(270));
        
        //Cria o arco e preenche com um circulo branco no meio
        Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
        Ellipse2D circle = new Ellipse2D.Float(0,0,110,110);
        
        //Tamanho Arco e Circulo
        arc.setFrameFromCenter(new Point(0,0), new Point(120,120));
        circle.setFrameFromCenter(new Point(0,0), new Point(110,110));
        
        //Angulo de onde o desenho irá iniciar
        arc.setAngleStart(1);
        
        //Divisão dos 360 do arco baseado no progresso
        arc.setAngleExtent(-progress*3.6); 
        
        g2.setColor(Color.RED);
        g2.draw(arc);
        g2.fill(arc);
        
        g2.setColor(Color.WHITE);
        g2.draw(circle);
        g2.fill(circle);
        g2.setColor(Color.BLACK);
        
        //Roda o objeto de desenho para inserir o texto com a porcentagem
        g2.rotate(Math.toRadians(90));
        
        //Configura fonte do objeto 
        g.setFont(new Font("Verdana", Font.PLAIN,50));
        FontMetrics fm = g2.getFontMetrics();
        
        //Cria um retangulo no centro do objeto para mostrar a string da porcentagem
        Rectangle2D r = fm.getStringBounds(progress+"%", g);
        int x = (0-(int)r.getWidth())/2;
        int y = (0-(int)r.getHeight())/2+fm.getAscent();
        
        //Desenha a %
        g2.drawString(progress+"%", x, y);
    }
    
}
