package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;

import java.awt.Graphics2D;

import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;



public class MainMenu {

	
	private int _w; //Width of the whole frame
	private int _h; //Height of the whole frame
	private Graphics2D g;
	
	private List<ControlButton> _cbs; //A list of control buttons. Needed to check for mouse clicks
	private EditableTextBox _addline1;
	private EditableTextBox _addline2;
	private String _line1;
	private String _line2;
	private int _toggle;
	private ControlButton _go;
	private int _etbwidth = 25;
	private boolean _first;
	private final Color _background = new Color(0,241,189);
	
	public MainMenu(int w, int h, String line1, String line2, int toggle) {
		_w = w;
		_h = h;
		_line1 = line1;
		_line2 = line2;
		_cbs = new ArrayList<ControlButton>();
		_toggle = toggle;
		this.g = null;
		_first = true;
	}

	public void draw(Graphics2D g) {
		this.g = g;
		if (_first) {
			int c = 30;
      Graphics2D gTemp = g;
			_go = new ControlButton("JUGAR", _w/2, _h/5 + 3*c, g);      
			_addline1 = new EditableTextBox(_etbwidth, _w/2, _h/5 + c, _line1);
			_addline2 = new EditableTextBox(_etbwidth, _w/2, _h/5 + 2*c, _line2);
			_cbs.add(new ControlButton("Universidad Brown", 3*_w/2, _h/5 + 2*c, g));
			_cbs.add(new ControlButton("Wall Street", 3*_w/2, _h/5 + 3*c, g));
			_cbs.add(new ControlButton("White House", 3*_w/2, _h/5 + 4*c, g));
			_cbs.add(new ControlButton("Eiffel Tower", 3*_w/2, _h/5 + 5*c, g));
			_cbs.add(new ControlButton("San Francisco", 3*_w/2, _h/5 + 6*c, g));
			_cbs.add(new ControlButton("Philadelphia Museum of Art", 3*_w/2, _h/5 + 7*c, g));
			_cbs.add(new ControlButton("London", 3*_w/2, _h/5 + 8*c, g));
			_cbs.add(new ControlButton("Amsterdam", 3*_w/2, _h/5 + 9*c, g));
			_first = false;
		}
		
		if (_toggle == 1) {
			_addline1.select();
			_addline2.unselect();
		}
		else if (_toggle == 2) {
			_addline2.select();
			_addline1.unselect();
		}
		
		java.awt.Color colorholder = g.getColor();
		g.setColor(_background);
		g.fill(new Rectangle2D.Float(0,0,_w,_h));
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Helvetica", Font.BOLD, 30));
		new Text("Invasión zombie!", centerX("Invasión zombie!", _w), _h/10);

		g.setColor(Color.BLACK);
		g.setFont(new Font("Helvetica", Font.BOLD, 15));
		new Text("Introduce una ubicación", centerX("Introduce una ubicación", _w/2), _h/5);
		
		FontMetrics fm = g.getFontMetrics();
		int c = fm.getHeight() + 10;
		new Text("O elige de una", centerX("O elige de una", 3*_w/2), _h/5);
		new Text("de nuestras ubicaciones", centerX("de nuestras ubicaciones", 3*_w/2), _h/5 + c - 10);
		
		g.drawLine((int) (_w/2), (int) (_h/6), (int) (_w/2), (int) (3*_h/5 - 30));
		
		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font("Helvetica", Font.BOLD, 15));
		_addline1.draw();
		_addline2.draw();
		
		
		_go.draw(g, _background);
		
		for (ControlButton cb: _cbs) {
			cb.draw(g, _background);
		}
		

		int r = 3*_h/5 + 10;
		g.setColor(_background);
		g.fillRect(0, 3*_h/5 + 10, _w, _h);
		g.setColor(Color.DARK_GRAY);
		g.drawLine(0, 3*_h/5 + 10, _w, 3*_h/5 + 10);
		int f = 16;
		int s = 30;
		g.setFont(new Font("Helvetica", Font.BOLD, 13));
		g.setColor(Color.DARK_GRAY);
		new CenText("Tutorial", _w, r + f);
		new CenText("Invasión Zombie es un juego de defensa basado en mapas del mundo real. Puedes escribir una dirección o seleccionar", _w, r + 2*f);
		new CenText("una ubicación a la derecha para generar un mapa en el cual podrás jugar. El objetivo del juego es prevenir", _w, r + 3*f);
		new CenText("que los zombies destruyan tu base, añadiendo torres de defensa. Al final de cada partida", _w, r + 4*f);
		new CenText("recibes el 5% de interés sobre el dinero que no hayas gastado. Tips:", _w, r + 5*f);
		new Text("La Torre básica dispara balas regulares.", s, r + 7*f);
		new Text("El Lanzallamas crea un circulo de flamas.", s, r + 8*f);
		new Text("El Cañon dispara bombas que causan un gran daño al impactar.", s, r + 9*f);
		new Text("El Pegote vuelve más lentos a los zombies.", s, r + 10*f);
		new Text("El Alacrán envenena a los zombies que pasan cerca y mueren lentamente.", s, r + 11*f);
		new Text("El Arco eléctrico proporciona descargas eléctricas que pueden saltar de zombie a zombie.", s, r + 12*f);
		new Text("El Láser daña a todos los zombies en su camino.", s, r + 13*f);

		new Text("En la partida 5 llegarán zombies que se mueven al doble de velocidad normal.", s, r + 15*f);
		new Text("En la partida 10 enfrentarás zombies matones con el doble de resistencia que un zombie normal.", s, r + 16*f);
		new Text("En la partida 15 aparecerán zombies que pueden atacar la base desde la distancia.", s, r + 17*f);
		new Text("En la partida 20 los super zombies harán su aparición....buena suerte con ellos!", s, r + 18*f);


		g.setColor(colorholder);
	}
	
	private float centerX(String name, float rightline) {
		FontMetrics fm = g.getFontMetrics();
		int c = fm.stringWidth(name);
		int x = (int) (.5*rightline - .5*c);
		return x;
	}
	
	
	private class EditableTextBox {
		private String _text;
		private String _disptext;
		private String _widthholder;
		private RoundRectangle2D _r;
		private Rectangle2D _bb;
		private float x;
		private float y;
		private int blink = 0;
		private boolean _selected = false;
		public EditableTextBox(float textwidth, float rightline, float y, String line) {
			_widthholder = "";
			for (int i = 0; i < textwidth; i++) {
				_widthholder = _widthholder + "d";
			}
			g.setFont(new Font("Helvetica", Font.BOLD, 15));
			float x = centerX(_widthholder, rightline);
			this.x = x;
			this.y = y;
			_text = line;
			_bb = null;
			_r = null;
		}
		public void draw() {
			g.setFont(new Font("Helvetica", Font.BOLD, 15));
			FontMetrics fm = g.getFontMetrics();
			_bb = fm.getStringBounds(_widthholder, g);
			_r = new RoundRectangle2D.Float(x,y,(float) (_bb.getWidth()+10), (float) (_bb.getHeight()+5), 10, 10);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Helvetica", Font.BOLD, 15));
			g.draw(_r);
			_disptext = _text;
			if ((blink > 50) && (blink < 100) && (_selected)) {
				_disptext = _disptext + "|";
			}
			while (fm.getStringBounds(_disptext, g).getWidth() > _bb.getWidth()) {
				_disptext = _disptext.substring(1);
			}
			g.drawString(_disptext, x+5,(int) (y+_bb.getHeight()+1));
			blink++;
			blink = blink % 100;
		}
		public void addLetter(String letter) {
			_text = _text + letter;
		}
		public void backspace() {
			int len = _text.length();
			if (len > 0) {
				_text = _text.substring(0, len-1);
			}
		}
		public void clear() {
			_text = "";
		}
		public String getText() {
			return _text;
		}
		public boolean contains(int x, int y) {
			if (_r.contains(x, y)) {
				return true;
			}
			return false;
		}
		public void select() {
			_selected = true;
		}
		public void unselect() {
			_selected = false;
		}
	}
	
	
	
	private class Text {
		public Text(String name, float x, float y) {
			g.drawString(name, x, y);
		}
	}
	
	private class CenText {
		public CenText(String name, float rightline, float y) {
			g.drawString(name, centerX(name, rightline), y);
		}
	}
	
	
	
	
	public String contains(int x, int y, boolean click) {
		for (ControlButton cb: _cbs) {
			if (cb.getRoundRect().contains(x, y)) {
				cb.highlight();
				return cb.getName();
			}
			else {
				cb.unhighlight();
			}
		}
		if (_go != null) {
			if (_go.getRoundRect().contains(x, y)) {
				_go.highlight();
				if (_addline2.getText().equals("")) {
					return _addline1.getText();
				}
				else {
					return (_addline1.getText() + " " + _addline2.getText());
				}
			}
			else {
				_go.unhighlight();
			}
		}
		if (click) {
			this.chooseAddline(x,y);
		}
		return null;
	}
	
	
	
	public void chooseAddline(int x, int y) {
		if (_addline1.contains(x, y)) {
			_toggle = 1;
			_addline1.select();
			_addline2.unselect();
		}
		else if (_addline2.contains(x, y)) {
			_toggle = 2;
			_addline2.select();
			_addline1.unselect();
		}
	}
	
	
	//Right now this is set up so that if neither addline in in focus nothing happens
	public void keyTyped(String letter) {
		EditableTextBox holder = null;
		boolean focus = true;
		if (_toggle == 1) {
			holder = _addline1;
		}
		else if (_toggle == 2) {
			_toggle = 2;
			holder = _addline2;
		}
		else {
			focus = false;
		}
		if ((letter.length() > 1) && (focus)) {
			if (letter.equals("backspace")) {
				holder.backspace();
			}
			else if ((letter.equals("enter")) || (letter.equals("tab"))) {
				if (_toggle == 1) {
					_toggle = 2;
					_addline2.select();
					_addline1.unselect();
				}
			}
		}
		else if (focus) {
			holder.addLetter(letter);
		}
	}
	

	public String getLine1() {
		if (_addline1 != null) {
			return _addline1.getText();
		}
		else {
			return "";
		}
	}
	
	public String getLine2() {
		if (_addline1 != null) {
			return _addline2.getText();
		}
		else {
			return "";
		}
	}
	
	public int getToggle() {
		return _toggle;
	}
	
	public void clear() {
		if (_addline1 != null) {
		_addline1.clear();
		_addline2.clear();
		}
		
	}
	
}
