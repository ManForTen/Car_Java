import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
public class Main extends Canvas{
    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        drawWheel(200,450, 150, 50, new Color(255, 255, 255), Color.black, g2);// Колесо 1
        drawWheel(750,450, 150, 50, new Color(255, 255, 255), Color.black, g2);// Колесо 2

        Path2D.Double path = new Path2D.Double();
        double x = 165, y = 525; // Стартовая точка кузова машины
        path.moveTo(x, y); // Задаем стартовую точку
        path.curveTo(x, y-150, x+220, y-150, x+220, y); // Арка первого колеса
        path.lineTo(x+=550,y); // Дно авто
        path.curveTo(x, y-150, x+=220, y-150, x, y); // Арка второго колеса
        path.lineTo(x+=120,y); // Низ переда
        path.quadTo(x+100, y-15, x+60,y-70 ); // Передний бампер
        path.quadTo(x+100, y-200, x-=180,y-=250 ); // Капот
        double xGlass = x, yGlass = y; // Запоминаем эти координаты для рисования стекол в дальнейшем
        path.quadTo(x-400, y-330, x-=700,y-=30); // Крыша
        path.quadTo(x-100, y+20, x-=100,y+=190); // Багажник
        path.quadTo(x-50, y+20, x+15,525); // Задний бампер
        path.closePath(); // Соединяем линии
        g2.setColor(new Color(255, 255, 0));
        g2.fill(path); // Рисуем созданный кузов
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(6)); // Ширина линий
        g2.draw(path); // Рисуем окантовку кузова
        path.reset(); // Очищаем путь

        path.moveTo(xGlass-50, yGlass); // Начальная точка стекла
        path.quadTo(xGlass-220, yGlass-140, xGlass-370,yGlass-145); // Первая линия
        path.lineTo(xGlass-=370, yGlass); // Вторая линия
        path.closePath(); // Соединяем
        g2.setColor(new Color(255, 255, 255));
        g2.fill(path); // Рисуем стекло
        g2.setColor(Color.black);
        g2.draw(path); // Рисуем окантовку стекла
        path.reset(); // Очищаем путь

        path.moveTo(xGlass-30, yGlass-145); // Начальная точка стекла
        path.quadTo(xGlass-180, yGlass-140, xGlass-280,yGlass-0); // Первая линия
        path.lineTo(xGlass-30, yGlass); // Вторая линия
        path.closePath(); // Соединяем
        g2.setColor(new Color(255, 255, 255));
        g2.fill(path); // Рисуем стекло
        g2.setColor(Color.black);
        g2.draw(path); // Рисуем окантовку стекла
        path.reset(); // Очищаем путь

        g2.setStroke(new BasicStroke(6)); // Ширина линий
        g2.drawLine(520, 320 ,550, 320); // Ручка двери

        path.moveTo(114,280); //рисуем заднюю фару
        path.quadTo(80,280, 80,362);
        path.quadTo(120,290, 114,280);
        g2.setColor(Color.red);
        g2.fill(path);//рисуем фару
        g2.setColor(Color.black);
        g2.draw(path);//рисуем окантовку фары
        path.reset();//очищаем путь
    }

    public void drawWheel (int x, int y, int diameter, int border, Color colorOval, Color colorBorder, Graphics2D g2){
        g2.setColor(colorOval); // Цвет диска
        g2.fillOval(x,y,diameter,diameter); // Диск
        g2.setColor(colorBorder); // Цвет шины
        g2.setStroke(new BasicStroke(border)); // Ширина шины
        g2.fillOval(x+diameter/2-diameter/10/2,y+diameter/2-diameter/10/2,diameter/10,diameter/10); // Ось колеса
        g2.drawOval(x,y,diameter,diameter); // Шина
    }
    public static void main(String[] args) {
        Main m = new Main();
        JFrame f = new JFrame();
        f.setTitle("Машина");
        f.add(m);
        f.setSize(1200,700);
        f.setVisible(true);
    }
}